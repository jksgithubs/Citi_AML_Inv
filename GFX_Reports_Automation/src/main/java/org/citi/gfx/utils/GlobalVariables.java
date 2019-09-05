package org.citi.gfx.utils;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;

public class GlobalVariables {
	public static WebDriver cDriver; //driver
	public static String rootSelector; //to store root selected for angular pages
	public static int getResponseCode=0; //to store response code during application check
	
	public static ArrayList<String> getCountriesUI = new ArrayList<String>(); //Array to store applicable countries for the run
	public static ArrayList<String> getReportsUI = new ArrayList<String>(); //Array to store applicable reports for the run
	public static ArrayList<String> getCurrenciesUI = new ArrayList<String>(); //Array to store applicable reports for the run
	
	public static ArrayList<String> getCountriesData = new ArrayList<String>(); //Array to store applicable countries for the run
	public static ArrayList<String> getReportsData = new ArrayList<String>(); //Array to store applicable reports for the run
	public static ArrayList<String> getCurrenciesData = new ArrayList<String>(); //Array to store applicable reports for the run
	
	public static ArrayList<String> getCountriesReport = new ArrayList<String>(); //Array to store applicable countries for the run
	public static ArrayList<String> getReportsReport = new ArrayList<String>(); //Array to store applicable reports for the run
	public static ArrayList<String> getCurrenciesReport = new ArrayList<String>(); //Array to store applicable reports for the run
}