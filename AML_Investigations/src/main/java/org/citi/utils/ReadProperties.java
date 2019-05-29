package org.citi.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	public static String GetLocator() throws IOException {
		BufferedReader proReader = new BufferedReader(new FileReader(""));
		Properties locProperties = new Properties();
		locProperties.load(proReader);
		
		
		
		return null;
	}

	
}