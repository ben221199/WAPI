package nl.ben221199.wapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class FunInputStream extends NoiseInputStream{

	public FunInputStream(InputStream in){
		super(in);
	}

	public String readXML() throws IOException{
		byte[] tokens = this.readDecryptedSegment();
		if(tokens==null){
			return null;
		}
		//TODO Fix flags
		return FunXMPP.decode(Arrays.copyOfRange(tokens,1,tokens.length));
	}
}