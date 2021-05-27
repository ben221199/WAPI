package nl.ben221199.wapi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.google.protobuf.ByteString;
import com.whatsapp.proto.VNameCertProtos;
import com.whatsapp.proto.WA4Protos;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.json.JSONObject;
import org.whispersystems.libsignal.IdentityKeyPair;
import org.whispersystems.libsignal.InvalidKeyException;
import org.whispersystems.libsignal.state.SignedPreKeyRecord;
import org.whispersystems.libsignal.util.KeyHelper;

public class RegisterMain{

	static{
		Security.addProvider(new BouncyCastleProvider());
	}

	public static void main(String... args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
		Config config = new Config();

		Scanner s = new Scanner(System.in);

		String final_id;
		String final_cc;
		String final_in;

		while(true){
			System.err.println("Enter your configuration Id:");
			String id = s.nextLine();
			if(id!=null && id.length()==20){
				final_id = id;
				break;
			}
			System.err.println("Id not valid. Should be 20 chars long.");
		}
		config.setId(final_id);
		System.err.println("Enter your country code:");
		final_cc = s.nextLine();
		config.setCountryCode(final_cc);
		System.err.println("Enter your internal number:");
		final_in = s.nextLine();
		config.setInternalNumber(final_in);

		RegisterMain.initConfig(config);

		String[] existParams = RegisterMain.getExistParams(config);
		String existData = Verification.exist(
				Constants.UserAgent.Android.USER_AGENT,
				true,
				existParams);
		config.setString("__exist_request",String.join("&",existParams));
		config.setString("__exist_response",existData);
		JSONObject existJSON = new JSONObject(existData);
		if(existJSON.has("status") && "ok".equals(existJSON.getString("status"))){
			System.err.println("This Id is linked to CC & IN. You could use it directly.");
			return;
		}else if(existJSON.has("status") && "fail".equals(existJSON.getString("status"))){
			if(existJSON.has("reason") && "blocked".equals(existJSON.getString("reason"))){
				System.err.println("THIS NUMBER IS BANNED. ENDING REGISTRATION");
				System.exit(0);
				return;
			}
			if(existJSON.has("reason") && "bad_param".equals(existJSON.getString("reason"))){
				System.err.println("The parameter '"+existJSON.getString("param")+"' is not valid.");
				return;
			}
			System.err.println("This ID is not linked to CC & NN. You should do the verification process.");
		}

		System.err.println("Enter your method (sms/voice):");
		String method = s.nextLine();
		config.setMethod(method);

		String[] codeParams = RegisterMain.getCodeParams(config);
		String codeData = Verification.code(
				Constants.UserAgent.Android.USER_AGENT,
				true,
				codeParams);
		config.setString("__code_request",String.join("&",codeParams));
		config.setString("__code_response",codeData);
		JSONObject codeJSON = new JSONObject(codeData);
		if(codeJSON.has("status") && "sent".equals(codeJSON.getString("status"))){
			System.err.println("The code is sent to the phone number.");
		}else if(codeJSON.has("status") && "fail".equals(codeJSON.getString("status"))){
			if(existJSON.has("reason") && "blocked".equals(existJSON.getString("reason"))){
				System.err.println("THIS NUMBER IS BANNED. ENDING REGISTRATION");
				System.exit(0);
				return;
			}
			if(existJSON.has("reason") && "bad_param".equals(existJSON.getString("reason"))){
				System.err.println("The parameter '"+existJSON.getString("param")+"' is not valid.");
				return;
			}
			System.err.println("The code is not sent. Maybe already sent. Error: "+codeJSON);
		}

		System.err.println("Enter your received code:");
		int code = s.nextInt();
		config.setCode(code);
		s.nextLine();

		String[] registerParams = RegisterMain.getRegisterParams(config);
		String registerData = Verification.register(
				Constants.UserAgent.Android.USER_AGENT,
				true,
				registerParams);
		config.setString("__register_request",String.join("&",registerParams));
		config.setString("__register_response",registerData);
		JSONObject registerJSON = new JSONObject(registerData);
		if(registerJSON.has("status") && "ok".equals(registerJSON.getString("status"))){
			config.setEdgeRoutingInfo(Base64.decode(registerJSON.getString("edge_routing_info")));
			config.setLogin(Long.parseLong(registerJSON.getString("login")));
			System.err.println("The verification process is done.");
		}else if(registerJSON.has("status") && "fail".equals(registerJSON.getString("status"))){
			if(existJSON.has("reason") && "blocked".equals(existJSON.getString("reason"))){
				System.err.println("THIS NUMBER IS BANNED. ENDING REGISTRATION");
				System.exit(0);
				return;
			}
			System.err.println("The verification process is not done. Something went wrong. Error: "+registerJSON);
		}

		config.save();
	}

