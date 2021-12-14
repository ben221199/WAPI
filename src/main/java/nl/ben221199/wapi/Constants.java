package nl.ben221199.wapi;

import nl.ben221199.wapi.fun.FunVersion;

public class Constants{

	public static class Device{

		public static class Android{

			public static final String RO_BUILD_FLAVOR = "grandprimeve3gub-user";
			public static final String RO_BUILD_ID = "R16NW";
			public static final String RO_BUILD_TAGS = "release-keys";
			public static final String RO_BUILD_VERSION_INCREMENTAL = "G531HUBU0APE2";
			public static final String RO_BUILD_VERSION_RELEASE = "5.0.2";//8.0.0

			public static final String RO_BUILD_DESCRIPTION = RO_BUILD_FLAVOR+" "+RO_BUILD_VERSION_RELEASE+" "+RO_BUILD_ID+" "+RO_BUILD_VERSION_INCREMENTAL+" "+RO_BUILD_TAGS;

			public static final String RO_PRODUCT_DEVICE = "fortunave3g";//star2lte
			public static final String RO_PRODUCT_MANUFACTURER = "samsung";

		}

	}

	public static class Protocol{

		public static final int EDGE_MAJOR = 0x00;

		public static final int EDGE_MINOR = 0x01;

		public static final int MAJOR = 0x05;

		public static final int MINOR = 0x00;

		public static final FunVersion FUN_VERSION = FunVersion.VERSION_5_2;

	}

	public static class UserAgent{

		public static class Android{

			public static final String OS_NAME = "Android";

			public static final String OS_VERSION = Constants.Device.Android.RO_BUILD_VERSION_RELEASE;
			public static final String MANUFACTURER = Constants.Device.Android.RO_PRODUCT_MANUFACTURER;
			public static final String DEVICE_NAME = Constants.Device.Android.RO_PRODUCT_DEVICE;
			public static final String OS_BUILD_NUMBER = Constants.Device.Android.RO_BUILD_DESCRIPTION;

			public static final String USER_AGENT = "WhatsApp/"+Version.WHATSAPP_VERSION+" "+OS_NAME+"/"+OS_VERSION+" Device/"+MANUFACTURER+"-"+DEVICE_NAME;

		}

	}

	public static class Verification{

		public static class Android{

			public static final byte[] CERTIFICATE = Base64.decode("MIIDMjCCAvCgAwIBAgIETCU2pDALBgcqhkjOOAQDBQAwfDELMAkGA1UEBhMCVVMxEzARBgNVBAgTCkNhbGlmb3JuaWExFDASBgNV" +
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
					"KtOrNTQcc0e+t");

			public static final byte[] CLASSES_HASH = Base64.decode("oEYGYTr+K6IN0mDOrAZpsg==");

			public static final byte[] SECRET_KEY = Base64.decode("eQV5aq/Cg63Gsq1sshN9T3gh+UUp0wIw0xgHYT1bnCjEqOJQKCRrWxdAe2yvsDeCJL+Y4G3PRD2HUF7oUgiGo8vGlNJOaux26k+A2F3hj8A=");

			//		public static byte[] getSecretKey(){
//			return PRIVATE_KEY;
//		}

		}

		public static class Nokia{

			public static final String TOKEN_SALT = "PdA2DJyKoUrwLw1Bg6EIhzh502dF9noR9uFCllGk";

			//2.13.30
			public static final long RELEASE_TIME = 1452554789539L;

		}

		public static final String BASE_URL = "https://v.whatsapp.net/v2/";

		public static final byte[] PUBLIC_KEY_ENCRYPTED_PARAMETERS = {5, (byte) 142, (byte) 140, 15, 116, (byte) 195, (byte) 235, (byte) 197, (byte) 215, (byte) 166, (byte) 134, 92, 108,60, (byte) 132, 56, 86, (byte) 176, 97, 33, (byte) 204, (byte) 232, (byte) 234, 119, 77, 34, (byte) 251,111, 18, 37, 18, 48, 45};

	}

	public static class Version{
//2.21.5.18
//		public static final int WHATSAPP_VERSION_PRIMARY = 2;
//		public static final int WHATSAPP_VERSION_SECONDARY = 20;
//		public static final int WHATSAPP_VERSION_TERTIARY = 206;
//		public static final int WHATSAPP_VERSION_QUATERNARY = 22;

		public static final int WHATSAPP_VERSION_PRIMARY = 2;
		public static final int WHATSAPP_VERSION_SECONDARY = 21;
		public static final int WHATSAPP_VERSION_TERTIARY = 5;
		public static final int WHATSAPP_VERSION_QUATERNARY = 18;

		public static final String WHATSAPP_VERSION = String.format("%d.%d.%d.%d",WHATSAPP_VERSION_PRIMARY,WHATSAPP_VERSION_SECONDARY,WHATSAPP_VERSION_TERTIARY,WHATSAPP_VERSION_QUATERNARY);//"2.20.206.22"

	}

}