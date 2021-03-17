package nl.ben221199.wapi;

public class Base64{

	public static String encode(byte[] bytes){
		return java.util.Base64.getEncoder().encodeToString(bytes);
	}

	public static byte[] decode(String str){
		return java.util.Base64.getDecoder().decode(str);
	}

}