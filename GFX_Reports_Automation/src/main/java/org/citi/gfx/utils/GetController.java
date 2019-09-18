package org.citi.gfx.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class GetController {
	public static ArrayList<String> GetReportList() throws IOException {
		BufferedReader confReader = new BufferedReader(new FileReader("src//main//resources//RunnerController.properties"));
		Properties confProperties = new Properties();
		confProperties.load(confReader);
		Iterator<Object> itr = confProperties.keySet().iterator();
		ArrayList<String> getReports = new ArrayList<String>();
		
		while (itr.hasNext()) {
			String getKey = itr.next().toString();
			if (getKey.split("_")[0].contains("RPT")) {
				String getValue = confProperties.getProperty(getKey);
				if (getValue.contains("Y")) {
					getReports.add(getKey);
				}
			}
		}
		confReader.close();
		return getReports;
	}
	
	public static ArrayList<String> GetCountryList() throws IOException {
		BufferedReader confReader = new BufferedReader(new FileReader("src//main//resources//RunnerController.properties"));
		Properties confProperties = new Properties();
		confProperties.load(confReader);
		Iterator<Object> itr = confProperties.keySet().iterator();
		ArrayList<String> getCountries = new ArrayList<String>();
		
		while (itr.hasNext()) {
			String getKey = itr.next().toString();
			if (getKey.split("_")[0].contains("CTY")) {
				String getValue = confProperties.getProperty(getKey);
				if (getValue.split(",")[0].contains("Y")) {
					getCountries.add(getKey);
				}
			} 
		}
		confReader.close();
		return getCountries;
	}
	
	public static ArrayList<String> GetCurrencyList() throws IOException {
		BufferedReader confReader = new BufferedReader(new FileReader("src//main//resources//RunnerController.properties"));
		Properties confProperties = new Properties();
		confProperties.load(confReader);
		Iterator<Object> itr = confProperties.keySet().iterator();
		ArrayList<String> getCurrencies = new ArrayList<String>();
		
		while (itr.hasNext()) {
			String getKey = itr.next().toString();
			if (getKey.split("_")[0].contains("CUR")) {
				String getValue = confProperties.getProperty(getKey);
				if (getValue.contains("Y")) {
					getCurrencies.add(getKey);
				}
			} 
		}
		confReader.close();
		return getCurrencies;
	}
	
	public static String GetPropertyValue(String proReference) throws IOException {
		BufferedReader proReader = new BufferedReader(new FileReader("src//main//resources//RunnerController.properties"));
		Properties locProperties = new Properties();
		locProperties.load(proReader);
		
		String getProperties = locProperties.getProperty(proReference);	
		return getProperties;
	}
}