package org.citi.appUtils;

import org.openqa.selenium.WebDriver;
import org.citi.utils.*;

public class openUrl {
	public static WebDriver rtnDriver;
	public static WebDriver openBrowser(String getBrowser) throws Throwable {
		try {
			rtnDriver = GetDriver.Get(getBrowser);
		} catch(Throwable ex) {
			ExpHandler.Handle(ex, rtnDriver);
			ex.printStackTrace();
		}
		return rtnDriver;
	}
	
	public static void openHome(String getUrl, WebDriver aDriver) throws Throwable {
		try {
			aDriver.get(DataFromDB.Locator(getUrl));
			FluentWaits.waitForPageToLoad();
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, aDriver);
			ex.printStackTrace();
		}
	}
}