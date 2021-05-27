package nl.ben221199.wapi;

import com.google.protobuf.ByteString;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.whatsapp.proto.WA4Protos;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.whispersystems.libsignal.state.PreKeyRecord;
import org.whispersystems.libsignal.util.KeyHelper;

public class Main implements Runnable{

	private Config config;
	private FunInputStream in;
	private FunOutputStream out;

	protected Main(Config config,FunInputStream in,FunOutputStream out){
		this.config = config;
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

		new Thread(new Main(config,in,out)).start();
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

	private void handleFailure(String xml,Element elem) throws IOException {
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

		boolean sentKeys = false;
		if(this.config.has("__prekeys_sent")){
			sentKeys = this.config.getPrekeysSent();
		}
		if(!sentKeys){
			this.setKeys();
		}

		this.setProfilePicture();

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

	private void setProfilePicture() throws IOException{
		String xml = "";

		byte[] imageData = new FileInputStream(new File("C:\\Users\\Ben\\Pictures\\WAPP_IMAGE.jpg")).readAllBytes();
		byte[] previewData = new FileInputStream(new File("C:\\Users\\Ben\\Pictures\\WAPP_PREVIEW.jpg")).readAllBytes();

		xml += "<iq type=\"set\" id=\"123-img\" xmlns=\"w:profile:picture\" to=\"79066233987@s.whatsapp.net\">";
		xml += "<picture type=\"image\" id=\""+System.currentTimeMillis()+"\">"+Base64.encode(imageData)+"</picture>";
		xml += "<picture type=\"preview\">"+Base64.encode(previewData)+"</picture>";
		xml += "</iq>";

		System.err.println("[]>> "+FunXMPP.decode(FunXMPP.encode(xml)));
		this.out.writeXML(xml);
		this.out.flush();
	}

	private void setKeys() throws IOException {
//		IdentityKeyPair identityKeyPair = new IdentityKeyPair(nl.ben221199.wapi.Base64.decode(this.config.getE2EIdentFull()));
		List<PreKeyRecord> prekeys = KeyHelper.generatePreKeys(0,100);

		ByteString.Output o = ByteString.newOutput();
		o.write("<iq id=\"2\" xmlns=\"encrypt\" type=\"get\" to=\"s.whatsapp.net\">".getBytes());

		o.write("<list>".getBytes());
		for(PreKeyRecord pkr : prekeys){
			String id = Base64.encode(ByteBuffer.allocate(4).putInt(pkr.getId()).array());
			String value = Base64.encode(pkr.getKeyPair().getPublicKey().serialize());
			o.write(("<key><id>"+id+"</id><value>"+value+"</value></key>").getBytes());
		}
		o.write("</list>".getBytes());

		o.write(("<identity>"+this.config.getE2EIdent()+"</identity>").getBytes());
		String e_regid = Base64.encode(ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(config.getE2ERegId()).array());
		o.write(("<registration>"+e_regid+"</registration>").getBytes());
		String e_keytype = Base64.encode(ByteBuffer.allocate(1).order(ByteOrder.BIG_ENDIAN).put((byte) config.getE2EKeyType()).array());
		o.write(("<type>"+e_keytype+"</type>").getBytes());

		o.write("<skey>".getBytes());
		String e_skey_id = Base64.encode(ByteBuffer.allocate(3).order(ByteOrder.BIG_ENDIAN).putShort(1,(short) config.getE2ESKeyId()).array());
		o.write(("<id>"+e_skey_id+"</id>").getBytes());
		o.write(("<value>"+this.config.getE2ESkeyVal()+"</value>").getBytes());
		o.write(("<signature>"+this.config.getE2ESkeySig()+"</signature>").getBytes());
		o.write("</skey>".getBytes());

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

//		System.err.println("[]>> "+FunXMPP.decode(FunXMPP.encode(xml)));
		this.out.writeXML(xml);
		this.out.flush();

		this.config.setPrekeysSent(true);
		this.config.save();
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
				.setPrimary(Constants.Version.WHATSAPP_VERSION_PRIMARY)
				.setSecondary(Constants.Version.WHATSAPP_VERSION_SECONDARY)
				.setTertiary(Constants.Version.WHATSAPP_VERSION_TERTIARY)
				.setQuaternary(Constants.Version.WHATSAPP_VERSION_QUATERNARY)
				.build();

		WA4Protos.ClientPayload.UserAgent userAgent = WA4Protos.ClientPayload.UserAgent.newBuilder()
				.setReleaseChannel(WA4Protos.ClientPayload.UserAgent.ReleaseChannel.forNumber(config.getReleaseChannel()))
				.setPlatform(WA4Protos.ClientPayload.UserAgent.Platform.ANDROID)
				.setMcc(config.getMCC())
				.setMnc(config.getMNC())
				.setOsVersion(Constants.UserAgent.Android.OS_VERSION)
				.setManufacturer(Constants.UserAgent.Android.MANUFACTURER)
				.setDevice(Constants.UserAgent.Android.DEVICE_NAME)
				.setOsBuildNumber(Constants.UserAgent.Android.OS_BUILD_NUMBER)
				.setPhoneId(config.getFDId())
				.setLocaleLanguageIso6391(config.getLanguage())
				.setLocalCountryIso31661Alpha2(config.getLanguageCountry())
				.setAppVersion(appVersion)
				.build();

		return WA4Protos.ClientPayload.newBuilder()
				.setUsername(config.getLogin())
				.setPassive(true)
				.setPushName("I have a cool name")
				.setSessionId(new Random().nextInt())
				.setShortConnect(false)
				.setConnectType(WA4Protos.ClientPayload.ConnectType.WIFI_UNKNOWN)
				.setUserAgent(userAgent).build();
	}

}