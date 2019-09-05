package org.citi.gfx.apputils;

import static org.testng.Assert.assertEquals;

import org.citi.gfx.utils.ExpHandler;
import org.citi.gfx.utils.GetElement;
import static org.citi.gfx.utils.GlobalVariables.*;
import org.openqa.selenium.WebElement;

public class AppAssertions {
	public static void Equals(String locValue, String value) throws Throwable { 
		WebElement getEle = null; 
		try {
			getEle = GetElement.Get(locValue);
			assertEquals(getEle.getAttribute("value"), value); 
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, cDriver);
			ex.printStackTrace(); 
		} 
	}
	
	public static boolean TextAvailable(String getText) throws Throwable {
		boolean ind = false;
		try {
			ind = cDriver.getPageSource().contains(getText);
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, cDriver);
			ex.printStackTrace();
		}
		return ind;
	}
}