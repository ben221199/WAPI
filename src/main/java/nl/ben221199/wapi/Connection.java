package nl.ben221199.wapi;

import com.southernstorm.noise.protocol.CipherStatePair;
import com.whatsapp.proto.WA4Protos;

import java.io.IOException;
import java.net.Socket;
import java.security.KeyPair;
import java.security.PublicKey;

import java.util.Map;

public class Connection{

	private Socket socket;
	private FunInputStream in;
	private FunOutputStream out;
	//private HandshakeState handshake;
	private HandshakeManager handshakeManager;

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
		this.handshakeManager = new HandshakeManager();
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
			Map<String, Object> values = this.handshakeManager.doHandshakeXX(in, out, s, clientPayload);
			this.out = (FunOutputStream) values.get("out");
			this.s = (KeyPair) values.get("s");
			this.clientPayload = (WA4Protos.ClientPayload) values.get("clientPayload");
		}else{
			try{
				this.handshakeManager.doHandshakeIK();
			}catch(Exception e){
				this.handshakeManager.doHandshakeXXfallback();
			}
		}

		this.handshakeManager.checkSplitState();
		CipherStatePair cipherStatePair = this.handshakeManager.handshakeSplit();
		this.in.setCipherState(cipherStatePair.getReceiver());
		this.out.setCipherState(cipherStatePair.getSender());
	}

	private void writeEdgeHeader() throws IOException{
		byte[] ED = {'E','D',(byte) Constants.Protocol.EDGE_MAJOR,(byte) Constants.Protocol.EDGE_MINOR};
		this.out.write(ED);
		this.out.writeSegment(edge_routing_info);
		this.out.flush();
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
		this.handshakeManager.setNull();
	}

	public void close() throws IOException{
		this.socket.close();
	}

	public void restart() throws IOException{
		this.close();
		this.start();
	}

}
