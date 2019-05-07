package org.citi.appUtils;

import org.citi.utils.*;

public class AppLogInOut {
	public static void Login(String revUrl) throws Throwable {
		try {
			//Open browser
			Constants.bDriver = GetDriver.Get(DataFromDB.Properties("browser"));
			
			//Open URL
			OpenUrl.Open(revUrl);
			
			//Enter User Name, Password and click Login button
			Keywords.SendKeys("txtLoginId", DataFromDB.Locator("amlUserName"));
			Keywords.SendKeys("txtPassword", DataFromDB.Locator("amlPassword"));
			Keywords.Click("btnLogIn");
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}
	}
	
	public static void Logout() throws Throwable {
		try {
			Constants.bDriver.switchTo().parentFrame();
			Keywords.Click("btnLogOut");
			Constants.bDriver.switchTo().alert().accept();
			Constants.bDriver.quit();
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, Constants.bDriver);
			ex.printStackTrace();
		}	
	}
}