package nl.ben221199.wapi;

import com.google.protobuf.ByteString;
import com.southernstorm.noise.protocol.CipherStatePair;
import com.southernstorm.noise.protocol.HandshakeState;
import com.whatsapp.proto.WA4Protos;
import nl.ben221199.wapi.fun.FunXMPP;

import javax.crypto.BadPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Arrays;

public class Connection{

	private Socket socket;
	private FunInputStream in;
	private FunOutputStream out;
	private HandshakeState handshake;

	private byte[] edge_routing_info;
	private KeyPair s;
	private PublicKey rs;

//	private WA4Protos.HandshakeMessage.ClientHello client_hello;
//	private WA4Protos.HandshakeMessage.ServerHello server_hello;
//	private WA4Protos.HandshakeMessage.ClientFinish client_finish;
//
//	private WA4Protos.NoiseCertificate noiseCertificate;
	private WA4Protos.ClientPayload clientPayload;

	public Connection(String host,int port) throws IOException{
		this.socket = new Socket(host,port);
		this.socket.setKeepAlive(true);
	}

	public Connection setEdgeRoutingInfo(byte[] edge_routing_info){
		this.edge_routing_info = edge_routing_info;
		return this;
	}

	public Connection setS(KeyPair s){
		this.s = s;
		return this;
	}

	public Connection setRS(PublicKey rs){
		this.rs = rs;
		return this;
	}

	public Connection setPayload(WA4Protos.ClientPayload payload){
		this.clientPayload = payload;
		return this;
	}

	public void start() throws IOException{
		if(this.socket.isClosed()){
			this.reset();
		}
		this.in = new FunInputStream(this.socket.getInputStream());
		this.out = new FunOutputStream(this.socket.getOutputStream());
		this.doHandshake();
	}

	public boolean isConnected(){
		return this.socket.isConnected() && !this.socket.isClosed();
	}

	private void doHandshake() throws IOException{
		if(this.edge_routing_info!=null){
			this.writeEdgeHeader();
		}
		if(this.rs==null){
			this.doHandshakeXX();
		}else{
			try{
				this.doHandshakeIK();
			}catch(Exception e){
				this.doHandshakeXXfallback();
			}
		}
		if(this.handshake.getAction()!=HandshakeState.SPLIT){
			throw new IOException("Handshake should be in split state");
		}
		CipherStatePair cipherStatePair = this.handshake.split();
		this.in.setCipherState(cipherStatePair.getReceiver());
		this.out.setCipherState(cipherStatePair.getSender());
	}

	private void writeEdgeHeader() throws IOException{
		byte[] ED = {'E','D',(byte) Constants.Protocol.EDGE_MAJOR,(byte) Constants.Protocol.EDGE_MINOR};
		this.out.write(ED);
		this.out.writeSegment(edge_routing_info);
		this.out.flush();
	}

