package nl.ben221199.wapi.fun;

import nl.ben221199.wapi.fun.token.Token;

public class FunAttribute{

	private Token key;
	private Token value;

	public FunAttribute(){}

	public FunAttribute(Token key,Token value){
		this.key = key;
		this.value = value;
	}

	public Token getKey(){
		return this.key;
	}

	public void setKey(Token key){
		this.key = key;
	}

	public Token getValue(){
		return this.value;
	}

	public void setValue(Token value){
		this.value = value;
	}

	@Override
	public String toString() {
		return "Attribute{" +
				"key='" + key + '\'' +
				", value='" + value + '\'' +
				'}';
	}

}