package nl.ben221199.wapi.fun;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import nl.ben221199.wapi.protocol.WA02;
import nl.ben221199.wapi.protocol.WA41;

import org.w3c.dom.Element;

public class FunXMPP{

	private static DocumentBuilder BUILDER;
	private static Transformer TRANSFORMER;
	private static FunVersion VERSION;

	public static DocumentBuilder getBuilder(){
		if(FunXMPP.BUILDER==null){
			try{
				FunXMPP.BUILDER = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return FunXMPP.BUILDER;
	}

	public static Transformer getTransformer(){
		if(FunXMPP.TRANSFORMER==null){
			try{
				FunXMPP.TRANSFORMER = TransformerFactory.newInstance().newTransformer();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return FunXMPP.TRANSFORMER;
	}

	public static FunVersion getVersion(){
		return FunXMPP.VERSION;
	}

	public static void setVersion(FunVersion version){
		FunXMPP.VERSION = version;
	}

	public static String[] getDictionary(){
		switch(FunXMPP.VERSION){
			case VERSION_0_2:return WA02.getDictionary();
//			case VERSION_4_0:return WA40.getDictionary();
			case VERSION_4_1:return WA41.getDictionary();
		}
		return null;
	}

	public static String[][] getSecondaryDictionary(){
		switch(FunXMPP.VERSION){
			case VERSION_0_2:return WA02.getSecondaryDictionary();
//			case VERSION_4_0:return WA40.getSecondaryDictionary();
			case VERSION_4_1:return WA41.getSecondaryDictionary();
		}
		return null;
	}

	private static void ensureDictionaries(){
		if(FunXMPP.getDictionary()==null || FunXMPP.getSecondaryDictionary()==null){
			throw new RuntimeException("FunXMPP version is not set.");
		}
	}

	public static Element decodeElement(byte[] tokens){
		FunNode node = FunXMPP.decodeNode(tokens);
		return node.toElement();
	}

	public static FunNode decodeNode(byte[] tokens){
		FunXMPP.ensureDictionaries();
		if(tokens==null){
			throw new RuntimeException("Token array should not be null.");
		}
		return FunNode.fromTokens(tokens);
	}

	public static String decodeXML(byte[] tokens){
		FunNode node = FunXMPP.decodeNode(tokens);
		return node.toXML();
	}

	public static byte[] encodeElement(Element element){
		if(element==null){
			throw new RuntimeException("Element should not be null.");
		}
		FunNode node = FunNode.fromElement(element);
		return FunXMPP.encodeNode(node);
	}

	public static byte[] encodeNode(FunNode node){
		FunXMPP.ensureDictionaries();
		if(node==null){
			throw new RuntimeException("Node should not be null.");
		}
		return node.toTokens();
	}

	public static byte[] encodeXML(String xml){
		if(xml==null){
			throw new RuntimeException("XML should not be null.");
		}
		FunNode node = FunNode.fromXML(xml);
		return FunXMPP.encodeNode(node);
	}

}