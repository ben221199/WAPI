package com.whatsapp;

import br.eti.balena.security.ecdh.curve25519.Curve25519PrivateKey;
import br.eti.balena.security.ecdh.curve25519.Curve25519PublicKey;

import com.google.protobuf.ByteString;
import com.southernstorm.noise.protocol.CipherStatePair;
import com.southernstorm.noise.protocol.HandshakeState;
import com.whatsapp.protobuf.WhatsProtos;

import java.io.IOException;
import java.net.Socket;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.ShortBufferException;

public class Main{

	private static final int MAJOR = 4;
	private static final int MINOR = 0;

	public static void main(String... args) throws IOException{
		new TestServer().start();

		String client_static_keypair = "";

		byte[] client_static_keypair_bytes = Base64.getDecoder().decode(client_static_keypair);
		client_static_keypair_bytes = new byte[64];
//		if(client_static_keypair_bytes.length!=64){
//			System.err.println("The 'client_static_keypair' isn't 64 bytes long");
//			return;
//		}
		byte[] priv_bytes = new byte[32];
		System.arraycopy(client_static_keypair_bytes,0,priv_bytes,0,priv_bytes.length);
		PrivateKey priv = new Curve25519PrivateKey(priv_bytes);

		byte[] pub_bytes = new byte[32];
		System.arraycopy(client_static_keypair_bytes,32,pub_bytes,0,pub_bytes.length);
		PublicKey pub = new Curve25519PublicKey(pub_bytes);

		KeyPair kp = new KeyPair(pub,priv);

		Socket s = new Socket("e7.whatsapp.net",443);
		NoiseInputStream in = new NoiseInputStream(s.getInputStream());
		NoiseOutputStream out = new NoiseOutputStream(s.getOutputStream());

		HandshakeState hs = Main.createHandshakeState();
		if(hs==null){
			System.err.println("Failed to create handshake state");
			return;
		}

		Main.writeWhatsAppHeader(hs,out);

		CipherStatePair cipherStates = Main.writeHandshakeXX(hs,in,out);
		if(cipherStates==null){
			System.err.println("Failed to perform handshake");
			return;
		}

		in.setCipherState(cipherStates.getReceiver());
		out.setCipherState(cipherStates.getSender());

		//out.writeEncryptedSegment("HOI".getBytes());

		//while(in.available()==0);

		//This is FunXMPP
		byte[] o = in.readDecryptedSegment();
		System.out.println("From server = "+new String(o));
	}

