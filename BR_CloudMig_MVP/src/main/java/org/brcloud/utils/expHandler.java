package org.brcloud.utils;

import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.ReadOnlyFileSystemException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.SQLTimeoutException;
//import org.junit.Assert;
//import org.junit.ComparisonFailure;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.safari.ConnectionClosedException;
import org.testng.Assert;
//import org.testng.AssertJUnit;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.ScriptTimeoutException;

public class expHandler {
	public static String errTrace = "";
	public static void cmnExpHandler(Throwable getError, WebDriver driver) throws Throwable {	
		appAvailabilityCheck.sendGET();
		
		if (pubConstants.getResponseCode==200) {
			for(StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {                         
				errTrace = errTrace + System.lineSeparator() + stackTraceElement.toString();
			}   
						
			if (getError instanceof NullPointerException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace); driver.close(); Assert.fail();
			} else if (getError instanceof ConnectionClosedException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof NoSuchSessionException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace); driver.close(); Assert.fail();
			} else if (getError instanceof NoSuchElementException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof TimeoutException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof ScriptTimeoutException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace); driver.close(); Assert.fail();
			} else if (getError instanceof UnhandledAlertException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof UnreachableBrowserException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace); driver.close(); Assert.fail();
			} else if (getError instanceof WebDriverException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace); driver.close(); Assert.fail();		
			} /*else if (getError instanceof ComparisonFailure) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace);
			}*/ else if (getError instanceof SQLDataException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof SQLException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof SQLTimeoutException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof SQLSyntaxErrorException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof ReadOnlyFileSystemException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof NoSuchFileException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else if (getError instanceof InvalidPathException) {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace);
			} else {
				logger.log(getError.getLocalizedMessage()+" has occured"+errTrace);
			}
		} else {
			pubConstants.bDriver.quit();
			pubConstants.getResponseCode=0;
			logger.log("Application is unavailable, script execution is terminated!!!");
			logger.log(getError.getLocalizedMessage()+" has occured"+errTrace);
			System.exit(0);
		}
	}
}