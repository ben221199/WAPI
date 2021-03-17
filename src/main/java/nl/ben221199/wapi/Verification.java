package nl.ben221199.wapi;

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

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;

public class Verification{

	private static final String HMAC_SHA1 = "HmacSHA1";

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
	public static String exist(String userAgent,String... query) throws IOException{
		System.out.println(String.join("&",query));
		HttpsURLConnection conn = (HttpsURLConnection) new URL(Constants.Verification.BASE_URL+"exist?"+String.join("&",query)).openConnection();
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
	public static String code(String userAgent,String... query) throws IOException{
		System.out.println(String.join("&",query));
		HttpsURLConnection conn = (HttpsURLConnection) new URL(Constants.Verification.BASE_URL+"code?"+String.join("&",query)).openConnection();
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
	public static String register(String userAgent,String... query) throws IOException{
		System.out.println(String.join("&",query));
		HttpsURLConnection conn = (HttpsURLConnection) new URL(Constants.Verification.BASE_URL+"register?"+String.join("&",query)).openConnection();
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
	public static String calculateToken(String internalNumber,Verification.Platform platform){
		switch(platform){
			case ANDROID:{
				return Verification.calculateAndroidToken(internalNumber);
			}
			case NOKIA:{
				return Verification.calculateNokiaToken(internalNumber);
			}
		}
		return null;
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