package dMartCompare;
import java.sql.*;

public class getConn {
    public static Connection openConnection(String UsrName, String pwd, String host, String port, String sidser) 
            throws SQLException{
        Connection dbConn = DriverManager.getConnection("jdbc:oracle:thin:@"+host+":"+port+":"+sidser,UsrName,pwd);
        return dbConn;
    }

    public static void main(String UsrName, String pwd, String host, String port, String sidser) throws SQLException{
        openConnection(UsrName,pwd,host,port,sidser);
    }
}