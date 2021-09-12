package nl.ben221199.wapi.fun.token;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import nl.ben221199.wapi.Base64;

public class Int20LengthArrayString extends AbstractDataHolder{

	public Int20LengthArrayString(){
		super((byte) 0xFD);
	}

	public Int20LengthArrayString(byte[] data){
		this();
		if(data.length>=1048575L){
			throw new RuntimeException("Data is too long for a int20 data array.");
		}
		this.length = data.length;
		this.data = data;
	}

	public byte[] getBytes(){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			baos.write(new byte[]{this.token,(byte) ((this.data.length >> 16) & 0x0F), (byte) ((this.data.length >> 8) & 0xFF), (byte) (this.data.length & 0xFF)});
			baos.write(this.data);
			baos.flush();
		}
		catch(IOException ignored){}
		return baos.toByteArray();
	}

	@Override
	public String toString() {
		return "Int20LengthArrayString{" +
				"length=" + length +
				", data='" + Base64.encode(data) + '\'' +
				'}';
	}

	public String getString(){
		return new String(this.data);
	}

}