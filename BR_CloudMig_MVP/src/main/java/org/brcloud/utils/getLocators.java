package org.brcloud.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class getLocators {
	public static String retLocatorValue(String getLocaltorRef) throws Throwable{
		String locValue = null;
		Connection dbConn = opnDbConn.getDBConn(null);
		Statement locState = dbConn.createStatement();
		ResultSet locResultSet = locState.executeQuery("SELECT LOCATOR_VAL FROM SCFF_LOCATOR_REFERENCE "
				+ "WHERE LOCATOR_REF = '" + getLocaltorRef +"'");
		
		while (locResultSet.next()) {
			locValue = locResultSet.getString(1);
			}
			
		dbConn.close();
		locResultSet.close();
		return locValue; 		
	}	
}