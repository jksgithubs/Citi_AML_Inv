package dMartCompare;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;

public class mainClassComp {
    public static void runComparator(String srcUser, String srcPwd, String srcHost, String srcPort, String srcSidSer,
                    String trgUser, String trgPwd, String trgHost, String trgPort, String trgSidSer,
                    String srcFolder, String trgFolder, String SelSQL){
        try{  		
            Connection dbSrcConn = getConn.openConnection(srcUser,srcPwd,srcHost,srcPort,srcSidSer);
            Connection dbTrgConn = getConn.openConnection(trgUser,trgPwd,trgHost,trgPort,trgSidSer);

            Statement srcStatement = dbSrcConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            Statement trgStatement = dbTrgConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            //set fetch size
            srcStatement.setFetchSize(2000);
            trgStatement.setFetchSize(2000);

            //execute source and target SQL and pass the response to a result set
            if (SelSQL.equals("All")){
                File srcFolderFile = new File(srcFolder);
                File[] srcFileList = srcFolderFile.listFiles();
                int srcFileCount = srcFileList.length;

                File trgFolderFile = new File(trgFolder);
                File[] trgFileList = trgFolderFile.listFiles();
                int trgFileCount = trgFileList.length;

                if (srcFileCount==trgFileCount){
                    for (int loopSrcFldr = 0; loopSrcFldr < srcFileCount; loopSrcFldr++) {
                        String srcIndRef = srcFileList[loopSrcFldr].getName().substring(0,3);

                        for (int loopTrgFldr = 0; loopTrgFldr < trgFileCount; loopTrgFldr++){                   
                            if(trgFileList[loopTrgFldr].getName().startsWith(srcIndRef)){                     
                                String srcSQLFile = buildSQL.buildSQLs(srcFolder+"\\"+srcFileList[loopSrcFldr].getName());
                                String trgSQLFile = buildSQL.buildSQLs(trgFolder+"\\"+trgFileList[loopTrgFldr].getName());

                                ResultSet srcResultSet = srcStatement.executeQuery(srcSQLFile);
                                ResultSet trgResultSet = trgStatement.executeQuery(trgSQLFile);

                                int chkErrCount = compResultSets.main(srcResultSet, trgResultSet, srcFileList[loopSrcFldr].getName(), trgFileList[loopTrgFldr].getName());

                                //if no mismatch, print no mismatch
                                if (chkErrCount == 0){
                                    System.out.println("No mismatch: "+srcFileList[loopSrcFldr].getName()+" "+trgFileList[loopTrgFldr].getName());
                                }
                                loopTrgFldr = trgFileCount;
                            }
                        }
                    }
                }else {
                    System.out.println("# of files in Source, Target Folders are not equal");
                }
            }else {
                String [] listSQL = SelSQL.split(",");

                File srcFolderFile = new File(srcFolder);
                File[] srcFileList = srcFolderFile.listFiles();
                int srcFileCount = srcFileList.length;

                File trgFolderFile = new File(trgFolder);
                File[] trgFileList = trgFolderFile.listFiles();
                int trgFileCount = trgFileList.length;

                for (int i = 0; i<listSQL.length; i++){
                    for (int loopSrcFldr = 0; loopSrcFldr < srcFileCount; loopSrcFldr++) {
                        String srcIndRef = listSQL[i];

                        for (int loopTrgFldr = 0; loopTrgFldr < trgFileCount; loopTrgFldr++){                   
                            if(trgFileList[loopTrgFldr].getName().startsWith(srcIndRef)){                     
                                String srcSQLFile = buildSQL.buildSQLs(srcFolder+"\\"+srcFileList[loopSrcFldr].getName());
                                String trgSQLFile = buildSQL.buildSQLs(trgFolder+"\\"+trgFileList[loopTrgFldr].getName());

                                ResultSet srcResultSet = srcStatement.executeQuery(srcSQLFile);
                                ResultSet trgResultSet = trgStatement.executeQuery(trgSQLFile);
                          
                                int chkErrCount = compResultSets.main(srcResultSet, trgResultSet, srcFileList[loopSrcFldr].getName(), trgFileList[loopTrgFldr].getName());

                                //if no mismatch, print no mismatch
                                if (chkErrCount == 0){
                                    System.out.println("No mismatch: "+srcFileList[loopSrcFldr].getName()+" "+trgFileList[loopTrgFldr].getName());
                                }
                                loopTrgFldr = trgFileCount;
                            }
                        }
                    }
                }
            }

            //Close DB connections
            dbSrcConn.close();
            dbTrgConn.close();
        }
        catch(SQLException | IOException e){ 
            System.out.println(e);
            JOptionPane.showMessageDialog(null,e.toString(),"Error!",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void main(String srcUser, String srcPwd, String srcHost, String srcPort, String srcSidSer,
                    String trgUser, String trgPwd, String trgHost, String trgPort, String trgSidSer,
                    String srcFolder, String trgFolder, String selSQL){
        runComparator(srcUser,srcPwd,srcHost,srcPort,srcSidSer,trgUser,trgPwd,trgHost,
                trgPort,trgSidSer,srcFolder,trgFolder,selSQL);       
    } 
}