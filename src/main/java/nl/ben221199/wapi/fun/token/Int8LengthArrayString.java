package nl.ben221199.wapi.fun.token;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import nl.ben221199.wapi.Base64;

public class Int8LengthArrayString extends AbstractDataHolder{

	public Int8LengthArrayString(){
		super((byte) 0xFC);
	}

	public Int8LengthArrayString(byte[] data){
		this();
		if(data.length>=256){
			throw new RuntimeException("Data is too long for a int8 data array.");
		}
		this.length = data.length;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Int8LengthArrayString{" +
				"length=" + length +
				", data='" + Base64.encode(data) + '\'' +
				'}';
	}

	public byte[] getBytes(){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			baos.write(new byte[]{this.token,(byte) this.data.length});
			baos.write(this.data);
			baos.flush();
		}
		catch(IOException ignored){}
		return baos.toByteArray();
	}

	public String getString(){
		return new String(this.data);
	}

}