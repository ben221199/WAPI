package nl.ben221199.wapi.fun.token;

public abstract class AbstractDataHolder extends Token{

	protected int length;
	protected byte[] data;

	protected AbstractDataHolder(byte token){
		super(token);
	}

	public byte[] getData(){
		return this.data;
	}

}