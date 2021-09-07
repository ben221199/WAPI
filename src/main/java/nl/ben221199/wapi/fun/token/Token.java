package nl.ben221199.wapi.fun.token;

import nl.ben221199.wapi.fun.FunXMPP;

import java.nio.ByteBuffer;

public class Token{

	protected byte token;

	public Token(byte token){
		this.token = token;
	}

	public static Token from(ByteBuffer bb){
		int b = bb.get() & 0xFF;
		switch(b){
			case 0xEC:
			case 0xED:
			case 0xEE:
			case 0xEF:{
				return new SecondaryToken((byte) b,bb.get());
			}
			case 0xF8:{
				ShortList t = new ShortList();
				t.length = bb.get();
				for(int i=0;i<t.length;i++){
					t.items.add(Token.from(bb));
				}
				return t;
			}
			case 0xF9:{
				LongList t = new LongList();
				t.length = bb.getShort();
				for(int i=0;i<t.length;i++){
					t.items.add(Token.from(bb));
				}
				return t;
			}
			case 0xFA:{
				return new JabberId(Token.from(bb),Token.from(bb));
			}
			case 0xFB:{
				int startByte = bb.get() & 0xFF;

				boolean ignoreLast = startByte>=0x80;
				int size = startByte & 0x7F;

				byte[] buf = new byte[size];
				bb.get(buf);
				return new PackedHex(PackedHex.unpack(buf,ignoreLast));
			}
			case 0xFC:{
				byte[] buf = new byte[bb.get() & 0xFF];
				bb.get(buf);
				return new Int8LengthArrayString(buf);
			}
			case 0xFD:{
				byte[] buf = new byte[(((bb.get() & 0xF) << 16) | ((bb.get() & 0xFF) << 8) | (bb.get() & 0xFF)) & 0b11111111111111111111];
				bb.get(buf);
				return new Int20LengthArrayString(buf);
			}
			case 0xFE:{
				byte[] buf = new byte[((bb.get() & 0x7F << 24) | (bb.get() << 16) | bb.get() << 8 | bb.get()) & 0b1111111111111111111111111111111];
				bb.get(buf);
				return new Int31LengthArrayString(buf);
			}
			case 0xFF:{
				int startByte = bb.get() & 0xFF;

				int size = startByte & 0x7F;

				byte[] buf = new byte[size];
				bb.get(buf);
				return new PackedNibble(PackedNibble.unpack(buf));
			}
			default:{
				return new Token((byte) b);
			}
		}
	}

	public byte[] getBytes(){
		return new byte[]{this.token};
	}

	public String getString(){
		if(!this.getClass().equals(Token.class)){
			throw new RuntimeException("Cannot get string on this token");
		}
		return FunXMPP.getDictionary()[this.token & 0xFF];
	}

	@Override
	public String toString() {
		return "Token{" +
				"token=" + token +
				'}';
	}

}