package nl.ben221199.wapi;

import com.southernstorm.noise.protocol.CipherState;

import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class NoiseOutputStream extends SegmentOutputStream{

	private CipherState cipherState;

	public NoiseOutputStream(OutputStream out){
		super(out);
	}

	public void setCipherState(CipherState cipherState){
		this.cipherState = cipherState;
	}

	public void writeEncryptedSegment(byte[] plaintext) throws IOException {
		byte[] cipherText = new byte[plaintext.length+8096];

		int length = 0;
		try{
			length = this.cipherState.encryptWithAd(new byte[0],plaintext,0,cipherText,0,plaintext.length);
		}catch(ShortBufferException e){
			e.printStackTrace();
		}
		this.writeSegment(Arrays.copyOfRange(cipherText,0,length));
	}

}
