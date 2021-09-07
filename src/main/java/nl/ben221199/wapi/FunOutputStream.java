package nl.ben221199.wapi;

import nl.ben221199.wapi.fun.FunXMPP;
import org.w3c.dom.Element;

import java.io.IOException;
import java.io.OutputStream;

public class FunOutputStream extends NoiseOutputStream{

	public FunOutputStream(OutputStream out){
		super(out);
	}

	public void writeElement(Element element) throws IOException{
		byte[] tokenBytes = FunXMPP.encodeElement(element);
		byte[] funBytes = new byte[tokenBytes.length+1];
		//TODO Fix flags
		funBytes[0] = 0x00;//Flags
		System.arraycopy(tokenBytes,0,funBytes,1,tokenBytes.length);

		this.writeEncryptedSegment(funBytes);
	}

	public void writeNode(Element element) throws IOException{
		byte[] tokenBytes = FunXMPP.encodeElement(element);
		byte[] funBytes = new byte[tokenBytes.length+1];
		//TODO Fix flags
		funBytes[0] = 0x00;//Flags
		System.arraycopy(tokenBytes,0,funBytes,1,tokenBytes.length);

		this.writeEncryptedSegment(funBytes);
	}

	public void writeXML(String xml) throws IOException{
		byte[] tokenBytes = FunXMPP.encodeXML(xml);
		byte[] funBytes = new byte[tokenBytes.length+1];
		//TODO Fix flags
		funBytes[0] = 0x00;//Flags
		System.arraycopy(tokenBytes,0,funBytes,1,tokenBytes.length);

		this.writeEncryptedSegment(funBytes);
	}

}