package nl.ben221199.wapi;

import org.whispersystems.curve25519.Curve25519;
import org.whispersystems.curve25519.Curve25519KeyPair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;

public class Verification{

	private static final String AES_GCM_NOPADDING = "AES/GCM/NoPadding";
	private static final String HMAC_SHA1 = "HmacSHA1";

	private static final byte[] ENCRYPT_KEY = new byte[]{
			(byte)142,	(byte)140,	(byte)15,	(byte)116,	(byte)195,	(byte)235,	(byte)197,	(byte)215,
			(byte)166,	(byte)134,	(byte)92,	(byte)108,	(byte)60,	(byte)132,	(byte)56,	(byte)86,
			(byte)176,	(byte)97,	(byte)33,	(byte)204,	(byte)232,	(byte)234,	(byte)119,	(byte)77,
			(byte)34,	(byte)251,	(byte)111,	(byte)18,	(byte)37,	(byte)18,	(byte)48,	(byte)45,
	};

	public enum Platform{
		ANDROID,
		NOKIA,
	}

	/**
	 * Minimum parameters:
	 * https://v.whatsapp.net/v2/exist?authkey={RANDOM:PUBLICKEY}&in={CONFIG:INTERNALNUMBER}&cc={CONFIG:COUNTRYCODE}&id={CONFIG:ID}
	 * @param userAgent User Agent
	 * @param query Query
	 * @return The JSON content
	 * @throws IOException Exception when request is failing
	 */
	public static String exist(String userAgent,boolean encrypted,String... query) throws IOException{
		String parameters = String.join("&",query);
		System.out.println(parameters);
		if(encrypted){
			parameters = Verification.encryptParameters(parameters);
			System.out.println(parameters);
		}
		HttpsURLConnection conn = (HttpsURLConnection) new URL(Constants.Verification.BASE_URL+"exist?"+parameters).openConnection();
		conn.setRequestProperty("User-Agent",userAgent);
		return Verification.runConnection(conn);
	}
	
	/**
	 * Minimum parameters:
	 * https://v.whatsapp.net/v2/code?authkey={RANDOM:PUBLICKEY}&in={CONFIG:INTERNALNUMBER}&cc={CONFIG:COUNTRYCODE}&token={TOKEN:IN}&id={CONFIG:ID}&method=sms
	 * @param userAgent User Agent
	 * @param query Query
	 * @return The JSON content
	 * @throws IOException Exception when request is failing
	 */
	public static String code(String userAgent,boolean encrypted,String... query) throws IOException{
		String parameters = String.join("&",query);
		System.out.println(parameters);
		if(encrypted){
			parameters = Verification.encryptParameters(parameters);
			System.out.println(parameters);
		}
		HttpsURLConnection conn = (HttpsURLConnection) new URL(Constants.Verification.BASE_URL+"code?"+parameters).openConnection();
		conn.setRequestProperty("User-Agent",userAgent);
		return Verification.runConnection(conn);
	}

	/**
	 * Minimum parameters:
	 * https://v.whatsapp.net/v2/register?authkey={RANDOM:PUBLICKEY}&in={CONFIG:INTERNALNUMBER}&cc={CONFIG:COUNTRYCODE}&code={CODE}&id={CONFIG:ID}
	 * @param userAgent User Agent
	 * @param query Query
	 * @return The JSON content
	 * @throws IOException Exception when request is failing
	 */
	public static String register(String userAgent,boolean encrypted,String... query) throws IOException{
		String parameters = String.join("&",query);
		System.out.println(parameters);
		if(encrypted){
			parameters = Verification.encryptParameters(parameters);
			System.out.println(parameters);
		}
		HttpsURLConnection conn = (HttpsURLConnection) new URL(Constants.Verification.BASE_URL+"register?"+parameters).openConnection();
		conn.setRequestProperty("User-Agent",userAgent);
		return Verification.runConnection(conn);
	}

	/**
	 * Calculate token
	 * @param internalNumber Internal Number
	 * @return Token
	 */
	public static String calculateToken(String internalNumber){
		return Verification.calculateToken(internalNumber,Verification.Platform.ANDROID);
	}

	/**
	 * Calculate token based on platform
	 * @param internalNumber Internal Number
	 * @param platform Platform
	 * @return Token
	 */


	public static String calculateToken(String internalNumber, Verification.Platform platform) {
		TokenCalculator tokenCalculator = TokenCalculatorFactory.getCalculator(platform);
		return tokenCalculator.calculateToken(internalNumber);
	}

	/**
	 * Calculate token for Android by internal number
	 * @param internalNumber Internal Number
	 */
	public static String calculateAndroidToken(String internalNumber){
		byte[] certificate = Constants.Verification.Android.CERTIFICATE;
		byte[] classesHash = Constants.Verification.Android.CLASSES_HASH;
		byte[] numberBytes = internalNumber.getBytes();
		byte[] secretKey = Constants.Verification.Android.SECRET_KEY;

		byte[] data = new byte[certificate.length+classesHash.length+numberBytes.length];
		System.arraycopy(certificate,0,data,0,certificate.length);
		System.arraycopy(classesHash,0,data,certificate.length,classesHash.length);
		System.arraycopy(numberBytes,0,data,certificate.length+classesHash.length,numberBytes.length);

		try{
			Mac hmac_sha1 = Mac.getInstance(Verification.HMAC_SHA1);
			hmac_sha1.init(new SecretKeySpec(Arrays.copyOfRange(secretKey,0,64),Verification.HMAC_SHA1));
			return Base64.encode(hmac_sha1.doFinal(data));
		}catch(NoSuchAlgorithmException | InvalidKeyException e){
			e.printStackTrace();
		}
		return null;
	}

	public static String calculateNokiaToken(String internalNumber){
		String tokenSalt = Constants.Verification.Nokia.TOKEN_SALT;
		String releaseTime = Long.toString(Constants.Verification.Nokia.RELEASE_TIME);
		try{
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			return Hex.fromBytes(md5.digest((tokenSalt+releaseTime+internalNumber).getBytes()));
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return null;
	}

	private static String encryptParameters(String parameters){
		try{
			Curve25519KeyPair keyPair = Curve25519.getInstance(Curve25519.BEST).generateKeyPair();
			byte[] publicKey = keyPair.getPublicKey();
			byte[] sharedSecret = Curve25519.getInstance(Curve25519.BEST).calculateAgreement(Verification.ENCRYPT_KEY,keyPair.getPrivateKey());

			Cipher cipher = Cipher.getInstance(Verification.AES_GCM_NOPADDING);
			cipher.init(Cipher.ENCRYPT_MODE,new SecretKeySpec(sharedSecret,Verification.AES_GCM_NOPADDING),new IvParameterSpec(new byte[12]));
			byte[] ciphertext = cipher.doFinal(parameters.getBytes());

			byte[] encryptedParameters = new byte[publicKey.length+ciphertext.length];
			System.arraycopy(publicKey,0,encryptedParameters,0,publicKey.length);
			System.arraycopy(ciphertext,0,encryptedParameters,publicKey.length,ciphertext.length);

			return "ENC="+Base64.encode(encryptedParameters);
		}catch(Exception e){
			e.printStackTrace();
		}
		return parameters;
	}

	private static String runConnection(HttpURLConnection conn) throws IOException{
		conn.connect();
		InputStream in;
		try{
			in = conn.getInputStream();
		}catch(Exception e){
			in = conn.getErrorStream();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = br.readLine())!=null){
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}

}