package org.brcloud.tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.java.After;
 
@CucumberOptions(
		features="src/test/resources/features/test",
		glue={"org.brcloud.stepdefs.test"},
		plugin= {"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/re-run.txt"}
		)

public class SampleTests {
	public static WebDriver driver;
	private TestNGCucumberRunner testRunner;
	
	@BeforeClass
	public void setUP(){
		testRunner = new TestNGCucumberRunner(SampleTests.class);
	}
	@Test(description="OpenMRS",dataProvider="features")
	public void OpenMRS(CucumberFeatureWrapper cFeature){
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}
	@DataProvider(name="features")
	public Object[][] getFeatures(){
		return testRunner.provideFeatures();
	}
	@AfterClass
	public void tearDown(){
		testRunner.finish();
		//System.out.println("TD");
	}
	
	/*@After
	public void tearDown1(Scenario scenario) {
		//testRunner.finish();
		System.out.println("TD1");
		
		if (scenario.isFailed()) {	    	
	    	// Take a screenshot...
	    	final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    	scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
	    }
	}*/
	
	/*@AfterMethod
	public void tearDown1(Scenario scenario) {
		//testRunner.finish();
		System.out.println("TD1");
		
		if (scenario.isFailed()) {	    	
	    	// Take a screenshot...
	    	final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    	scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
	    }
	}*/
}