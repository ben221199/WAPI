package nl.ben221199.wapi;

public class Base64{

	public static final char CHAR_62 = '+';
	public static final char CHAR_63 = '/';

	public static final char CHAR_62_URLSAFE = '-';
	public static final char CHAR_63_URLSAFE = '_';

	public static String convertFromURLSafe(String base64){
		return base64.replaceAll(Character.valueOf(Base64.CHAR_62_URLSAFE).toString(),"\\"+Base64.CHAR_62).replaceAll("\\"+Base64.CHAR_63_URLSAFE,Character.valueOf(Base64.CHAR_63).toString());
	}

	public static String convertToURLSafe(String base64){
		return base64.replaceAll("\\"+Base64.CHAR_62,"\\"+Base64.CHAR_62_URLSAFE).replaceAll(Character.valueOf(Base64.CHAR_63).toString(),"\\"+Base64.CHAR_63_URLSAFE);
	}

	public static String encode(byte[] bytes){
		return java.util.Base64.getEncoder().encodeToString(bytes);
	}

	public static byte[] decode(String str){
		return java.util.Base64.getDecoder().decode(str);
	}

}