	private static void initConfig(Config config) throws NoSuchAlgorithmException, InvalidKeyException {
		config.setClientStaticKeypair(Config.Tools.generateClientStaticKeyPair());

		/*Optionals*/
		config.setReleaseChannel(WA4Protos.ClientPayload.UserAgent.ReleaseChannel.RELEASE_VALUE);
		config.setSIMNumber(1);
		config.setHasInternalRegistrationCode(true);
		config.setProcessId(123);
		config.setMistyped(6);
		config.setNetworkRadioType(1);
		config.setClientMetrics(new JSONObject().put("attempts",1));

		UUID expid = UUID.randomUUID();
		config.setLanguage("en");
		config.setLanguageCountry("US");
		config.setFDId(UUID.randomUUID().toString());
		config.setExpId(Base64.encode(ByteBuffer.allocate(16).putLong(expid.getMostSignificantBits()).putLong(expid.getLeastSignificantBits()).array()));

		/*E2E*/
		int e_regid = KeyHelper.generateRegistrationId(false);
		IdentityKeyPair e_ident = KeyHelper.generateIdentityKeyPair();
		SignedPreKeyRecord e_skey = KeyHelper.generateSignedPreKey(e_ident,0);
		config.setE2EIdentFull(Base64.encode(e_ident.serialize()));
		config.setE2ESkeyFull(Base64.encode(e_skey.serialize()));

		config.setE2ERegId(e_regid);
		config.setE2EKeyType(0x05);
		config.setE2EIdent(Base64.encode(ByteString.copyFrom(e_ident.getPublicKey().serialize()).substring(1).toByteArray()));
		System.err.println("A => "+e_skey.getId());
		config.setE2ESKeyId(e_skey.getId());
		config.setE2ESkeyVal(Base64.encode(ByteString.copyFrom(e_skey.getKeyPair().getPublicKey().serialize()).substring(1).toByteArray()));
		config.setE2ESkeySig(Base64.encode(e_skey.getSignature()));

		/*EXIST*/
		config.setNetworkOperatorName("Partner");
		config.setReadPhonePermissionGranted(true);
		config.setToken(Verification.calculateToken(config.getInternalNumber()));
		config.setSIMOperatorName("Partner");
		config.setOfflineAB(new JSONObject());
		config.setSIMState(5);

		/*CODE*/
		config.setSIMMNC("000");
		config.setSIMMCC("000");
		config.setMNC("000");
		config.setReason("");
		config.setMCC("000");
		config.setHasAutoVerification(2);

		/*REGISTER*/
//		VNameCertProtos.VerifiedNameCertificate.Details details = VNameCertProtos.VerifiedNameCertificate.Details.newBuilder().build();
//		VNameCertProtos.VerifiedNameCertificate vnameCert = VNameCertProtos.VerifiedNameCertificate.newBuilder().setDetails(details.toByteString()).setSignature(ByteString.EMPTY).build();
		config.setEntered(2);
		config.setNetworkOperatorName("Partner");
		config.setSIMMNC("000");
//		config.setVName(Base64.encode(vnameCert.toByteArray()));
		config.setSIMMCC("000");
		config.setMNC("000");
		config.setSIMOperatorName("Partner");
		config.setMCC("000");
	}

	private static String[] getExistParams(Config config) throws UnsupportedEncodingException{
		List<String> params = new ArrayList<>();

		RegisterMain.addRequiredBasicParams(config,params);
		RegisterMain.addOptionalBasicParams(config,params);
		RegisterMain.addE2EParams(config,params);
		RegisterMain.addOptionalExistParams(config,params);

		return params.toArray(new String[0]);
	}

	private static String[] getCodeParams(Config config) throws UnsupportedEncodingException{
		String token = Verification.calculateToken(config.getInternalNumber());
		if(token==null){
			token = "<NULL>";
			System.err.println("Somehow the token is null.");
		}

		List<String> params = new ArrayList<>();

		RegisterMain.addRequiredBasicParams(config,params);
		RegisterMain.addOptionalBasicParams(config,params);
		RegisterMain.addE2EParams(config,params);
		RegisterMain.addOptionalCodeParams(config,params);
		params.add("token="+URLEncoder.encode(token,"UTF-8"));
		params.add("method="+config.getMethod());

		return params.toArray(new String[0]);
	}

