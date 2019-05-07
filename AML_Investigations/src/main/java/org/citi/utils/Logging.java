package org.citi.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logging {
	public static void Log(String getError) throws Throwable {
		try {
			Logger log = Logger.getLogger("Logs");
			PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
			log.debug(getError);
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
	}
}