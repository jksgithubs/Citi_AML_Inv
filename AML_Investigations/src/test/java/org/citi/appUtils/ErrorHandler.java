package org.citi.appUtils;

//import org.brcloud.utils.Constants;
//import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ErrorHandler {
	public static SoftAssert softAssertion = new SoftAssert();
	public static void DataExisting(String attCheck, String textCheck) throws Throwable {
		//SoftAssert softAssertion= new SoftAssert();
		
		boolean ind = AppAssertions.TextAvailable(textCheck);
		if (ind == true) { 
			//Constants.bDriver.switchTo().parentFrame();
			//RevPortLogInOut.Logout();
			//Assert.assertFalse(ind, attCheck + ": " + textCheck);
			softAssertion.assertFalse(ind, attCheck + ": " + textCheck);
		}
	}
}