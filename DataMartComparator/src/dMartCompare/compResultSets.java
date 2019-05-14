package dMartCompare;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class compResultSets {
    public static int main(ResultSet srcSet, ResultSet trgSet, String srcSQLFile, String trgSQLFile) throws SQLException{
        ResultSetMetaData srcRSMD = srcSet.getMetaData();
        ResultSetMetaData trgRSMD = trgSet.getMetaData();
        int srcColNum = srcRSMD.getColumnCount();
        //int trgColNum = trgRSMD.getColumnCount();
        
        int chkErrCount = 0;
        int chkColPrint = 0;
        int chkFileNamePrint = 0;
        int chkFirstPrintCol = 0;
        int chkFirstPrintRow = 0;
                
        while (srcSet.next()&&trgSet.next()) {
            for (int loopRS = 1; loopRS <= srcColNum; loopRS++) {      
                String srcColValue = srcSet.getString(loopRS);
                String trgColValue = trgSet.getString(loopRS);

                String getColumns = "";
                String getRows = "";

                if(srcColValue.equals(trgColValue)) {

                }else{
                    if (chkFileNamePrint == 0){
                        System.out.println("SQL Files: "+srcSQLFile+" & "+trgSQLFile);
                        chkFileNamePrint = 1;
                    }
                    chkFirstPrintRow = 0;
                    for(int innrLoop = 1; innrLoop <= srcColNum; innrLoop++){
                        if (chkColPrint == 0){
                            if (chkFirstPrintCol == 0){
                                getColumns = srcRSMD.getColumnName(innrLoop)+","+trgRSMD.getColumnName(innrLoop);
                                chkFirstPrintCol = 1;
                            }else{
                                getColumns = getColumns+","+srcRSMD.getColumnName(innrLoop)+","+trgRSMD.getColumnName(innrLoop);
                            }
                        }
                        if (chkFirstPrintRow == 0){
                                getRows = srcSet.getString(innrLoop)+","+trgSet.getString(innrLoop);
                                chkFirstPrintRow = 1;
                            }else{
                                getRows = getRows+","+srcSet.getString(innrLoop)+","+trgSet.getString(innrLoop);
                            }                      
                    }
                    chkColPrint = 1;
                    System.out.println(getColumns);
                    System.out.println(getRows);
                    chkErrCount = 1;		        		
                }
            }
        }
        return chkErrCount;
    }
}