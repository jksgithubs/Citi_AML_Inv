package org.citi.gfx.apputils;

import org.citi.gfx.utils.DataFromDB;
import org.citi.gfx.utils.ExpHandler;
import org.citi.gfx.utils.GetDriver;
import org.citi.gfx.utils.Keywords;
import org.citi.gfx.utils.OpenUrl;
import static org.citi.gfx.utils.GlobalVariables.*;

public class AppAccess {
	public static void Login() throws Throwable {
		try {
			//Open browser
			cDriver = GetDriver.Get(DataFromDB.GetProperties("browser"));
			
			//Open URL
			OpenUrl.Open(DataFromDB.GetProperties("envToUse"));
			
			//Enter User Name, Password and click Login button
			Keywords.SendKeys("txtLoginId", DataFromDB.GetLoginUserName(DataFromDB.GetProperties("envToUse")));
			Keywords.SendKeys("txtPassword", DataFromDB.GetLoginPwd(DataFromDB.GetProperties("envToUse")));
			Keywords.Click("btnLogIn");
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, cDriver);
			ex.printStackTrace();
		}
	}
	
	public static void Logout() throws Throwable {
		try {
			cDriver.switchTo().parentFrame();
			Keywords.Click("btnLogOut");
			cDriver.switchTo().alert().accept();
			cDriver.quit();
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, cDriver);
			ex.printStackTrace();
		}	
	}
}