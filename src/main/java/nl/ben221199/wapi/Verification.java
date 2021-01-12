package nl.ben221199.wapi;

import com.google.protobuf.ByteString;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Verification{

	/**
	 * Minimum parameters:
	 * https://v.whatsapp.net/v2/exist?authkey={RANDOM:PUBLICKEY}&in={CONFIG:INTERNALNUMBER}&cc={CONFIG:COUNTRYCODE}&id={CONFIG:ID}
	 * @param query Query
	 * @return The JSON content
	 * @throws IOException Exception when request is failing
	 */
	public static String exist(String... query) throws IOException{
		HttpsURLConnection conn = (HttpsURLConnection) new URL(Constants.Verification.BASE_URL+"exist?"+String.join("&",query)).openConnection();
		conn.setRequestProperty("User-Agent",Constants.Verification.USER_AGENT);
		return Verification.runConnection(conn);
	}
	
	/**
	 * Minimum parameters:
	 * https://v.whatsapp.net/v2/code?authkey={RANDOM:PUBLICKEY}&in={CONFIG:INTERNALNUMBER}&cc={CONFIG:COUNTRYCODE}&token={TOKEN:IN}&id={CONFIG:ID}&method=sms
	 * @param query Query
	 * @return The JSON content
	 * @throws IOException Exception when request is failing
	 */
	public static String code(String... query) throws IOException{
		HttpsURLConnection conn = (HttpsURLConnection) new URL(Constants.Verification.BASE_URL+"code?"+String.join("&",query)).openConnection();
		conn.setRequestProperty("User-Agent",Constants.Verification.USER_AGENT);
		return Verification.runConnection(conn);
	}

	/**
	 * Minimum parameters:
	 * https://v.whatsapp.net/v2/register?authkey={RANDOM:PUBLICKEY}&in={CONFIG:INTERNALNUMBER}&cc={CONFIG:COUNTRYCODE}&code={CODE}&id={CONFIG:ID}
	 * @param query Query
	 * @return The JSON content
	 * @throws IOException Exception when request is failing
	 */
	public static String register(String... query) throws IOException{
		HttpsURLConnection conn = (HttpsURLConnection) new URL(Constants.Verification.BASE_URL+"register?"+String.join("&",query)).openConnection();
		conn.setRequestProperty("User-Agent",Constants.Verification.USER_AGENT);
		return Verification.runConnection(conn);
	}

	public static String calculateAndroidToken(String internalNumber){
		byte[] keyDecoded = Base64.getDecoder().decode(Constants.Verification.PRIVATE_KEY);
		byte[] sigDecoded = Base64.getDecoder().decode(Constants.Verification.CERTIFICATE_APK);
		byte[] clsDecoded = Base64.getDecoder().decode(Constants.Verification.HASH_CLASSES);

		byte[] data = ByteString.copyFrom(sigDecoded).concat(ByteString.copyFrom(clsDecoded)).concat(ByteString.copyFrom(internalNumber.getBytes())).toByteArray();

		byte[] opad = new byte[64];
		byte[] ipad = new byte[64];
		for(int i=0;i<64;i++){
			opad[i] = (byte) (0x5C ^ keyDecoded[i]);
			ipad[i] = (byte) (0x36 ^ keyDecoded[i]);
		}
		MessageDigest hash;
		MessageDigest subHash;
		try{
			hash = MessageDigest.getInstance("SHA1");
			subHash = MessageDigest.getInstance("SHA1");
		}catch(NoSuchAlgorithmException e){
			return null;
		}
		subHash.update(ByteString.copyFrom(ipad).concat(ByteString.copyFrom(data)).toByteArray());
		hash.update(ByteString.copyFrom(opad).concat(ByteString.copyFrom(subHash.digest())).toByteArray());
		return Base64.getEncoder().encodeToString(hash.digest());
	}

//	public static String calculateNokiaToken(String phoneNumber){
//		String $const = "PdA2DJyKoUrwLw1Bg6EIhzh502dF9noR9uFCllGk";
//		String releaseTime = "1452554789539"; // 2.13.30
//		MessageDigest md5;
//		try{
//			md5 = MessageDigest.getInstance("MD5");
//		}catch(NoSuchAlgorithmException e){
//			return null;
//		}
//		md5.update(($const+releaseTime+phoneNumber).getBytes());
//		return Main.bytesToHex(md5.digest());
//	}

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