package nl.ben221199.wapi.fun.token;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import nl.ben221199.wapi.Base64;

public class PackedHex extends AbstractDataHolder{

	public PackedHex(){
		super((byte) 0xFB);
	}

	public PackedHex(byte[] data){
		this();
		this.length = data.length;
		this.data = data;
	}

	public byte[] getBytes(){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			baos.write(new byte[]{this.token,(byte) 0x00});
			baos.flush();
		}
		catch(IOException ignored){}
		return baos.toByteArray();
	}

	public static byte[] unpack(byte[] packed,boolean ignoreLast){
		if(packed==null || packed.length==0){
			return new byte[0];
		}
		byte[] ret = new byte[packed.length*2];
		for(int i=0;i<packed.length;i++){
			byte currByte = packed[i];
			byte firstNibble = (byte) ((currByte & 0xF0) >> 4);
			byte secondNibble = (byte) (currByte & 0x0F);
			ret[i*2] = PackedHex.unpackByte(firstNibble);
			ret[i*2+1] = PackedHex.unpackByte(secondNibble);
		}
		if(ignoreLast){
			ret = Arrays.copyOfRange(ret,0,ret.length-1);
		}
		return ret;
	}

	private static byte unpackByte(int value){
		if(value < 0 || value > 15){
			throw new RuntimeException("invalid hex to unpack: "+value);
		}
		if(value < 10){
			return (byte) ('0'+value);
		}else{
			return (byte) ('A'+value-10);
		}
	}

	@Override
	public String toString() {
		return "PackedHex{" +
				"data='" + Base64.encode(data) + '\'' +
				'}';
	}

	public String getString(){
		return new String(this.data);
	}

}