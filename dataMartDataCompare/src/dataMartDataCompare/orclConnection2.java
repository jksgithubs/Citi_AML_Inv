package dataMartDataCompare;
import java.sql.*; 

public class orclConnection2 {
	public static void main(String args[]){
	try{  
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		
		//open source and target DB connection
		Connection dbSourceConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","Oracle_1");
		Connection dbTargetConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","Oracle_1");
		
		//declare source and target statement
		Statement srcStatement = dbSourceConn.createStatement();
		Statement trgStatement = dbTargetConn.createStatement();
		
		//execute source and target SQL and pass the response to a result set
		ResultSet srcResultSet = srcStatement.executeQuery("SELECT * FROM PRODUCTS_SRC");
		ResultSet trgResultSet = trgStatement.executeQuery("SELECT * FROM PRODUCTS_TRG");
		
		//get meta data for source and target result set
		ResultSetMetaData srcRSMD = srcResultSet.getMetaData();
		//ResultSetMetaData trgRSMD = trgResultSet.getMetaData();
				
		//get column count for looping
		int srcColNum = srcRSMD.getColumnCount();

		//initialize error counter
		int errCountr = 0;
		
		//Compare source and target data
		while (srcResultSet.next() && trgResultSet.next()) {
		    for (int i = 1; i <= srcColNum; i++) {
		        //int srcColValue = srcResultSet.getInt(i);
		        //int trgColValue = trgResultSet.getInt(i);
		        
		        String srcColValue = srcResultSet.getString(i);
		        String trgColValue = trgResultSet.getString(i);
		        
		       // System.out.println(srcColValue+" "+trgColValue);
		        
		        //if(srcColValue != trgColValue) {
		        	//System.out.println(srcResultSet.getRow()+" "+"Source Column Name: "+srcRSMD.getColumnName(i)+" Source Data: "+srcResultSet.getString(i));
		        	//errCountr = 1;
		        //}
		        		        
		        if(new String(srcColValue).equals(trgColValue)) {
		        }else{
		        	System.out.println("Row #: "+srcResultSet.getRow()+", "+"Column: "+srcRSMD.getColumnName(i)+", Values: "+srcResultSet.getString(i)+", "+trgResultSet.getString(i));
		        	errCountr = 1;		        		
		        }
		        
		        //int refRow = srcResultSet.getRow();
		        //int refCol = srcResultSet.getInt(i);
		        //Array refCol = orclResultSet.getArray(i);
		        //System.out.println(refRow+" "+refCol+"    "+colValue);
		        //System.out.print(colValue + " " + rsmd.getColumnName(i));
		        //System.out.println(srcResultSet.);
		    }
		}
		
		if (errCountr == 0) System.out.println("No Mismatch");
		
		dbSourceConn.close();
		dbTargetConn.close();
		
		}
	
		catch(Exception e){ System.out.println(e);}  
		} 
}