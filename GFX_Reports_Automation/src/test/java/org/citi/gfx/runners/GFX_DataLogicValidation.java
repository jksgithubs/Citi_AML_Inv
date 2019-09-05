package org.citi.gfx.runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.citi.gfx.utils.*;
import static org.citi.gfx.utils.GlobalVariables.*;

@CucumberOptions(
		features="src/test/resources/features/logics",
		glue={"org.citi.gfx.stepdefs.logics"}
		)

public class GFX_DataLogicValidation {
	//public static WebDriver driver;
	private TestNGCucumberRunner logicRunner;
	
	@BeforeClass
	public void setUP() throws Throwable {
		logicRunner = new TestNGCucumberRunner(GFX_DataLogicValidation.class);
		getReportsData = GetController.GetReportList();
		getCountriesData = GetController.GetCountryList();
		getCurrenciesData = GetController.GetCurrencyList();
		//System.out.println("GFX_DataLogicValidation Report List: "+getReportsData);
		//System.out.println("GFX_DataLogicValidation Country List: "+getCountriesData);
		//System.out.println("GFX_DataLogicValidation Currency List: "+getCurrenciesData);
	}
	@Test(description="GFX_Reports_Logic_Validation",dataProvider="scenarios")
	public void GFX_DataValidation(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cFeature) throws Throwable {
		logicRunner.runScenario(pickleEvent.getPickleEvent());
	}
	@DataProvider(name="scenarios")
	public Object[][] getScenarios() {
		return logicRunner.provideScenarios();
	}
	
	@AfterClass
	public void tearDown() throws Throwable {
		logicRunner.finish();
	}
}