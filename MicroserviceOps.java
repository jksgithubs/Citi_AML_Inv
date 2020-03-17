package org.citi.risk.insight.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.sf.json.JSONObject;
import static org.citi.risk.insight.utils.DataFromDB.*;
import static org.citi.risk.insight.utils.ExpHandler.*;
import static org.citi.risk.insight.utils.GlobalVariables.*;

public class MicroserviceOps {
	public static String BuildEndPoint(String endPoint) throws Throwable {
		String retEndPoint = endPoint + "?";
		try {
			Connection openConn = OpenDBConn();
			Statement qpStmt = openConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				    ResultSet.CONCUR_READ_ONLY); 
			ResultSet queryParam = qpStmt.executeQuery("SELECT ARG_NAME, ARG_VALUE FROM MICROSERVICE_QUERY_PARAM "
					+ "WHERE ENDPOINT_NAME = '" + endPoint + "'");  
			
			if (!queryParam.next()) {
				retEndPoint = endPoint;
			} else {
				queryParam.beforeFirst();
				while(queryParam.next()) {
					if (queryParam.isLast()) {
						retEndPoint = retEndPoint + queryParam.getString(1) + "=" + queryParam.getString(2);
					} else {
						retEndPoint = retEndPoint + queryParam.getString(1) + "=" + queryParam.getString(2) + "&";
					}
				}
			}
			openConn.close();			
		}catch(Throwable ex) {
			Handle(ex, null);
			ex.printStackTrace();
		}
		return retEndPoint;	
	}
	
	public static Response GET(String endPoint) throws Throwable {
		RestAssured.baseURI = GetProperties("base_uri");
		RequestSpecification getRequest = RestAssured
									   	.given()
									   		.header("Authorization", "Bearer" + accessToken)
									   		.contentType(ContentType.JSON);
		
		Response getResponse = getRequest.get(BuildEndPoint(endPoint));
		return getResponse;
	}
	
	public static Response POST (String endPoint, String tableName) throws Throwable {
		RestAssured.baseURI = GetProperties("base_uri");
		RequestSpecification postRequest = RestAssured
									   		.given()
									   			.header("Authorization", "Bearer" + accessToken)
									   			.contentType(ContentType.JSON);
		
		JSONObject postParam = new JSONObject();
		
		try {
			Connection openConn = OpenDBConn();
			Statement clStmt = openConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				    ResultSet.CONCUR_READ_ONLY); 
			Statement pdStmt = openConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				    ResultSet.CONCUR_READ_ONLY);
			ResultSet colList = clStmt.executeQuery("SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = '" + tableName + "'"); 
			ResultSet postData = pdStmt.executeQuery("SELECT * FROM "+tableName+" WHERE ROWNUM = 1");
			
			ArrayList<String> colNames = new ArrayList<>();
			
			while (colList.next()) {
				colNames.add(colList.getString(1));
			}

			while (postData.next()) {
				for (int i=0;i<colNames.size();i++) {
					postParam.put(colNames.get(i), postData.getString(i+1));
				}
				postRequest.body(postParam.toString());
				System.out.println(postParam.toString());
				Response postResponse = postRequest.post(endPoint);
				return postResponse;
			}
			openConn.close();			
		}catch(Throwable ex) {
			Handle(ex, null);
			ex.printStackTrace();
		}
		return null;
	}
	
	public static Response PUT(String endPoint, String tableName, String putReference) throws Throwable {
		RestAssured.baseURI = GetProperties("base_uri");
		RequestSpecification putRequest = RestAssured
			   						   	.given()
			   						   		.header("Authorization", "Bearer" + accessToken)
			   						   		.contentType(ContentType.JSON);
		
		JSONObject putParam = new JSONObject();
		
		try {
			Connection openConn = OpenDBConn();
			Statement clStmt = openConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				    ResultSet.CONCUR_READ_ONLY); 
			Statement pdStmt = openConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				    ResultSet.CONCUR_READ_ONLY);
			ResultSet colList = clStmt.executeQuery("SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = '" + tableName + "'"); 
			ResultSet putData = pdStmt.executeQuery("SELECT * FROM "+tableName+" WHERE ROWNUM = 1");
			
			ArrayList<String> colNames = new ArrayList<>();
			
			while (colList.next()) {
				colNames.add(colList.getString(1));
			}

			while (putData.next()) {
				for (int i=0;i<colNames.size();i++) {
					putParam.put(colNames.get(i), putData.getString(i+1));
				}
				putRequest.body(putParam.toString());
				System.out.println(putParam.toString());
				Response putResponse = putRequest.put(endPoint + putReference);
				return putResponse;
			}
			openConn.close();			
		}catch(Throwable ex) {
			Handle(ex, null);
			ex.printStackTrace();
		}
		return null;
	}
	
	public static Response DELETE (String endPoint, String delReference) throws Throwable {
		RestAssured.baseURI = GetProperties("base_uri");
		RequestSpecification delRequest = RestAssured
									   	.given()
									   		.header("Authorization", "Bearer" + accessToken)
									   		.contentType(ContentType.JSON);
		
		Response delResponse = delRequest.delete(endPoint + delReference);
		return delResponse;
	}
	
	public static Response PATCH (String endPoint, String tableName, String patchReference) throws Throwable {
		RestAssured.baseURI = GetProperties("base_uri");
		RequestSpecification patchRequest = RestAssured
			   						   	.given()
			   						   		.header("Authorization", "Bearer" + accessToken)
			   						   		.contentType(ContentType.JSON);
		
		JSONObject putParam = new JSONObject();
		
		try {
			Connection openConn = OpenDBConn();
			Statement clStmt = openConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				    ResultSet.CONCUR_READ_ONLY); 
			Statement pdStmt = openConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				    ResultSet.CONCUR_READ_ONLY);
			ResultSet colList = clStmt.executeQuery("SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = '" + tableName + "'"); 
			ResultSet patchData = pdStmt.executeQuery("SELECT * FROM "+tableName+" WHERE ROWNUM = 1");
			
			ArrayList<String> colNames = new ArrayList<>();
			
			while (colList.next()) {
				colNames.add(colList.getString(1));
			}
			
			while (patchData.next()) {
				for (int i=0;i<colNames.size();i++) {
					putParam.put(colNames.get(i), patchData.getString(i+1));
				}
				patchRequest.body(putParam.toString());
				System.out.println(putParam.toString());
				Response patchResponse = patchRequest.patch(endPoint + patchReference);
				return patchResponse;
			}
			openConn.close();			
		}catch(Throwable ex) {
			Handle(ex, null);
			ex.printStackTrace();
		}
		return null;
	}
	
	public static Response UploadFile(String endPoint, String filePath) throws Throwable {
		File fileToUpload = new File(filePath);
        RestAssured.baseURI = GetProperties("base_uri");
 
        RequestSpecification fileUploadRequest = RestAssured
			   	.given()
			   		.header("Authorization", "Bearer" + accessToken)
			   		.contentType(ContentType.JSON)
			   		.multiPart(fileToUpload);

        Response fileUploadResponse = fileUploadRequest.post(endPoint);
        return fileUploadResponse;
	}
}