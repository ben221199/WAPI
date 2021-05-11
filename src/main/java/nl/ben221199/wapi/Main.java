package nl.ben221199.wapi;

import com.google.protobuf.ByteString;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import com.whatsapp.proto.WA4Protos;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.whispersystems.libsignal.IdentityKeyPair;
import org.whispersystems.libsignal.InvalidKeyException;
import org.whispersystems.libsignal.state.PreKeyRecord;
import org.whispersystems.libsignal.state.SignedPreKeyRecord;
import org.whispersystems.libsignal.util.KeyHelper;

public class Main implements Runnable{

	private FunInputStream in;
	private FunOutputStream out;

	protected Main(FunInputStream in,FunOutputStream out){
		this.in = in;
		this.out = out;
	}

	public static void main(String... args) throws IOException{
		Scanner s = new Scanner(System.in);
		System.err.println("Enter your configuration Id:");
		String id = s.nextLine();

		Config config = Config.loadConfig(id);

		Connection conn = new Connection("e7.whatsapp.net",443)
				.setEdgeRoutingInfo(config.getEdgeRoutingInfo())
				.setS(config.getClientStaticKeypair())
//				.setRS(Config.server_static_key)
				.setPayload(Main.getClientPayload(config));
		conn.start();
		FunInputStream in = conn.getInputStream();
		FunOutputStream out = conn.getOutputStream();

		new Thread(new Main(in,out)).start();
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
				if("failure".equals(elem.tagName())){
					this.handleFailure(xml,elem);
					continue;
				}
				if("ib".equals(elem.tagName())){
					this.handleIB(xml,elem);
					continue;
				}
				if("iq".equals(elem.tagName())){
					this.handleIQ(xml,elem);
					continue;
				}
				if("stream:error".equals(elem.tagName())){
					this.handleStreamError(xml,elem);
					continue;
				}
				if("success".equals(elem.tagName())){
					this.handleSuccess(xml,elem);
					continue;
				}
				System.err.println("Unknown tag: "+xml);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.err.println("EXIT");
	}

	private void handleFailure(String xml,Element elem){
		System.err.println("Failure: "+xml);
	}

	private void handleIB(String xml,Element elem) throws IOException{
		System.err.println("<<[] IB: "+xml);
	}

	private void handleIQ(String xml,Element elem) throws IOException{
		System.err.println("<<[] IQ: "+xml);
	}

	private void handleStreamError(String xml,Element elem) throws IOException{
		System.err.println("<<[] Stream Error: "+xml);
	}

	private void handleSuccess(String xml,Element elem) throws IOException{
		System.err.println("<<[] Success: "+xml);

		this._getCDN();
		this._doPing();

		String presence = "<presence type=\"available\"/>";
		System.err.println("[]>> "+FunXMPP.decode(FunXMPP.encode(presence)));
		this.out.writeXML(presence);
		this.out.flush();

//		String key = "<iq id=\"enc-123\" type=\"get\" xmlns=\"encrypt\" to=\"s.whatsapp.net\"><key><user jid=\"31612322954@s.whatsapp.net\"/></key></iq>";
//		System.err.println("[]>> "+FunXMPP.decode(FunXMPP.encode(key)));
//		this.out.writeXML(key);
//		this.out.flush();

//		this.setKeys();

		String xml3 = "<iq id=\"4\" xmlns=\"encrypt\" type=\"get\" to=\"s.whatsapp.net\"><key><user jid=\"31612322954@s.whatsapp.net\"/></key></iq>";
		System.err.println("[]>> "+FunXMPP.decode(FunXMPP.encode(xml3)));
		this.out.writeXML(xml3);
		this.out.flush();

//		String xml3 = "<iq id=\"4\" xmlns=\"encrypt\" type=\"get\" to=\"s.whatsapp.net\"><key><user jid=\"79622766291@s.whatsapp.net\"/></key></iq>";
//		System.err.println("[]>> "+FunXMPP.decode(FunXMPP.encode(xml3)));
//		this.out.writeXML(xml3);
//		this.out.flush();

		//this.createGroup();

//		String message = "<message to=\"31612322954@s.whatsapp.net\" type=\"text\" id=\"message-"+System.currentTimeMillis()/1000+"-1\" t=\""+System.currentTimeMillis()/1000+"\"><body>Test</body></message>";
//		System.err.println("[]>> "+FunXMPP.decode(FunXMPP.encode(message)));
//		this.out.writeXML(message);
//		this.out.flush();
	}

