package nl.ben221199.wapi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class Main implements Runnable{

	private FunInputStream in;
	private FunOutputStream out;

	protected Main(FunInputStream in,FunOutputStream out){
		this.in = in;
		this.out = out;
	}

	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for ( int j = 0; j < bytes.length; j++ ) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}


	public static void main(String... args) throws IOException{
//		FunXMPP.setVersion(4,1);
//
//		byte[] b = FunXMPP.encode("<presence type=\"available\"/>");
//		System.err.println(bytesToHex(b));
//		System.exit(0);
//
//
//
//
//		//return;
//		FunXMPP.setVersion(4,0);
////
//		System.err.println(FunXMPP.decode(new byte[]{ (byte) 248, 10, 17, 7, (byte) 252, 15, 115, 46, 119, 104, 97, 116, 97, 115, 97, 112, 112, 46, 110, 101, 116, 27, (byte) 252, 25, 117, 114, 110, 58, 120, 109, 112, 112, 58, 119, 104, 97, 116, 115, 97, 112, 112, 58, 97, 99, 99, 111, 117, 110, 116, 5, 45, 4, (byte) 237, 80, (byte) 248, 1, (byte) 248, 2, (byte) 252, 3, 50, 102, 97, (byte) 248, 1, (byte) 248, 2, 119, (byte) 252, 6, 1, 0, 3, 1, 2, 3}));
//		JSONArray arr = new JSONArray();
//		arr.put(2);
//		arr.put("9CqpnVpHO3tHA8ERQsk3SsD8UXJghK0FcURx6byJAAY4pQOwlpOO9LVbNeiH0aiQAWY+81krqToJncbOhm09rw");
//		arr.put("7rqrrrgP50WmcqlLh8tXvA");
//		arr.put("XfZx1A");
//		arr.put("psyX9dPFy49Zm1aqwEo1UA");
//
//		EncryptedClientStaticKeypair csk = EncryptedClientStaticKeypair.fromJSONArray(arr);
//		try {
//			System.err.println("Decrypted = "+Hex.fromBytes(csk.decrypt()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.exit(0);
//
//
//		FunXMPP.setVersion(4,0);
//
//		String xml1 = "<stream:stream>";
//		System.err.println(xml1);
//		byte[] fun = FunXMPP.encode(xml1);
//		System.err.println(Hex.fromBytes(fun));
//		String xml2 = FunXMPP.decode(fun);
//		System.err.println(xml2);
//		System.err.println("=======================================================");
//		a();
//		System.err.println("=======================================================");
//		String _xml1 = "</stream:stream>";
//		System.err.println(_xml1);
//		byte[] _fun = FunXMPP.encode(_xml1);
//		System.err.println(Hex.fromBytes(_fun));
//		String _xml2 = FunXMPP.decode(_fun);
//		System.err.println(_xml2);


		Connection conn = new Connection("e7.whatsapp.net",443)
				.setEdgeRoutingInfo(Config.edge_routing_info)
				.setS(Config.client_static_keypair)
				.setRS(Config.server_static_key)
				.setPayload(Config.PAYLOAD);
		conn.start();
		FunInputStream in = conn.getInputStream();
		FunOutputStream out = conn.getOutputStream();

		new Thread(new Main(in,out)).start();
	}

	private static void a(){
		FunXMPP.setVersion(4,0);

		String xml1 = "<a href=\"jan@s.whatsapp.net\">Hoi<b><c/>Asia/Kabul</b>A</a>";
		System.err.println(xml1);
		byte[] fun = FunXMPP.encode(xml1);
		System.err.println(Hex.fromBytes(fun));
		String xml2 = FunXMPP.decode(fun);
		System.err.println(xml2);
	}

	@Override
	public void run(){
		try{
			String xml;
			while((xml = in.readXML())!=null){
				Element elem = Jsoup.parse(xml).body().children().first();
				if(elem==null){
					System.err.println("CLOSED");
					break;
				}
				if("stream:error".equals(elem.tagName())){
					this.handleStreamError(elem);
					continue;
				}
				if("success".equals(elem.tagName())){
					this.handleSuccess(elem);
					continue;
				}
				if("ib".equals(elem.tagName())){
					this.handleIB(elem);
					continue;
				}
				if("iq".equals(elem.tagName())){
					this.handleIQ(elem);
					continue;
				}
				System.err.println("Unknown tag: "+elem);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.err.println("EXIT");
	}

	private void handleStreamError(Element elem) throws IOException{
		System.err.println("Stream Error: "+elem);
	}

	private void handleSuccess(Element elem) throws IOException{
		System.err.println("Success: "+elem);

		this._getCDN();
		this._doPing();

		this.out.write(0);

		this.out.writeXML("<presence type=\"available\"/>");
		this.out.flush();
	}

	private void _getCDN() throws IOException{
		this.out.writeXML("<iq to=\"s.whatsapp.net\" id=\"1\" xmlns=\"w:m\" type=\"set\"><media_conn/></iq>");
		this.out.flush();
	}

	private void _doPing(){
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					out.writeXML("<iq id=\"2\" xmlns=\"w:p\" type=\"get\" to=\"s.whatsapp.net\"><ping/></iq>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		},100, 4 * 60 * 1000);
	}

	private void handleIB(Element elem) throws IOException{
		System.err.println("IB: "+elem);
	}

	private void handleIQ(Element elem) throws IOException{
		System.err.println("IQ: "+elem);
	}

}