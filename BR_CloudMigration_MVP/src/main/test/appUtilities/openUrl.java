package main.test.appUtilities;

import org.openqa.selenium.WebDriver;
import main.java.cmnUtilities.*;

public class openUrl {
	public static WebDriver rtnDriver;
	public static WebDriver openBrowser(String getBrowser) throws Throwable {
		try {
			rtnDriver = getBrowserDriver.retBrowserDriver(getBrowser);
		} catch(Throwable ex) {
			expHandler.cmnExpHandler(ex, rtnDriver);
			ex.printStackTrace();
		}
		return rtnDriver;
	}
	
	public static void openHome(String getUrl, WebDriver aDriver) throws Throwable {
		try {
			aDriver.get(getLocators.retLocatorValue(getUrl));
			fluWaits.waitForPageToLoad(aDriver);
		} catch (Throwable ex) {
			expHandler.cmnExpHandler(ex, aDriver);
			ex.printStackTrace();
		}
	}
}