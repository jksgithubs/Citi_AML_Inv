package main.java.cmnUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fluWaits{
	protected static WebDriver driver;
	public static WebElement getVisibleElement(By locator, WebDriver driver) throws Throwable {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(main.java.cmnUtilities.fluWaits.waitForPageToLoad(driver), Integer.parseInt(main.java.cmnUtilities.getProperties.retPropertyValue("timeout")));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}
	
	public static WebElement getClickableElement(By locator, WebDriver driver) throws Throwable {
		WebElement element = null;
	 	WebDriverWait wait = new WebDriverWait(main.java.cmnUtilities.fluWaits.waitForPageToLoad(driver), Integer.parseInt(main.java.cmnUtilities.getProperties.retPropertyValue("timeout")));
	 	element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	 	return element;
	}
	
	public static WebDriver waitForPageToLoad(WebDriver driver) throws Throwable {
	 	new WebDriverWait(driver, Integer.parseInt(main.java.cmnUtilities.getProperties.retPropertyValue("timeout"))).until(
	 	          webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	 	return driver;
	}
}