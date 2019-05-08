package org.citi.utils;

public class OpenUrl {
	public static void Open(String getEnv) throws Throwable {
		try {
			String url = DataFromDB.Url(getEnv);
			Constants.bDriver.get(url);
			FluentWaits.waitForPageToLoad();
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
	}
}