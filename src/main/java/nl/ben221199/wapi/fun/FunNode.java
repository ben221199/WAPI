package nl.ben221199.wapi.fun;

import nl.ben221199.wapi.Base64;
import nl.ben221199.wapi.fun.token.AbstractDataHolder;
import nl.ben221199.wapi.fun.token.AbstractList;
import nl.ben221199.wapi.fun.token.Int20LengthArrayString;
import nl.ben221199.wapi.fun.token.Int31LengthArrayString;
import nl.ben221199.wapi.fun.token.Int8LengthArrayString;
import nl.ben221199.wapi.fun.token.JabberId;
import nl.ben221199.wapi.fun.token.LongList;
import nl.ben221199.wapi.fun.token.SecondaryToken;
import nl.ben221199.wapi.fun.token.ShortList;
import nl.ben221199.wapi.fun.token.Token;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class FunNode{

	private static final byte STREAMSTART = 1;
	private static final byte STREAMEND = 2;

	public static final String XMLSTREAMSTART = "<stream:stream>";
	public static final String XMLSTREAMEND = "</stream:stream>";

	private static final Token TOKEN_START = new Token(FunNode.STREAMSTART);
	private static final Token TOKEN_END = new Token(FunNode.STREAMEND);

	public static final FunNode START = new FunNode(FunNode.TOKEN_START);
	public static final FunNode END = new FunNode(FunNode.TOKEN_END);

	private Token tag;
	private List<FunAttribute> attributes = new ArrayList<>();
	private List<FunNode> children = new ArrayList<>();
	private byte[] data;

	private FunNode(){}

	private FunNode(Token tag){
		this.tag = tag;
	}

	public boolean isStart(){
		return Arrays.equals(FunNode.TOKEN_START.getBytes(),this.tag.getBytes());
	}

	public boolean isEnd(){
		return Arrays.equals(FunNode.TOKEN_END.getBytes(),this.tag.getBytes());
	}

	public static FunNode fromElement(Element element){
		FunNode node = new FunNode();
		node.tag = FunNode.writeStringHelper(element.getTagName());
		if(element.hasAttributes()){
			for(int i=0;i<element.getAttributes().getLength();i++){
				Node n = element.getAttributes().item(i);
				if(n instanceof Attr){
					FunAttribute attr = new FunAttribute();
					attr.setKey(FunNode.writeStringHelper(((Attr) n).getName()));
					attr.setValue(FunNode.writeStringHelper(((Attr) n).getValue()));
					node.attributes.add(attr);
				}
			}
		}
		if(element.hasChildNodes()){
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<element.getChildNodes().getLength();i++){
				Node n = element.getChildNodes().item(i);
				if(n instanceof Element){
					node.children.add(FunNode.fromElement((Element) n));
				}
				if(n.getNodeType()==Node.TEXT_NODE){
					sb.append(n.getTextContent());
				}
			}
			if(!sb.toString().isEmpty()){
				node.data = Base64.decode(sb.toString());
			}
		}
		return node;
	}

	private static FunNode fromList(AbstractList list){
		int offset = 0;
		FunNode node = new FunNode();

		int size = list.getItems().size();

		node.tag = list.getItems().get(offset++);

		int attribCount = (size - 2 + size % 2) / 2;
		for(int i=0;i<attribCount;i++){
			FunAttribute attr = new FunAttribute();
			attr.setKey(list.getItems().get(offset++));
			attr.setValue(list.getItems().get(offset++));
			node.attributes.add(attr);
		}

		if(size % 2 ==1){
			return node;
		}

		Token child = list.getItems().get(offset);
		if(child instanceof AbstractList){
			for(Token t : ((AbstractList) child).getItems()){
				node.children.add(FunNode.fromList((AbstractList) t));
			}
		}else{
			if(child instanceof AbstractDataHolder){
				node.data = ((AbstractDataHolder) child).getData();
			}
		}

		return node;
	}

	public static FunNode fromTokens(byte[] tokens){
		Token token = Token.from(ByteBuffer.wrap(tokens));
		if(token instanceof AbstractList){
			AbstractList list = (AbstractList) token;
			return FunNode.fromList(list);
		}
		return null;
	}

	public static FunNode fromXML(String xml){
		if(xml.equals(FunNode.XMLSTREAMSTART)){
			return FunNode.START;
		}
		if(xml.equals(FunNode.XMLSTREAMEND)){
			return FunNode.END;
		}
		try{
			Element element = FunXMPP.getBuilder().parse(new ByteArrayInputStream(xml.getBytes())).getDocumentElement();
			return FunNode.fromElement(element);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public Element toElement(){
		Element element = FunXMPP.getBuilder().newDocument().createElement(this.tag.getString());
		for(FunAttribute attr : this.attributes){
			element.setAttribute(attr.getKey().getString(),attr.getValue().getString());
		}
		for(FunNode child : this.children){
			element.appendChild(child.toElement());
		}
		if(this.data!=null){
			element.setTextContent(Base64.encode(this.data));
		}
		return element;
	}

	private AbstractList toList(){
		int size = 1;
		size += this.attributes.size()*2;
		if(this.data!=null || this.children.size()>0){
			size++;
		}
		AbstractList list;
		if(size>=256){
			list = new LongList();
		}else{
			list = new ShortList();
		}
		list.getItems().add(this.tag);
		for(FunAttribute a : this.attributes){
			list.getItems().add(a.getKey());
			list.getItems().add(a.getValue());
		}
		if(this.children.size()>0){
			AbstractList childList;
			if(this.children.size()>=256){
				childList = new LongList();
			}else{
				childList = new ShortList();
			}
			for(FunNode childFunNode : this.children){
				childList.getItems().add(childFunNode.toList());
			}
			list.getItems().add(childList);
		}else if(this.data!=null){
			list.getItems().add(FunNode.writeBytesHelper(this.data));
		}
		return list;
	}

	public byte[] toTokens(){
		return this.toList().getBytes();
	}

	public String toXML(){
		if(this.isStart()){
			return FunNode.XMLSTREAMSTART;
		}
		if(this.isEnd()){
			return FunNode.XMLSTREAMEND;
		}
		Element element = this.toElement();
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		try{
			FunXMPP.getTransformer().transform(new DOMSource(element),result);
			return writer.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	private static Token writeBytesHelper(byte[] bytes){
		if(bytes.length<=255L){
			return new Int8LengthArrayString(bytes);
		}
		if(bytes.length<=1048575L){
			return new Int20LengthArrayString(bytes);
		}
		//2147483647L
		return new Int31LengthArrayString(bytes);
	}

	private static Token writeStringHelper(String str){
		if(str==null){
			return new Token((byte) 0);
		}
		for(int i=1;i<FunXMPP.getDictionary().length;i++){
			if(FunXMPP.getDictionary()[i].equals(str)){
				return new Token((byte) i);
			}
		}
		for(int i=0;i<FunXMPP.getSecondaryDictionary().length;i++){
			for(int j=0;j<FunXMPP.getSecondaryDictionary()[i].length;j++){
				if(FunXMPP.getSecondaryDictionary()[i][j].equals(str)){
					return new SecondaryToken((byte) (0xEC+i),(byte) (j));
				}
			}
		}
		if(str.endsWith("s.whatsapp.net") || str.endsWith("g.us")){
			if(!str.contains("@")){
				str += "@";
			}
			String[] jid = str.split("@");
			Token user = FunNode.writeStringHelper(jid[0]);
			Token server = FunNode.writeStringHelper(jid[1]);
			JabberId t = new JabberId();
			t.setUser(user);
			t.setServer(server);
			return t;
		}
		return FunNode.writeBytesHelper(str.getBytes());
	}

	@Override
	public String toString() {
		return "FunNode{" +
				"tag=" + tag +
				", attributes=" + attributes +
				", children=" + children +
				", data=" + Arrays.toString(data) +
				'}';
	}

}