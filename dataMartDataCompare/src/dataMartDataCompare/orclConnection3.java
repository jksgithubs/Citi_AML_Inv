package dataMartDataCompare;
import java.sql.*;
import java.io.*;

public class orclConnection3 {
	public static void main(String args[]){
	try{  
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		
		//open source and target DB connection
		Connection dbSourceConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","Oracle_1");
		Connection dbTargetConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","Oracle_1");
		
		//get source path and build SQL
		String srcSQLPath = "D:\\JKs Computer\\@Tools\\srcSQL\\001_PRODUCTS_SRC.sql";
		String s = new String(); 
		StringBuffer sb = new StringBuffer(); 
		
		FileReader fr = new FileReader(new File(srcSQLPath));
		BufferedReader br = new BufferedReader(fr);
		
		while((s = br.readLine()) != null) 
		{ 
		sb.append(s); 
		} 
		br.close();
		
		//get target path and build SQL
		@SuppressWarnings("unused")
		String trgSQLParh = "D:\\JKs Computer\\@Tools\\trgSQL\\001_PRODUCTS_TRG.sql";
		String s1 = new String(); 
		StringBuffer sb1 = new StringBuffer(); 
		
		FileReader fr1 = new FileReader(new File(srcSQLPath));
		BufferedReader br1 = new BufferedReader(fr1);
		
		while((s1 = br1.readLine()) != null) 
		{ 
		sb1.append(s1); 
		} 
		br1.close();
		
		//declare source and target statement
		Statement srcStatement = dbSourceConn.createStatement();
		Statement trgStatement = dbTargetConn.createStatement();
		
		//execute source and target SQL and pass the response to a result set
		String srcSQL = sb.toString();
		String trgSQL = sb1.toString();
		@SuppressWarnings("unused")
		ResultSet srcResultSet = srcStatement.executeQuery(srcSQL);
		@SuppressWarnings("unused")
		ResultSet trgResultSet = trgStatement.executeQuery(trgSQL);
		

		//Close DB connections
        dbSourceConn.close();
		dbTargetConn.close();
		
		}
		catch(Exception e){ System.out.println(e);}  
		} 
}