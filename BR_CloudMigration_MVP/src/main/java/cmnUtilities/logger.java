package main.java.cmnUtilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class logger {
	public static void log(String getLogger) {
		Logger log = Logger.getLogger("runnerLogger");
		PropertyConfigurator.configure("src\\main\\java\\resources\\log4j.properties");
		log.debug(getLogger);
	}
}