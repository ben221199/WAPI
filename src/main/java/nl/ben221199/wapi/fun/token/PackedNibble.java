package nl.ben221199.wapi.fun.token;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

import nl.ben221199.wapi.Base64;
import nl.ben221199.wapi.Hex;

public class PackedNibble extends AbstractDataHolder{

	public PackedNibble(){
		super((byte) 0xFF);
	}

	public PackedNibble(byte[] data){
		this();
		this.length = data.length;
		this.data = data;
	}

	public byte[] getBytes(){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			baos.write(new byte[]{this.token});
			baos.write(PackedNibble.pack(this.data));
			baos.flush();
		}
		catch(IOException ignored){}
		return baos.toByteArray();
	}

	public static byte[] pack(byte[] unpacked){
		boolean ignoreLast = unpacked.length%2==1;
		String hex = new String(unpacked);
		if(ignoreLast){
			hex += "F";
		}
		byte[] data = Hex.toBytes(hex);
		byte startByte = (byte) (data.length & 0x7F);
		return ByteBuffer.allocate(1+data.length).put(startByte).put(data).array();
	}

	public static byte[] unpack(byte[] packed){
		if(packed==null || packed.length==0){
			return new byte[0];
		}
		byte[] ret = new byte[packed.length*2];
		int digits = 0;
		for(int i=0;i<packed.length;i++){
			byte currByte = packed[i];
			byte firstNibble = (byte) ((currByte & 0xF0) >> 4);
			byte secondNibble = (byte) (currByte & 0x0F);
			if(firstNibble>11){
				continue;
			}
			ret[i*2] = PackedNibble.unpackByte(firstNibble);
			digits++;
			if(secondNibble>11){
				continue;
			}
			ret[i*2+1] = PackedNibble.unpackByte(secondNibble);
			digits++;
		}
		return Arrays.copyOfRange(ret,0,digits);
	}

	private static byte unpackByte(int value){
		if(value < 0 || value > 11){
			throw new RuntimeException("invalid nibble to unpack: "+value);
		}
		if(value < 10){
			return (byte) ('0'+value);
		}else{
			return (byte) ('-'+value-10);
		}
	}

	@Override
	public String toString() {
		return "PackedNibble{" +
				"data='" + Base64.encode(data) + '\'' +
				'}';
	}

	public String getString(){
		return new String(this.data);
	}

}