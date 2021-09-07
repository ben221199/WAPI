package nl.ben221199.wapi.fun.token;

import nl.ben221199.wapi.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Int31LengthArrayString extends AbstractDataHolder{

	public Int31LengthArrayString(){
		super((byte) 0xFE);
	}

	public Int31LengthArrayString(byte[] data){
		this();
		if(data.length>=2147483647L){
			throw new RuntimeException("Data is too long for a int31 data array.");
		}
		this.length = data.length;
		this.data = data;
	}

	public byte[] getBytes(){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			baos.write(new byte[]{this.token,(byte) ((byte) this.data.length >> 24 & 0x7F), (byte) ((byte) this.data.length >> 16 & 0xFF), (byte) (this.data.length >> 8 & 0xFF), (byte) (this.data.length & 0xFF)});
			baos.write(this.data);
			baos.flush();
		}
		catch(IOException ignored){}
		return baos.toByteArray();
	}

	@Override
	public String toString() {
		return "Int31LengthArrayString{" +
				"length=" + length +
				", data='" + Base64.encode(data) + '\'' +
				'}';
	}

	public String getString(){
		return new String(this.data);
	}

}