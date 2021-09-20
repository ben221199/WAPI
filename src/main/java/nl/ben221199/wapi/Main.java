package nl.ben221199.wapi;

import com.whatsapp.proto.WA4Protos;

import java.util.Random;

public class Main {

	public static void main(String... args) throws Exception{
		String id = "ABCDFABCDFABCDFABCDF";

		Config config = Config.loadConfig(id);

		Connection connection = new Connection("e"+(1+new Random().nextInt(16))+".whatsapp.net",443)
				.setEdgeRoutingInfo(config.getEdgeRoutingInfo())
				.setS(config.getClientStaticKeypair())
//					.setRS(Config.server_static_key)
				.setPayload(Main.getClientPayload(config));

		connection.start();
	}

	public static WA4Protos.ClientPayload getClientPayload(Config config){
		WA4Protos.ClientPayload.UserAgent.AppVersion appVersion = WA4Protos.ClientPayload.UserAgent.AppVersion.newBuilder()
				.setPrimary(Constants.Version.WHATSAPP_VERSION_PRIMARY)
				.setSecondary(Constants.Version.WHATSAPP_VERSION_SECONDARY)
				.setTertiary(Constants.Version.WHATSAPP_VERSION_TERTIARY)
				.setQuaternary(Constants.Version.WHATSAPP_VERSION_QUATERNARY)
				.build();

		WA4Protos.ClientPayload.UserAgent userAgent = WA4Protos.ClientPayload.UserAgent.newBuilder()
				.setReleaseChannel(WA4Protos.ClientPayload.UserAgent.ReleaseChannel.forNumber(config.getReleaseChannel()))
				.setPlatform(WA4Protos.ClientPayload.UserAgent.Platform.ANDROID)
				.setMcc(config.getMCC())
				.setMnc(config.getMNC())
				.setOsVersion(Constants.UserAgent.Android.OS_VERSION)
				.setManufacturer(Constants.UserAgent.Android.MANUFACTURER)
				.setDevice(Constants.UserAgent.Android.DEVICE_NAME)
				.setOsBuildNumber(Constants.UserAgent.Android.OS_BUILD_NUMBER)
				.setPhoneId(config.getFDId())
				.setLocaleLanguageIso6391(config.getLanguage())
				.setLocalCountryIso31661Alpha2(config.getLanguageCountry())
				.setAppVersion(appVersion)
				.build();

		return WA4Protos.ClientPayload.newBuilder()
				.setUsername(config.getLogin())
				.setPassive(false)
				.setPushName("I have a cool name")
				.setSessionId(new Random().nextInt())
				.setShortConnect(false)
				.setConnectType(WA4Protos.ClientPayload.ConnectType.WIFI_UNKNOWN)
				.setUserAgent(userAgent).build();
	}


}
