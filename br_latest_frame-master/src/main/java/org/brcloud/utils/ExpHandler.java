package org.brcloud.utils;

import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.ReadOnlyFileSystemException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.SQLTimeoutException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.safari.ConnectionClosedException;
import org.testng.Assert;
import org.openqa.selenium.NoSuchSessionException;
//import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScriptTimeoutException;
//import org.openqa.selenium.TakesScreenshot;
//import cucumber.api.Scenario;

public class ExpHandler {
	public static String errTrace = "";
	public static void Handle(Throwable getError, WebDriver driver) throws Throwable {	
		AppCheck.sendGET();
		
		if (Constants.getResponseCode==200) {
			for(StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {                         
				errTrace = errTrace + System.lineSeparator() + stackTraceElement.toString();
			}   
						
			if (getError instanceof NullPointerException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace); driver.close(); Assert.fail();
			} else if (getError instanceof ConnectionClosedException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof NoSuchSessionException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace); driver.close(); Assert.fail();
			} else if (getError instanceof NoSuchElementException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof TimeoutException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof ScriptTimeoutException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace); driver.close(); Assert.fail();
			} else if (getError instanceof UnhandledAlertException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof UnreachableBrowserException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace); driver.close(); Assert.fail();
			} else if (getError instanceof WebDriverException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace); driver.close(); Assert.fail();		
			} else if (getError instanceof SQLDataException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof SQLException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof SQLTimeoutException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof SQLSyntaxErrorException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof ReadOnlyFileSystemException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof NoSuchFileException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof InvalidPathException) {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else {
				Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace);  driver.close(); Assert.fail();
			}
		} else {
			Constants.bDriver.quit();
			Constants.getResponseCode=0;
			Logging.Log("Application is unavailable, script execution is terminated!!!");
			Logging.Log(getError.getLocalizedMessage()+" has occured"+errTrace);
			System.exit(0);
		}
	}
}