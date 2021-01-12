package nl.ben221199.wapi;

import java.io.IOException;

public class Main{

	public static void main(String... args) throws IOException{
				FunXMPP.setVersion(4,0);

		String xml1 = "<stream:stream>";
		System.err.println(xml1);
		byte[] fun = FunXMPP.encode(xml1);
		System.err.println(Hex.fromBytes(fun));
		String xml2 = FunXMPP.decode(fun);
		System.err.println(xml2);
		System.err.println("=======================================================");
		a();
		System.err.println("=======================================================");
		String _xml1 = "</stream:stream>";
		System.err.println(_xml1);
		byte[] _fun = FunXMPP.encode(_xml1);
		System.err.println(Hex.fromBytes(_fun));
		String _xml2 = FunXMPP.decode(_fun);
		System.err.println(_xml2);


		Connection conn = new Connection("e7.whatsapp.net",443)
				.setEdgeRoutingInfo(Config.edge_routing_info)
				.setS(Config.client_static_keypair)
				.setRS(Config.server_static_key)
				.setPayload(Config.PAYLOAD);
		conn.start();
		FunInputStream in = conn.getInputStream();
		FunOutputStream out = conn.getOutputStream();

		String xml;
		while((xml = in.readXML())!=null){
			System.out.println(xml);
		}
		System.err.println("EXIT");
	}

	private static void a(){
		FunXMPP.setVersion(4,0);

		String xml1 = "<a href=\"jan@s.whatsapp.net\">Hoi<b><c/>Asia/Kabul</b>A</a>";
		System.err.println(xml1);
		byte[] fun = FunXMPP.encode(xml1);
		System.err.println(Hex.fromBytes(fun));
		String xml2 = FunXMPP.decode(fun);
		System.err.println(xml2);
	}

}