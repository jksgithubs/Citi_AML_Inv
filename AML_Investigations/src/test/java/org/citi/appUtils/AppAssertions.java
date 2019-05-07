package org.citi.appUtils;

import static org.testng.Assert.assertEquals;
import org.citi.utils.Constants;
import org.citi.utils.ExpHandler;
import org.citi.utils.GetElement;
import org.openqa.selenium.WebElement;

public class AppAssertions {
	public static void Equals(String locValue, String value) throws Throwable { 
		WebElement getEle = null; 
		try {
			getEle = GetElement.Get(locValue);
			assertEquals(getEle.getAttribute("value"), value); 
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace(); 
		} 
	}
	
	public static boolean TextAvailable(String getText) throws Throwable {
		boolean ind = false;
		try {
			ind = Constants.bDriver.getPageSource().contains(getText);
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
		return ind;
	}
}