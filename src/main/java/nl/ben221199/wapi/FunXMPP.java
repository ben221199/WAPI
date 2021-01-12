package nl.ben221199.wapi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nl.ben221199.wapi.protocol.WA40;

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
		throw new RuntimeException("Protocol version not implemented");
	}

	public static String decode(byte[] tokens){
		ByteBuffer bb = ByteBuffer.wrap(tokens);

		Token t = Token.from(bb);
		if(t instanceof AbstractList){
			Node n = Node.from((AbstractList) t);
			return n.getString();
		}
		return null;
	}

	public static byte[] encode(String xml){
		FunXMPP.Node node = FunXMPP.Node.from(xml);
		return node.getToken().getBytes();
	}

	private static class Token{

		protected byte token;

		public Token(byte token){
			this.token = token;
		}

		public Token(){}

		public static Token from(ByteBuffer bb){
			int b = bb.get() & 0xFF;
			switch(b){
				case 0xEC:
				case 0xED:
				case 0xEE:
				case 0xEF:{
					SecondaryToken t = new SecondaryToken((byte) b);
					t.secondaryToken = bb.get();
					return t;
				}
				case 0xF8:{
					ShortList t = new ShortList((byte) b);
					t.length = bb.get();
					for(int i=0;i<t.length;i++){
						t.items.add(Token.from(bb));
					}
					return t;
				}
				case 0xF9:{
					LongList t = new LongList((byte) b);
					t.length = bb.getShort();
					for(int i=0;i<t.length;i++){
						t.items.add(Token.from(bb));
					}
					return t;
				}
				case 0xFA:{
					JabberId t = new JabberId((byte) b);
					t.user = Token.from(bb);
					t.server = Token.from(bb);
					return t;
				}
				case 0xFB:{
					PackedHex t = new PackedHex((byte) b);
					byte startByte = bb.get();
					t.length = startByte & 0x7F;
					byte[] buf = new byte[t.length];
					bb.get(buf);
					t.data = PackedHex.unpack(startByte,buf);
					return t;
				}
				case 0xFC:{
					Int8LengthArrayString t = new Int8LengthArrayString((byte) b);
					t.length = bb.get();
					byte[] buf = new byte[t.length];
					bb.get(buf);
					t.data = new String(buf);
					return t;
				}
				case 0xFD:{
					Int20LengthArrayString t = new Int20LengthArrayString((byte) b);
					t.length = ((bb.get() & 0xF) << 16) | (bb.get() << 8) | bb.get();
					byte[] buf = new byte[t.length];
					bb.get(buf);
					t.data = new String(buf);
					return t;
				}
				case 0xFE:{
					Int31LengthArrayString t = new Int31LengthArrayString((byte) b);
					byte int1 = bb.get();
					t.length = (int1 << 24) | (int1 << 16) | bb.get() << 8 | bb.get();
					byte[] buf = new byte[t.length];
					bb.get(buf);
					t.data = new String(buf);
					return t;
				}
				case 0xFF:{
					PackedNibble t = new PackedNibble((byte) b);
					byte startByte = bb.get();
					t.length = startByte & 0x7F;
					byte[] buf = new byte[t.length];
					bb.get(buf);
					t.data = PackedNibble.unpack(startByte,buf);
					return t;
				}
				default:{
					Token t = new Token();
					t.token = (byte) b;
					return t;
				}
			}
		}

		public byte[] getBytes(){
			return new byte[]{this.token};
		}

		public String getString(){
			return FunXMPP.dictionary[this.token & 0xFF];
		}

		@Override
		public String toString() {
			return "Token{" +
					"token=" + token +
					'}';
		}

	}

	private static class SecondaryToken extends Token{

		protected byte secondaryToken;

		public SecondaryToken(byte token){
			super(token);
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

	private static class AbstractList extends Token{

		public AbstractList(byte token){
			super(token);
		}

		protected List<Token> items = new ArrayList<>();

	}

	private static class ShortList extends AbstractList{

		protected byte length;

		public ShortList(byte token){
			super(token);
		}

		public ShortList(){
			super((byte) 0xF8);
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

	private static class LongList extends AbstractList{

		protected short length;

		public LongList(byte token){
			super(token);
		}

		public LongList(){
			super((byte) 0xF9);
		}

		public byte[] getBytes(){
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try{
				baos.write(new byte[]{this.token,(byte) ((this.items.size()>>8)&0xFF),(byte) ((this.items.size()>>0)&0xFF)});
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

	private static class JabberId extends Token{

		protected Token user;
		protected Token server;

		public JabberId(byte token){
			super(token);
		}

		public JabberId(){
			super((byte) 0xFA);
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
				baos.write(this.user.getBytes());
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
			return this.user.getString()+"@"+this.server.getString();
		}

	}

	private static class Int8LengthArrayString extends Token{

		protected byte length;
		protected String data;

		public Int8LengthArrayString(byte token){
			super(token);
		}

		public Int8LengthArrayString(){
			super((byte) 0xFC);
		}

		@Override
		public String toString() {
			return "Int8LengthArrayString{" +
					"length=" + length +
					", data='" + StringEscapeUtils.escapeXml11(data) + '\'' +
					'}';
		}

		public byte[] getBytes(){
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try{
				baos.write(new byte[]{this.token,(byte) this.data.length()});
				baos.write(this.data.getBytes());
				baos.flush();
			}
			catch(IOException ignored){}
			return baos.toByteArray();
		}

		public String getString(){
			return this.data;
		}

	}

	private static class Int20LengthArrayString extends Token{

		protected int length;
		protected String data;

		public Int20LengthArrayString(byte token){
			super(token);
		}

		public Int20LengthArrayString(){
			super((byte) 0xFD);
		}

		public byte[] getBytes(){
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try{
				baos.write(new byte[]{this.token, (byte) ((byte) this.data.length() >> 16 & 0x0F), (byte) (this.data.length() >> 8 & 0xFF), (byte) (this.data.length() >>0 & 0xFF)});
				baos.write(this.data.getBytes());
				baos.flush();
			}
			catch(IOException ignored){}
			return baos.toByteArray();
		}

		@Override
		public String toString() {
			return "Int20LengthArrayString{" +
					"length=" + length +
					", data='" + StringEscapeUtils.escapeXml11(data) + '\'' +
					'}';
		}

		public String getString(){
			return this.data;
		}

	}

	private static class Int31LengthArrayString extends Token{

		protected int length;
		protected String data;

		public Int31LengthArrayString(byte token){
			super(token);
		}

		public Int31LengthArrayString(){
			super((byte) 0xFE);
		}

		public byte[] getBytes(){
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try{
				baos.write(new byte[]{this.token,(byte) ((byte) this.data.length() >> 24 & 0x7F), (byte) ((byte) this.data.length() >> 16 & 0xFF), (byte) (this.data.length() >> 8 & 0xFF), (byte) (this.data.length() >>0 & 0xFF)});
				baos.write(this.data.getBytes());
				baos.flush();
			}
			catch(IOException ignored){}
			return baos.toByteArray();
		}

		@Override
		public String toString() {
			return "Int31LengthArrayString{" +
					"length=" + length +
					", data='" + StringEscapeUtils.escapeXml11(data) + '\'' +
					'}';
		}

		public String getString(){
			return this.data;
		}

	}

	private static class PackedNibble extends Token{

		protected int length;
		protected String data;

		public PackedNibble(byte token){
			super(token);
		}

		public PackedNibble(){
			super((byte) 0xFF);
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

		public static String unpack(byte startByte,byte[] packed){
			StringBuilder ret = new StringBuilder();
			if((startByte & 0x7F)==0){
				return "";
			}
			for(int i=0;i<(startByte & 0x7F);i++){
				byte currByte = packed[i];
				ret.append(PackedNibble.unpackByte((currByte & 0xF0) >> 4));
				ret.append(PackedNibble.unpackByte(currByte & 0x0F));
			}
			if((startByte >> 7)==0){
				ret = new StringBuilder(new String(Arrays.copyOfRange(ret.toString().getBytes(), 0, ret.length() - 1)));// ret[:len(ret)-1];
			}
			return ret.toString();
		}

		private static String unpackByte(int value){
			if(value < 0 || value > 15){
				throw new RuntimeException("invalid hex to unpack: "+value);
			}
			if(value < 10){
				return String.valueOf((char) ('0'+value));
			}else{
				return String.valueOf((char) ('A'+value-10));
			}
		}

		@Override
		public String toString() {
			return "PackedNibble{" +
					"data='" + data + '\'' +
					'}';
		}

		public String getString(){
			return this.data;
		}

	}

	private static class PackedHex extends Token{

		protected int length;
		protected String data;

		public PackedHex(byte token){
			super(token);
		}

		public PackedHex(){
			super((byte) 0xFB);
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

		public static String unpack(byte startByte,byte[] packed){
			StringBuilder ret = new StringBuilder();
			if((startByte & 0x7F)==0){
				return "";
			}
			for(int i=0;i<(startByte & 0x7F);i++){
				byte currByte = packed[i];
				ret.append(PackedHex.unpackByte((currByte & 0xF0) >> 4));
				ret.append(PackedHex.unpackByte(currByte & 0x0F));
			}
			if((startByte >> 7)==0){
				ret = new StringBuilder(new String(Arrays.copyOfRange(ret.toString().getBytes(), 0, ret.length() - 1)));// ret[:len(ret)-1];
			}
			return ret.toString();
		}

		private static String unpackByte(int value){
			if(value >= 0 && value <= 9){
				return String.valueOf((char) ('0'+value));
			}else if(value==10){
				return "-";
			}else if(value==11){
				return ".";
			}else if(value==15){
				return "\0";
			}
			throw new RuntimeException("invalid nibble to unpack: " + value);
		}

		@Override
		public String toString() {
			return "PackedHex{" +
					"data='" + data + '\'' +
					'}';
		}

		public String getString(){
			return this.data;
		}

	}

	public static class Node{

		private Token tagToken;
		private String tag;
		private List<Attribute> attributes = new ArrayList<>();
		private List<Node> children = new ArrayList<>();
		private String data;

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
			Element elem = Jsoup.parse(xml).body().child(0);
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
			output.append(this.tag);
			for(Attribute attr : this.attributes){
				output.append(" ").append(attr.key).append("=\"").append(attr.value).append("\"");
			}
			if(this.data==null && this.children.size()==0 && this.tagToken.token!=2){
				output.append("/>");
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

			nodeList.items.add(this.writeString(this.tag));
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
			for(int i=0;i<FunXMPP.dictionary.length;i++){
				if(FunXMPP.dictionary[i].equals(str)){
					return new Token((byte) i);
				}
			}
			for(int i=0;i<FunXMPP.secondaryDictionary.length;i++){
				if(FunXMPP.secondaryDictionary[i].equals(str)){
					SecondaryToken t = new SecondaryToken((byte) (0xEC+i/256));
					t.secondaryToken = (byte) (i%256);
					return t;
				}
			}
			if(str.contains("@")){
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
				Int8LengthArrayString arr = new Int8LengthArrayString();
				arr.data = str;
				return arr;
			}
			if(str.length()<=1048575L){
				Int8LengthArrayString arr = new Int8LengthArrayString();
				arr.data = str;
				return arr;
			}
			if(str.length()<=2147483647L){
				Int31LengthArrayString arr = new Int31LengthArrayString();
				arr.data = str;
				return arr;
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