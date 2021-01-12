package nl.ben221199.wapi;

import java.io.IOException;
import java.io.OutputStream;

public class SegmentOutputStream extends OutputStream{

	private OutputStream out;

	public SegmentOutputStream(OutputStream out){
		this.out = out;
	}

	@Override
	public void write(int b) throws IOException{
		this.out.write(b);
	}

	public void writeInt24BE(int integer) throws IOException{
		int a = integer >> 16 & 0xFF;
		int b = integer >> 8 & 0xFF;
		int c = integer >> 0 & 0xFF;
		this.write(a);
		this.write(b);
		this.write(c);
	}

	public void writeSegment(byte[] bytes) throws IOException{
		this.writeInt24BE(bytes.length);
		this.write(bytes);
	}

	@Override
	public void flush() throws IOException{
		this.out.flush();
	}

	@Override
	public void close() throws IOException{
		this.out.close();
	}

}
