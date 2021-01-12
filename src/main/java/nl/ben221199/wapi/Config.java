package nl.ben221199.wapi;

import br.eti.balena.security.ecdh.curve25519.Curve25519PrivateKey;
import br.eti.balena.security.ecdh.curve25519.Curve25519PublicKey;
import com.southernstorm.noise.protocol.DHState;
import com.southernstorm.noise.protocol.Noise;
import nl.ben221199.wapi.protobuf.WhatsProtos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Base64;

public class Config{

	public static String id = "abcdeabcdeabcde12350";
	public static String cc = "7";
	public static String in = "9670154494";
	public static byte[] edge_routing_info = Base64.getDecoder().decode("CAUICA==");

	public static KeyPair client_static_keypair;
	static{
		try {
			client_static_keypair = Config.getClientStaticKeyPair();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	public static PublicKey server_static_key = null;

	public static WhatsProtos.ClientPayload PAYLOAD = Config.getConfig();

	private static WhatsProtos.ClientPayload getConfig(){
		WhatsProtos.ClientPayload.UserAgent.AppVersion appVersion = WhatsProtos.ClientPayload.UserAgent.AppVersion.newBuilder()
				.setPrimary(2)
				.setSecondary(20)
				.setTertiary(206)
				.setQuaternary(22)
				.build();

		WhatsProtos.ClientPayload.UserAgent userAgent = WhatsProtos.ClientPayload.UserAgent.newBuilder()
				.setPlatform(WhatsProtos.ClientPayload.UserAgent.Platform.ANDROID)
				//.setMcc("12")
				//.setMnc("334534")
				.setOsVersion("1.2.3.4")
				.setManufacturer("Droid")
				.setDevice("S5")
				.setOsBuildNumber("1.0.5")
				.setPhoneId(cc+in)
				.setLocaleLanguageIso6391("nl")
				.setLocalCountryIso31661Alpha2("NL")
				.setAppVersion(appVersion)
				.build();

		return WhatsProtos.ClientPayload.newBuilder()
				.setUsername(Long.parseLong(cc+in))
				.setPassive(true)
				.setPushName("H_____________OI")
				.setSessionId(5)
				.setShortConnect(false)
				.setConnectType(WhatsProtos.ClientPayload.ConnectType.WIFI)
				.setUserAgent(userAgent).build();
	}

	private static KeyPair getClientStaticKeyPair() throws IOException, NoSuchAlgorithmException {
		File keypairFile = new File("keypair.txt");
		if(keypairFile.exists()){
			FileInputStream fos = new FileInputStream(keypairFile);
			byte[] bytes = new byte[64];
			fos.read(bytes);
			fos.close();
			return new KeyPair(new Curve25519PublicKey(Arrays.copyOfRange(bytes,0,32)),new Curve25519PrivateKey(Arrays.copyOfRange(bytes,32,64)));
		}
		DHState client_static_keypair = Noise.createDH("25519");
		client_static_keypair.generateKeyPair();
		byte[] public_key_bytes = new byte[client_static_keypair.getPublicKeyLength()];
		client_static_keypair.getPublicKey(public_key_bytes,0);
		byte[] private_key_bytes = new byte[client_static_keypair.getPrivateKeyLength()];
		client_static_keypair.getPrivateKey(private_key_bytes,0);
		FileOutputStream fos = new FileOutputStream(keypairFile);
		fos.write(public_key_bytes);
		fos.write(private_key_bytes);
		fos.flush();
		fos.close();
		return new KeyPair(new Curve25519PublicKey(public_key_bytes),new Curve25519PrivateKey(private_key_bytes));
	}

}