package com.whatsapp;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Verification{

	private static final String BASE_URL = "https://v.whatsapp.net/v2/";
	private static final String USER_AGENT = "WhatsApp/2.20.206.22 Android/8.0.0 Device/samsung-star2lte";

	/**
	 * Minimum parameters:
	 * https://v.whatsapp.net/v2/exist?authkey={RANDOM:PUBLICKEY}&in={CONFIG:INTERNALNUMBER}&cc={CONFIG:COUNTRYCODE}&id={CONFIG:ID}
	 * @param query Query
	 * @return The JSON content
	 * @throws IOException Exception when request is failing
	 */
	public static String exist(String... query) throws IOException{
		HttpsURLConnection conn = (HttpsURLConnection) new URL(Verification.BASE_URL+"exist?"+String.join("&",query)).openConnection();
		conn.setRequestProperty("User-Agent",Verification.USER_AGENT);
		return Verification.runConnection(conn);
	}
	
	/**
	 * Minimum parameters:
	 * https://v.whatsapp.net/v2/code?authkey={RANDOM:PUBLICKEY}&in={CONFIG:INTERNALNUMBER}&cc={CONFIG:COUNTRYCODE}&token={TOKEN:IN}&id={CONFIG:ID}&method=sms
	 * @param query Query
	 * @return The JSON content
	 * @throws IOException Exception when request is failing
	 */
	public static String code(String... query) throws IOException{
		HttpsURLConnection conn = (HttpsURLConnection) new URL(Verification.BASE_URL+"code?"+String.join("&",query)).openConnection();
		conn.setRequestProperty("User-Agent",Verification.USER_AGENT);
		return Verification.runConnection(conn);
	}

	/**
	 * Minimum parameters:
	 * https://v.whatsapp.net/v2/register?authkey={RANDOM:PUBLICKEY}&in={CONFIG:INTERNALNUMBER}&cc={CONFIG:COUNTRYCODE}&code={CODE}&id={CONFIG:ID}
	 * @param query Query
	 * @return The JSON content
	 * @throws IOException Exception when request is failing
	 */
	public static String register(String... query) throws IOException{
		HttpsURLConnection conn = (HttpsURLConnection) new URL(Verification.BASE_URL+"register?"+String.join("&",query)).openConnection();
		conn.setRequestProperty("User-Agent",Verification.USER_AGENT);
		return Verification.runConnection(conn);
	}

	private static String runConnection(HttpURLConnection conn) throws IOException{
		conn.connect();
		InputStream in;
		try{
			in = conn.getInputStream();
		}catch(Exception e){
			in = conn.getErrorStream();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = br.readLine())!=null){
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}

}