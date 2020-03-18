package org.citi.risk.insight.utils;

import org.openqa.selenium.WebDriver;
import static org.citi.risk.insight.utils.GlobalVariables.*;

public class ExpHandler {
	public static String errTrace = "";	
	public static void Handle(Throwable getError, WebDriver driver) throws Throwable {	
		AppCheck.sendGET();
		if (getResponseCode==200) {
			for(StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {                         
				errTrace = errTrace + System.lineSeparator() + stackTraceElement.toString();
			}

			switch(DataFromDB.GetErrorExceptionSeverity(getError.getClass().getSimpleName())){
				case "Sev-1":
					cDriver.quit();
					Logging.Log("Exception with Sev-1 severity occured, further test phases terminated!!!");
					Logging.Log(getError.getLocalizedMessage() + " has occured" + errTrace);
					System.exit(0);
				case "Sev-2":
					cDriver.quit();
					Logging.Log("Exception with Sev-2 severity occured, further feature execution terminated!!!");
					Logging.Log(getError.getLocalizedMessage() + " has occured" + errTrace);
					getError.getSuppressed();
				case "Sev-3":
					Logging.Log("Exception with Sev-3 severity occured, refer stackTrace for details");
					Logging.Log(getError.getLocalizedMessage() + " has occured" + errTrace);
					getError.getSuppressed();
				case "Sev-4":
					Logging.Log("Exception with Sev-4 severity occured, refer stackTrace for details");
					Logging.Log(getError.getLocalizedMessage() + " has occured" + errTrace);
					getError.getSuppressed();
				default:
					Logging.Log("Exception code not in list, refer stackTrace for details");
					Logging.Log(getError.getLocalizedMessage() + " has occured" + errTrace);
					getError.getSuppressed();
				}
		} else {
			cDriver.quit();
			getResponseCode=0;
			Logging.Log("Application is unavailable, further execution is terminated!!!");
			Logging.Log(getError.getLocalizedMessage() + " has occured" + errTrace);
			System.exit(0);
		}
	}
}