package nl.ben221199.wapi;

import org.json.JSONArray;
import org.json.JSONObject;
import org.whispersystems.libsignal.IdentityKey;
import org.whispersystems.libsignal.IdentityKeyPair;
import org.whispersystems.libsignal.InvalidKeyException;
import org.whispersystems.libsignal.InvalidKeyIdException;
import org.whispersystems.libsignal.SignalProtocolAddress;
import org.whispersystems.libsignal.state.PreKeyRecord;
import org.whispersystems.libsignal.state.SessionRecord;
import org.whispersystems.libsignal.state.SignalProtocolStore;
import org.whispersystems.libsignal.state.SignedPreKeyRecord;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONSignalStore implements SignalProtocolStore{

	private IdentityKeyPair identityKeyPair;
	private int localRegistrationId;

	private Map<SignalProtocolAddress,IdentityKey> identities = new HashMap<>();
	private Map<Integer,PreKeyRecord> preKeys = new HashMap<>();
	private Map<SignalProtocolAddress,SessionRecord> sessions = new HashMap<>();
	private Map<Integer,SignedPreKeyRecord> signedPreKeys = new HashMap<>();

	@Override
	public IdentityKeyPair getIdentityKeyPair(){
		return this.identityKeyPair;
	}

	public void setIdentityKeyPair(IdentityKeyPair identityKeyPair){
		this.identityKeyPair = identityKeyPair;
	}

	@Override
	public int getLocalRegistrationId(){
		return this.localRegistrationId;

	}

	public void setLocalRegistrationId(int localRegistrationId){
		this.localRegistrationId = localRegistrationId;
	}

	@Override
	public boolean saveIdentity(SignalProtocolAddress signalProtocolAddress,IdentityKey identityKey){
		return this.identities.put(signalProtocolAddress,identityKey)!=null;
	}

	@Override
	public boolean isTrustedIdentity(SignalProtocolAddress signalProtocolAddress, IdentityKey identityKey, Direction direction){
		IdentityKey storedIdentity = this.getIdentity(signalProtocolAddress);
		return storedIdentity == null || identityKey.equals(storedIdentity);
	}

	@Override
	public IdentityKey getIdentity(SignalProtocolAddress signalProtocolAddress){
		return this.identities.get(signalProtocolAddress);
	}

//	public boolean containsIdentity(SignalProtocolAddress signalProtocolAddress){
//		return this.identities.containsKey(signalProtocolAddress);
//	}
//
//	public void removeIdentity(SignalProtocolAddress signalProtocolAddress){
//		this.identities.remove(signalProtocolAddress);
//	}

	@Override
	public PreKeyRecord loadPreKey(int i) throws InvalidKeyIdException{
		if(this.preKeys.containsKey(i)){
			return this.preKeys.get(i);
		}
		throw new InvalidKeyIdException("PreKey doesn't exist");
	}

	@Override
	public void storePreKey(int i, PreKeyRecord preKeyRecord){
		this.preKeys.put(i,preKeyRecord);
	}

	@Override
	public boolean containsPreKey(int i){
		return this.preKeys.containsKey(i);
	}

	@Override
	public void removePreKey(int i){
		this.preKeys.remove(i);
	}

	@Override
	public SessionRecord loadSession(SignalProtocolAddress signalProtocolAddress){
		if(this.sessions.containsKey(signalProtocolAddress)){
			return this.sessions.get(signalProtocolAddress);
		}
		SessionRecord newSession = new SessionRecord();
		this.storeSession(signalProtocolAddress,newSession);
		return newSession;
	}

	@Override
	public List<Integer> getSubDeviceSessions(String s){
		List<Integer> list = new ArrayList<>();
		for(SignalProtocolAddress signalProtocolAddress : this.sessions.keySet()){
			if(signalProtocolAddress.getName().equals(s) && signalProtocolAddress.getDeviceId()!=1){
				list.add(signalProtocolAddress.getDeviceId());
			}
		}
		return list;
	}

	@Override
	public void storeSession(SignalProtocolAddress signalProtocolAddress, SessionRecord sessionRecord) {
		this.sessions.put(signalProtocolAddress,sessionRecord);
	}

	@Override
	public boolean containsSession(SignalProtocolAddress signalProtocolAddress) {
		return this.sessions.containsKey(signalProtocolAddress);
	}

	@Override
	public void deleteSession(SignalProtocolAddress signalProtocolAddress){
		this.sessions.remove(signalProtocolAddress);
	}

	@Override
	public void deleteAllSessions(String s) {
		for(SignalProtocolAddress signalProtocolAddress : this.sessions.keySet()){
			if(signalProtocolAddress.getName().equals(s)){
				this.sessions.remove(signalProtocolAddress);
			}
		}
	}

	@Override
	public SignedPreKeyRecord loadSignedPreKey(int i) throws InvalidKeyIdException {
		if(this.signedPreKeys.containsKey(i)){
			return this.signedPreKeys.get(i);
		}
		throw new InvalidKeyIdException("SignedPreKey doesn't exist");
	}

	@Override
	public List<SignedPreKeyRecord> loadSignedPreKeys(){
		return List.of(this.signedPreKeys.values().toArray(new SignedPreKeyRecord[0]));
	}

	@Override
	public void storeSignedPreKey(int i, SignedPreKeyRecord signedPreKeyRecord){
		this.signedPreKeys.put(i,signedPreKeyRecord);
	}

	@Override
	public boolean containsSignedPreKey(int i) {
		return this.signedPreKeys.containsKey(i);
	}

	@Override
	public void removeSignedPreKey(int i) {
		this.signedPreKeys.remove(i);
	}

	private JSONObject getJSON(){
		JSONObject json = new JSONObject();

		if(this.identityKeyPair!=null){
			json.put("identityKeyPair",Base64.encode(identityKeyPair.serialize()));
		}
		json.put("localRegistrationId",localRegistrationId);
		if(!this.identities.isEmpty()){
			JSONArray identitiesArr = new JSONArray();
			for(Map.Entry<SignalProtocolAddress,IdentityKey> entry : this.identities.entrySet()){
				JSONObject obj = new JSONObject();
				obj.put("name",entry.getKey().getName());
				obj.put("device",entry.getKey().getDeviceId());
				obj.put("identityKey",Base64.encode(entry.getValue().serialize()));
				identitiesArr.put(obj);
			}
			json.put("identities",identitiesArr);
		}
		if(!this.preKeys.isEmpty()){
			JSONArray identitiesArr = new JSONArray();
			for(Map.Entry<Integer,PreKeyRecord> entry : this.preKeys.entrySet()){
				JSONObject obj = new JSONObject();
				obj.put("index",entry.getKey());
				obj.put("preKey",Base64.encode(entry.getValue().serialize()));
				identitiesArr.put(obj);
			}
			json.put("preKeys",identitiesArr);
		}
		if(!this.sessions.isEmpty()){
			JSONArray sessionsArr = new JSONArray();
			for(Map.Entry<SignalProtocolAddress,SessionRecord> entry : this.sessions.entrySet()){
				JSONObject obj = new JSONObject();
				obj.put("name",entry.getKey().getName());
				obj.put("device",entry.getKey().getDeviceId());
				obj.put("session",Base64.encode(entry.getValue().serialize()));
				sessionsArr.put(obj);
			}
			json.put("sessions",sessionsArr);
		}
		if(!this.signedPreKeys.isEmpty()){
			JSONArray identitiesArr = new JSONArray();
			for(Map.Entry<Integer,SignedPreKeyRecord> entry : this.signedPreKeys.entrySet()){
				JSONObject obj = new JSONObject();
				obj.put("index",entry.getKey());
				obj.put("signedPreKey",Base64.encode(entry.getValue().serialize()));
				identitiesArr.put(obj);
			}
			json.put("signedPreKeys",identitiesArr);
		}

		return json;
	}

	private JSONSignalStore setJSON(JSONObject json){
		this.reset();

		if(json.has("identityKeyPair")){
			try{
				this.identityKeyPair = new IdentityKeyPair(Base64.decode(json.getString("identityKeyPair")));
			}catch(InvalidKeyException e){
				e.printStackTrace();
			}
		}
		if(json.has("localRegistrationId")){
			this.localRegistrationId = json.getInt("localRegistrationId");
		}
		if(json.has("identities")){
			JSONArray arr = json.getJSONArray("identities");
			for(int i=0;i<arr.length();i++){
				JSONObject obj = arr.getJSONObject(i);
				if(obj.has("name") && obj.has("device") && obj.has("identityKey")){
					try{
						SignalProtocolAddress signalProtocolAddress = new SignalProtocolAddress(obj.getString("name"),obj.getInt("device"));
						IdentityKey identityKey = new IdentityKey(Base64.decode(obj.getString("identityKey")),0);
						this.identities.put(signalProtocolAddress,identityKey);
					}catch(InvalidKeyException e){
						e.printStackTrace();
					}
				}
			}
		}
		if(json.has("preKeys")){
			JSONArray arr = json.getJSONArray("preKeys");
			for(int j=0;j<arr.length();j++){
				JSONObject obj = arr.getJSONObject(j);
				if(obj.has("index") && obj.has("preKey")){
					try{
						int index = obj.getInt("index");
						PreKeyRecord preKeyRecord = new PreKeyRecord(Base64.decode(obj.getString("preKey")));
						this.preKeys.put(index,preKeyRecord);
					}catch(IOException e){
						e.printStackTrace();
					}
				}
			}
		}
		if(json.has("sessions")){
			JSONArray arr = json.getJSONArray("sessions");
			for(int i=0;i<arr.length();i++){
				JSONObject obj = arr.getJSONObject(i);
				if(obj.has("name") && obj.has("device") && obj.has("session")){
					try{
						SignalProtocolAddress signalProtocolAddress = new SignalProtocolAddress(obj.getString("name"),obj.getInt("device"));
						SessionRecord sessionRecord = new SessionRecord(Base64.decode(obj.getString("session")));
						this.sessions.put(signalProtocolAddress,sessionRecord);
					}catch(IOException e){
						e.printStackTrace();
					}
				}
			}
		}
		if(json.has("signedPreKeys")){
			JSONArray arr = json.getJSONArray("signedPreKeys");
			for(int j=0;j<arr.length();j++){
				JSONObject obj = arr.getJSONObject(j);
				if(obj.has("index") && obj.has("signedPreKey")){
					try{
						int index = obj.getInt("index");
						SignedPreKeyRecord signedPreKeyRecord = new SignedPreKeyRecord(Base64.decode(obj.getString("signedPreKey")));
						signedPreKeys.put(index,signedPreKeyRecord);
					}catch(IOException e){
						e.printStackTrace();
					}
				}
			}
		}

		return this;
	}

	private void reset(){
		this.identityKeyPair = null;
		this.localRegistrationId = 0;

		this.identities.clear();
		this.preKeys.clear();
		this.sessions.clear();
		this.signedPreKeys.clear();
	}

	public void save(File f) throws IOException{
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(this.getJSON().toString().getBytes());
		fos.flush();
		fos.close();
	}

	public static JSONSignalStore load(File f) throws IOException{
		FileInputStream fis = new FileInputStream(f);
		byte[] buf = new byte[fis.available()];
		int retval = fis.read(buf);
		if(retval==-1){
			return null;
		}
		fis.close();
		String json = new String(buf);
		return new JSONSignalStore().setJSON(new JSONObject(json));
	}

}