	private void setKeys() throws IOException{
		IdentityKeyPair identityKeyPair = KeyHelper.generateIdentityKeyPair();

		SignedPreKeyRecord signedPreKey = null;
		try {
			signedPreKey = KeyHelper.generateSignedPreKey(identityKeyPair, 5);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		ByteString.Output o = ByteString.newOutput();
		o.write("<iq id=\"2\" xmlns=\"encrypt\" type=\"get\" to=\"s.whatsapp.net\">".getBytes());
		o.write("<list>".getBytes());
		for(PreKeyRecord pkr : KeyHelper.generatePreKeys(0,100)){
			String id = byteEncode(ByteBuffer.allocate(4).putInt(pkr.getId()).array());
			String value = byteEncode(pkr.getKeyPair().getPublicKey().serialize());
			o.write(("<key><id>"+id+"</id><value>"+value+"</value></key>").getBytes());
		}
		o.write("</list>".getBytes());
		o.write(("<identity>"+byteEncode(identityKeyPair.getPublicKey().serialize())+"</identity>").getBytes());
		o.write(("<registration>"+byteEncode(ByteBuffer.allocate(4).putInt(KeyHelper.generateRegistrationId(true)).array())+"</registration>").getBytes());
		o.write(("<type>"+byteEncode(new byte[]{0x05})+"</type>").getBytes());
//		o.write("<skey>".getBytes());
//		o.write(("<id>"+byteEncode(Arrays.copyOfRange(ByteBuffer.allocate(4).putInt(signedPreKey==null?0:signedPreKey.getId()).array(),1,4))+"</id>").getBytes());
//		byte[] value = signedPreKey==null?new byte[0]:signedPreKey.getKeyPair().getPublicKey().serialize();
//		o.write(("<value>"+byteEncode(Arrays.copyOfRange(value,1,value.length))+"</value>").getBytes());
//		o.write(("<signature>"+byteEncode(signedPreKey==null?new byte[0]:signedPreKey.getSignature())+"</signature>").getBytes());
//		o.write("</skey>".getBytes());
		o.write("</iq>".getBytes());

//		System.err.println();
		String xml = o.toByteString().toStringUtf8();
		System.err.println("> XML: "+xml);
//		FunXMPP.Node node = FunXMPP.Node.from(xml);
//		System.err.println("> OBJ: "+node);
//		System.err.println();
//		byte[] bytes = FunXMPP.encode(xml);
//		System.err.println("> HEX: "+Hex.fromBytes(bytes));
//		System.err.println();
//		FunXMPP.Node node2 = FunXMPP.Node.from((FunXMPP.ShortList) FunXMPP.Token.from(ByteBuffer.wrap(bytes)));
//		System.err.println("> JBO: "+node2);
//		String xml2 = FunXMPP.decode(bytes);
//		System.err.println("> LMX: "+xml2);
//		System.err.println();

		System.err.println("[]>> "+FunXMPP.decode(FunXMPP.encode(xml)));
		this.out.writeXML(xml);
		this.out.flush();
	}

	private String byteEncode(byte[] ba){
		return Base64.getEncoder().encodeToString(ba);
//		StringBuilder sb = new StringBuilder();
//		for(byte b : ba){
//			char c = (char) b;
//			if(c==0){
//				sb.append("&#0;");
//				continue;
//			}
//		}
//		return sb.toString();
	}

	private void createGroup() throws IOException{
		String group = "<iq id=\"1234\" xmlns=\"w:g2\" type=\"set\" to=\"g.us\">" +
				"<create subject=\"MyNewGroup\">" +
				"<participant jid=\"31612322954@s.whatsapp.net\"/>" +
				"</create>" +
				"</iq>";
		System.err.println("[]>> "+FunXMPP.decode(FunXMPP.encode(group)));
		this.out.writeXML(group);
		this.out.flush();
	}

	private void _getCDN() throws IOException{
		String iq = "<iq to=\"s.whatsapp.net\" id=\"1\" xmlns=\"w:m\" type=\"set\"><media_conn/></iq>";
		System.err.println("[]>> "+FunXMPP.decode(FunXMPP.encode(iq)));
		this.out.writeXML(iq);
		this.out.flush();
	}

	private void _doPing(){
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					String iq = "<iq id=\"1416174955-ping\" xmlns=\"w:p\" type=\"get\" to=\"s.whatsapp.net\"><ping/></iq>";
					System.err.println("[]>> "+FunXMPP.decode(FunXMPP.encode(iq)));
					out.writeXML(iq);
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		},100,4 * 60 * 1000);
	}

	private static WA4Protos.ClientPayload getClientPayload(Config config){
		WA4Protos.ClientPayload.UserAgent.AppVersion appVersion = WA4Protos.ClientPayload.UserAgent.AppVersion.newBuilder()
				.setPrimary(2)
				.setSecondary(20)
				.setTertiary(206)
				.setQuaternary(22)
				.build();

		WA4Protos.ClientPayload.UserAgent userAgent = WA4Protos.ClientPayload.UserAgent.newBuilder()
				.setPlatform(WA4Protos.ClientPayload.UserAgent.Platform.ANDROID)
				//.setMcc("12")
				//.setMnc("334534")
				.setOsVersion("1.2.3.4")
				.setManufacturer("Droid")
				.setDevice("S5")
				.setOsBuildNumber("1.0.5")
				.setPhoneId(UUID.randomUUID().toString())
				.setLocaleLanguageIso6391("nl")
				.setLocalCountryIso31661Alpha2("NL")
				.setAppVersion(appVersion)
				.build();

		return WA4Protos.ClientPayload.newBuilder()
				.setUsername(config.getLogin())
				.setPassive(true)
				.setPushName("H_____________OI")
				.setSessionId(5)
				.setShortConnect(false)
				.setConnectType(WA4Protos.ClientPayload.ConnectType.WIFI_UNKNOWN)
				.setUserAgent(userAgent).build();
	}

}