package com.whatsapp;

import com.google.protobuf.InvalidProtocolBufferException;
import com.southernstorm.noise.protocol.DHState;
import com.whatsapp.protobuf.WhatsProtos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.whispersystems.curve25519.Curve25519;

public class CertificateChecker{

	private static final Map<String,byte[]> PUBKEYS = new HashMap<>();

	static{
		PUBKEYS.put("WhatsAppLongTerm1",new byte[]{20, 35, 117, 87, 77, 10, 88, 113, 102, (byte) 170, (byte) 231, 30, (byte) 190, 81, 100, 55, (byte) 196, (byte) 162, (byte) 139, 115, (byte) 227, 105, 92, 108, (byte) 225, (byte) 247, (byte) 249, 84, 93, (byte) 168, (byte) 238, 107});
	}

	public static boolean check(WhatsProtos.NoiseCertificate certificate,DHState remote) throws InvalidProtocolBufferException{
		WhatsProtos.NoiseCertificate.Details details = WhatsProtos.NoiseCertificate.Details.parseFrom(certificate.getDetails());
		System.out.println("[] Certificate = "+certificate.toString().trim());
		System.out.println("[] - Details = "+details.toString().trim());

		System.err.printf("[CC] NoiseCertificate(signature=[%d bytes], serial=%d, issuer='%s', expires=%d, subject='%s', key=[%d bytes])",certificate.getSignature().size(),details.getSerial(),details.getIssuer(),details.getExpires(),details.getSubject(),details.getKey().size()).println();

		if(!PUBKEYS.containsKey(details.getIssuer())){
			System.out.printf("[CC] noise certificate issued by unknown source: issuer=%s",details.getIssuer()).println();
			return false;
		}

		if(!Curve25519.getInstance(Curve25519.BEST).verifySignature(PUBKEYS.get(details.getIssuer()),certificate.getDetails().toByteArray(),certificate.getSignature().toByteArray())) {
			System.out.printf("invalid signature on noise ceritificate; issuer=%s",details.getIssuer()).println();
			return false;
		}

		byte[] pubkey = new byte[32];
		remote.getPublicKey(pubkey,0);
		if(!Arrays.equals(details.getKey().toByteArray(),pubkey)){
			System.out.printf("[CC] noise certificate key does not match proposed server static key; issuer=%s",details.getIssuer()).println();
			return false;
		}

		if(details.hasExpires() && details.getExpires()<System.currentTimeMillis()/1000){
			System.out.printf("[CC] noise certificate expired; issuer=%s",details.getIssuer()).println();
			return false;
		}

		return true;
	}

}