package nl.ben221199.wapi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.KeyPair;
import java.util.Base64;
import java.util.Scanner;

import org.json.JSONObject;

public class RegisterMain{

	private static String id;// = "abcdeabcdeabcde12350";
	private static String cc;// = "7";
	private static String in;// = "9670154494";

	public static void main(String... args) throws IOException{
		KeyPair client_static_keypair = Config.client_static_keypair;

		Scanner s = new Scanner(System.in);

		while(RegisterMain.id==null){
			System.err.println("Enter your configuration Id:");
			String id = s.nextLine();
			if(id!=null && id.length()==20){
				RegisterMain.id = id;
				break;
			}
			System.err.println("Id not valid. Should be 20 chars long.");
		}
		System.err.println("Enter your country code:");
		RegisterMain.cc = s.nextLine();
		System.err.println("Enter your internal number:");
		RegisterMain.in = s.nextLine();

		String existData = Verification.exist(
				"authkey="+ URLEncoder.encode(Base64.getEncoder().encodeToString(client_static_keypair.getPublic().getEncoded()),"UTF-8"),
				"in="+in,
				"cc="+cc,
				"id="+URLEncoder.encode(id,"UTF-8"));
		FileOutputStream existOUT = new FileOutputStream(new File(id+"_exist.json"));
		existOUT.write(existData.getBytes());
		existOUT.close();
		JSONObject existJSON = new JSONObject(existData);
		if(existJSON.has("status") && "ok".equals(existJSON.getString("status"))){
			System.err.println("This Id is linked to CC & IN. You could use it directly.");
			return;
		}else if(existJSON.has("status") && "fail".equals(existJSON.getString("status"))){
			if(existJSON.has("reason") && "bad_param".equals(existJSON.getString("reason"))){
				System.err.println("The parameter '"+existJSON.getString("param")+"' is not valid.");
				return;
			}
			System.err.println("This ID is not linked to CC & NN. You should do the verification process.");
		}

		System.err.println("Enter your method (sms/voice):");
		String method = s.nextLine();

		String token = Verification.calculateAndroidToken(in);
		if(token==null){
			System.err.println("Somehow the token is null.");
			return;
		}
		String codeData = Verification.code(
				"authkey="+ URLEncoder.encode(Base64.getEncoder().encodeToString(client_static_keypair.getPublic().getEncoded()),"UTF-8"),
				"in="+in,
				"cc="+cc,
				"token="+URLEncoder.encode(token,"UTF-8"),
				"id="+URLEncoder.encode(id,"UTF-8"),
				"method="+method);
		FileOutputStream codeOUT = new FileOutputStream(new File(id+"_code.json"));
		codeOUT.write(codeData.getBytes());
		codeOUT.close();
		JSONObject codeJSON = new JSONObject(codeData);
		if(codeJSON.has("status") && "sent".equals(codeJSON.getString("status"))){
			System.err.println("The code is sent to the phone number.");
		}else if(codeJSON.has("status") && "fail".equals(codeJSON.getString("status"))){
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
				"authkey="+ URLEncoder.encode(Base64.getEncoder().encodeToString(client_static_keypair.getPublic().getEncoded()),"UTF-8"),
				"in="+in,
				"cc="+cc,
				"code="+code,
				"id="+URLEncoder.encode(id,"UTF-8"));
		FileOutputStream registerOUT = new FileOutputStream(new File(id+"_register.json"));
		registerOUT.write(registerData.getBytes());
		registerOUT.close();
		JSONObject registerJSON = new JSONObject(registerData);
		if(registerJSON.has("status") && "ok".equals(registerJSON.getString("status"))){
			System.err.println("The verification process is done.");
		}else if(registerJSON.has("status") && "fail".equals(registerJSON.getString("status"))){
			System.err.println("The verification process is not done. Something went wrong. Error: "+registerJSON);
		}

	}

}