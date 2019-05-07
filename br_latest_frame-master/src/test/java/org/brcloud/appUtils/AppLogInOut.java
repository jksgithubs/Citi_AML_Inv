package org.brcloud.appUtils;

import org.brcloud.utils.*;

public class AppLogInOut {
	public static void Login(String revUrl) throws Throwable {
		try {
			//Open browser
			Constants.bDriver = GetDriver.Get(DataFromDB.Properties("browser"));
			
			//Open RevPort URL
			OpenUrl.Open(revUrl);
			
			//Enter User Name, Password and click Login button
			Keywords.SendKeys("txtRevLoginId", DataFromDB.Locator("revUserName"));
			Keywords.SendKeys("txtRevPassword", DataFromDB.Locator("revPassword"));
			Keywords.Click("btnRevLogIn");
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