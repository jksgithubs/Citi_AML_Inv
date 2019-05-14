package org.brcloud.utils;

import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class getTestData {
	public static void retTestData(String getSQL) throws Throwable{
		//String locValue = null;
		pubConstants.dbConn =opnDbConn.getDBConn(null);
		Statement locState = pubConstants.dbConn.createStatement();
		pubConstants.dataResultSet = locState.executeQuery(getSQL);
		
		ResultSetMetaData sqlRSMD = pubConstants.dataResultSet.getMetaData();
        pubConstants.colNum = sqlRSMD.getColumnCount();
			
		/*while (locResultSet.next()) {
			locValue = locResultSet.getString(1);
			}*/
			
		//dbConn.close();
		//locResultSet.close();
		//return locValue; 		
	}
}