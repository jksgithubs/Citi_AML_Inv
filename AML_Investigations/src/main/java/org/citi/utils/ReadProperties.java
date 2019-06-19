package org.citi.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	public static String GetLocator(String locReference) throws IOException {
		BufferedReader proReader = new BufferedReader(new FileReader("src//test//resources//Locators//Locators.properties"));
		Properties locProperties = new Properties();
		locProperties.load(proReader);
		
		String getProperties = locProperties.getProperty(locReference);	
		return getProperties;
	}
}