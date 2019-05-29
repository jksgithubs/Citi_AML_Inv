package org.brcloud.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.asserts.SoftAssert;

//import static org.junit.Assert.assertEquals;
//import org.testng.Assert;
import static org.testng.Assert.assertEquals;

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
			pubConstants.sa.assertEquals(getEle.getAttribute("value"), value);
		} catch (Throwable ex) {
			expHandler.cmnExpHandler(ex, driver);
			ex.printStackTrace();
		}
	}
	
	public static void actVerifyPageTitle(WebDriver driver, String expTitle) throws Throwable {
		try {
			//pubConstants.sa = new SoftAssert();
			pubConstants.actTitle = driver.getTitle();
			pubConstants.sa.assertEquals(pubConstants.actTitle, expTitle);
		}catch (Throwable ex) {
			expHandler.cmnExpHandler(ex, driver);
			ex.printStackTrace();
		}
	}
}