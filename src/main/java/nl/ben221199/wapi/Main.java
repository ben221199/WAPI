package nl.ben221199.wapi;

import java.io.IOException;

public class Main{

	public static void main(String... args) throws IOException{
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

}