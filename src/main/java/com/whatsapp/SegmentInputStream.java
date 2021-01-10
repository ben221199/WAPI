package com.whatsapp;

import java.io.IOException;
import java.io.InputStream;

public class SegmentInputStream extends InputStream{

	private InputStream in;

	public SegmentInputStream(InputStream in){
		this.in = in;
	}

	@Override
	public int read() throws IOException{
		return this.in.read();
	}

	public int readInt24BE() throws IOException{
		int a = this.read();
		int b = this.read();
		int c = this.read();

		return (a<< 16) | (b<<8) | (c<<0);
	}

	public byte[] readSegment() throws IOException{
		int length = this.readInt24BE();
		if(length==-1){
			return null;
		}
		byte[] buf = new byte[length];
		int rv = this.read(buf);
		if(rv==-1){
			return null;
		}
		return buf;
	}

	@Override
	public int available() throws IOException{
		return this.in.available();
	}

	@Override
	public void close() throws IOException{
		this.in.close();
	}

}
