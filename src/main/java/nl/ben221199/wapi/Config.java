package nl.ben221199.wapi;

import br.eti.balena.security.ecdh.curve25519.Curve25519PrivateKey;
import br.eti.balena.security.ecdh.curve25519.Curve25519PublicKey;
import com.southernstorm.noise.protocol.DHState;
import com.southernstorm.noise.protocol.Noise;
import com.whatsapp.proto.WA4Protos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.UUID;

public class Config{

//	public static String id = "gerdagerdagerdagerda";
//	public static String cc = "7";
//	public static String in = "9013691751";
//	public static byte[] edge_routing_info = Base64.getDecoder().decode("CAwIAg==");

//	public static String id = "kaaskaaskaaskaaskaas";
//	public static String cc = "7";
//	public static String in = "9622766291";
//	public static byte[] edge_routing_info = Base64.getDecoder().decode("CAwIAg==");

//	public static String id = "abcdefabcdefabcdefab";
//	public static String cc = "7";
//	public static String in = "9631936675";
//	public static byte[] edge_routing_info = null;//Base64.getDecoder().decode("CAUICA==");

//	public static String id = "abcdefabcdefabcdefab";
//	public static String cc = "7";
//	public static String in = "9309676431";
//	public static byte[] edge_routing_info = Base64.getDecoder().decode("CAUICA==");

////	public static String id = "abcdefabcdefabcdefab";
//	public static String cc = "972";
//	public static String in = "503046237";
//	public static byte[] edge_routing_info = Base64.getDecoder().decode("CAgIAg==");

//	public static KeyPair client_static_keypair;
//	static{
//		try {
//			client_static_keypair = Config.getClientStaticKeyPair();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//	}
	public static PublicKey server_static_key = null;

//	public static WA4Protos.ClientPayload PAYLOAD = Config.getConfig();

	public static WA4Protos.ClientPayload getConfig(long username){
		WA4Protos.ClientPayload.UserAgent.AppVersion appVersion = WA4Protos.ClientPayload.UserAgent.AppVersion.newBuilder()
				.setPrimary(2)
				.setSecondary(20)
				.setTertiary(206)
				.setQuaternary(22)
				.build();

		WA4Protos.ClientPayload.UserAgent userAgent = WA4Protos.ClientPayload.UserAgent.newBuilder()
				.setPlatform(WA4Protos.ClientPayload.UserAgent.Platform.ANDROID)
				//.setMcc("12")
				//.setMnc("334534")
				.setOsVersion("1.2.3.4")
				.setManufacturer("Droid")
				.setDevice("S5")
				.setOsBuildNumber("1.0.5")
				.setPhoneId(UUID.randomUUID().toString())
				.setLocaleLanguageIso6391("nl")
				.setLocalCountryIso31661Alpha2("NL")
				.setAppVersion(appVersion)
				.build();

		return WA4Protos.ClientPayload.newBuilder()
				.setUsername(username)
				.setPassive(true)
				.setPushName("H_____________OI")
				.setSessionId(5)
				.setShortConnect(false)
				.setConnectType(WA4Protos.ClientPayload.ConnectType.WIFI_UNKNOWN)
				.setUserAgent(userAgent).build();
	}

//	private static KeyPair getClientStaticKeyPair() throws IOException, NoSuchAlgorithmException {
//		File keypairFile = new File(id+"_keypair.txt");
//		if(keypairFile.exists()){
//			FileInputStream fos = new FileInputStream(keypairFile);
//			byte[] bytes = new byte[64];
//			fos.read(bytes);
//			fos.close();
////			bytes = Base64.getDecoder().decode("yM8j4VCg5YSdITmx8bVyRJN6Ekrujri+9PZQLDxLlmxScul6forvBztjpU3ys8M94grJgCh1z10f2zDtzXaoNA");
////			System.err.println("HASH = "+bytes.length+" "+Base64.getEncoder().encodeToString(bytes));
//			return new KeyPair(new Curve25519PublicKey(Arrays.copyOfRange(bytes,0,32)),new Curve25519PrivateKey(Arrays.copyOfRange(bytes,32,64)));
//		}
//		DHState client_static_keypair = Noise.createDH("25519");
//		client_static_keypair.generateKeyPair();
//		byte[] public_key_bytes = new byte[client_static_keypair.getPublicKeyLength()];
//		client_static_keypair.getPublicKey(public_key_bytes,0);
//		byte[] private_key_bytes = new byte[client_static_keypair.getPrivateKeyLength()];
//		client_static_keypair.getPrivateKey(private_key_bytes,0);
//		FileOutputStream fos = new FileOutputStream(keypairFile);
//		fos.write(public_key_bytes);
//		fos.write(private_key_bytes);
//		fos.flush();
//		fos.close();
//		return new KeyPair(new Curve25519PublicKey(public_key_bytes),new Curve25519PrivateKey(private_key_bytes));
//	}

	public static void saveClientStaticKeyPair(String id,KeyPair keypair) throws IOException {
		byte[] pub = keypair.getPublic().getEncoded();
		byte[] priv = keypair.getPrivate().getEncoded();

		byte[] keypairBytes = new byte[pub.length+priv.length];
		System.arraycopy(pub,0,keypairBytes,0,pub.length);
		System.arraycopy(priv,0,keypairBytes,pub.length,priv.length);
		Config.saveFile(id,"keypair",keypairBytes);
	}

	public static KeyPair loadClientStaticKeypair(String id) throws IOException {
		byte[] content = Config.loadFile(id,"keypair");
		return new KeyPair(new Curve25519PublicKey(Arrays.copyOfRange(content,0,32)),new Curve25519PrivateKey(Arrays.copyOfRange(content,32,64)));
	}

	public static void saveCountryCode(String id,String cc) throws IOException {
		Config.saveFile(id,"cc",cc.getBytes());
	}

	public static String loadCountryCode(String id) throws IOException {
		return new String(Config.loadFile(id,"cc"));
	}

	public static void saveInternalNumber(String id,String in) throws IOException {
		Config.saveFile(id,"in",in.getBytes());
	}

	public static String loadInternalNumber(String id) throws IOException {
		return new String(Config.loadFile(id,"in"));
	}

	private static void saveFile(String id,String name,byte[] content) throws IOException {
		File file = new File(id+"_"+name+".txt");
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(content);
		fos.flush();
		fos.close();
	}

	private static byte[] loadFile(String id,String name) throws IOException {
		File file = new File(id+"_"+name+".txt");
		FileInputStream fos = new FileInputStream(file);
		byte[] bytes = new byte[fos.available()];
		fos.read(bytes);
		fos.close();
		return bytes;
	}

	public static KeyPair generateClientStaticKeyPair() throws NoSuchAlgorithmException{
		DHState client_static_keypair = Noise.createDH("25519");
		client_static_keypair.generateKeyPair();
		byte[] public_key_bytes = new byte[client_static_keypair.getPublicKeyLength()];
		client_static_keypair.getPublicKey(public_key_bytes,0);
		byte[] private_key_bytes = new byte[client_static_keypair.getPrivateKeyLength()];
		client_static_keypair.getPrivateKey(private_key_bytes,0);
		return new KeyPair(new Curve25519PublicKey(public_key_bytes),new Curve25519PrivateKey(private_key_bytes));
	}

}