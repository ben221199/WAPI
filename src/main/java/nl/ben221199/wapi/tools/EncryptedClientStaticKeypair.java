package nl.ben221199.wapi.tools;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONArray;

public class EncryptedClientStaticKeypair{

	private static final String SOMETOKEN = "A\u0004\u001d@\u0011\u0018V\u0002T(3{;ES";

	public final int type;
	public final byte[] ciphertext;
	public final byte[] iv;
	public final byte[] salt;
	public final byte[] password;

	public EncryptedClientStaticKeypair(int type,byte[] ciphertext,byte[] iv,byte[] salt,byte[] password){
		this.type = type;
		this.ciphertext = ciphertext;
		this.iv = iv;
		this.salt = salt;
		this.password = password;
	}

	public byte[] decrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {
		if(this.type!=2){
			throw new RuntimeException("The type should be 2.");
		}
		String sb2 = EncryptedClientStaticKeypair.doSomething(SOMETOKEN)+Base64.getEncoder().encodeToString(this.password);
		SecretKeySpec secretKeySpec = new SecretKeySpec(EncryptedClientStaticKeypair.doSomething2(sb2,this.salt),"AES/OFB/NoPadding");
		Cipher instance = Cipher.getInstance("AES/OFB/NoPadding");
		instance.init(this.type,secretKeySpec,new IvParameterSpec(this.iv));
		return instance.doFinal(this.ciphertext);
	}

	public JSONArray toJSONArray(){
		JSONArray arr = new JSONArray();
		arr.put(this.type);
		arr.put(Base64.getEncoder().encodeToString(this.ciphertext));
		arr.put(Base64.getEncoder().encodeToString(this.iv));
		arr.put(Base64.getEncoder().encodeToString(this.salt));
		arr.put(Base64.getEncoder().encodeToString(this.password));
		return arr;
	}

	public static EncryptedClientStaticKeypair encrypt(byte[] client_static_keypair) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		byte[] bArr2 = new byte[4];
		SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr2);
		byte[] bArr3 = new byte[16];
		SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr3);
		byte[] bArr4 = new byte[16];
		SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr4);
		String encodeToString = Base64.getEncoder().encodeToString(bArr4);
		String sb = EncryptedClientStaticKeypair.doSomething(EncryptedClientStaticKeypair.SOMETOKEN)+encodeToString;
		SecretKeySpec secretKeySpec = new SecretKeySpec(doSomething2(sb, bArr2), "AES/OFB/NoPadding");
		Cipher instance = Cipher.getInstance("AES/OFB/NoPadding");
		instance.init(1, secretKeySpec, new IvParameterSpec(bArr3));
		byte[] ciphertext = instance.doFinal(client_static_keypair);
		return new EncryptedClientStaticKeypair(2, ciphertext, bArr3, bArr2, bArr4);



//		//TODO Encrypt client_static_keypair
//		return null;
	}

	public static EncryptedClientStaticKeypair fromJSONArray(JSONArray arr){
		int type = arr.getInt(0);
		byte[] ciphertext = Base64.getDecoder().decode(arr.getString(1));
		byte[] random1 = Base64.getDecoder().decode(arr.getString(2));
		byte[] random2 = Base64.getDecoder().decode(arr.getString(3));
		byte[] random3 = Base64.getDecoder().decode(arr.getString(4));
		return new EncryptedClientStaticKeypair(type,ciphertext,random1,random2,random3);
	}

	public static String doSomething(String str){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			sb.append((char) (str.charAt(i) ^ 18));
		}
		return sb.toString();
	}

	private static byte[] doSomething2(String passwordCharsStr, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] bytes = passwordCharsStr.getBytes();
		int length = bytes.length;
		char[] passwordChars = new char[length];
		for (int i = 0; i < length; i++) {
			passwordChars[i] = (char) bytes[i];
		}
		return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1And8BIT").generateSecret(new PBEKeySpec(passwordChars, salt, 16, 128)).getEncoded(), "AES").getEncoded();
	}

}