	private void doHandshakeXX() throws IOException{
		this.createHandshakeState("Noise_XX_25519_AESGCM_SHA256");
		if(this.handshake==null){
			throw new IOException("Handshake should not be null");
		}
		this.writeWhatsAppHeader();
		if(this.handshake.needsLocalKeyPair()){
//			this.handshake.getLocalKeyPair().setPublicKey(this.s.getPublic().getEncoded(),0);
			this.handshake.getLocalKeyPair().setPrivateKey(this.s.getPrivate().getEncoded(),0);
		}
		this.handshake.start();
		System.out.println("Handshake started");

		System.out.println("Sending CLIENT HELLO: e");
		byte[] clientHello = this.writeHandshakeMessage(new byte[0]);
		byte[] client_hello_ephemeral = Arrays.copyOfRange(clientHello,0,32);
		WA4Protos.HandshakeMessage.ClientHello client_hello = WA4Protos.HandshakeMessage.ClientHello.newBuilder().setEphemeral(ByteString.copyFrom(client_hello_ephemeral)).build();
		WA4Protos.HandshakeMessage client_hello_message = WA4Protos.HandshakeMessage.newBuilder().setClientHello(client_hello).build();
		out.writeSegment(client_hello_message.toByteArray());
		out.flush();
		System.out.println("Sent CLIENT HELLO");

		System.out.println("Receiving SERVER HELLO: e, ee, s, es");
		byte[] server_hello_data = in.readSegment();
		WA4Protos.HandshakeMessage server_hello_message = WA4Protos.HandshakeMessage.parseFrom(server_hello_data);
		if(!server_hello_message.hasServerHello()){
			System.err.println("Doesn't have server hello");
			return;
		}
		WA4Protos.HandshakeMessage.ServerHello server_hello = server_hello_message.getServerHello();
		byte[] server_hello_buffer = server_hello.getEphemeral().concat(server_hello.getStatic().concat(server_hello.getPayload())).toByteArray();
		byte[] serverHello = this.readHandshakeMessage(server_hello_buffer);
		WA4Protos.NoiseCertificate noiseCertificate = WA4Protos.NoiseCertificate.parseFrom(serverHello);
		boolean isValid = CertificateChecker.check(noiseCertificate,this.handshake.getRemotePublicKey());
		System.out.println("Received SERVER HELLO: Certificate is"+(isValid?"":" NOT")+" valid.");

		System.out.println("Sending CLIENT FINISH: s, se");
		byte[] clientFinish = this.writeHandshakeMessage(clientPayload.toByteArray());


//		System.out.println("<> "+bytesToHex(buffer2));

		byte[] staticBytes = ByteString.copyFrom(clientFinish).substring(0,48).toByteArray();
		byte[] payloadBytes = ByteString.copyFrom(clientFinish).substring(48,clientFinish.length).toByteArray();

		WA4Protos.HandshakeMessage.ClientFinish client_finish = WA4Protos.HandshakeMessage.ClientFinish.newBuilder()
				.setStatic(ByteString.copyFrom(staticBytes))
				.setPayload(ByteString.copyFrom(payloadBytes))
				.build();
		byte[] buf = new byte[32];
		this.handshake.getLocalKeyPair().getPublicKey(buf,0);
		WA4Protos.HandshakeMessage client_finish_message = WA4Protos.HandshakeMessage.newBuilder().setClientFinish(client_finish).build();
		out.writeSegment(client_finish_message.toByteArray());
		out.flush();
		System.out.println("Sent CLIENT FINISH");
	}

	private void doHandshakeIK() throws IOException{}

	private void doHandshakeXXfallback() throws IOException{}

	private byte[] readHandshakeMessage(byte[] data){
		byte[] buffer = new byte[data.length+1024];
		int length = 0;
		try{
			length = this.handshake.readMessage(data,0,data.length,buffer,0);
		}catch(BadPaddingException|ShortBufferException e){
			e.printStackTrace();
		}
		if(length==0){
			return new byte[0];
		}
		if(length==buffer.length){
			return buffer;
		}
		byte[] result = new byte[length];
		System.arraycopy(buffer,0,result,0,length);
		return result;
	}

	private byte[] writeHandshakeMessage(byte[] data){
		byte[] buffer = new byte[data.length+1024];
		int length = 0;
		try{
			length = this.handshake.writeMessage(buffer,0,data,0,data.length);
		}catch(ShortBufferException e){
			e.printStackTrace();
		}
		if(length==0){
			return new byte[0];
		}
		if(length==buffer.length){
			return buffer;
		}
		byte[] result = new byte[length];
		System.arraycopy(buffer,0,result,0,length);
		return result;
	}

	private void createHandshakeState(String protocol){
		try{
			this.handshake = new HandshakeState(protocol,HandshakeState.INITIATOR);
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
	}

	private void writeWhatsAppHeader() throws IOException{
		byte[] WA = {(byte)'W',(byte)'A',(byte) Constants.Protocol.MAJOR,(byte) Constants.Protocol.MINOR};
		this.handshake.setPrologue(WA,0,WA.length);
		this.out.write(WA);
		this.out.flush();
		FunXMPP.setVersion(Constants.Protocol.FUN_VERSION);
	}

	public FunInputStream getInputStream(){
		return this.in;
	}

	public FunOutputStream getOutputStream(){
		return this.out;
	}

	private void reset() throws IOException{
		this.socket = new Socket(this.socket.getInetAddress(),this.socket.getPort());
		this.socket.setKeepAlive(true);
		this.in = null;
		this.out = null;
		this.handshake = null;
	}

	public void close() throws IOException{
		this.socket.close();
	}

	public void restart() throws IOException{
		this.close();
		this.start();
	}

}
