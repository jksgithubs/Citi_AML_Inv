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
		features="src/test/resources/features/ui",
		glue={"org.citi.gfx.stepdefs.ui"},
		plugin= {"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/re-run.txt"}
		)

public class GFX_UIValidation {
	//public static WebDriver driver;
	private TestNGCucumberRunner uiRunner;
	
	@BeforeClass
	public void setUP() throws Throwable {
		uiRunner = new TestNGCucumberRunner(GFX_UIValidation.class);
		getReportsUI = GetController.GetReportList();
		getCountriesUI = GetController.GetCountryList();
		getCurrenciesUI = GetController.GetCurrencyList();
		//System.out.println("GFX_UIValidation Report List: "+getReportsUI);
		//System.out.println("GFX_UIValidation Country List: "+getCountriesUI);
		//System.out.println("GFX_UIValidation Currency List: "+getCurrenciesUI);
	}
	@Test(description="GFX_Reports_UI_Validation",dataProvider="scenarios")
	public void GFX_UI_Validation(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cFeature) throws Throwable {
		uiRunner.runScenario(pickleEvent.getPickleEvent());
	}
	@DataProvider(name="scenarios")
	public Object[][] getFeatures() {
		return uiRunner.provideScenarios();
	}
	@AfterClass
	public void tearDown() throws Throwable {
		uiRunner.finish();
	}
}