	private static String[] getRegisterParams(Config config) throws UnsupportedEncodingException{
		List<String> params = new ArrayList<>();

		RegisterMain.addRequiredBasicParams(config,params);
		RegisterMain.addOptionalBasicParams(config,params);
		RegisterMain.addE2EParams(config,params);
		RegisterMain.addOptionalRegisterParams(config,params);
		params.add("code="+config.getCode());

		return params.toArray(new String[0]);
	}

	private static void addRequiredBasicParams(Config config,List<String> params) throws UnsupportedEncodingException{
		params.add("authkey="+Base64.convertToURLSafe(Base64.encode(config.getClientStaticKeypair().getPublic().getEncoded())));
		params.add("in="+config.getInternalNumber());
		params.add("cc="+config.getCountryCode());
		params.add("id="+URLEncoder.encode(config.getId(),"UTF-8"));
	}


	private static void addOptionalBasicParams(Config config,List<String> params) throws UnsupportedEncodingException{
		params.add("rc="+config.getReleaseChannel());
		params.add("simnum="+config.getSIMNumber());
		params.add("hasinrc="+(config.getHasInternalRegistrationCode()?1:0));
		params.add("mistyped="+config.getMistyped());
		params.add("pid="+config.getProcessId());
		params.add("network_radio_type="+config.getNetworkRadioType());
		params.add("client_metrics="+URLEncoder.encode(config.getClientMetrics().toString(),"UTF-8"));

		params.add("lg="+config.getLanguage());
		params.add("lc="+config.getLanguageCountry());
		params.add("expid="+Base64.convertToURLSafe(config.getExpId()));
		params.add("fdid="+config.getFDId());
	}

	private static void addE2EParams(Config config,List<String> params){
		String e_regid = Base64.encode(ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(config.getE2ERegId()).array());
		params.add("e_regid="+Base64.convertToURLSafe(e_regid).replaceAll("=",""));

		String e_keytype = Base64.encode(ByteBuffer.allocate(1).order(ByteOrder.BIG_ENDIAN).put((byte) config.getE2EKeyType()).array());
		params.add("e_keytype="+Base64.convertToURLSafe(e_keytype).replaceAll("=",""));
		params.add("e_ident="+Base64.convertToURLSafe(config.getE2EIdent()).replaceAll("=",""));

		String e_skey_id = Base64.encode(ByteBuffer.allocate(3).order(ByteOrder.BIG_ENDIAN).putShort(1,(short) config.getE2ESKeyId()).array());
		params.add("e_skey_id="+Base64.convertToURLSafe(e_skey_id).replaceAll("=",""));

		params.add("e_skey_val="+Base64.convertToURLSafe(config.getE2ESkeyVal()).replaceAll("=",""));
		params.add("e_skey_sig="+Base64.convertToURLSafe(config.getE2ESkeySig()).replaceAll("=",""));
	}

	private static void addOptionalExistParams(Config config,List<String> params) throws UnsupportedEncodingException{
		params.add("network_operator_name="+config.getNetworkOperatorName());
		params.add("read_phone_permission_granted="+(config.getReadPhonePermissionGranted()?1:0));
		params.add("token="+Base64.encode(config.getToken().getBytes()));
		params.add("sim_operator_name="+config.getSIMOperatorName());
		params.add("offline_ab="+URLEncoder.encode(config.getOfflineAB().toString(),"UTF-8"));
		params.add("sim_state="+config.getSIMState());
	}

	private static void addOptionalCodeParams(Config config,List<String> params){
		params.add("sim_mnc="+config.getSIMMNC());
		params.add("sim_mcc="+config.getSIMMCC());
		params.add("mnc="+config.getMNC());
		params.add("reason="+config.getReason());
		params.add("mcc="+config.getMCC());
		params.add("hasav="+config.getHasAutoVerification());
	}

	private static void addOptionalRegisterParams(Config config,List<String> params){
		params.add("entered="+config.getEntered());
		params.add("network_operator_name="+config.getNetworkOperatorName());
		params.add("sim_mnc="+config.getSIMMNC());
		if(config.has("vname")){
			params.add("vname="+Base64.convertToURLSafe(config.getVName().replaceAll("=","")));
		}
		params.add("sim_mcc="+config.getSIMMCC());
		params.add("mnc="+config.getMNC());
		params.add("sim_operator_name="+config.getSIMOperatorName());
		params.add("mcc="+config.getMCC());
	}

}