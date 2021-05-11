package nl.ben221199.wapi;

import br.eti.balena.security.ecdh.curve25519.Curve25519PrivateKey;
import br.eti.balena.security.ecdh.curve25519.Curve25519PublicKey;

import com.southernstorm.noise.protocol.DHState;
import com.southernstorm.noise.protocol.Noise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.json.JSONObject;

public class Config{

	private JSONObject data;

	public Config(){
		this.data = new JSONObject();
	}

	public String getString(String key){
		return this.data.getString(key);
	}

	public void setString(String key,String value){
		this.data.put(key,value);
	}

	public long getLong(String key){
		return this.data.getLong(key);
	}

	public void setLong(String key,long value){
		this.data.put(key,value);
	}

	public KeyPair getClientStaticKeypair(){
		byte[] keypairBytes = Base64.decode(this.getString("client_static_keypair"));
		return new KeyPair(new Curve25519PublicKey(Arrays.copyOfRange(keypairBytes,0,32)),new Curve25519PrivateKey(Arrays.copyOfRange(keypairBytes,32,64)));
	}

	public void setClientStaticKeypair(KeyPair keypair){
		byte[] pub = keypair.getPublic().getEncoded();
		byte[] priv = keypair.getPrivate().getEncoded();

		byte[] keypairBytes = new byte[pub.length+priv.length];
		System.arraycopy(pub,0,keypairBytes,0,pub.length);
		System.arraycopy(priv,0,keypairBytes,pub.length,priv.length);
		this.setString("client_static_keypair",Base64.encode(keypairBytes));
	}

	public String getId(){
		return this.getString("id");
	}

	public void setId(String id){
		this.setString("id",id);
	}

	public String getCountryCode(){
		return this.getString("cc");
	}

	public void setCountryCode(String cc){
		this.setString("cc",cc);
	}

	public String getInternalNumber(){
		return this.getString("in");
	}

	public void setInternalNumber(String in){
		this.setString("in",in);
	}

	public byte[] getEdgeRoutingInfo(){
		return Base64.decode(this.getString("edge_routing_info"));
	}

	public void setEdgeRoutingInfo(byte[] edge_routing_info){
		this.setString("edge_routing_info",Base64.encode(edge_routing_info));
	}

	public long getLogin(){
		return this.getLong("login");
	}

	public void setLogin(long login){
		this.setLong("login",login);
	}

	public void save() throws IOException{
		Config.saveConfig(this.getId(),this);
	}

	public static Config loadConfig(String id) throws IOException{
		Config c = new Config();
		c.data = new JSONObject(new String(Config.loadFile(id)));
		return c;
	}

	private static byte[] loadFile(String id) throws IOException{
		File file = new File("configs/"+id+".conf");
		FileInputStream fos = new FileInputStream(file);
		byte[] bytes = new byte[fos.available()];
		fos.read(bytes);
		fos.close();
		return bytes;
	}

	public static void saveConfig(String id,Config config) throws IOException{
		Config.saveFile(id,config.data.toString().getBytes());
	}

	private static void saveFile(String id,byte[] content) throws IOException{
		File file = new File("configs/"+id+".conf");
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(content);
		fos.flush();
		fos.close();
	}

	public static class Tools{

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


}