	private static HandshakeState createHandshakeState(){
		HandshakeState hs = null;
		try{
			hs = new HandshakeState("Noise_XX_25519_AESGCM_SHA256",HandshakeState.INITIATOR);
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return hs;
	}

	private static void writeWhatsAppHeader(HandshakeState hs,NoiseOutputStream sos) throws IOException{
		byte[] WA = new byte[]{(byte)'W',(byte)'A',(byte) Main.MAJOR,(byte) Main.MINOR};
		sos.write(WA);
		hs.setPrologue(WA,0,WA.length);
		sos.flush();
	}

	private static CipherStatePair writeHandshakeXX(HandshakeState hs,NoiseInputStream in,NoiseOutputStream out) throws IOException{
		if(hs.needsLocalKeyPair()){
			hs.getLocalKeyPair().generateKeyPair();
//			hs.getLocalKeyPair().setPublicKey(kp.getPublic().getEncoded(),0);
//			hs.getLocalKeyPair().setPrivateKey(kp.getPrivate().getEncoded(),0);
//			System.out.println("[PUBL] "+bytesToHex(kp.getPublic().getEncoded()));
//			System.out.println("[PRIV] "+bytesToHex(kp.getPrivate().getEncoded()));
//			System.err.println(hs.getLocalKeyPair().generateKeyPair());
		}
		hs.setPrologue(new byte[]{(byte)'W',(byte)'A',0x04,0x00},0,4);
		hs.start();

		System.out.println("[Action] "+hs.getAction());
		byte[] buffer = new byte[1024*8];
		byte[] client_hello_payload = new byte[0];
		int client_hello_length = 0;
		try{
			client_hello_length = hs.writeMessage(buffer,0,client_hello_payload,0,client_hello_payload.length);
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

		System.out.println("[Action] "+hs.getAction());
		// <= e, ee, s, es
		byte[] server_hello_data = in.readSegment();
		//System.out.println(bytesToHex(server_hello_data));
		WhatsProtos.HandshakeMessage server_hello_message = WhatsProtos.HandshakeMessage.parseFrom(server_hello_data);
		if(!server_hello_message.hasServerHello()){
			System.err.println("Doesn't have server hello");
			return null;
		}
		WhatsProtos.HandshakeMessage.ServerHello server_hello = server_hello_message.getServerHello();
		byte[] server_hello_buffer = server_hello.getEphemeral().concat(server_hello.getStatic().concat(server_hello.getPayload())).toByteArray();
		System.err.println(ByteString.copyFrom(server_hello_buffer));
		byte[] server_hello_info = new byte[4096];
		int server_hello_length = 0;
		try{
			server_hello_length = hs.readMessage(server_hello_buffer,0,server_hello_buffer.length,server_hello_info,0);
		}catch(ShortBufferException | BadPaddingException e){
			e.printStackTrace();
		}
		server_hello_info = ByteString.copyFrom(server_hello_info).substring(0,server_hello_length).toByteArray();
		System.out.println("[Client] "+server_hello_message.toString().trim());
		System.out.println("P> "+server_hello_message.getServerHello().getEphemeral().size());
		System.out.println("P> "+server_hello_message.getServerHello().getStatic().size());
		System.out.println("P> "+server_hello_message.getServerHello().getPayload().size());
		WhatsProtos.NoiseCertificate noiseCertificate = WhatsProtos.NoiseCertificate.parseFrom(server_hello_info);
		boolean isValid = CertificateChecker.check(noiseCertificate,hs.getRemotePublicKey());
		System.out.println("CC = "+isValid);
		System.out.println("=======================================================");

		System.out.println("[Action] "+hs.getAction());
		// => s, se
		byte[] buffer2 = new byte[1000];
		byte[] client_finish_payload = Main.getConfig().toByteArray();
		client_finish_payload = new byte[]{(byte)0x08,(byte)0xFA,(byte)0x9D,(byte)0xFE,(byte)0xF7,(byte)0x2C,(byte)0x18,(byte)0x01,(byte)0x2A,(byte)0x94,(byte)0x01,(byte)0x08,(byte)0x00,(byte)0x12,(byte)0x06,(byte)0x08,(byte)0x02,(byte)0x10,(byte)0x13,(byte)0x18,(byte)0x33,(byte)0x1A,(byte)0x03,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x22,(byte)0x03,(byte)0x30,(byte)0x30,(byte)0x30,(byte)0x2A,(byte)0x05,(byte)0x38,(byte)0x2E,(byte)0x30,(byte)0x2E,(byte)0x30,(byte)0x32,(byte)0x07,(byte)0x73,(byte)0x61,(byte)0x6D,(byte)0x73,(byte)0x75,(byte)0x6E,(byte)0x67,(byte)0x3A,(byte)0x08,(byte)0x73,(byte)0x74,(byte)0x61,(byte)0x72,(byte)0x32,(byte)0x6C,(byte)0x74,(byte)0x65,(byte)0x42,(byte)0x36,(byte)0x73,(byte)0x74,(byte)0x61,(byte)0x72,(byte)0x32,(byte)0x6C,(byte)0x74,(byte)0x65,(byte)0x78,(byte)0x78,(byte)0x2D,(byte)0x75,(byte)0x73,(byte)0x65,(byte)0x72,(byte)0x20,(byte)0x38,(byte)0x2E,(byte)0x30,(byte)0x2E,(byte)0x30,(byte)0x20,(byte)0x52,(byte)0x31,(byte)0x36,(byte)0x4E,(byte)0x57,(byte)0x20,(byte)0x47,(byte)0x39,(byte)0x36,(byte)0x35,(byte)0x46,(byte)0x58,(byte)0x58,(byte)0x55,(byte)0x31,(byte)0x41,(byte)0x52,(byte)0x43,(byte)0x43,(byte)0x20,(byte)0x72,(byte)0x65,(byte)0x6C,(byte)0x65,(byte)0x61,(byte)0x73,(byte)0x65,(byte)0x2D,(byte)0x6B,(byte)0x65,(byte)0x79,(byte)0x73,(byte)0x4A,(byte)0x24,(byte)0x61,(byte)0x65,(byte)0x65,(byte)0x66,(byte)0x65,(byte)0x36,(byte)0x61,(byte)0x30,(byte)0x2D,(byte)0x39,(byte)0x31,(byte)0x33,(byte)0x38,(byte)0x2D,(byte)0x34,(byte)0x31,(byte)0x32,(byte)0x63,(byte)0x2D,(byte)0x62,(byte)0x66,(byte)0x38,(byte)0x61,(byte)0x2D,(byte)0x39,(byte)0x32,(byte)0x62,(byte)0x64,(byte)0x33,(byte)0x30,(byte)0x65,(byte)0x34,(byte)0x62,(byte)0x32,(byte)0x35,(byte)0x32,(byte)0x5A,(byte)0x02,(byte)0x65,(byte)0x6E,(byte)0x62,(byte)0x02,(byte)0x55,(byte)0x53,(byte)0x3A,(byte)0x0A,(byte)0x63,(byte)0x6F,(byte)0x6E,(byte)0x73,(byte)0x6F,(byte)0x6E,(byte)0x61,(byte)0x6E,(byte)0x63,(byte)0x65,(byte)0x4D,(byte)0x0D,(byte)0xE4,(byte)0x7B,(byte)0x99,(byte)0x50,(byte)0x01,(byte)0x60,(byte)0x01};
		System.out.println("<> "+bytesToHex(client_finish_payload));
		int client_finish_length = 0;
		try{
			client_finish_length = hs.writeMessage(buffer2,0,client_finish_payload,0,client_finish_payload.length);
		}catch(ShortBufferException e){
			e.printStackTrace();
		}
		System.out.println("<> "+bytesToHex(buffer2));

		byte[] staticBytes = ByteString.copyFrom(buffer2).substring(0,48).toByteArray();
		byte[] payloadBytes = ByteString.copyFrom(buffer2).substring(48,client_finish_length).toByteArray();
		System.out.println("PP "+client_finish_payload.length+" & "+payloadBytes.length);

		WhatsProtos.HandshakeMessage.ClientFinish client_finish = WhatsProtos.HandshakeMessage.ClientFinish.newBuilder()
				.setStatic(ByteString.copyFrom(staticBytes))
				.setPayload(ByteString.copyFrom(payloadBytes))
				.build();
		byte[] buf = new byte[32];
		hs.getLocalKeyPair().getPublicKey(buf,0);
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

		System.out.println("[Action] "+hs.getAction());

		return hs.split();
	}

	private static void writeHandshakeIK(KeyPair kp,SegmentInputStream in,SegmentOutputStream out) throws IOException{

	}

	private static WhatsProtos.ClientPayload getConfig(){
		WhatsProtos.ClientPayload.UserAgent.AppVersion appVersion = WhatsProtos.ClientPayload.UserAgent.AppVersion.newBuilder()
				.setPrimary(2)
				.setSecondary(20)
				.setTertiary(206)
				//.setQuaternary(22)
				.build();

		WhatsProtos.ClientPayload.UserAgent userAgent = WhatsProtos.ClientPayload.UserAgent.newBuilder()
				.setPlatform(WhatsProtos.ClientPayload.UserAgent.Platform.ANDROID)
				.setMcc("0122")
				.setMnc("334534")
				.setOsVersion("1.2.3.4")
				.setManufacturer("Droid")
				.setDevice("S5")
				.setOsBuildNumber("1.0.5")
				.setPhoneId("123663")
				.setLocaleLanguageIso6391("nl")
				.setLocalCountryIso31661Alpha2("NL")
				.setAppVersion(appVersion)
				.build();

		return WhatsProtos.ClientPayload.newBuilder()
				.setUsername(31612322954L)
				.setPassive(true)
				.setPushName("H_____________OI")
				.setSessionId(5)
				.setShortConnect(false)
				.setConnectType(WhatsProtos.ClientPayload.ConnectType.WIFI)
				.setUserAgent(userAgent).build();
	}

	public void a(){
//		AtomicInteger incoming = new AtomicInteger();
//
//		new Thread(() -> {
//			while(true){
//				try{
//					if(in.available()>0){
//
//
//						if(incoming.get()==0){
//
//
//
//
//
//							//WhatsProtos.HandshakeMessage.
//							//out.writeSegment(new byte[]{0x22,(byte)0xC4,(byte)0x01,(byte)0x0A,(byte)0x30,(byte)0x5D,(byte)0xB1,(byte)0x28,(byte)0x38,(byte)0x99,(byte)0x27,(byte)0xD5,(byte)0xD5,(byte)0x78,(byte)0xD9,(byte)0x68,(byte)0x9F,(byte)0x2C,(byte)0x76,(byte)0x80,(byte)0xFD,(byte)0xA6,(byte)0xFD,(byte)0x5C,(byte)0x7C,(byte)0xF0,(byte)0x1C,(byte)0x2F,(byte)0xCD,(byte)0x2E,(byte)0xB7,(byte)0xAB,(byte)0x2A,(byte)0xC9,(byte)0x8E,(byte)0x9A,(byte)0xAC,(byte)0x0E,(byte)0x4F,(byte)0xE7,(byte)0xEC,(byte)0x1D,(byte)0x0D,(byte)0xE9,(byte)0x64,(byte)0xA0,(byte)0x50,(byte)0x25,(byte)0xA4,(byte)0xEF,(byte)0x12,(byte)0xA5,(byte)0xED,(byte)0x12,(byte)0x8F,(byte)0x01,(byte)0x39,(byte)0xE9,(byte)0xEE,(byte)0x56,(byte)0xCF,(byte)0x06,(byte)0x8B,(byte)0xC4,(byte)0x0D,(byte)0x4A,(byte)0x88,(byte)0x02,(byte)0x74,(byte)0xAB,(byte)0xD9,(byte)0x6B,(byte)0xF7,(byte)0x91,(byte)0x24,(byte)0x96,(byte)0xAB,(byte)0xC1,(byte)0x53,(byte)0x22,(byte)0xE4,(byte)0x85,(byte)0x33,(byte)0x24,(byte)0xC9,(byte)0x82,(byte)0xA3,(byte)0x7D,(byte)0x78,(byte)0x82,(byte)0x87,(byte)0x99,(byte)0x75,(byte)0x67,(byte)0xE9,(byte)0x4C,(byte)0x3D,(byte)0xFE,(byte)0x74,(byte)0x33,(byte)0x55,(byte)0x4C,(byte)0x04,(byte)0xE2,(byte)0xBC,(byte)0xBE,(byte)0x76,(byte)0xE9,(byte)0x70,(byte)0xBE,(byte)0xC8,(byte)0x67,(byte)0xD1,(byte)0xAB,(byte)0x44,(byte)0x52,(byte)0xF6,(byte)0xF8,(byte)0x9C,(byte)0xA5,(byte)0xCD,(byte)0xAC,(byte)0xED,(byte)0x2D,(byte)0x95,(byte)0x2B,(byte)0xF0,(byte)0x86,(byte)0x0F,(byte)0x26,(byte)0x30,(byte)0x5B,(byte)0x77,(byte)0x13,(byte)0xF3,(byte)0xDF,(byte)0x51,(byte)0x65,(byte)0x5B,(byte)0xB9,(byte)0xC7,(byte)0xF7,(byte)0x06,(byte)0x3A,(byte)0x13,(byte)0x62,(byte)0x89,(byte)0x02,(byte)0x8E,(byte)0xCE,(byte)0x39,(byte)0xE6,(byte)0x59,(byte)0xB1,(byte)0xF8,(byte)0x06,(byte)0x63,(byte)0x9A,(byte)0xD4,(byte)0x76,(byte)0x49,(byte)0xD1,(byte)0x01,(byte)0x9C,(byte)0x14,(byte)0xC6,(byte)0xE2,(byte)0xC1,(byte)0xD5,(byte)0xB5,(byte)0x39,(byte)0x7A,(byte)0x14,(byte)0x28,(byte)0xF2,(byte)0x54,(byte)0x9A,(byte)0x24,(byte)0xD7,(byte)0x60,(byte)0x91,(byte)0x48,(byte)0x56,(byte)0x20,(byte)0xC2,(byte)0x4E,(byte)0x9A,(byte)0x26,(byte)0xB2,(byte)0x50,(byte)0xF3,(byte)0xD9,(byte)0x46,(byte)0x31,(byte)0xAB,(byte)0x75,(byte)0x9C,(byte)0x0D,(byte)0xC7});
//							//out.flush();
//						}else{
//							System.out.println(data);
//						}
//
//						incoming.getAndIncrement();
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();
//
//
//
//		//new byte[]{(byte)0xAD,(byte)0xB4,(byte)0xF9,(byte)0xCA,(byte)0x9F,(byte)0x4F,(byte)0x46,(byte)0x5E,(byte)0x96,(byte)0x70,(byte)0xC1,(byte)0x72,(byte)0x41,(byte)0xD4,(byte)0xB4,(byte)0xE8,(byte)0x65,(byte)0x0E,(byte)0xC5,(byte)0xA1,(byte)0x7B,(byte)0x33,(byte)0x05,(byte)0xE0,(byte)0xD2,(byte)0x08,(byte)0x61,(byte)0xD9,(byte)0x7A,(byte)0xEE,(byte)0xF8,(byte)0x02}
//
//
//		//Curve25519PublicKey.a();
//
//		//KeyPair ecdh = new KeyPair();
	}











	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

	public static String bytesToHex(byte[] bytes) {
		if(bytes==null){
			return "NULL";
		}
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = HEX_ARRAY[v >>> 4];
			hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
		}
		return new String(hexChars);
	}

}