package nl.ben221199.wapi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import nl.ben221199.wapi.protocol.WA40;
import nl.ben221199.wapi.protocol.WA41;

import org.apache.commons.text.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class FunXMPP{

	private static String[] dictionary;
	private static String[] secondaryDictionary;

	public static void setVersion(int major,int minor){
		if(major==0x04 && minor==0x00){
			FunXMPP.dictionary = WA40.getDictionary();
			FunXMPP.secondaryDictionary = WA40.getSecondaryDictionary();
			return;
		}
		if(major==0x04 && minor==0x01){
			FunXMPP.dictionary = WA41.getDictionary();
			FunXMPP.secondaryDictionary = WA41.getSecondaryDictionary();
			return;
		}
		throw new RuntimeException("Protocol version not implemented");
	}

	private static void ensureDictionaries(){
		if(FunXMPP.dictionary==null || FunXMPP.secondaryDictionary==null){
			throw new RuntimeException("FunXMPP version is not set.");
		}
	}

	public static String decode(byte[] tokens){
		FunXMPP.ensureDictionaries();

		ByteBuffer bb = ByteBuffer.wrap(tokens);

		Token t = Token.from(bb);
		if(t instanceof AbstractList){
			Node n = Node.from((AbstractList) t);
			return n.getString();
		}
		return null;
	}

	public static byte[] encode(String xml){
		FunXMPP.ensureDictionaries();

		FunXMPP.Node node = FunXMPP.Node.from(xml);
		return node.getToken().getBytes();
	}

	public static class Token{

		protected byte token;

		public Token(byte token){
			this.token = token;
		}

//		public Token(){}

		public static Token from(ByteBuffer bb){
			int b = bb.get() & 0xFF;
			switch(b){
				case 0xEC:
				case 0xED:
				case 0xEE:
				case 0xEF:{
					return new SecondaryToken((byte) b,bb.get());
				}
				case 0xF8:{
					ShortList t = new ShortList();
					t.length = bb.get();
					for(int i=0;i<t.length;i++){
						t.items.add(Token.from(bb));
					}
					return t;
				}
				case 0xF9:{
					LongList t = new LongList();
					t.length = bb.getShort();
					for(int i=0;i<t.length;i++){
						t.items.add(Token.from(bb));
					}
					return t;
				}
				case 0xFA:{
					return new JabberId(Token.from(bb),Token.from(bb));
				}
				case 0xFB:{
					byte startByte = bb.get();
					byte[] buf = new byte[startByte & 0x7F];
					bb.get(buf);
					return new PackedHex(PackedHex.unpack(startByte,buf));
				}
				case 0xFC:{
					byte[] buf = new byte[bb.get()];
					bb.get(buf);
					return new Int8LengthArrayString(buf);
				}
				case 0xFD:{
					byte[] buf = new byte[((bb.get() & 0xF) << 16) | (bb.get() << 8) | bb.get()];
					bb.get(buf);
					return new Int20LengthArrayString(buf);
				}
				case 0xFE:{
					byte[] buf = new byte[(bb.get() & 0x7F << 24) | (bb.get() << 16) | bb.get() << 8 | bb.get()];
					bb.get(buf);
					return new Int31LengthArrayString(buf);
				}
				case 0xFF:{
					byte startByte = bb.get();
					byte[] buf = new byte[startByte & 0x7F];
					bb.get(buf);
					return new PackedNibble(PackedNibble.unpack(startByte,buf));
				}
				default:{
					return new Token((byte) b);
				}
			}
		}

		public byte[] getBytes(){
			return new byte[]{this.token};
		}

		public String getString(){
			if(!this.getClass().equals(Token.class)){
				throw new RuntimeException("Cannot get string on this token");
			}
			return FunXMPP.dictionary[this.token & 0xFF];
		}

		@Override
		public String toString() {
			return "Token{" +
					"token=" + token +
					'}';
		}

	}

	public static class SecondaryToken extends Token{

		protected byte secondaryToken;

		public SecondaryToken(byte token,byte secondaryToken){
			super(token);
			this.secondaryToken = secondaryToken;
		}

		public byte[] getBytes(){
			return new byte[]{this.token,this.secondaryToken};
		}

		public String getString(){
			int n = this.token-236 & 0xFF;
			int n2 = this.secondaryToken & 0xFF;
			return FunXMPP.secondaryDictionary[n2+n*256];
		}

		@Override
		public String toString() {
			return "SecondaryToken{" +
					"secondaryToken=" + secondaryToken +
					'}';
		}

	}

	private abstract static class AbstractList extends Token{

		public AbstractList(byte token){
			super(token);
		}

		protected List<Token> items = new ArrayList<>();

	}

	public static class ShortList extends AbstractList{

		protected byte length;

		public ShortList(){
			super((byte) 0xF8);
		}

		public ShortList(List<Token> items){
			this();
			this.items = items;
		}

		public byte[] getBytes(){
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try{
				baos.write(new byte[]{this.token, (byte) this.items.size()});
				for(Token t : this.items){
					baos.write(t.getBytes());
				}
				baos.flush();
			}
			catch(IOException ignored){}
			return baos.toByteArray();
		}

		@Override
		public String toString() {
			return "ShortList{" +
					"length=" + length +
					", items=" + items +
					'}';
		}

	}

	public static class LongList extends AbstractList{

		protected short length;

		public LongList(){
			super((byte) 0xF9);
		}

		public LongList(List<Token> items){
			this();
			this.items = items;
		}

		public byte[] getBytes(){
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try{
				baos.write(new byte[]{this.token,(byte) ((this.items.size()>>8)&0xFF),(byte) (this.items.size() & 0xFF)});
				for(Token t : this.items){
					baos.write(t.getBytes());
				}
				baos.flush();
			}
			catch(IOException ignored){}
			return baos.toByteArray();
		}

		@Override
		public String toString() {
			return "LongList{" +
					"length=" + length +
					", items=" + items +
					'}';
		}

	}

	public static class JabberId extends Token{

		protected Token user;
		protected Token server;

		private JabberId(){
			super((byte) 0xFA);
		}

		public JabberId(Token server){
			this();
			this.server = server;
		}

		public JabberId(Token user,Token server){
			this(server);
			this.user = user;
		}

		@Override
		public String toString() {
			return "JabberId{" +
					"user=" + user +
					", server=" + server +
					'}';
		}

		public byte[] getBytes(){
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try{
				baos.write(new byte[]{this.token});
				baos.write(this.user==null?new byte[1]:this.user.getBytes());
				baos.write(this.server.getBytes());
				baos.flush();
			}
			catch(IOException ignored){}
			return baos.toByteArray();
		}

		public String getString(){
			if(this.user==null || this.server==null){
				return "";
			}
			String user = this.user.getString();
			String jid = "";
			if(user!=null){
				jid = user+"@";
			}
			jid += this.server.getString();
			return jid;
		}

	}

	public static class Int8LengthArrayString extends Token{

		protected byte length;
		protected byte[] data;

		public Int8LengthArrayString(){
			super((byte) 0xFC);
		}

		public Int8LengthArrayString(byte[] data){
			this();
			if(data.length>=256){
				throw new RuntimeException("Data is too long for a int8 data array.");
			}
			this.length = (byte) data.length;
			this.data = data;
		}

		@Override
		public String toString() {
			return "Int8LengthArrayString{" +
					"length=" + length +
					", data='" + Base64.getEncoder().encodeToString(data) + '\'' +
					'}';
		}

		public byte[] getBytes(){
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try{
				baos.write(new byte[]{this.token,(byte) this.data.length});
				baos.write(this.data);
				baos.flush();
			}
			catch(IOException ignored){}
			return baos.toByteArray();
		}

		public String getString(){
			return null;
		}

	}

	public static class Int20LengthArrayString extends Token{

		protected int length;
		protected byte[] data;

		public Int20LengthArrayString(){
			super((byte) 0xFD);
		}

		public Int20LengthArrayString(byte[] data){
			this();
			if(data.length>=1048575L){
				throw new RuntimeException("Data is too long for a int20 data array.");
			}
			this.length = (byte) data.length;
			this.data = data;
		}

		public byte[] getBytes(){
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try{
				baos.write(new byte[]{this.token, (byte) ((byte) this.data.length >> 16 & 0x0F), (byte) (this.data.length >> 8 & 0xFF), (byte) (this.data.length & 0xFF)});
				baos.write(this.data);
				baos.flush();
			}
			catch(IOException ignored){}
			return baos.toByteArray();
		}

		@Override
		public String toString() {
			return "Int20LengthArrayString{" +
					"length=" + length +
					", data='" + Base64.getEncoder().encodeToString(data) + '\'' +
					'}';
		}

		public String getString(){
			return null;
		}

	}

	public static class Int31LengthArrayString extends Token{

		protected int length;
		protected byte[] data;

		public Int31LengthArrayString(){
			super((byte) 0xFE);
		}

		public Int31LengthArrayString(byte[] data){
			this();
			if(data.length>=2147483647L){
				throw new RuntimeException("Data is too long for a int31 data array.");
			}
			this.length = (byte) data.length;
			this.data = data;
		}

		public byte[] getBytes(){
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try{
				baos.write(new byte[]{this.token,(byte) ((byte) this.data.length >> 24 & 0x7F), (byte) ((byte) this.data.length >> 16 & 0xFF), (byte) (this.data.length >> 8 & 0xFF), (byte) (this.data.length & 0xFF)});
				baos.write(this.data);
				baos.flush();
			}
			catch(IOException ignored){}
			return baos.toByteArray();
		}

		@Override
		public String toString() {
			return "Int31LengthArrayString{" +
					"length=" + length +
					", data='" + Base64.getEncoder().encodeToString(data) + '\'' +
					'}';
		}

		public String getString(){
			return null;
		}

	}

	private static class PackedNibble extends Token{

		protected int length;
		protected byte[] data;

		public PackedNibble(){
			super((byte) 0xFF);
		}

		public PackedNibble(byte[] data){
			this();
			this.data = data;
		}

		public byte[] getBytes(){
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try{
				baos.write(new byte[]{this.token,(byte) 0x00});
				baos.flush();
			}
			catch(IOException ignored){}
			return baos.toByteArray();
		}

		public static byte[] unpack(byte startByte,byte[] packed){
			if((startByte & 0x7F)==0){
				return new byte[0];
			}
			byte[] ret = new byte[(startByte & 0x7F)*2];
			for(int i=0;i<(startByte & 0x7F);i++){
				byte currByte = packed[i];
				ret[i*2] = PackedNibble.unpackByte((currByte & 0xF0) >> 4);
				ret[i*2+1] = PackedNibble.unpackByte(currByte & 0x0F);
			}
			if((startByte >> 7)==0){
				ret = Arrays.copyOfRange(ret,0,ret.length-1); // ret[:len(ret)-1];
			}
			return ret;
		}

		private static byte unpackByte(int value){
			if(value < 0 || value > 15){
				throw new RuntimeException("invalid hex to unpack: "+value);
			}
			if(value < 10){
				return (byte) ('0'+value);
			}else{
				return (byte) ('A'+value-10);
			}
		}

		@Override
		public String toString() {
			return "PackedNibble{" +
					"data='" + Base64.getEncoder().encodeToString(data) + '\'' +
					'}';
		}

		public String getString(){
			return null;
		}

	}

	private static class PackedHex extends Token{

		protected int length;
		protected byte[] data;

		public PackedHex(){
			super((byte) 0xFB);
		}

		public PackedHex(byte[] data){
			this();
			this.data = data;
		}

		public byte[] getBytes(){
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try{
				baos.write(new byte[]{this.token,(byte) 0x00});
				baos.flush();
			}
			catch(IOException ignored){}
			return baos.toByteArray();
		}

		public static byte[] unpack(byte startByte,byte[] packed){
			if((startByte & 0x7F)==0){
				return new byte[0];
			}
			byte[] ret = new byte[(startByte & 0x7F)*2];
			for(int i=0;i<(startByte & 0x7F);i++){
				byte currByte = packed[i];
				ret[i*2] = PackedHex.unpackByte((currByte & 0xF0) >> 4);
				ret[i*2+1] = PackedHex.unpackByte(currByte & 0x0F);
			}
			if((startByte >> 7)==0){
				ret = Arrays.copyOfRange(ret,0,ret.length-1);// ret[:len(ret)-1];
			}
			return ret;
		}

		private static byte unpackByte(int value){
			if(value >= 0 && value <= 9){
				return (byte) ('0'+value);
			}else if(value==10){
				return '-';
			}else if(value==11){
				return '.';
			}else if(value==15){
				return '\0';
			}
			throw new RuntimeException("invalid nibble to unpack: " + value);
		}

		@Override
		public String toString() {
			return "PackedHex{" +
					"data='" + Base64.getEncoder().encodeToString(data) + '\'' +
					'}';
		}

		public String getString(){
			return null;
		}

	}

	public static class Node{

		private Token tagToken;
		private String tag;
		private List<Attribute> attributes = new ArrayList<>();
		private List<Node> children = new ArrayList<>();
		private String data;

		public static Node closed(){
			Node node = new Node();
			node.tagToken = new Token((byte) 2);
			node.tag = node.tagToken.getString();
			return node;
		}

		public static Node from(AbstractList list){
			int offset = 0;
			Node node = new Node();

			int size = list.items.size();

			node.tagToken = list.items.get(offset++);
			node.tag = node.tagToken.getString();

			int attribCount = (size - 2 + size % 2) / 2;
			for(int i=0;i<attribCount;i++){
				Attribute attr = new Attribute();
				attr.key = list.items.get(offset++).getString();
				attr.value = list.items.get(offset++).getString();
				node.attributes.add(attr);
			}

			if(size % 2 ==1){
				return node;
			}

			Token child = list.items.get(offset);
			if(child instanceof AbstractList){
				for(Token t : ((AbstractList) child).items){
					node.children.add(Node.from((AbstractList) t));
				}
			}else{
				node.data = child.getString();
			}

			return node;
		}

		public static Node from(String xml){
			if("</stream:stream>".equalsIgnoreCase(xml)){
				return Node.closed();
			}
			Element elem = Jsoup.parse(xml).body().children().first();
			return Node.from(elem);
		}

		private static Node from(Element elem){
			Node n = new Node();

			n.tag = elem.tagName();

			for(org.jsoup.nodes.Attribute a : elem.attributes()){
				n.attributes.add(new Attribute(a.getKey(),a.getValue()));
			}
			for(Element e : elem.children()){
				n.children.add(Node.from(e));
			}

			if(!elem.ownText().isEmpty()){
				n.data = elem.ownText();
			}

			return n;
		}

		public String getString(){
			StringBuilder output = new StringBuilder();

			output.append("<");
			if(this.tagToken!=null && this.tagToken.token==2){
				output.append("/");
			}
			output.append(this.tag);
			for(Attribute attr : this.attributes){
				output.append(" ").append(attr.key).append("=\"").append(attr.value).append("\"");
			}
			if(this.data==null && this.children.size()==0){
				if(this.tagToken!=null && this.tagToken.token==1){
					output.append(">");
				}else{
					if(this.tagToken!=null && this.tagToken.token==2){
						output.append(">");
					}else{
						output.append("/>");
					}
				}
			}else{
				output.append(">");
				if(this.data==null){
					for(Node child : this.children){
						output.append(child.getString());
					}
				}else{
					output.append(StringEscapeUtils.escapeXml11(this.data));
				}
				output.append("</").append(this.tag).append(">");
			}

			return output.toString();
		}

		public AbstractList getToken(){
			int size = 1;
			size += this.attributes.size()*2;
			if(this.data!=null || this.children.size()>0){
				size++;
			}
			AbstractList nodeList;
			if(size>=256){
				nodeList = new LongList();
			}else{
				nodeList = new ShortList();
			}

			if(this.tagToken==null){
				nodeList.items.add(this.writeString(this.tag));
			}else{
				nodeList.items.add(this.tagToken);
			}
			for(Attribute a : this.attributes){
				nodeList.items.add(this.writeString(a.key));
				nodeList.items.add(this.writeString(a.value));
			}
			if(this.children.size()>0){
//				if(this.children.size()==1){
//					nodeList.items.add(this.children.get(0).getToken());
//				}else{
					AbstractList childList;
					if(this.children.size()>=256){
						childList = new LongList();
					}else{
						childList = new ShortList();
					}
					for(Node childNode : this.children){
						childList.items.add(childNode.getToken());
					}
					nodeList.items.add(childList);
//				}
			}else if(this.data!=null){
				nodeList.items.add(this.writeString(this.data));
			}

			return nodeList;
		}

		private Token writeString(String str){
			if(str==null){
				return new Token((byte) 0);
			}
			for(int i=1;i<FunXMPP.dictionary.length;i++){
				if(FunXMPP.dictionary[i].equals(str)){
					return new Token((byte) i);
				}
			}
			for(int i=0;i<FunXMPP.secondaryDictionary.length;i++){
				if(FunXMPP.secondaryDictionary[i].equals(str)){
					return new SecondaryToken((byte) (0xEC+i/256),(byte) (i%256));
				}
			}
			if(str.endsWith("s.whatsapp.net") || str.endsWith("g.us")){
				if(!str.contains("@")){
					str += "@";
				}
				String[] jid = str.split("@");
				Token user = this.writeString(jid[0]);
				Token server = this.writeString(jid[1]);
				JabberId t = new JabberId();
				t.user = user;
				t.server = server;
				return t;
			}
			//TODO Packed Nibble and packed Hex
			if(str.length()<=255L){
				return new Int8LengthArrayString(str.getBytes());
			}
			if(str.length()<=1048575L){
				return new Int20LengthArrayString(str.getBytes());
			}
			if(str.length()<=2147483647L){
				return new Int31LengthArrayString(str.getBytes());
			}
			return null;
		}

		@Override
		public String toString() {
			return "Node{" +
					"tag='" + tag + '\'' +
					", attributes=" + attributes +
					", children=" + children +
					", data='" + data + '\'' +
					'}';
		}

		private static class Attribute{

			private String key;
			private String value;

			public Attribute(){
			}

			public Attribute(String key,String value){
				this.key = key;
				this.value = value;
			}

			@Override
			public String toString() {
				return "Attribute{" +
						"key='" + key + '\'' +
						", value='" + value + '\'' +
						'}';
			}

		}

	}

}