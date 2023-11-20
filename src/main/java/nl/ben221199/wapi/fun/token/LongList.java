package nl.ben221199.wapi.fun.token;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class LongList extends AbstractList{

//	protected short length;

	public LongList(){
		super((byte) 0xF9);
	}

	public LongList(List<Token> items){
		this();
		this.items = items;
	}

	public byte[] getBytes(){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			baos.write(new byte[]{this.token,(byte) ((this.items.size()>>8)&0xFF),(byte) (this.items.size() & 0xFF)});
			for(Token t : this.items){
				baos.write(t.getBytes());
			}
			baos.flush();
		}
		catch(IOException ignored){}
		return baos.toByteArray();
	}

	@Override
	public String toString() {
		return "LongList{" +
				"length=" + length +
				", items=" + items +
				'}';
	}

}