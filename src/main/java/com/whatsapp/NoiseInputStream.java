package com.whatsapp;

import com.southernstorm.noise.protocol.CipherState;

import javax.crypto.BadPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class NoiseInputStream extends SegmentInputStream{

	private CipherState cipherState;

	public NoiseInputStream(InputStream in){
		super(in);
	}

	public void setCipherState(CipherState cipherState){
		this.cipherState = cipherState;
	}

	public byte[] readDecryptedSegment() throws IOException{
		byte[] plaintext = new byte[8096];

		byte[] segment = this.readSegment();
		if(segment==null){
			return null;
		}
		int length = 0;
		try{
			length = this.cipherState.decryptWithAd(new byte[0],segment,0,plaintext,0,segment.length);
		}catch(BadPaddingException|ShortBufferException e){
			e.printStackTrace();
		}
		return Arrays.copyOfRange(plaintext,0, length);
	}

}