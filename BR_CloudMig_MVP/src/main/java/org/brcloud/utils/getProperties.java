package org.brcloud.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class getProperties {
	public static String retPropertyValue(String getPropertyRef) throws Throwable{
		String locValue = null;
		Connection dbConn = opnDbConn.getDBConn(null);
		Statement locState = dbConn.createStatement();
		ResultSet locResultSet = locState.executeQuery("SELECT PROPERTY_VAL FROM SCFF_PROPERTY_REFERENCE "
				+ "WHERE PROPERTY_REF = '" + getPropertyRef +"'");
		
		while (locResultSet.next()) {
			locValue = locResultSet.getString(1);
			}
			
		dbConn.close();
		locResultSet.close();
		return locValue; 		
	}	
}