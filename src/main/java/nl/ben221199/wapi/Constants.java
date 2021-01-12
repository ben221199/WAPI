package nl.ben221199.wapi;

public class Constants{

	public static class Protocol{

		public static final int EDGE_MAJOR = 0x00;

		public static final int EDGE_MINOR = 0x01;

		public static final int MAJOR = 0x04;

		public static final int MINOR = 0x00;

	}

	public static class Verification{

		public static final String BASE_URL = "https://v.whatsapp.net/v2/";

		public static final byte[] CERTIFICATE_APK = ("MIIDMjCCAvCgAwIBAgIETCU2pDALBgcqhkjOOAQDBQAwfDELMAkGA1UEBhMCVVMxEzARBgNVBAgTCkNhbGlmb3JuaWExFDASBgNV" +
				"BAcTC1NhbnRhIENsYXJhMRYwFAYDVQQKEw1XaGF0c0FwcCBJbmMuMRQwEgYDVQQLEwtFbmdpbmVlcmluZzEUMBIGA1UEAxMLQnJ" +
				"pYW4gQWN0b24wHhcNMTAwNjI1MjMwNzE2WhcNNDQwMjE1MjMwNzE2WjB8MQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5" +
				"pYTEUMBIGA1UEBxMLU2FudGEgQ2xhcmExFjAUBgNVBAoTDVdoYXRzQXBwIEluYy4xFDASBgNVBAsTC0VuZ2luZWVyaW5nMRQwEg" +
				"YDVQQDEwtCcmlhbiBBY3RvbjCCAbgwggEsBgcqhkjOOAQBMIIBHwKBgQD9f1OBHXUSKVLfSpwu7OTn9hG3UjzvRADDHj+AtlEm" +
				"aUVdQCJR+1k9jVj6v8X1ujD2y5tVbNeBO4AdNG/yZmC3a5lQpaSfn+gEexAiwk+7qdf+t8Yb+DtX58aophUPBPuD9tPFHsMCN" +
				"VQTWhaRMvZ1864rYdcq7/IiAxmd0UgBxwIVAJdgUI8VIwvMspK5gqLrhAvwWBz1AoGBAPfhoIXWmz3ey7yrXDa4V7l5lK+7+jr" +
				"qgvlXTAs9B4JnUVlXjrrUWU/mcQcQgYC0SRZxI+hMKBYTt88JMozIpuE8FnqLVHyNKOCjrh4rs6Z1kW6jfwv6ITVi8ftiegEkO" +
				"8yk8b6oUZCJqIPf4VrlnwaSi2ZegHtVJWQBTDv+z0kqA4GFAAKBgQDRGYtLgWh7zyRtQainJfCpiaUbzjJuhMgo4fVWZIvXHaS" +
				"HBU1t5w//S0lDK2hiqkj8KpMWGywVov9eZxZy37V26dEqr/c2m5qZ0E+ynSu7sqUD7kGx/zeIcGT0H+KAVgkGNQCo5Uc0koLRW" +
				"YHNtYoIvt5R3X6YZylbPftF/8ayWTALBgcqhkjOOAQDBQADLwAwLAIUAKYCp0d6z4QQdyN74JDfQ2WCyi8CFDUM4CaNB+ceVXd" +
				"KtOrNTQcc0e+t").getBytes();

		public static final byte[] HASH_CLASSES = ("oEYGYTr+K6IN0mDOrAZpsg==").getBytes();

		public static final byte[] PRIVATE_KEY = ("eQV5aq/Cg63Gsq1sshN9T3gh+UUp0wIw0xgHYT1bnCjEqOJQKCRrWxdAe2yvsDeCJL+Y4G3PRD2HUF7oUgiGo8vGlNJOaux26k+A2F3hj8A=").getBytes();

		public static final byte[] PUBLIC_KEY_ENCRYPTED_PARAMETERS = {5, (byte) 142, (byte) 140, 15, 116, (byte) 195, (byte) 235, (byte) 197, (byte) 215, (byte) 166, (byte) 134, 92, 108,60, (byte) 132, 56, 86, (byte) 176, 97, 33, (byte) 204, (byte) 232, (byte) 234, 119, 77, 34, (byte) 251,111, 18, 37, 18, 48, 45};

		public static final String USER_AGENT = "WhatsApp/2.20.206.22 Android/8.0.0 Device/samsung-star2lte";

	}

}