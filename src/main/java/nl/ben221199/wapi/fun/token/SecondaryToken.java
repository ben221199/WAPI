package nl.ben221199.wapi.fun.token;

import nl.ben221199.wapi.fun.FunXMPP;

public class SecondaryToken extends Token{

	protected byte secondaryToken;

	public SecondaryToken(byte token,byte secondaryToken){
		super(token);
		this.secondaryToken = secondaryToken;
	}

	public byte[] getBytes(){
		return new byte[]{this.token,this.secondaryToken};
	}

	public String getString(){
		int n = this.token-0xEC & 0xFF;
		int n2 = this.secondaryToken & 0xFF;
		return FunXMPP.getSecondaryDictionary()[n][n2];
	}

	@Override
	public String toString() {
		return "SecondaryToken{" +
				"secondaryToken=" + secondaryToken +
				'}';
	}

}