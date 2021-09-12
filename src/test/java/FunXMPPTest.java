import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import nl.ben221199.wapi.fun.FunNode;
import nl.ben221199.wapi.fun.FunVersion;
import nl.ben221199.wapi.fun.FunXMPP;
import nl.ben221199.wapi.fun.token.Int20LengthArrayString;
import nl.ben221199.wapi.fun.token.Int31LengthArrayString;
import nl.ben221199.wapi.fun.token.Int8LengthArrayString;
import nl.ben221199.wapi.fun.token.JabberId;
import nl.ben221199.wapi.fun.token.LongList;
import nl.ben221199.wapi.fun.token.PackedHex;
import nl.ben221199.wapi.fun.token.PackedNibble;
import nl.ben221199.wapi.fun.token.ShortList;
import nl.ben221199.wapi.fun.token.Token;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FunXMPPTest{

	@BeforeAll
	public static void setVersion(){
		FunXMPP.setVersion(FunVersion.VERSION_4_1);
	}

	@Test
	public void testPackedHex(){
		byte[] str = PackedHex.unpack(new byte[]{(byte) 0xAA,(byte) 0xBB,(byte) 0xCC,(byte) 0xDD,(byte) 0xEE,(byte) 0xFF},false);
		Assertions.assertEquals("AABBCCDDEEFF",new String(str));

		byte[] str2 = PackedHex.unpack(new byte[]{(byte) 0xAA,(byte) 0xBB,(byte) 0xCC,(byte) 0xDD,(byte) 0xEE,(byte) 0xFF},true);
		Assertions.assertEquals("AABBCCDDEEF",new String(str2));

		byte[] ba = PackedHex.pack("AABBCCDDEEFF".getBytes());
		Assertions.assertArrayEquals(new byte[]{6,(byte) 0xAA,(byte) 0xBB,(byte) 0xCC,(byte) 0xDD,(byte) 0xEE,(byte) 0xFF},ba);

		byte[] ba2 = PackedHex.pack("AABBCCDDEEF".getBytes());
		Assertions.assertArrayEquals(new byte[]{(byte) (6 | 0x80),(byte) 0xAA,(byte) 0xBB,(byte) 0xCC,(byte) 0xDD,(byte) 0xEE,(byte) 0xFF},ba2);
	}

	@Test
	public void testPackedNibble(){
		byte[] str = PackedNibble.unpack(new byte[]{0x31,0x61,0x23,0x45,0x78,(byte) 0x90});
		Assertions.assertEquals("316123457890",new String(str));

		byte[] str2 = PackedNibble.unpack(new byte[]{0x31,0x61,0x23,0x45,0x78,(byte) 0x90,0x5D});
		Assertions.assertEquals("3161234578905",new String(str2));

		byte[] ba = PackedNibble.pack("316123457890".getBytes());
		Assertions.assertArrayEquals(new byte[]{6,0x31,0x61,0x23,0x45,0x78,(byte) 0x90},ba);

		byte[] ba2 = PackedNibble.pack("3161234578905".getBytes());
		Assertions.assertArrayEquals(new byte[]{7,0x31,0x61,0x23,0x45,0x78,(byte) 0x90,0x5F},ba2);
	}

	@Test
	public void testToken(){
		byte tokenByte = 4;
		byte[] bytes = new byte[]{4};

		Token token = new Token(tokenByte);
		Assertions.assertNotNull(token);

		byte[] tokenBytes = token.getBytes();
		Assertions.assertArrayEquals(bytes,tokenBytes);

		//WhatsApp 4.1 specific
		String tokenString = token.getString();
		Assertions.assertEquals("id",tokenString);

		Token token2 = Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(token2);

		byte[] tokenBytes2 = token2.getBytes();
		Assertions.assertArrayEquals(bytes,tokenBytes2);

		//WhatsApp 4.1 specific
		String tokenString2 = token2.getString();
		Assertions.assertEquals("id",tokenString2);
	}

//	@Test
//	public void testSecondaryTokenPage1(){
//		byte tokenByte = (byte) 0xEC;
//		byte secondaryTokenByte = 16;
//		byte[] bytes = new byte[]{(byte) 0xEC,16};
//
//		SecondaryToken secondaryToken = new SecondaryToken(tokenByte,secondaryTokenByte);
//		Assertions.assertNotNull(secondaryToken);
//
//		byte[] secondaryTokenBytes = secondaryToken.getBytes();
//		Assertions.assertArrayEquals(bytes,secondaryTokenBytes);
//
//		//WhatsApp 4.1 specific
//		String secondaryTokenString = secondaryToken.getString();
//		Assertions.assertEquals("screen_height",secondaryTokenString);
//
//		SecondaryToken secondaryToken2 = (SecondaryToken) Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
//		Assertions.assertNotNull(secondaryToken2);
//
//		byte[] secondaryTokenBytes2 = secondaryToken2.getBytes();
//		Assertions.assertArrayEquals(bytes,secondaryTokenBytes2);
//
//		//WhatsApp 4.1 specific
//		String secondaryTokenString2 = secondaryToken2.getString();
//		Assertions.assertEquals("invis",secondaryTokenString2);
//	}

//	@Test
//	public void testSecondaryTokenPage3(){
//		byte tokenByte = (byte) 0xEE;
//		byte secondaryTokenByte = 99;
//		byte[] bytes = new byte[]{(byte) 0xEE,99};
//
//		SecondaryToken secondaryToken = new SecondaryToken(tokenByte,secondaryTokenByte);
//		Assertions.assertNotNull(secondaryToken);
//
//		byte[] secondaryTokenBytes = secondaryToken.getBytes();
//		Assertions.assertArrayEquals(bytes,secondaryTokenBytes);
//
//		//WhatsApp 4.1 specific
//		String secondaryTokenString = secondaryToken.getString();
//		Assertions.assertEquals("fs_time_spent",secondaryTokenString);
//
//		SecondaryToken secondaryToken2 = (SecondaryToken) Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
//		Assertions.assertNotNull(secondaryToken2);
//
//		byte[] secondaryTokenBytes2 = secondaryToken2.getBytes();
//		Assertions.assertArrayEquals(bytes,secondaryTokenBytes2);
//
//		//WhatsApp 4.1 specific
//		String secondaryTokenString2 = secondaryToken2.getString();
//		Assertions.assertEquals("media.fsub1-1.fna.whatsapp.net",secondaryTokenString2);
//	}

	@Test
	public void testShortListEmpty(){
		byte[] bytes = new byte[]{(byte) 0xF8,0};

		ShortList shortList = new ShortList();
		Assertions.assertNotNull(shortList);

		byte[] shortListBytes = shortList.getBytes();
		Assertions.assertArrayEquals(bytes,shortListBytes);

		ShortList shortList2 = (ShortList) Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(shortList2);

		byte[] shortListBytes2 = shortList2.getBytes();
		Assertions.assertArrayEquals(bytes,shortListBytes2);
	}

	@Test
	public void testShortListNonEmpty(){
		List<Token> items = new ArrayList<>();
		items.add(new Token((byte) 1));
		items.add(new Token((byte) 3));
		items.add(new Token((byte) 5));
		items.add(new Token((byte) 7));
		byte[] bytes = new byte[]{(byte) 0xF8,4,1,3,5,7};

		ShortList shortList = new ShortList(items);
		Assertions.assertNotNull(shortList);

		byte[] shortListBytes = shortList.getBytes();
		Assertions.assertArrayEquals(bytes,shortListBytes);

		ShortList shortList2 = (ShortList) Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(shortList2);

		byte[] shortListBytes2 = shortList2.getBytes();
		Assertions.assertArrayEquals(bytes,shortListBytes2);
	}

	@Test
	public void testLongListEmpty(){
		byte[] bytes = new byte[]{(byte) 0xF9,0,0};

		LongList longList = new LongList();
		Assertions.assertNotNull(longList);

		byte[] longListBytes = longList.getBytes();
		Assertions.assertArrayEquals(bytes,longListBytes);

		LongList longList2 = (LongList) Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(longList2);

		byte[] longListBytes2 = longList2.getBytes();
		Assertions.assertArrayEquals(bytes,longListBytes2);
	}

	@Test
	public void testLongListNonEmpty(){
		List<Token> items = new ArrayList<>();
		items.add(new Token((byte) 7));
		items.add(new Token((byte) 5));
		items.add(new Token((byte) 3));
		items.add(new Token((byte) 1));
		byte[] bytes = new byte[]{(byte) 0xF9,0,4,7,5,3,1};

		LongList longList = new LongList(items);
		Assertions.assertNotNull(longList);

		byte[] longListBytes = longList.getBytes();
		Assertions.assertArrayEquals(bytes,longListBytes);

		LongList longList2 = (LongList) Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(longList2);

		byte[] longListBytes2 = longList2.getBytes();
		Assertions.assertArrayEquals(bytes,longListBytes2);
	}

	@Test
	public void testJabberIdServer(){
		Token server = new Token((byte) 5);
		byte[] bytes = new byte[]{(byte) 0xFA,0,5};

		JabberId jabberId = new JabberId(server);
		Assertions.assertNotNull(jabberId);

		byte[] jabberIdBytes = jabberId.getBytes();
		Assertions.assertArrayEquals(bytes,jabberIdBytes);

		JabberId jabberId2 = (JabberId) Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(jabberId2);

		byte[] jabberIdBytes2 = jabberId2.getBytes();
		Assertions.assertArrayEquals(bytes,jabberIdBytes2);
	}

	@Test
	public void testJabberIdUserAndServer(){
		Token user = new Token((byte) 7);
		Token server = new Token((byte) 3);
		byte[] bytes = new byte[]{(byte) 0xFA,7,3};

		JabberId jabberId = new JabberId(user,server);
		Assertions.assertNotNull(jabberId);

		byte[] jabberIdBytes = jabberId.getBytes();
		Assertions.assertArrayEquals(bytes,jabberIdBytes);

		JabberId jabberId2 = (JabberId) Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(jabberId2);

		byte[] jabberIdBytes2 = jabberId2.getBytes();
		Assertions.assertArrayEquals(bytes,jabberIdBytes2);

	}

	//TODO Packed Hex

	@Test
	public void testInt8LengthArrayString(){
		byte[] data = "Hello world 8".getBytes();
		byte[] bytes = new byte[]{(byte) 0xFC,13,'H','e','l','l','o',' ','w','o','r','l','d',' ','8'};

		Int8LengthArrayString int8LengthArrayString = new Int8LengthArrayString(data);
		Assertions.assertNotNull(int8LengthArrayString);

		byte[] int8LengthArrayStringBytes = int8LengthArrayString.getBytes();
		Assertions.assertArrayEquals(bytes,int8LengthArrayStringBytes);

		Int8LengthArrayString int8LengthArrayString2 = (Int8LengthArrayString) Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(int8LengthArrayString2);

		byte[] int8LengthArrayStringBytes2 = int8LengthArrayString2.getBytes();
		Assertions.assertArrayEquals(bytes,int8LengthArrayStringBytes2);
	}

	@Test
	public void testInt20LengthArrayString(){
		byte[] data = "Hello world 20".getBytes();
		byte[] bytes = new byte[]{(byte) 0xFD,0,0,14,'H','e','l','l','o',' ','w','o','r','l','d',' ','2','0'};

		Int20LengthArrayString int20LengthArrayString = new Int20LengthArrayString(data);
		Assertions.assertNotNull(int20LengthArrayString);

		byte[] int20LengthArrayStringBytes = int20LengthArrayString.getBytes();
		Assertions.assertArrayEquals(bytes,int20LengthArrayStringBytes);

		Int20LengthArrayString int20LengthArrayString2 = (Int20LengthArrayString) Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(int20LengthArrayString2);

		byte[] int20LengthArrayStringBytes2 = int20LengthArrayString2.getBytes();
		Assertions.assertArrayEquals(bytes,int20LengthArrayStringBytes2);
	}

	@Test
	public void testInt31LengthArrayString(){
		byte[] data = "Hello world 31".getBytes();
		byte[] bytes = new byte[]{(byte) 0xFE,0,0,0,14,'H','e','l','l','o',' ','w','o','r','l','d',' ','3','1'};

		Int31LengthArrayString int31LengthArrayString = new Int31LengthArrayString(data);
		Assertions.assertNotNull(int31LengthArrayString);

		byte[] int31LengthArrayStringBytes = int31LengthArrayString.getBytes();
		Assertions.assertArrayEquals(bytes,int31LengthArrayStringBytes);

		Int31LengthArrayString int31LengthArrayString2 = (Int31LengthArrayString) Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(int31LengthArrayString2);

		byte[] int31LengthArrayStringBytes2 = int31LengthArrayString2.getBytes();
		Assertions.assertArrayEquals(bytes,int31LengthArrayStringBytes2);
	}

	//TODO Packed Nibble

	@Test
	public void testNodeStart(){
		Assertions.assertEquals(FunNode.XMLSTREAMSTART,FunNode.START.toXML());
		Assertions.assertEquals(FunNode.XMLSTREAMSTART,FunNode.fromXML(FunNode.XMLSTREAMSTART).toXML());
	}

	@Test
	public void testNodeEnd(){
		Assertions.assertEquals(FunNode.XMLSTREAMEND,FunNode.END.toXML());
		Assertions.assertEquals(FunNode.XMLSTREAMEND,FunNode.fromXML(FunNode.XMLSTREAMEND).toXML());
	}

//	@Test
//	public void testNode(){
//		FunNode.
//
//		byte[] data = "Hello world 31".getBytes();
//		byte[] bytes = new byte[]{(byte) 0xFE,0,0,0,14,'H','e','l','l','o',' ','w','o','r','l','d',' ','3','1'};
//
//		Int31LengthArrayString int31LengthArrayString = new Int31LengthArrayString(data);
//		Assertions.assertNotNull(int31LengthArrayString);
//
//		byte[] int31LengthArrayStringBytes = int31LengthArrayString.getBytes();
//		Assertions.assertArrayEquals(bytes,int31LengthArrayStringBytes);
//
//		Int31LengthArrayString int31LengthArrayString2 = (Int31LengthArrayString) Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
//		Assertions.assertNotNull(int31LengthArrayString2);
//
//		byte[] int31LengthArrayStringBytes2 = int31LengthArrayString2.getBytes();
//		Assertions.assertArrayEquals(bytes,int31LengthArrayStringBytes2);
//	}

}
