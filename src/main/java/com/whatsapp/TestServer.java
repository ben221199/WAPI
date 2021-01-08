package com.whatsapp;

import com.google.protobuf.ByteString;
import com.southernstorm.noise.protocol.CipherStatePair;
import com.southernstorm.noise.protocol.HandshakeState;
import com.whatsapp.protobuf.WhatsProtos;

import javax.crypto.BadPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class TestServer extends Thread{

	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(8443);
			while(true){
				TestServer.runClient(ss.accept());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void runClient(Socket s) throws IOException{
		HandshakeState hs = null;
		try{
			//Noise.setForceFallbacks(true);
			hs = new HandshakeState("Noise_XX_25519_AESGCM_SHA256",HandshakeState.RESPONDER);
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		if(hs==null){
			return;
		}
		hs.getLocalKeyPair().generateKeyPair();
		hs.start();

		NoiseInputStream in = new NoiseInputStream(s.getInputStream());
		NoiseOutputStream out = new NoiseOutputStream(s.getOutputStream());

		byte[] WA = new byte[4];
		in.read(WA);
		System.out.println("WhatsApp Protocol "+WA[2]+"."+WA[3]);

		byte[] client_hello_data = in.readSegment();
		WhatsProtos.HandshakeMessage clientHello = WhatsProtos.HandshakeMessage.parseFrom(client_hello_data);
		byte[] ephemeral = clientHello.getClientHello().getEphemeral().toByteArray();
		byte[] client_hello = new byte[800];
		try {
			hs.readMessage(ephemeral,0,ephemeral.length,client_hello,0);
		} catch (BadPaddingException|ShortBufferException e) {
			e.printStackTrace();
		}
		System.out.println("[SERVER] "+clientHello.toString().trim());

		byte[] data = new byte[0];

		byte[] message = new byte[800];
		try {
			message = Arrays.copyOfRange(message,0,hs.writeMessage(message,0,data,0,data.length));
		} catch (ShortBufferException e) {
			e.printStackTrace();
		}
		WhatsProtos.HandshakeMessage serverHello = WhatsProtos.HandshakeMessage.newBuilder().setServerHello(WhatsProtos.HandshakeMessage.ServerHello.newBuilder()
				.setEphemeral(ByteString.copyFrom(Arrays.copyOfRange(message,0,32)))
				.setStatic(ByteString.copyFrom(Arrays.copyOfRange(message,32,32+48)))
				.setPayload(ByteString.copyFrom(Arrays.copyOfRange(message,32+48,message.length)))
				.build()).build();
		System.out.println("[SERVER] "+serverHello.toString().trim());
		out.writeSegment(serverHello.toByteArray());

		byte[] client_finish_data = in.readSegment();
		System.out.println("ZZZZ "+Main.bytesToHex(client_finish_data));
		WhatsProtos.HandshakeMessage clientFinish = WhatsProtos.HandshakeMessage.parseFrom(client_finish_data);
		byte[] a = clientFinish.getClientFinish().getStatic().concat(clientFinish.getClientFinish().getPayload()).toByteArray();
		byte[] client_finish = new byte[800];
		int length = 0;
		try {
			length = hs.readMessage(a,0,a.length,client_finish,0);
		} catch (BadPaddingException|ShortBufferException e) {
			e.printStackTrace();
		}
		System.out.println("[SERVER] "+clientFinish.toString().trim());
		byte[] finish = Arrays.copyOfRange(client_finish,0,length);
		System.out.println(WhatsProtos.ClientPayload.parseFrom(finish));

		CipherStatePair cipherStatePair = hs.split();

		in.setCipherState(cipherStatePair.getReceiver());
		out.setCipherState(cipherStatePair.getSender());

		System.out.println("From client = "+new String(in.readDecryptedSegment()));
		out.writeEncryptedSegment("DOEI".getBytes());
	}

}