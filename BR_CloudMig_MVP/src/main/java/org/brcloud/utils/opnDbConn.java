package org.brcloud.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class opnDbConn {
	public static Connection getDBConn(String Arg[]) throws Throwable{
		//connect to oracle
		//Class.forName("oracle.jdbc.driver.OracleDriver"); 
		//Connection dbConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","oracle");
		
		//connect to MySQL
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/localres","root","root");
		return dbConn; 		
	}
}