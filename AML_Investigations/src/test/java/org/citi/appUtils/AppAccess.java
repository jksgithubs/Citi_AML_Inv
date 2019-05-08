package org.citi.appUtils;

import org.citi.utils.*;

public class AppAccess {
	public static void Login() throws Throwable {
		try {
			//Open browser
			Constants.bDriver = GetDriver.Get(DataFromDB.Properties("browser"));
			
			//Open URL
			OpenUrl.Open(DataFromDB.Properties("envToUse"));
			
			//Enter User Name, Password and click Login button
			Keywords.SendKeys("txtLoginId", DataFromDB.EnvUserName(DataFromDB.Properties("envToUse")));
			Keywords.SendKeys("txtPassword", DataFromDB.EnvPwd(DataFromDB.Properties("envToUse")));
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