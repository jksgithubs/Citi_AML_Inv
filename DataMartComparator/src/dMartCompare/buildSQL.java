package dMartCompare;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class buildSQL {
    public static String buildSQLs(String runSQL) throws FileNotFoundException, IOException{
        String sqlPath = runSQL;
        String sqlRdPath = new String(); 
        StringBuilder sqlStrBuf = new StringBuilder(); 
        
        FileReader srcFileRdr = new FileReader(new File(sqlPath));
        BufferedReader srcBufRdr = new BufferedReader(srcFileRdr);
        
        while((sqlRdPath = srcBufRdr.readLine()) != null) 
        { 
                sqlStrBuf.append(sqlRdPath); 
        } 
        
        //Close buffer reader
	srcBufRdr.close();
        
        String sqlToRun = sqlStrBuf.toString();
        return sqlToRun;
    }
    
    public static void main(String sqlRun) throws IOException{
        buildSQLs(sqlRun);        
    }
}
