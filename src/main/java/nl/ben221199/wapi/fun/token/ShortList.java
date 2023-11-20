package nl.ben221199.wapi.fun.token;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ShortList extends AbstractList{

	//protected byte length;

	public ShortList(){
		super((byte) 0xF8);
	}

	public ShortList(List<Token> items){
		this();
		this.items = items;
	}

	public byte[] getBytes(){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			baos.write(new byte[]{this.token, (byte) this.items.size()});
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
		return "ShortList{" +
				"length=" + length +
				", items=" + items +
				'}';
	}

}