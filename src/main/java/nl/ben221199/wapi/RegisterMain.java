package nl.ben221199.wapi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Base64;
import java.util.Scanner;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.json.JSONObject;

public class RegisterMain{

	static{
		Security.addProvider(new BouncyCastleProvider());
	}

	public static void main(String... args) throws IOException, NoSuchAlgorithmException{
		KeyPair client_static_keypair = Config.generateClientStaticKeyPair();

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
		System.err.println("Enter your country code:");
		final_cc = s.nextLine();
		System.err.println("Enter your internal number:");
		final_in = s.nextLine();

		String existData = Verification.exist(
				Constants.Verification.Android.USER_AGENT,
				true,
				"authkey="+ URLEncoder.encode(Base64.getEncoder().encodeToString(client_static_keypair.getPublic().getEncoded()),"UTF-8"),
				"in="+final_in,
				"cc="+final_cc,
				"id="+URLEncoder.encode(final_id,"UTF-8"));
		FileOutputStream existOUT = new FileOutputStream(new File(final_id+"_exist.json"));
		existOUT.write(existData.getBytes());
		existOUT.close();
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

		String token = Verification.calculateToken(final_in);
		if(token==null){
			System.err.println("Somehow the token is null.");
			return;
		}
		String codeData = Verification.code(
				Constants.Verification.Android.USER_AGENT,
				true,
				"authkey="+ URLEncoder.encode(Base64.getEncoder().encodeToString(client_static_keypair.getPublic().getEncoded()),"UTF-8"),
				"in="+final_in,
				"cc="+final_cc,
				"token="+URLEncoder.encode(token,"UTF-8"),
				"id="+URLEncoder.encode(final_id,"UTF-8"),
				"method="+method);
		FileOutputStream codeOUT = new FileOutputStream(new File(final_id+"_code.json"));
		codeOUT.write(codeData.getBytes());
		codeOUT.close();
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
		s.nextLine();

		String registerData = Verification.register(
				Constants.Verification.Android.USER_AGENT,
				true,
				"authkey="+ URLEncoder.encode(Base64.getEncoder().encodeToString(client_static_keypair.getPublic().getEncoded()),"UTF-8"),
				"in="+final_in,
				"cc="+final_cc,
				"code="+code,
				"id="+URLEncoder.encode(final_id,"UTF-8"));
		FileOutputStream registerOUT = new FileOutputStream(new File(final_id+"_register.json"));
		registerOUT.write(registerData.getBytes());
		registerOUT.close();
		JSONObject registerJSON = new JSONObject(registerData);
		if(registerJSON.has("status") && "ok".equals(registerJSON.getString("status"))){
			System.err.println("The verification process is done.");
		}else if(registerJSON.has("status") && "fail".equals(registerJSON.getString("status"))){
			if(existJSON.has("reason") && "blocked".equals(existJSON.getString("reason"))){
				System.err.println("THIS NUMBER IS BANNED. ENDING REGISTRATION");
				System.exit(0);
				return;
			}
			System.err.println("The verification process is not done. Something went wrong. Error: "+registerJSON);
		}

		Config.saveClientStaticKeyPair(final_id,client_static_keypair);
		Config.saveCountryCode(final_id,final_cc);
		Config.saveInternalNumber(final_id,final_in);
	}

}