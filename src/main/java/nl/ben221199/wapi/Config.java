package nl.ben221199.wapi;

import com.southernstorm.noise.protocol.DHState;
import com.southernstorm.noise.protocol.Noise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.json.JSONObject;
import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.ecc.DjbECPrivateKey;
import org.whispersystems.libsignal.ecc.DjbECPublicKey;
import org.whispersystems.libsignal.ecc.ECKeyPair;
import org.whispersystems.libsignal.ecc.ECPrivateKey;
import org.whispersystems.libsignal.ecc.ECPublicKey;

public class Config{

	private JSONObject data;

	public Config(){
		this.data = new JSONObject();
	}

	public JSONObject getObject(String key){
		return this.data.getJSONObject(key);
	}

	public void setObject(String key,JSONObject value){
		this.data.put(key,value);
	}

	public boolean getBoolean(String key){
		return this.data.getBoolean(key);
	}

	public void setBoolean(String key,boolean value){
		this.data.put(key,value);
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

	public int getInt(String key){
		return this.data.getInt(key);
	}

	public void setInt(String key,int value){
		this.data.put(key,value);
	}

	public ECKeyPair getClientStaticKeypair(){
		byte[] keypairBytes = Base64.decode(this.getString("client_static_keypair"));

		try{
			ECPublicKey pub = Curve.decodePoint(Arrays.copyOfRange(keypairBytes,0,32),0);
			ECPrivateKey priv = Curve.decodePrivatePoint(Arrays.copyOfRange(keypairBytes,32,64));

			return new ECKeyPair(pub,priv);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public void setClientStaticKeypair(ECKeyPair keypair){
		byte[] pub = ((DjbECPublicKey) keypair.getPublicKey()).getPublicKey();
		byte[] priv = ((DjbECPrivateKey) keypair.getPrivateKey()).getPrivateKey();

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

	public JSONObject getClientMetrics(){
		return this.getObject("client_metrics");
	}

	public void setClientMetrics(JSONObject client_metrics){
		this.setObject("client_metrics",client_metrics);
	}

	public int getCode(){
		return this.getInt("code");
	}

	public void setCode(int code){
		this.setInt("code",code);
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

	public int getEntered(){
		return this.getInt("entered");
	}

	public void setEntered(int entered){
		this.setInt("entered",entered);
	}

//	public String getE2EIdentFull(){
//		return this.getString("e2e_ident_full");
//	}
//
//	public void setE2EIdentFull(String e_ident){
//		this.setString("e2e_ident_full",e_ident);
//	}

//	public String getE2ESkeyFull(){
//		return this.getString("e2e_skey_full");
//	}
//
//	public void setE2ESkeyFull(String e_skey){
//		this.setString("e2e_skey_full",e_skey);
//	}
//
//	public int getE2ERegId(){
//		return this.getInt("e_regid");
//	}
//
//	public void setE2ERegId(int e_regid){
//		this.setInt("e_regid",e_regid);
//	}
//
//	public int getE2EKeyType(){
//		return this.getInt("e_keytype");
//	}
//
//	public void setE2EKeyType(int e_keytype){
//		this.setInt("e_keytype",e_keytype);
//	}
//
//	public String getE2EIdent(){
//		return this.getString("e_ident");
//	}
//
//	public void setE2EIdent(String e_ident){
//		this.setString("e_ident",e_ident);
//	}
//
//	public int getE2ESKeyId(){
//		return this.getInt("e_skey_id");
//	}
//
//	public void setE2ESKeyId(int e_skey_id){
//		this.setInt("e_skey_id",e_skey_id);
//	}
//
//	public String getE2ESkeyVal(){
//		return this.getString("e_skey_val");
//	}
//
//	public void setE2ESkeyVal(String e_skey_val){
//		this.setString("e_skey_val",e_skey_val);
//	}
//
//	public String getE2ESkeySig(){
//		return this.getString("e_skey_sig");
//	}
//
//	public void setE2ESkeySig(String e_skey_sig){
//		this.setString("e_skey_sig",e_skey_sig);
//	}

	public byte[] getEdgeRoutingInfo(){
		return Base64.decode(this.getString("edge_routing_info"));
	}

	public void setEdgeRoutingInfo(byte[] edge_routing_info){
		this.setString("edge_routing_info",Base64.encode(edge_routing_info));
	}

	public void setExpId(String expid){
		this.setString("expid",expid);
	}

	public String getExpId(){
		return this.getString("expid");
	}

	public void setFDId(String fdid){
		this.setString("fdid",fdid);
	}

	public String getFDId(){
		return this.getString("fdid");
	}

	public int getHasAutoVerification(){
		return this.getInt("hasav");
	}

	public void setHasAutoVerification(int hasav){
		this.setInt("hasav",hasav);
	}

	public boolean getHasInternalRegistrationCode(){
		return this.getBoolean("hasinrc");
	}

	public void setHasInternalRegistrationCode(boolean hasinrc){
		this.setBoolean("hasinrc",hasinrc);
	}

	public String getLanguage(){
		return this.getString("lg");
	}

	public void setLanguage(String lg){
		this.setString("lg",lg);
	}

	public String getLanguageCountry(){
		return this.getString("lc");
	}

	public void setLanguageCountry(String lc){
		this.setString("lc",lc);
	}

	public long getLogin(){
		return this.getLong("login");
	}

	public void setLogin(long login){
		this.setLong("login",login);
	}

	public String getMCC(){
		return this.getString("mcc");
	}

	public void setMCC(String mcc){
		this.setString("mcc",mcc);
	}

	public String getMethod(){
		return this.getString("method");
	}

	public void setMethod(String method){
		this.setString("method",method);
	}

	public String getMNC(){
		return this.getString("mnc");
	}

	public void setMNC(String mnc){
		this.setString("mnc",mnc);
	}

	public int getMistyped(){
		return this.getInt("mistyped");
	}

	public void setMistyped(int mistyped){
		this.setInt("mistyped",mistyped);
	}

	public String getNetworkOperatorName(){
		return this.getString("network_operator_name");
	}

	public void setNetworkOperatorName(String network_operator_name){
		this.setString("network_operator_name",network_operator_name);
	}

	public int getNetworkRadioType(){
		return this.getInt("mistyped");
	}

	public void setNetworkRadioType(int mistyped){
		this.setInt("mistyped",mistyped);
	}

	public JSONObject getOfflineAB(){
		return this.getObject("offline_ab");
	}

	public void setOfflineAB(JSONObject offline_ab){
		this.setObject("offline_ab",offline_ab);
	}

	public int getProcessId(){
		return this.getInt("pid");
	}

	public void setProcessId(int pid){
		this.setInt("pid",pid);
	}

	public boolean getReadPhonePermissionGranted(){
		return this.getBoolean("read_phone_permission_granted");
	}

	public void setReadPhonePermissionGranted(boolean read_phone_permission_granted){
		this.setBoolean("read_phone_permission_granted",read_phone_permission_granted);
	}

	public String getReason(){
		return this.getString("reason");
	}

	public void setReason(String reason){
		this.setString("reason",reason);
	}

	public int getReleaseChannel(){
		return this.getInt("rc");
	}

	public void setReleaseChannel(int rc){
		this.setInt("rc",rc);
	}

	public String getSIMMCC(){
		return this.getString("sim_mcc");
	}

	public void setSIMMCC(String sim_mcc){
		this.setString("sim_mcc",sim_mcc);
	}

	public String getSIMMNC(){
		return this.getString("sim_mnc");
	}

	public void setSIMMNC(String sim_mnc){
		this.setString("sim_mnc",sim_mnc);
	}

	public int getSIMNumber(){
		return this.getInt("simnum");
	}

	public void setSIMNumber(int simnum){
		this.setInt("simnum",simnum);
	}

	public String getSIMOperatorName(){
		return this.getString("sim_operator_name");
	}

	public void setSIMOperatorName(String sim_operator_name){
		this.setString("sim_operator_name",sim_operator_name);
	}

	public int getSIMState(){
		return this.getInt("sim_state");
	}

	public void setSIMState(int sim_state){
		this.setInt("sim_state",sim_state);
	}

	public String getToken(){
		return this.getString("token");
	}

	public void setToken(String token){
		this.setString("token",token);
	}

	public String getVName(){
		return this.getString("vname");
	}

	public void setVName(String vname){
		this.setString("vname",vname);
	}

	public boolean has(String key){
		return this.data.has(key);
	}

	public boolean getPrekeysSent(){
		return this.getBoolean("__prekeys_sent");
	}

	public void setPrekeysSent(boolean __prekeys_sent){
		this.setBoolean("__prekeys_sent",__prekeys_sent);
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
		if(fos.read(bytes)>-1){
			fos.close();
		}
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

		public static ECKeyPair generateClientStaticKeyPair() throws NoSuchAlgorithmException{
			DHState client_static_keypair = Noise.createDH("25519");
			client_static_keypair.generateKeyPair();
			byte[] public_key_bytes = new byte[client_static_keypair.getPublicKeyLength()];
			client_static_keypair.getPublicKey(public_key_bytes,0);
			byte[] private_key_bytes = new byte[client_static_keypair.getPrivateKeyLength()];
			client_static_keypair.getPrivateKey(private_key_bytes,0);

			try{
				ECPublicKey pub = Curve.decodePoint(Arrays.copyOfRange(public_key_bytes,0,32),0);
				ECPrivateKey priv = Curve.decodePrivatePoint(Arrays.copyOfRange(private_key_bytes,32,64));

				return new ECKeyPair(pub,priv);
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}

	}


}