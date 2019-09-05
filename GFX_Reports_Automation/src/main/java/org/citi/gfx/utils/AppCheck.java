package org.citi.gfx.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import static org.citi.gfx.utils.GlobalVariables.*;

public class AppCheck {
	public static void sendGET() throws Throwable {
		try {
			URL urlObj = new URL(DataFromDB.GetEnvUrl(DataFromDB.GetProperties("envToUse")));
			HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", DataFromDB.GetProperties("browser"));
			getResponseCode = con.getResponseCode();
			con.disconnect();
			//System.out.println("GET Response Code :: " + Constants.getResponseCode);
		} catch (Throwable ex) {
			getResponseCode = 404;
		}
	}
}