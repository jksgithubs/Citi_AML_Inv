package org.citi.utils;

import java.net.HttpURLConnection;
import java.net.URL;

public class AppCheck {
	public static void sendGET() throws Throwable {
		try {
			URL urlObj = new URL(DataFromDB.Url(DataFromDB.Properties("envToUse")));
			HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", DataFromDB.Properties("browser"));
			PubVariables.getResponseCode = con.getResponseCode();
			con.disconnect();
			//System.out.println("GET Response Code :: " + Constants.getResponseCode);
		} catch (Throwable ex) {
			PubVariables.getResponseCode = 404;
		}
	}
}