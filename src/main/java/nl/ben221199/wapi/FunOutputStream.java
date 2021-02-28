package nl.ben221199.wapi;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class FunOutputStream extends NoiseOutputStream{

	public FunOutputStream(OutputStream out){
		super(out);
	}

	public void writeXML(String xml) throws IOException{
		byte[] tokenBytes = FunXMPP.encode(xml);
		byte[] funBytes = new byte[tokenBytes.length+1];
		//TODO Fix flags
		funBytes[0] = 0x00;//Flags
		System.arraycopy(tokenBytes,0,funBytes,1,tokenBytes.length);

		this.writeEncryptedSegment(funBytes);
	}

}