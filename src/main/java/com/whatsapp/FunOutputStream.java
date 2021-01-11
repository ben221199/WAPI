package com.whatsapp;

import java.io.IOException;
import java.io.OutputStream;

public class FunOutputStream extends NoiseOutputStream{

	public FunOutputStream(OutputStream out){
		super(out);
	}

	public void writeXML(FunXMPP.Node xml) throws IOException{
		this.writeEncryptedSegment(FunXMPP.encode(xml));
	}

}