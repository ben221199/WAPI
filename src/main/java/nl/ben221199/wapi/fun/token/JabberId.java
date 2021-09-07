package nl.ben221199.wapi.fun.token;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class JabberId extends Token{

	protected Token user;
	protected Token server;

	public JabberId(){
		super((byte) 0xFA);
	}

	public JabberId(Token server){
		this();
		this.server = server;
	}

	public JabberId(Token user,Token server){
		this(server);
		this.user = user;
	}

	public Token getUser(){
		return this.user;
	}

	public void setUser(Token user){
		this.user = user;
	}

	public Token getServer(){
		return this.server;
	}

	public void setServer(Token server){
		this.server = server;
	}

	@Override
	public String toString() {
		return "JabberId{" +
				"user=" + user +
				", server=" + server +
				'}';
	}

	public byte[] getBytes(){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			baos.write(new byte[]{this.token});
			baos.write(this.user==null?new byte[1]:this.user.getBytes());
			baos.write(this.server.getBytes());
			baos.flush();
		}
		catch(IOException ignored){}
		return baos.toByteArray();
	}

	public String getString(){
		if(this.user==null || this.server==null){
			return "";
		}
		String user = this.user.getString();
		String jid = "";
		if(user!=null){
			jid = user+"@";
		}
		jid += this.server.getString();
		return jid;
	}

}