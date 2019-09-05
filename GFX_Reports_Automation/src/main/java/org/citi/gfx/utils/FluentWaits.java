package org.citi.gfx.utils;

import java.util.List;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.citi.gfx.utils.GlobalVariables.*;

public class FluentWaits{
	static WebElement element;	
	static List <WebElement> lstElement;
	public static WebElement getElement(By locator) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(FluentWaits.waitForPageToLoad(), Integer.parseInt(DataFromDB.GetProperties("timeout")));
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, cDriver);
			ex.printStackTrace();
		}
		return element;
	}
	
	public static WebDriver waitForPageToLoad() throws Throwable {
	 	try {
	 		new WebDriverWait(cDriver, Integer.parseInt(DataFromDB.GetProperties("timeout"))).until(
	 				new Function<WebDriver, Object>() {
					public Object apply(WebDriver webDriver) {
						return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
						}
		          	});
	 	}catch(Throwable ex) {
	 		ExpHandler.Handle(ex, cDriver);
	 		ex.printStackTrace();
	 	}
	 	return cDriver;
	}
}