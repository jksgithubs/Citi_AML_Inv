package org.citi.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import org.openqa.selenium.WebDriver;

public class PubVariables {
	public static WebDriver bDriver; //driver
	public static String actTitle; //to store actual page title
	public static String expTitle; //to store expected page title
	public static String rootSelector; //to store root selected for angular pages
	public static int getResponseCode=0; //to store response code during application check
	public static Connection dbConn; //to open DB connection
	public static ResultSet dataResultSet; //to store result set
	public static int colNum = 0; //to store column number of result set
	public static int rowNum = 0; //to store row number of result set
	//public static String clientType; //to store created Client Type
	//public static String bankName; //to store created Bank Name
	
	public static WebDriver getDriver() throws Throwable {
		bDriver = FluentWaits.waitForPageToLoad();
		return bDriver;
	}
}