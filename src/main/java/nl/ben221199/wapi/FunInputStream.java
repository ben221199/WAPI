package nl.ben221199.wapi;

import nl.ben221199.wapi.fun.FunNode;
import nl.ben221199.wapi.fun.FunXMPP;
import org.w3c.dom.Element;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class FunInputStream extends NoiseInputStream{

	public FunInputStream(InputStream in){
		super(in);
	}

	public Element readElement() throws IOException{
		byte[] tokens = this.readDecryptedSegment();
		if(tokens==null){
			return null;
		}
		//TODO Fix flags
		return FunXMPP.decodeElement(Arrays.copyOfRange(tokens,1,tokens.length));
	}

	public FunNode readNode() throws IOException{
		byte[] tokens = this.readDecryptedSegment();
		if(tokens==null){
			return null;
		}
		//TODO Fix flags
		return FunXMPP.decodeNode(Arrays.copyOfRange(tokens,1,tokens.length));
	}

	public String readXML() throws IOException{
		byte[] tokens = this.readDecryptedSegment();
		if(tokens==null){
			return null;
		}
		//TODO Fix flags
		return FunXMPP.decodeXML(Arrays.copyOfRange(tokens,1,tokens.length));
	}

}