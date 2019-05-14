package dataMartDataCompare;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.*;

public class orclConnection {
	public static void main(String args[]){
	try{  
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Scanner getValue = new Scanner(System.in);
		
		//get source DB user name and password  
	    //System.out.print("Enter Source DB UserName,Password: ");
        //String srcGetCred = getValue.nextLine();
        //String [] srcArrCred = srcGetCred.split(",");
        //String srcUserName = srcArrCred[0];
        //String srcPassword = srcArrCred[1];
        
      //get target DB user name and password 
	    //System.out.print("Enter Target DB UserName,Password: ");
        //String trgGetCred = getValue.nextLine();
        //String [] trgArrCred = trgGetCred.split(",");
        //String trgUserName = trgArrCred[0];
        //String trgPassword = trgArrCred[1];
        
        //establish connection for source and target DB
		//Connection dbSourceConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",srcUserName,srcPassword);
		//Connection dbTargetConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",trgUserName,trgPassword);
		
		Connection dbSourceConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","Oracle_1");
		Connection dbTargetConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","Oracle_1");
        	
		//get source path and build SQL
		String srcSQLPath = "D:\\JKs Computer\\@Tools\\srcSQL\\001_PRODUCTS_SRC.sql";
		String [] getSrcSqlId = srcSQLPath.split("\\\\"); //split to get SQL file name
		String srcRdPath = new String(); 
		StringBuffer srcStrBuf = new StringBuffer(); 
		
		FileReader srcFileRdr = new FileReader(new File(srcSQLPath));
		BufferedReader srcBufRdr = new BufferedReader(srcFileRdr);
		
		while((srcRdPath = srcBufRdr.readLine()) != null) 
		{ 
			srcStrBuf.append(srcRdPath); 
		} 
		
		//get target path and build SQL
		String trgSQLPath = "D:\\JKs Computer\\@Tools\\trgSQL\\001_PRODUCTS_TRG.sql";
		String [] getTrgSqlId = trgSQLPath.split("\\\\"); //split to get SQL file name
		String trgRdPath = new String(); 
		StringBuffer trgStrBuf = new StringBuffer(); 
		
		FileReader trgFileRdr = new FileReader(new File(trgSQLPath));
		BufferedReader trgBufRdr = new BufferedReader(trgFileRdr);
		
		while((trgRdPath = trgBufRdr.readLine()) != null) 
		{ 
			trgStrBuf.append(trgRdPath); 
		} 
		
		//declare source and target statement
		Statement srcStatement = dbSourceConn.createStatement();
		Statement trgStatement = dbTargetConn.createStatement();
		
		//set fetch size
		srcStatement.setFetchSize(2000);
		trgStatement.setFetchSize(2000);
		
		//execute source and target SQL and pass the response to a result set
		String srcSQL = srcStrBuf.toString();
		String trgSQL = trgStrBuf.toString();
		ResultSet srcResultSet = srcStatement.executeQuery(srcSQL);
		ResultSet trgResultSet = trgStatement.executeQuery(trgSQL);
		
		System.out.println(srcResultSet.getFetchSize());
		System.out.println(trgResultSet.getFetchSize());
		
		//compare two result sets
		//if (srcResultSet.equals(trgResultSet)) {
			
			//System.out.println("Success");
			//System.out.println(srcResultSet);
			
		//}
		
		//get meta data for source and target result set
		ResultSetMetaData srcRSMD = srcResultSet.getMetaData();
				
		//get column count for looping
		int srcColNum = srcRSMD.getColumnCount();

		//initialize error counter
		int errCountr = 0;
		
		//Compare source and target data
		while (srcResultSet.next() && trgResultSet.next()) {
		    for (int i = 1; i <= srcColNum; i++) {      
		        String srcColValue = srcResultSet.getString(i);
		        String trgColValue = trgResultSet.getString(i);
		        		        
		        if(new String(srcColValue).equals(trgColValue)) {
		        }else{
		        	System.out.println("Row #: "+srcResultSet.getRow()+", "+"Column: "+srcRSMD.getColumnName(i)+", Values: "+srcResultSet.getString(i)+", "+trgResultSet.getString(i));
		        	errCountr = 1;		        		
		        }
		    }
		}
		
		//if no mismatch, print no mismatch
		if (errCountr == 0) System.out.println("No mismatch between SQL files: "+getSrcSqlId[getSrcSqlId.length-1]+" & "+getTrgSqlId[getTrgSqlId.length-1]);
		
		//Close the scanner
		getValue.close();
		
		//Close buffer reader
		srcBufRdr.close();
		trgBufRdr.close();
		
		//Close DB connections
		dbSourceConn.close();
		dbTargetConn.close();
		
		}
		catch(Exception e){ System.out.println(e);}  
		} 
}