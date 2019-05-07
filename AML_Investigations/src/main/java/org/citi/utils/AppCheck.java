package org.citi.utils;

import java.net.HttpURLConnection;
import java.net.URL;

public class AppCheck {
	public static void sendGET() throws Throwable {
		try {
			URL urlObj = new URL(DataFromDB.Properties("SIT"));
			HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", DataFromDB.Properties("browser"));
			Constants.getResponseCode = con.getResponseCode();
			con.disconnect();
			//System.out.println("GET Response Code :: " + pubConstants.getResponseCode);
		} catch (Throwable ex) {
			Constants.getResponseCode = 404;
		}
	}
}