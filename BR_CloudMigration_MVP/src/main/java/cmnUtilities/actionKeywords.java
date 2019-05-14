package main.java.cmnUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.Keys;

public class actionKeywords {
	public static void actSendKeys(String locName, String locValue, WebDriver driver, String value) throws Throwable {
		WebElement getEle = null;
		try {
			getEle = retElements.getElement(locName, locValue, driver);
			getEle.clear();
			getEle.sendKeys(value);
		} catch (Throwable ex) {
			expHandler.cmnExpHandler(ex, driver);
			ex.printStackTrace();
		}
	}
	
	public static void actKeys(String locName, String locValue, WebDriver driver, Keys value) throws Throwable {
		WebElement getEle = null;
		try {
			getEle = retElements.getElement(locName, locValue, driver);
			getEle.sendKeys(value);
		} catch (Throwable ex) {
			expHandler.cmnExpHandler(ex, driver);
			ex.printStackTrace();
		}
	}
	
	public static void actAssertEquals(String locName, String locValue, WebDriver driver, String value) throws Throwable {
		WebElement getEle = null;
		try {
			getEle = retElements.getElement(locName, locValue, driver);
			assertEquals(getEle.getAttribute("value"), value);
		} catch (Throwable ex) {
			expHandler.cmnExpHandler(ex, driver);
			ex.printStackTrace();
		}
	}
	
	public static void actVerifyPageTitle(WebDriver driver, String expTitle) throws Throwable {
		try {
			pubConstants.actTitle = driver.getTitle();
			assertEquals(pubConstants.actTitle, expTitle);
		}catch (Throwable ex) {
			expHandler.cmnExpHandler(ex, driver);
			ex.printStackTrace();
		}
	}
}