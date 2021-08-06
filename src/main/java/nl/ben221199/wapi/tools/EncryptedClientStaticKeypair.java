package nl.ben221199.wapi.tools;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import nl.ben221199.wapi.Base64;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.json.JSONArray;

public class EncryptedClientStaticKeypair{

	static{
		Security.addProvider(new BouncyCastleProvider());
	}

	private static final int TYPE = 2;

	private static final String SOMETOKEN = "A\u0004\u001d@\u0011\u0018V\u0002T(3{;ES";

	public final int type;
	public final byte[] ciphertext;
	public final byte[] iv;
	public final byte[] salt;
	public final String password;

	public EncryptedClientStaticKeypair(int type,byte[] ciphertext,byte[] iv,byte[] salt,String password){
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
		String sb2 = EncryptedClientStaticKeypair.doSomething(SOMETOKEN)+this.password;
		SecretKeySpec secretKeySpec = new SecretKeySpec(EncryptedClientStaticKeypair.doSomething2(sb2,this.salt),"AES/OFB/NoPadding");
		Cipher instance = Cipher.getInstance("AES/OFB/NoPadding");
		instance.init(Cipher.DECRYPT_MODE,secretKeySpec,new IvParameterSpec(this.iv));
		return instance.doFinal(this.ciphertext);
	}

	public JSONArray toJSONArray(){
		JSONArray arr = new JSONArray();
		arr.put(this.type);
		arr.put(Base64.encode(this.ciphertext));
		arr.put(Base64.encode(this.iv));
		arr.put(Base64.encode(this.salt));
		arr.put(this.password);
		return arr;
	}

	public static EncryptedClientStaticKeypair encrypt(byte[] client_static_keypair) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		byte[] saltBytes = new byte[4];
		SecureRandom.getInstance("SHA1PRNG").nextBytes(saltBytes);
		byte[] ivBytes = new byte[16];
		SecureRandom.getInstance("SHA1PRNG").nextBytes(ivBytes);
		byte[] passwordBytes = new byte[16];
		SecureRandom.getInstance("SHA1PRNG").nextBytes(passwordBytes);
		String encodeToString = Base64.encode(passwordBytes);
		String sb = EncryptedClientStaticKeypair.doSomething(EncryptedClientStaticKeypair.SOMETOKEN)+encodeToString;
		SecretKeySpec secretKeySpec = new SecretKeySpec(doSomething2(sb, saltBytes), "AES/OFB/NoPadding");
		Cipher instance = Cipher.getInstance("AES/OFB/NoPadding");
		instance.init(Cipher.ENCRYPT_MODE, secretKeySpec,new IvParameterSpec(ivBytes));
		byte[] ciphertext = instance.doFinal(client_static_keypair);
		return new EncryptedClientStaticKeypair(EncryptedClientStaticKeypair.TYPE, ciphertext, ivBytes, saltBytes, Base64.encode(passwordBytes));
	}

	public static EncryptedClientStaticKeypair fromJSONArray(JSONArray arr){
		int type = arr.getInt(0);
		byte[] ciphertext = Base64.decode(arr.getString(1));
		byte[] random1 = Base64.decode(arr.getString(2));
		byte[] random2 = Base64.decode(arr.getString(3));
		String random3 = arr.getString(4);
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
		return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1And8bit").generateSecret(new PBEKeySpec(passwordChars, salt, 16, 128)).getEncoded(), "AES").getEncoded();
	}

}