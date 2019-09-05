package org.citi.gfx.utils;

import static org.citi.gfx.utils.GlobalVariables.*;

public class OpenUrl {
	public static void Open(String getEnv) throws Throwable {
		try {
			String url = DataFromDB.GetEnvUrl(getEnv);
			cDriver.get(url);
			FluentWaits.waitForPageToLoad();
		} catch (Throwable ex) {
			ExpHandler.Handle(ex, cDriver);
			ex.printStackTrace();
		}
	}
}