package org.citi.utils;

public class OpenUrl {
	public static void Open(String getUrl) throws Throwable {
		try {
			Constants.bDriver.get(DataFromDB.Properties(getUrl));
			FluentWaits.waitForPageToLoad();
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
	}
}