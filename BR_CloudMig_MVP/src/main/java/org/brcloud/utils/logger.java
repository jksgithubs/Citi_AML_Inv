package org.brcloud.utils;

//import org.apache.logging.log4j.Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class logger {
	public static void log(String getLogger) {
		Logger log = Logger.getLogger("runnerLogger");
		PropertyConfigurator.configure("src\\test\\java\\org\\brcloud\\resources\\log4j.properties");
		log.debug(getLogger);
	}
}