package org.citi.risk.insight.stepdefs;

import org.citi.risk.insight.utils.*;
import org.openqa.selenium.By;
//import static org.citi.risk.insight.utils.Keywords.*;
//import org.citi.risk.insight.utils.MicroserviceOps;
//import org.testng.Assert;
//import static org.hamcrest.Matchers.hasItems;
import static org.citi.risk.insight.utils.GlobalVariables.*;
//import java.util.ArrayList;
import java.util.NoSuchElementException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static org.citi.risk.insight.utils.DataFromDB.*;
//import java.io.File;
//import java.io.FileInputStream;
//import org.apache.jmeter.engine.StandardJMeterEngine;
//import org.apache.jmeter.reporters.ResultCollector;
//import org.apache.jmeter.reporters.Summariser;
//import org.apache.jmeter.save.SaveService;
//import org.apache.jmeter.util.JMeterUtils;
//import org.apache.jorphan.collections.HashTree;
import io.restassured.response.Response;
import io.cucumber.java.en.Given;

public class Audit {
	@Given("^Audit HTML Page is displaying$")
	public void audit_html_page_is_displaying() throws Throwable {
		try {
			/*cDriver = GetDriver.Get(GetProperties("browser"));
			cDriver.get("https://www.google.com/");
			cDriver.findElement(By.name("q")).sendKeys("Test");
			cDriver.quit();*/
			
			/*int indexOfSpace = 0;
			int nextIndexOfSpace = 0;
			 
			String sentence  = "This is a sentence ";
			 
			int lastIndexOfSpace = sentence.lastIndexOf(" ");
			while(indexOfSpace != lastIndexOfSpace){
			    nextIndexOfSpace = sentence.indexOf(" ",indexOfSpace);  
			    String word = sentence.substring(indexOfSpace,nextIndexOfSpace);
			    System.out.println("Word: " + word + " Length: " + word.length());
			    indexOfSpace = nextIndexOfSpace;
			}
			 
			String lastWord = sentence.substring(lastIndexOfSpace);
			System.out.println("Word: " + lastWord + " Length: " + lastWord.length());*/
			
			/*String str = "Hey this is Ram";
			String [] words = str.split(" ");
	 
			for (String word : words)
				System.out.println(word);*/
			
			//int senti_op = 10;
			//int senti_score = 23;
			
			/*ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            //String exp = "some double value" + senti_op + senti_score;
            String exp = "print('Hello, World')";
            
            try {
                //System.out.println(engine.eval(exp));
            	engine.eval(exp);
            } catch (ScriptException e) {
                e.printStackTrace();
            }*/
			
			try {
				ScriptEngineManager sem = new ScriptEngineManager();
	            ScriptEngine se = sem.getEngineByName("JavaScript");
	            String myExpression = "('abc' == 'abc' && 'thy' == 'thy') || ('ujys' == 'ujy')";
	            System.out.println("Eval: " + se.eval(myExpression));
	        } catch (ScriptException e) {
	            System.out.println("Invalid Expression");
	            e.printStackTrace();
	        }
			
		}catch (Throwable ex){
			String excepS = ex.getClass().getSimpleName();
			System.out.println("Exception Code: "+ excepS);
			//String[] lists = ex.getClass().getName().split(".");
			//ex.printStackTrace();
			//ex.getCause();
			//System.out.println("Exception Code: "+ lists);
			//cDriver.quit();
		}
		
		//System.out.println("Print: "+cDriver.findElement(By.name("q")).getAttribute("name"));
		//SendKeys("txtSearch","Test");
		//cDriver.quit();

		//Response getResponse = MicroserviceOps.GET("http://api.openweathermap.org","/data/2.5/weather");
		Response postResponse = MicroserviceOps.POST("/register","POST_PARAM_REGISTER");
		//Response putResponse = MicroserviceOps.PUT("/update/","PUT_PARAM","15410");
		//Response delResponse = MicroserviceOps.DELETE("/delete/", "15410");
		
		//MicroserviceOps.DownloadFile();
		
		//int statusCode = delResponse.getStatusCode();
		//System.out.println("Status Code: "+statusCode);
		//Assert.assertEquals(statusCode, 200);
		//String successCode = delResponse.jsonPath().get("SuccessCode");
		//System.out.println("Success Code: "+successCode);
		//Assert.assertEquals(successCode, null);
		
		//System.out.println("POST String: "+postResponse.asString());
	}
}