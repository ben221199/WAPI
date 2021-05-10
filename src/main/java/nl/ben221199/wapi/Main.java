package nl.ben221199.wapi;

import com.google.protobuf.ByteString;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.KeyPair;
import java.util.Base64;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.whispersystems.libsignal.IdentityKeyPair;
import org.whispersystems.libsignal.InvalidKeyException;
import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.ecc.ECKeyPair;
import org.whispersystems.libsignal.state.PreKeyBundle;
import org.whispersystems.libsignal.state.PreKeyRecord;
import org.whispersystems.libsignal.state.SignalProtocolStore;
import org.whispersystems.libsignal.state.SignedPreKeyRecord;
import org.whispersystems.libsignal.util.KeyHelper;
import org.whispersystems.libsignal.util.Medium;

public class Main implements Runnable{

	private FunInputStream in;
	private FunOutputStream out;

	protected Main(FunInputStream in,FunOutputStream out){
		this.in = in;
		this.out = out;
	}

	private static final ECKeyPair aliceSignedPreKey = Curve.generateKeyPair();
//	private static final ECKeyPair bobSignedPreKey   = Curve.generateKeyPair();

	private static final int aliceSignedPreKeyId = new Random().nextInt(Medium.MAX_VALUE);
//	private static final int bobSignedPreKeyId   = new Random().nextInt(Medium.MAX_VALUE);

	private static PreKeyBundle createAlicePreKeyBundle(SignalProtocolStore aliceStore) throws InvalidKeyException {
		ECKeyPair aliceUnsignedPreKey   = Curve.generateKeyPair();
		int       aliceUnsignedPreKeyId = new Random().nextInt(Medium.MAX_VALUE);
		byte[]    aliceSignature        = Curve.calculateSignature(aliceStore.getIdentityKeyPair().getPrivateKey(),
				aliceSignedPreKey.getPublicKey().serialize());

		PreKeyBundle alicePreKeyBundle = new PreKeyBundle(1, 1,
				aliceUnsignedPreKeyId, aliceUnsignedPreKey.getPublicKey(),
				aliceSignedPreKeyId, aliceSignedPreKey.getPublicKey(),
				aliceSignature, aliceStore.getIdentityKeyPair().getPublicKey());

		aliceStore.storeSignedPreKey(aliceSignedPreKeyId, new SignedPreKeyRecord(aliceSignedPreKeyId, System.currentTimeMillis(), aliceSignedPreKey, aliceSignature));
		aliceStore.storePreKey(aliceUnsignedPreKeyId, new PreKeyRecord(aliceUnsignedPreKeyId, aliceUnsignedPreKey));

		return alicePreKeyBundle;
	}

	public static void main(String... args) throws IOException{
		Scanner s = new Scanner(System.in);
		System.err.println("Enter your configuration Id:");
		String id = s.nextLine();

		String countryCode = Config.loadCountryCode(id);
		String internalNumber = Config.loadInternalNumber(id);
		KeyPair keyPair = Config.loadClientStaticKeypair(id);


		Connection conn = new Connection("e7.whatsapp.net",443)
//				.setEdgeRoutingInfo(Config.edge_routing_info)
				.setS(keyPair)
				.setRS(Config.server_static_key)
				.setPayload(Config.getConfig(Long.parseLong(countryCode+internalNumber)));
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

}