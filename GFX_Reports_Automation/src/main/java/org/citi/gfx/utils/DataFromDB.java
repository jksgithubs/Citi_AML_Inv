package org.citi.gfx.utils;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import static com.mongodb.client.model.Filters.eq;

public class DataFromDB {
	public static MongoClient ConnectFrameworkDB() throws Throwable {
		MongoClient clientConnFrmWrk = new MongoClient();
		try {
			clientConnFrmWrk = new MongoClient("localhost", 27017);
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}		
		return clientConnFrmWrk;
	}
	
	public static MongoClient ConnectApplicationDB() throws Throwable {	
		MongoClient clientConnApplication = new MongoClient();
		try {
			clientConnApplication = new MongoClient("localhost", 27017);
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}		
		return clientConnApplication;
	}
	
	public static String GetLocatorValue(String locReference) throws Throwable{
		String getLocatorValue = null;
		try {
			MongoClient openConn = ConnectFrameworkDB();
			MongoDatabase mongoDB = openConn.getDatabase("GFX_AUTOMATION");
			MongoCollection<Document> collection = mongoDB.getCollection("REPOSITORY");
			
			if (openConn.getAddress() == null) {
				
			}
			
			getLocatorValue = collection.find(eq("LOCATOR_REFERENCE", locReference)
					).projection(
							Projections.include("LOCATOR_VALUE")
			    ).first().getString("LOCATOR_VALUE");
					
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
			MongoClient openConn = ConnectFrameworkDB();
			MongoDatabase mongoDB = openConn.getDatabase("GFX_AUTOMATION");
			MongoCollection<Document> collection = mongoDB.getCollection("REPOSITORY");
			
			getLocatorName = collection.find(eq("LOCATOR_REFERENCE", locReference)
					).projection(
							Projections.include("LOCATOR_NAME")
			    ).first().getString("LOCATOR_NAME");
					
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
			MongoClient openConn = ConnectFrameworkDB();
			MongoDatabase mongoDB = openConn.getDatabase("GFX_AUTOMATION");
			MongoCollection<Document> collection = mongoDB.getCollection("PROPERTIES");
			
			getPropertyValue = collection.find(eq("PROPERTY_REFERENCE", proReference)
					).projection(
							Projections.include("PROPERTY_VALUE")
			    ).first().getString("PROPERTY_VALUE");
					
			openConn.close();
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return getPropertyValue;	 		
	}
	
	public static String GetSQL(String sqlReference) throws Throwable{
		String getSQL = null;
		try {
			MongoClient openConn = ConnectFrameworkDB();
			MongoDatabase mongoDB = openConn.getDatabase("GFX_AUTOMATION");
			MongoCollection<Document> collection = mongoDB.getCollection("SQL_MAPPER");
			
			getSQL = collection.find(eq("REPORT_NAME", sqlReference)
					).projection(
							Projections.include("REPORT_SQL")
			    ).first().getString("REPORT_SQL");
					
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
			MongoClient openConn = ConnectFrameworkDB();
			MongoDatabase mongoDB = openConn.getDatabase("GFX_AUTOMATION");
			MongoCollection<Document> collection = mongoDB.getCollection("ENVIRONMENT");
			
			getUrl = collection.find(eq("ENVIRONMENT", envName)
					).projection(
							Projections.include("URL")
			    ).first().getString("URL");
					
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
			MongoClient openConn = ConnectFrameworkDB();
			MongoDatabase mongoDB = openConn.getDatabase("GFX_AUTOMATION");
			MongoCollection<Document> collection = mongoDB.getCollection("ENVIRONMENT");
			
			getUserName = collection.find(eq("ENVIRONMENT", envName)
					).projection(
							Projections.include("USER_NAME")
			    ).first().getString("USER_NAME");
					
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
			MongoClient openConn = ConnectFrameworkDB();
			MongoDatabase mongoDB = openConn.getDatabase("GFX_AUTOMATION");
			MongoCollection<Document> collection = mongoDB.getCollection("ENVIRONMENT");
			
			getPwd = collection.find(eq("ENVIRONMENT", envName)).projection(Projections.include("PASSWORD")).first().getString("PASSWORD");
			openConn.close();
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return getPwd;	 		
	}
	
	public static String GetDbServer(String envName) throws Throwable {
		String getDBServer = null;
		try {
			MongoClient openConn = ConnectFrameworkDB();
			MongoDatabase mongoDB = openConn.getDatabase("GFX_AUTOMATION");
			MongoCollection<Document> collection = mongoDB.getCollection("ENVIRONMENT");
			
			getDBServer = collection.find(eq("ENVIRONMENT", envName)).projection(Projections.include("DB_SERVER")).first().getString("DB_SERVER");	
			openConn.close();
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return getDBServer;		
	}
	
	public static String GetDbPort(String envName) throws Throwable {
		String getDBPort = null;
		try {
			MongoClient openConn = ConnectFrameworkDB();
			MongoDatabase mongoDB = openConn.getDatabase("GFX_AUTOMATION");
			MongoCollection<Document> collection = mongoDB.getCollection("ENVIRONMENT");
			
			getDBPort = collection.find(eq("ENVIRONMENT", envName)).projection(Projections.include("DB_PORT")).first().getString("DB_PORT");	
			openConn.close();
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return getDBPort;
	}
	
	public static String GetDbUserName(String envName) throws Throwable {
		String getDBUserName = null;
		try {
			MongoClient openConn = ConnectFrameworkDB();
			MongoDatabase mongoDB = openConn.getDatabase("GFX_AUTOMATION");
			MongoCollection<Document> collection = mongoDB.getCollection("ENVIRONMENT");
			
			getDBUserName = collection.find(eq("ENVIRONMENT", envName)).projection(Projections.include("DB_USER_NAME")).first().getString("DB_USER_NAME");	
			openConn.close();
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return getDBUserName;
	}
	
	public static String GetDbPwd(String envName) throws Throwable {
		String getDBPassword = null;
		try {
			MongoClient openConn = ConnectFrameworkDB();
			MongoDatabase mongoDB = openConn.getDatabase("GFX_AUTOMATION");
			MongoCollection<Document> collection = mongoDB.getCollection("ENVIRONMENT");
			
			getDBPassword = collection.find(eq("ENVIRONMENT", envName)).projection(Projections.include("DB_PASSWORD")).first().getString("DB_PASSWORD");	
			openConn.close();
		}catch(Throwable ex) {
			ExpHandler.Handle(ex, null);
			ex.printStackTrace();
		}
		return getDBPassword;
	}
}