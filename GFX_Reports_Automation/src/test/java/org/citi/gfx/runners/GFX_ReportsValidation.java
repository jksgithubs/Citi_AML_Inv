package org.citi.gfx.runners;

import static org.citi.gfx.utils.GlobalVariables.*;
import org.citi.gfx.utils.GetController;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
		features="src/test/resources/features/reports",
		glue={"org.citi.gfx.stepdefs.reports"},
		plugin= {"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/re-run.txt"}
		)

public class GFX_ReportsValidation {
	//public static WebDriver driver;
	private TestNGCucumberRunner reportsRunner;
	
	@BeforeClass
	public void setUP() throws Throwable {
		reportsRunner = new TestNGCucumberRunner(GFX_ReportsValidation.class);
		getReportsReport = GetController.GetReportList();
		getCountriesReport = GetController.GetCountryList();
		getCurrenciesReport = GetController.GetCurrencyList();
		//System.out.println("GFX_ReportsValidation Report List: "+getReportsReport);
		//System.out.println("GFX_ReportsValidation Country List: "+getCountriesReport);
		//System.out.println("GFX_ReportsValidation Currency List: "+getCurrenciesReport);		
	}
	@Test(description="GFX_Reports_Validation",dataProvider="scenarios")
	public void GFX_ReportValidation(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cFeature) throws Throwable {
		reportsRunner.runScenario(pickleEvent.getPickleEvent());
	}
	@DataProvider(name="scenarios")
	public Object[][] getFeatures() {
		return reportsRunner.provideScenarios();
	}
	@AfterClass
	public void tearDown() throws Throwable {
		reportsRunner.finish();
	}
}