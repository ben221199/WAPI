package nl.ben221199.wapi;

import java.io.IOException;
import java.io.OutputStream;

public class FunOutputStream extends NoiseOutputStream{

	public FunOutputStream(OutputStream out){
		super(out);
	}

	public void writeXML(String xml) throws IOException{
		this.writeEncryptedSegment(FunXMPP.encode(xml));
	}

}