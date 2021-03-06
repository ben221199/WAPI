import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import nl.ben221199.wapi.FunXMPP;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FunXMPPTest{

	@BeforeAll
	public static void setVersion(){
		FunXMPP.setVersion(4,1);
	}

	@Test
	public void testToken(){
		byte tokenByte = 4;
		byte[] bytes = new byte[]{4};

		FunXMPP.Token token = new FunXMPP.Token(tokenByte);
		Assertions.assertNotNull(token);

		byte[] tokenBytes = token.getBytes();
		Assertions.assertArrayEquals(bytes,tokenBytes);

		//WhatsApp 4.1 specific
		String tokenString = token.getString();
		Assertions.assertEquals("id",tokenString);

		FunXMPP.Token token2 = FunXMPP.Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(token2);

		byte[] tokenBytes2 = token2.getBytes();
		Assertions.assertArrayEquals(bytes,tokenBytes2);

		//WhatsApp 4.1 specific
		String tokenString2 = token2.getString();
		Assertions.assertEquals("id",tokenString2);
	}

	@Test
	public void testSecondaryTokenPage1(){
		byte tokenByte = (byte) 0xEC;
		byte secondaryTokenByte = 16;
		byte[] bytes = new byte[]{(byte) 0xEC,16};

		FunXMPP.SecondaryToken secondaryToken = new FunXMPP.SecondaryToken(tokenByte,secondaryTokenByte);
		Assertions.assertNotNull(secondaryToken);

		byte[] secondaryTokenBytes = secondaryToken.getBytes();
		Assertions.assertArrayEquals(bytes,secondaryTokenBytes);

		//WhatsApp 4.1 specific
		String secondaryTokenString = secondaryToken.getString();
		Assertions.assertEquals("screen_height",secondaryTokenString);

		FunXMPP.SecondaryToken secondaryToken2 = (FunXMPP.SecondaryToken) FunXMPP.Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(secondaryToken2);

		byte[] secondaryTokenBytes2 = secondaryToken2.getBytes();
		Assertions.assertArrayEquals(bytes,secondaryTokenBytes2);

		//WhatsApp 4.1 specific
		String secondaryTokenString2 = secondaryToken2.getString();
		Assertions.assertEquals("screen_height",secondaryTokenString2);
	}

	@Test
	public void testSecondaryTokenPage3(){
		byte tokenByte = (byte) 0xEE;
		byte secondaryTokenByte = 99;
		byte[] bytes = new byte[]{(byte) 0xEE,99};

		FunXMPP.SecondaryToken secondaryToken = new FunXMPP.SecondaryToken(tokenByte,secondaryTokenByte);
		Assertions.assertNotNull(secondaryToken);

		byte[] secondaryTokenBytes = secondaryToken.getBytes();
		Assertions.assertArrayEquals(bytes,secondaryTokenBytes);

		//WhatsApp 4.1 specific
		String secondaryTokenString = secondaryToken.getString();
		Assertions.assertEquals("media.fsub1-1.fna.whatsapp.net",secondaryTokenString);

		FunXMPP.SecondaryToken secondaryToken2 = (FunXMPP.SecondaryToken) FunXMPP.Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(secondaryToken2);

		byte[] secondaryTokenBytes2 = secondaryToken2.getBytes();
		Assertions.assertArrayEquals(bytes,secondaryTokenBytes2);

		//WhatsApp 4.1 specific
		String secondaryTokenString2 = secondaryToken2.getString();
		Assertions.assertEquals("media.fsub1-1.fna.whatsapp.net",secondaryTokenString2);
	}

	@Test
	public void testShortListEmpty(){
		byte[] bytes = new byte[]{(byte) 0xF8,0};

		FunXMPP.ShortList shortList = new FunXMPP.ShortList();
		Assertions.assertNotNull(shortList);

		byte[] shortListBytes = shortList.getBytes();
		Assertions.assertArrayEquals(bytes,shortListBytes);

		FunXMPP.ShortList shortList2 = (FunXMPP.ShortList) FunXMPP.Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(shortList2);

		byte[] shortListBytes2 = shortList2.getBytes();
		Assertions.assertArrayEquals(bytes,shortListBytes2);
	}

	@Test
	public void testShortListNonEmpty(){
		List<FunXMPP.Token> items = new ArrayList<>();
		items.add(new FunXMPP.Token((byte) 1));
		items.add(new FunXMPP.Token((byte) 3));
		items.add(new FunXMPP.Token((byte) 5));
		items.add(new FunXMPP.Token((byte) 7));
		byte[] bytes = new byte[]{(byte) 0xF8,4,1,3,5,7};

		FunXMPP.ShortList shortList = new FunXMPP.ShortList(items);
		Assertions.assertNotNull(shortList);

		byte[] shortListBytes = shortList.getBytes();
		Assertions.assertArrayEquals(bytes,shortListBytes);

		FunXMPP.ShortList shortList2 = (FunXMPP.ShortList) FunXMPP.Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(shortList2);

		byte[] shortListBytes2 = shortList2.getBytes();
		Assertions.assertArrayEquals(bytes,shortListBytes2);
	}

	@Test
	public void testLongListEmpty(){
		byte[] bytes = new byte[]{(byte) 0xF9,0,0};

		FunXMPP.LongList longList = new FunXMPP.LongList();
		Assertions.assertNotNull(longList);

		byte[] longListBytes = longList.getBytes();
		Assertions.assertArrayEquals(bytes,longListBytes);

		FunXMPP.LongList longList2 = (FunXMPP.LongList) FunXMPP.Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(longList2);

		byte[] longListBytes2 = longList2.getBytes();
		Assertions.assertArrayEquals(bytes,longListBytes2);
	}

	@Test
	public void testLongListNonEmpty(){
		List<FunXMPP.Token> items = new ArrayList<>();
		items.add(new FunXMPP.Token((byte) 7));
		items.add(new FunXMPP.Token((byte) 5));
		items.add(new FunXMPP.Token((byte) 3));
		items.add(new FunXMPP.Token((byte) 1));
		byte[] bytes = new byte[]{(byte) 0xF9,0,4,7,5,3,1};

		FunXMPP.LongList longList = new FunXMPP.LongList(items);
		Assertions.assertNotNull(longList);

		byte[] longListBytes = longList.getBytes();
		Assertions.assertArrayEquals(bytes,longListBytes);

		FunXMPP.LongList longList2 = (FunXMPP.LongList) FunXMPP.Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(longList2);

		byte[] longListBytes2 = longList2.getBytes();
		Assertions.assertArrayEquals(bytes,longListBytes2);
	}

	@Test
	public void testJabberIdServer(){
		FunXMPP.Token server = new FunXMPP.Token((byte) 5);
		byte[] bytes = new byte[]{(byte) 0xFA,0,5};

		FunXMPP.JabberId jabberId = new FunXMPP.JabberId(server);
		Assertions.assertNotNull(jabberId);

		byte[] jabberIdBytes = jabberId.getBytes();
		Assertions.assertArrayEquals(bytes,jabberIdBytes);

		FunXMPP.JabberId jabberId2 = (FunXMPP.JabberId) FunXMPP.Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(jabberId2);

		byte[] jabberIdBytes2 = jabberId2.getBytes();
		Assertions.assertArrayEquals(bytes,jabberIdBytes2);
	}

	@Test
	public void testJabberIdUserAndServer(){
		FunXMPP.Token user = new FunXMPP.Token((byte) 7);
		FunXMPP.Token server = new FunXMPP.Token((byte) 3);
		byte[] bytes = new byte[]{(byte) 0xFA,7,3};

		FunXMPP.JabberId jabberId = new FunXMPP.JabberId(user,server);
		Assertions.assertNotNull(jabberId);

		byte[] jabberIdBytes = jabberId.getBytes();
		Assertions.assertArrayEquals(bytes,jabberIdBytes);

		FunXMPP.JabberId jabberId2 = (FunXMPP.JabberId) FunXMPP.Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(jabberId2);

		byte[] jabberIdBytes2 = jabberId2.getBytes();
		Assertions.assertArrayEquals(bytes,jabberIdBytes2);

	}

	//TODO Packed Hex

	@Test
	public void testInt8LengthArrayString(){
		byte[] data = "Hello world 8".getBytes();
		byte[] bytes = new byte[]{(byte) 0xFC,13,'H','e','l','l','o',' ','w','o','r','l','d',' ','8'};

		FunXMPP.Int8LengthArrayString int8LengthArrayString = new FunXMPP.Int8LengthArrayString(data);
		Assertions.assertNotNull(int8LengthArrayString);

		byte[] int8LengthArrayStringBytes = int8LengthArrayString.getBytes();
		Assertions.assertArrayEquals(bytes,int8LengthArrayStringBytes);

		FunXMPP.Int8LengthArrayString int8LengthArrayString2 = (FunXMPP.Int8LengthArrayString) FunXMPP.Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(int8LengthArrayString2);

		byte[] int8LengthArrayStringBytes2 = int8LengthArrayString2.getBytes();
		Assertions.assertArrayEquals(bytes,int8LengthArrayStringBytes2);
	}

	@Test
	public void testInt20LengthArrayString(){
		byte[] data = "Hello world 20".getBytes();
		byte[] bytes = new byte[]{(byte) 0xFD,0,0,14,'H','e','l','l','o',' ','w','o','r','l','d',' ','2','0'};

		FunXMPP.Int20LengthArrayString int20LengthArrayString = new FunXMPP.Int20LengthArrayString(data);
		Assertions.assertNotNull(int20LengthArrayString);

		byte[] int20LengthArrayStringBytes = int20LengthArrayString.getBytes();
		Assertions.assertArrayEquals(bytes,int20LengthArrayStringBytes);

		FunXMPP.Int20LengthArrayString int20LengthArrayString2 = (FunXMPP.Int20LengthArrayString) FunXMPP.Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(int20LengthArrayString2);

		byte[] int20LengthArrayStringBytes2 = int20LengthArrayString2.getBytes();
		Assertions.assertArrayEquals(bytes,int20LengthArrayStringBytes2);
	}

	@Test
	public void testInt31LengthArrayString(){
		byte[] data = "Hello world 31".getBytes();
		byte[] bytes = new byte[]{(byte) 0xFE,0,0,0,14,'H','e','l','l','o',' ','w','o','r','l','d',' ','3','1'};

		FunXMPP.Int31LengthArrayString int31LengthArrayString = new FunXMPP.Int31LengthArrayString(data);
		Assertions.assertNotNull(int31LengthArrayString);

		byte[] int31LengthArrayStringBytes = int31LengthArrayString.getBytes();
		Assertions.assertArrayEquals(bytes,int31LengthArrayStringBytes);

		FunXMPP.Int31LengthArrayString int31LengthArrayString2 = (FunXMPP.Int31LengthArrayString) FunXMPP.Token.from(ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN));
		Assertions.assertNotNull(int31LengthArrayString2);

		byte[] int31LengthArrayStringBytes2 = int31LengthArrayString2.getBytes();
		Assertions.assertArrayEquals(bytes,int31LengthArrayStringBytes2);
	}

	//TODO Packed Nibble

}
