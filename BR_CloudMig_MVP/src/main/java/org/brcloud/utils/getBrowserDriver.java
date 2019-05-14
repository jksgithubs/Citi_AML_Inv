package org.brcloud.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getBrowserDriver {
	public static WebDriver retBrowserDriver(String getBrowserName){
		WebDriver driver = null;
		
		switch (getBrowserName) {
		case "Chrome": 
			System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;
			
		case "Firefox": 
			System.setProperty("webdriver.chrome.driver","src\\cmnUtils\\chromedriver1.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;

		case "Safari": 
			System.setProperty("webdriver.chrome.driver","D:\\JKs Computer\\@Tools\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;
		}		
		return driver;
	}
}