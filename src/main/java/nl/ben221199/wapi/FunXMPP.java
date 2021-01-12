package nl.ben221199.wapi;

import nl.ben221199.wapi.protocol.WA40;
import org.apache.commons.text.StringEscapeUtils;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public static byte[] encode(FunXMPP.Node xml){
		return new byte[0];
	}

	private static class Token{

		protected byte token;

		public static Token from(ByteBuffer bb){
			int b = bb.get() & 0xFF;
			switch(b){
				case 0xEC:
				case 0xED:
				case 0xEE:
				case 0xEF:{
					SecondaryToken t = new SecondaryToken();
					t.token = (byte) b;
					t.secondaryToken = bb.get();
					return t;
				}
				case 0xF8:{
					ShortList t = new ShortList();
					t.token = (byte) b;
					t.length = bb.get();
					for(int i=0;i<t.length;i++){
						t.items.add(Token.from(bb));
					}
					return t;
				}
				case 0xF9:{
					LongList t = new LongList();
					t.token = (byte) b;
					t.length = bb.getShort();
					for(int i=0;i<t.length;i++){
						t.items.add(Token.from(bb));
					}
					return t;
				}
				case 0xFA:{
					JabberId t = new JabberId();
					t.token = (byte) b;
					t.user = Token.from(bb);
					t.server = Token.from(bb);
					return t;
				}
				case 0xFB:{
					PackedHex t = new PackedHex();
					t.token = (byte) b;
					byte startByte = bb.get();
					t.length = startByte & 0x7F;
					byte[] buf = new byte[t.length];
					bb.get(buf);
					t.data = PackedHex.unpack(startByte,buf);
					return t;
				}
				case 0xFC:{
					Int8LengthArrayString t = new Int8LengthArrayString();
					t.token = (byte) b;
					t.length = bb.get();
					byte[] buf = new byte[t.length];
					bb.get(buf);
					t.data = new String(buf);
					return t;
				}
				case 0xFD:{
					Int20LengthArrayString t = new Int20LengthArrayString();
					t.token = (byte) b;
					t.length = ((bb.get() & 0xF) << 16) | (bb.get() << 8) | bb.get();
					byte[] buf = new byte[t.length];
					bb.get(buf);
					t.data = new String(buf);
					return t;
				}
				case 0xFE:{
					Int31LengthArrayString t = new Int31LengthArrayString();
					t.token = (byte) b;
					byte int1 = bb.get();
					t.length = (int1 << 24) | (int1 << 16) | bb.get() << 8 | bb.get();
					byte[] buf = new byte[t.length];
					bb.get(buf);
					t.data = new String(buf);
					return t;
				}
				case 0xFF:{
					PackedNibble t = new PackedNibble();
					t.token = (byte) b;
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

		protected List<Token> items = new ArrayList<>();

		public String getString(){
			return null;
		}

	}

	private static class ShortList extends AbstractList{

		protected byte length;

		@Override
		public String toString() {
			return "ShortList{" +
					"length=" + length +
					", items=" + items +
					'}';
		}

		public String getString(){
			return null;
		}

	}

	private static class LongList extends AbstractList{

		protected short length;

		@Override
		public String toString() {
			return "LongList{" +
					"length=" + length +
					", items=" + items +
					'}';
		}

		public String getString(){
			return null;
		}

	}

	private static class JabberId extends Token{

		protected Token user;
		protected Token server;

		@Override
		public String toString() {
			return "JabberId{" +
					"user=" + user +
					", server=" + server +
					'}';
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

		@Override
		public String toString() {
			return "Int8LengthArrayString{" +
					"length=" + length +
					", data='" + StringEscapeUtils.escapeXml11(data) + '\'' +
					'}';
		}

		public String getString(){
			return this.data;
		}

	}

	private static class Int20LengthArrayString extends Token{

		protected int length;
		protected String data;

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

		public static String unpack(byte startByte,byte[] packed){
			StringBuilder ret = new StringBuilder();
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

		public static String unpack(byte startByte,byte[] packed){
			StringBuilder ret = new StringBuilder();
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