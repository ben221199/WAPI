package nl.ben221199.wapi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import org.json.JSONObject;

public class RegisterMain{

	private static String id = "abcdeabcdeabcde12350";
	private static String cc = "7";
	private static String in = "9670154494";

	public static void main(String... args) throws IOException, NoSuchAlgorithmException {
		KeyPair client_static_keypair = Config.client_static_keypair;

		Scanner s = new Scanner(System.in);

		String existData = Verification.exist(
				"authkey="+ URLEncoder.encode(Base64.getEncoder().encodeToString(client_static_keypair.getPublic().getEncoded()),"UTF-8"),
				"in="+in,
				"cc="+cc,
				"id="+URLEncoder.encode(id,"UTF-8"));
		FileOutputStream existOUT = new FileOutputStream(new File(cc+in+"_resp_exist.json"));
		existOUT.write(existData.getBytes());
		existOUT.close();
		JSONObject existJSON = new JSONObject(existData);
		if(existJSON.has("status") && "ok".equals(existJSON.getString("status"))){
			System.err.println("This ID is linked to CC & IN. You could use it directly.");
			return;
		}else if(existJSON.has("status") && "fail".equals(existJSON.getString("status"))){
			System.err.println("This ID is not linked to CC & NN. You should do the verification process.");
		}

		System.err.println("Enter your method (sms/voice):");
		String method = s.nextLine();

		String codeData = Verification.code(
				"authkey="+ URLEncoder.encode(Base64.getEncoder().encodeToString(client_static_keypair.getPublic().getEncoded()),"UTF-8"),
				"in="+in,
				"cc="+cc,
				"token="+URLEncoder.encode(Verification.calculateAndroidToken(in),"UTF-8"),
				"id="+URLEncoder.encode(id,"UTF-8"),
				"method="+method);
		FileOutputStream codeOUT = new FileOutputStream(new File(cc+in+"_resp_code.json"));
		codeOUT.write(codeData.getBytes());
		codeOUT.close();
		JSONObject codeJSON = new JSONObject(codeData);
		if(codeJSON.has("status") && "sent".equals(codeJSON.getString("status"))){
			System.err.println("The code is sent to the phone number.");
		}else if(codeJSON.has("status") && "fail".equals(codeJSON.getString("status"))){
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
		FileOutputStream registerOUT = new FileOutputStream(new File(cc+in+"_resp_register.json"));
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