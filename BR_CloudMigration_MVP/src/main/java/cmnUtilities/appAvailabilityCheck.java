package main.java.cmnUtilities;

import java.net.HttpURLConnection;
import java.net.URL;

public class appAvailabilityCheck {
	public static void sendGET() throws Throwable {
		try {
			URL urlObj = new URL(getLocators.retLocatorValue("urlBase"));
			HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", getProperties.retPropertyValue("browser"));
			pubConstants.getResponseCode = con.getResponseCode();
			con.disconnect();
			//System.out.println("GET Response Code :: " + pubConstants.getResponseCode);
		} catch (Throwable ex) {
			pubConstants.getResponseCode = 404;
		}
	}
}