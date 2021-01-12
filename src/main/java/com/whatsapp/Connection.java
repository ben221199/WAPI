package com.whatsapp;

import com.google.protobuf.ByteString;
import com.southernstorm.noise.protocol.CipherStatePair;
import com.southernstorm.noise.protocol.HandshakeState;
import com.whatsapp.protobuf.WhatsProtos;

import javax.crypto.BadPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class Connection{

	private Socket socket;
	private FunInputStream in;
	private FunOutputStream out;
	private HandshakeState handshake;

	private byte[] edge_routing_info;
	private KeyPair s;
	private PublicKey rs;

	private WhatsProtos.HandshakeMessage.ClientHello client_hello;
	private WhatsProtos.HandshakeMessage.ServerHello server_hello;
	private WhatsProtos.HandshakeMessage.ClientFinish client_finish;

	private WhatsProtos.NoiseCertificate noiseCertificate;
	private WhatsProtos.ClientPayload clientPayload;

	public Connection(String host,int port) throws IOException{
		this.socket = new Socket(host,port);
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

	public Connection setPayload(WhatsProtos.ClientPayload payload){
		this.clientPayload = payload;
		return this;
	}

	public void start() throws IOException{
		this.in = new FunInputStream(this.socket.getInputStream());
		this.out = new FunOutputStream(this.socket.getOutputStream());
		this.doHandshake();
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








		System.out.println("[Action] "+this.handshake.getAction());
		byte[] buffer = new byte[1024*8];
		byte[] client_hello_payload = new byte[0];
		int client_hello_length = 0;
		try{
			client_hello_length = this.handshake.writeMessage(buffer,0,client_hello_payload,0,client_hello_payload.length);
		}catch(ShortBufferException e){
			e.printStackTrace();
		}
		byte[] client_hello_ephemeral = new byte[client_hello_length];
		System.arraycopy(buffer,0,client_hello_ephemeral,0,client_hello_ephemeral.length);
		// => e
		//System.err.println(new String(client_hello_ephemeral)+" ["+client_hello_ephemeral.length+"]");
		WhatsProtos.HandshakeMessage.ClientHello client_hello = WhatsProtos.HandshakeMessage.ClientHello.newBuilder().setEphemeral(ByteString.copyFrom(client_hello_ephemeral)).build();
		WhatsProtos.HandshakeMessage client_hello_message = WhatsProtos.HandshakeMessage.newBuilder().setClientHello(client_hello).build();
		out.writeSegment(client_hello_message.toByteArray());
		out.flush();
		System.out.println("[Client] "+client_hello_message.toString().trim());
		System.out.println("P> "+client_hello.getEphemeral().size());
		System.out.println("=======================================================");

		System.out.println("[Action] "+this.handshake.getAction());
		// <= e, ee, s, es
		byte[] server_hello_data = in.readSegment();
		//System.out.println(bytesToHex(server_hello_data));
		WhatsProtos.HandshakeMessage server_hello_message = WhatsProtos.HandshakeMessage.parseFrom(server_hello_data);
		if(!server_hello_message.hasServerHello()){
			System.err.println("Doesn't have server hello");
			return;
		}
		WhatsProtos.HandshakeMessage.ServerHello server_hello = server_hello_message.getServerHello();
		byte[] server_hello_buffer = server_hello.getEphemeral().concat(server_hello.getStatic().concat(server_hello.getPayload())).toByteArray();
		System.err.println(ByteString.copyFrom(server_hello_buffer));
		byte[] server_hello_info = new byte[4096];
		int server_hello_length = 0;
		try{
			server_hello_length = this.handshake.readMessage(server_hello_buffer,0,server_hello_buffer.length,server_hello_info,0);
		}catch(ShortBufferException | BadPaddingException e){
			e.printStackTrace();
		}
		server_hello_info = ByteString.copyFrom(server_hello_info).substring(0,server_hello_length).toByteArray();
		System.out.println("[Client] "+server_hello_message.toString().trim());
		System.out.println("P> "+server_hello_message.getServerHello().getEphemeral().size());
		System.out.println("P> "+server_hello_message.getServerHello().getStatic().size());
		System.out.println("P> "+server_hello_message.getServerHello().getPayload().size());
		WhatsProtos.NoiseCertificate noiseCertificate = WhatsProtos.NoiseCertificate.parseFrom(server_hello_info);
		boolean isValid = CertificateChecker.check(noiseCertificate,this.handshake.getRemotePublicKey());
		System.out.println("CC = "+isValid);
		System.out.println("=======================================================");

		System.out.println("[Action] "+this.handshake.getAction());
		// => s, se
		byte[] buffer2 = new byte[1000];
		byte[] client_finish_payload = clientPayload.toByteArray();
		//client_finish_payload = new byte[]{(byte)0x08,(byte)0xFA,(byte)0x9D,(byte)0xFE,(byte)0xF7,(byte)0x2C,(byte)0x18,(byte)0x01,(byte)0x2A,(byte)0x94,(byte)0x01,(byte)0x08,(byte)0x00,(byte)0x12,(byte)0x06,(byte)0x08,(byte)0x02,(byte)0x10,(byte)0x13,(byte)0x18,(byte)0x33,(byte)0x1A,(byte)0x03,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x22,(byte)0x03,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x2A,(byte)0x05,(byte)0x38,(byte)0x2E,(byte)0x30,(byte)0x2E,(byte)0x30,(byte)0x32,(byte)0x07,(byte)0x73,(byte)0x61,(byte)0x6D,(byte)0x73,(byte)0x75,(byte)0x6E,(byte)0x67,(byte)0x3A,(byte)0x08,(byte)0x73,(byte)0x74,(byte)0x61,(byte)0x72,(byte)0x32,(byte)0x6C,(byte)0x74,(byte)0x65,(byte)0x42,(byte)0x36,(byte)0x73,(byte)0x74,(byte)0x61,(byte)0x72,(byte)0x32,(byte)0x6C,(byte)0x74,(byte)0x65,(byte)0x78,(byte)0x78,(byte)0x2D,(byte)0x75,(byte)0x73,(byte)0x65,(byte)0x72,(byte)0x20,(byte)0x38,(byte)0x2E,(byte)0x30,(byte)0x2E,(byte)0x30,(byte)0x20,(byte)0x52,(byte)0x31,(byte)0x36,(byte)0x4E,(byte)0x57,(byte)0x20,(byte)0x47,(byte)0x39,(byte)0x36,(byte)0x35,(byte)0x46,(byte)0x58,(byte)0x58,(byte)0x55,(byte)0x31,(byte)0x41,(byte)0x52,(byte)0x43,(byte)0x43,(byte)0x20,(byte)0x72,(byte)0x65,(byte)0x6C,(byte)0x65,(byte)0x61,(byte)0x73,(byte)0x65,(byte)0x2D,(byte)0x6B,(byte)0x65,(byte)0x79,(byte)0x73,(byte)0x4A,(byte)0x24,(byte)0x61,(byte)0x65,(byte)0x65,(byte)0x66,(byte)0x65,(byte)0x36,(byte)0x61,(byte)0x30,(byte)0x2D,(byte)0x39,(byte)0x31,(byte)0x33,(byte)0x38,(byte)0x2D,(byte)0x34,(byte)0x31,(byte)0x32,(byte)0x63,(byte)0x2D,(byte)0x62,(byte)0x66,(byte)0x38,(byte)0x61,(byte)0x2D,(byte)0x39,(byte)0x32,(byte)0x62,(byte)0x64,(byte)0x33,(byte)0x30,(byte)0x65,(byte)0x34,(byte)0x62,(byte)0x32,(byte)0x35,(byte)0x32,(byte)0x5A,(byte)0x02,(byte)0x65,(byte)0x6E,(byte)0x62,(byte)0x02,(byte)0x55,(byte)0x53,(byte)0x3A,(byte)0x0A,(byte)0x63,(byte)0x6F,(byte)0x6E,(byte)0x73,(byte)0x6F,(byte)0x6E,(byte)0x61,(byte)0x6E,(byte)0x63,(byte)0x65,(byte)0x4D,(byte)0x0D,(byte)0xE4,(byte)0x7B,(byte)0x99,(byte)0x50,(byte)0x01,(byte)0x60,(byte)0x01};
//		System.out.println("<> "+bytesToHex(client_finish_payload));
		int client_finish_length = 0;
		try{
			client_finish_length = this.handshake.writeMessage(buffer2,0,client_finish_payload,0,client_finish_payload.length);
		}catch(ShortBufferException e){
			e.printStackTrace();
		}
//		System.out.println("<> "+bytesToHex(buffer2));

		byte[] staticBytes = ByteString.copyFrom(buffer2).substring(0,48).toByteArray();
		byte[] payloadBytes = ByteString.copyFrom(buffer2).substring(48,client_finish_length).toByteArray();
		System.out.println("PP "+client_finish_payload.length+" & "+payloadBytes.length);

		WhatsProtos.HandshakeMessage.ClientFinish client_finish = WhatsProtos.HandshakeMessage.ClientFinish.newBuilder()
				.setStatic(ByteString.copyFrom(staticBytes))
				.setPayload(ByteString.copyFrom(payloadBytes))
				.build();
		byte[] buf = new byte[32];
		this.handshake.getLocalKeyPair().getPublicKey(buf,0);
//		System.err.println("{} "+bytesToHex(buf));
//		System.err.println("{} "+bytesToHex(kp.getPublic().getEncoded()));
		//System.err.println("<> "+bytesToHex(ByteString.copyFrom(buffer2).substring(64,client_finish_length).toByteArray()));
		//System.err.println(client_finish_length);

		WhatsProtos.HandshakeMessage client_finish_message = WhatsProtos.HandshakeMessage.newBuilder().setClientFinish(client_finish).build();
		System.out.println(client_finish_length+" / "+ByteString.copyFrom(buffer2).substring(48,client_finish_length));
		out.writeSegment(client_finish_message.toByteArray());
		//out.writeSegment("AAAAAAAAAAAAA".getBytes());
		out.flush();
		System.out.println("[Client] "+client_finish_message.toString().trim());
		System.out.println("P> "+client_finish.getStatic().size());
		System.out.println("P> "+client_finish.getPayload().size());
		System.out.println("=======================================================");

		System.out.println("[Action] "+this.handshake.getAction());
	}

	private void doHandshakeIK() throws IOException{}

	private void doHandshakeXXfallback() throws IOException{}

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
		FunXMPP.setVersion(Constants.Protocol.MAJOR,Constants.Protocol.MINOR);
	}

	public FunInputStream getInputStream(){
		return this.in;
	}

	public FunOutputStream getOutputStream(){
		return this.out;
	}

}
