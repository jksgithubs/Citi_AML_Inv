package org.citi.utils;

import java.util.Arrays;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;  

public class ConnectDB { 
   public static void Mongo() {  
      MongoCredential credential = MongoCredential.createCredential("userName", "dbName", "pwd".toCharArray());       
      MongoClientOptions sslEnabled = MongoClientOptions.builder().sslEnabled(true).build();
      MongoClient dbConn = new MongoClient(new ServerAddress("server", 27017), Arrays.asList(credential), sslEnabled);
      dbConn.close();
   }
}