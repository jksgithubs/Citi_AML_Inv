package org.citi.runners;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
 
@CucumberOptions(
		features="src/test/resources/features/AMLInvestigations",
		glue={"org.citi.stepdefs.AMLInvestigations"},
		plugin= {"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/re-run.txt"}
		)

public class Runner_AMLInvestigation  
{
	public static WebDriver driver;
	private TestNGCucumberRunner testRunner;
	
	@BeforeClass
	public void setUP()
	{
		testRunner = new TestNGCucumberRunner(Runner_AMLInvestigation.class);
	}
	@Test(description="RevPort",dataProvider="features")
	public void RevPort(CucumberFeatureWrapper cFeature)
	{
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}
	@DataProvider(name="features")
	public Object[][] getFeatures()
	{
		return testRunner.provideFeatures();
	}
	@AfterClass
	public void tearDown()
	{
		testRunner.finish();
	}
}