# WAPI - The WhatsApp API

Connect your project to WhatsApp!

## Installation

First, add the JitPack repository to your POM:
```xml
<repository>
	<id>jitpack.io</id>
	<url>https://jitpack.io</url>
</repository>
```

Then, add the following dependency to your POM:
```xml
<dependency>
	<groupId>com.github.ben221199</groupId>
	<artifactId>WAPI</artifactId>
	<version>master</version>
</dependency>
```

## Usage

### Verification

```java
import nl.ben221199.wapi.Verification;

public class VerificationExample{

	public static void main(String... args){
		String userAgent = "";
		boolean encrypted = true;

		//Check if account already exists
		String[] existParams = {};
		Verification.exist(userAgent,encrypted,existParams);

		//Request code
		String[] codeParams = {};
		Verification.code(userAgent,encrypted,codeParams);

		//Register account using code
		String[] registerParams = {};
		Verification.register(userAgent,encrypted,registerParams);
	}

}
```

### Connection
```java
import com.whatsapp.proto.WA4Protos;
import java.security.KeyPair;
import java.security.PublicKey;
import nl.ben221199.wapi.Connection;

public class ConnectionExample{

	public static void main(String... args){
		//Connection arguments
		byte[] edge_routing_info = null;
		KeyPair client_static_keypair = null;
		PublicKey server_static_key = null;
		WA4Protos.ClientPayload payload = null;

		//Create connection
		Connection conn = new Connection("g.whatsapp.net",443)
			.setEdgeRoutingInfo(edge_routing_info)
			.setS(client_static_keypair)
			.setRS(server_static_key)
			.setPayload(payload);

		//Start connection
		conn.start();

		//Get IO
		FunInputStream in = conn.getInputStream();
		FunOutputStream out = conn.getOutputStream();
	}

}
```