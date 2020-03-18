package org.citi.risk.insight.utils;

import java.sql.*;

public class DataFromDB {
	public static Connection OpenDBConn() throws Throwable{
		Connection orclConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as SYSDBA","Jaikar20");
		return orclConn;
	}
	
	public static String GetLocatorValue(String locReference) throws Throwable{
		String getLocatorValue = null;
		try {
			Connection openConn = OpenDBConn();
			Statement qStmt = openConn.createStatement(); 
			ResultSet locResultSet = qStmt.executeQuery("SELECT LOCATOR_VALUE FROM ONEINSIGHT_REPOSITORY "
					+ "WHERE LOCATOR_REFERENCE = '" + locReference + "'");  
			
			while(locResultSet.next()) {
				getLocatorValue = locResultSet.getString(1);
			}
			
			openConn.close();			
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return getLocatorValue;	 		
	}
	
	public static String GetLocatorName(String locReference) throws Throwable{
		String getLocatorName = null;
		try {
			Connection openConn = OpenDBConn();
			Statement qStmt = openConn.createStatement(); 
			ResultSet locResultSet = qStmt.executeQuery("SELECT LOCATOR_NAME FROM ONEINSIGHT_REPOSITORY "
					+ "WHERE LOCATOR_REFERENCE = '" + locReference + "'");  
			
			while(locResultSet.next()) {
				getLocatorName = locResultSet.getString(1);
			}
			
			openConn.close();			
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return getLocatorName;	 		
	}
	
	public static String GetProperties(String proReference) throws Throwable{
		String getPropertyValue = null;
		try {
			Connection openConn = OpenDBConn();
			Statement qStmt = openConn.createStatement(); 
			ResultSet locResultSet = qStmt.executeQuery("SELECT PROPERTY_VALUE FROM ONEINSIGHT_PROPERTIES "
					+ "WHERE PROPERTY_REFERENCE = '" + proReference + "'");  
			
			while(locResultSet.next()) {
				getPropertyValue = locResultSet.getString(1);
			}
			
			openConn.close();			
		}catch(Throwable ex) {
			//ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return getPropertyValue;	 		
	}
	
	public static String GetSQL(String sqlReference) throws Throwable{
		String getSQL = null;
		try {
			Connection openConn = OpenDBConn();
			Statement qStmt = openConn.createStatement(); 
			ResultSet locResultSet = qStmt.executeQuery("SELECT EDIT_CHECK_SQL FROM EDIT_CHECK_SQL "
					+ "WHERE EDIT_CHECK_REFERENCE = '" + sqlReference + "'");  
			
			while(locResultSet.next()) {
				getSQL = locResultSet.getString(1);
			}
			
			openConn.close();			
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return getSQL;	 		
	}
	
	public static String GetEnvUrl(String envName) throws Throwable{
		String getUrl = null;
		try {
			Connection openConn = OpenDBConn();
			Statement qStmt = openConn.createStatement(); 
			ResultSet locResultSet = qStmt.executeQuery("SELECT ENV_URL FROM ONEINSIGHT_ENV "
					+ "WHERE ENV_NAME = '" + envName + "'");  
			
			while(locResultSet.next()) {
				getUrl = locResultSet.getString(1);
			}
			
			openConn.close();			
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return getUrl;	 		
	}
	
	public static String GetLoginUserName(String envName) throws Throwable{
		String getUserName = null;
		try {
			Connection openConn = OpenDBConn();
			Statement qStmt = openConn.createStatement(); 
			ResultSet locResultSet = qStmt.executeQuery("SELECT ENV_USER_NAME FROM ONEINSIGHT_ENV "
					+ "WHERE ENV_NAME = '" + envName + "'");  
			
			while(locResultSet.next()) {
				getUserName = locResultSet.getString(1);
			}
			
			openConn.close();			
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return getUserName;	 		
	}
	
	public static String GetLoginPwd(String envName) throws Throwable{
		String getPwd = null;
		try {
			Connection openConn = OpenDBConn();
			Statement qStmt = openConn.createStatement(); 
			ResultSet locResultSet = qStmt.executeQuery("SELECT ENV_USER_PWD FROM ONEINSIGHT_ENV "
					+ "WHERE ENV_NAME = '" + envName + "'");  
			
			while(locResultSet.next()) {
				getPwd = locResultSet.getString(1);
			}
			
			openConn.close();			
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return getPwd;	 		
	}
	
	public static String GetErrorExceptionSeverity (String getExceptionCode) throws Throwable {
		String retSeverity = null;
		try {
			Connection openConn = OpenDBConn();
			Statement qStmt = openConn.createStatement(); 
			ResultSet sevResultSet = qStmt.executeQuery("SELECT ERREXC_SEVERITY FROM ERROR_EXCEPTION_SEVERITY "
					+ "WHERE ERREXC_CODE = '" + getExceptionCode + "'");  
			
			while(sevResultSet.next()) {
				retSeverity = sevResultSet.getString(1);
			}
			
			openConn.close();			
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return retSeverity;
	}
}