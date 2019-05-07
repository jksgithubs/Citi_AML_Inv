package org.citi.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DataFromDB {
	static Connection dbConn;
	static String retValue;
	static ResultSet getData;
	public static Connection Open() throws Throwable{	
		try {
			//connect to MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://unicornqa.cluster-cwhuea5dgpmk.us-east-1.rds.amazonaws.com:3306/BR_CLOUDMIG_AUTOMATION","admin","Un!cornqa");
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return dbConn; 			
	}
	
	public static String Locator(String locReference) throws Throwable{
		try {
			Connection dbConn = Open();
			Statement locState = dbConn.createStatement();
			ResultSet locResultSet = locState.executeQuery("SELECT LOCATOR_VAL FROM "
					+ Properties("ObjRep") + " WHERE LOCATOR_REF = '" + locReference +"'");
			
			while (locResultSet.next()) {
				retValue = locResultSet.getString(1);
				}
				
			dbConn.close();
			locResultSet.close();
			
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return retValue;	 		
	}
	
	public static String LocatorName(String locReference) throws Throwable{
		try {
			Connection dbConn = Open();
			Statement locState = dbConn.createStatement();
			ResultSet locResultSet = locState.executeQuery("SELECT LOCATOR_NAME FROM "
					+ Properties("ObjRep") + " WHERE LOCATOR_REF = '" + locReference +"'");
			
			while (locResultSet.next()) {
				retValue = locResultSet.getString(1);
				}
				
			dbConn.close();
			locResultSet.close();
			
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return retValue;	 		
	}
	
	public static String Properties(String proReference) throws Throwable{
		try {
			Connection dbConn = Open();
			Statement locState = dbConn.createStatement();
			ResultSet locResultSet = locState.executeQuery("SELECT PROPERTY_VAL FROM REV_PROPERTIES WHERE PROPERTY_REF = '" + proReference +"'");
			
			while (locResultSet.next()) {
				retValue = locResultSet.getString(1);
				}
				
			dbConn.close();
			locResultSet.close();
			
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return retValue;	 		
	}
	
	public static String SQL(String sqlReference) throws Throwable{
		try {
			Connection dbConn = Open();
			Statement locState = dbConn.createStatement();
			ResultSet locResultSet = locState.executeQuery("SELECT SQL_VALUE FROM REV_SQL_REFERENCE WHERE SQL_REFERENCE = '" + sqlReference +"'");
			
			while (locResultSet.next()) {
				retValue = locResultSet.getString(1);
				}
				
			dbConn.close();
			locResultSet.close();
			
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return retValue;	 		
	}
	
	public static ResultSet TestData(String getSQL) throws Throwable{
		try {			
			Connection dbConn = Open();
			Statement locState = dbConn.createStatement();
			getData = locState.executeQuery(getSQL);
			
			ResultSetMetaData sqlRSMD = getData.getMetaData();
			Constants.colNum = sqlRSMD.getColumnCount();
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return getData;
	}
	
	public static String DataReuse(String dataName) throws Throwable{
		try {
			Connection dbConn = Open();
			Statement dataState = dbConn.createStatement();
			ResultSet dataResultSet = dataState.executeQuery("SELECT DATA_VALUE FROM DATA_USE_DURING_EXECUTION WHERE DATA_NAME = '" + dataName +"'");
			
			while (dataResultSet.next()) {
				retValue = dataResultSet.getString(1);
				}
				
			dbConn.close();
			dataResultSet.close();
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return retValue;
	}
	
	public static void UpdateDataReuse(String dataName, String dataValue) throws Throwable{
		try {
			Connection dbConn = Open();
			Statement updState = dbConn.createStatement();
			updState.execute("UPDATE DATA_USE_DURING_EXECUTION SET DATA_VALUE = '"+dataValue+"' WHERE DATA_NAME = '"+dataName+"'");
			dbConn.close();			
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
	}
}