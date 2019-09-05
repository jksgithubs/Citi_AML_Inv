package org.citi.gfx.stepdefs.logics;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.citi.gfx.apputils.BusinessDate;
import org.testng.SkipException;
import io.cucumber.java.en.And;
import static org.citi.gfx.utils.GlobalVariables.*;
import static org.citi.gfx.apputils.AppAccess.*;
import static org.citi.gfx.apputils.MenuNavigation.*;
import static org.citi.gfx.utils.Keywords.*;

public class F001_Logic_Trades_vs_GL_Deals_Data_Processor {	
	@Given("^Logged into GFX for Trades vs GL Deals and Data Processor$")
	public void Logged_into_GFX_for_Trades_vs_GL_Deals_and_Data_Processor() throws Throwable {
		boolean getReports = getReportsData.contains("RPT_TradesvsGLDealsAndDataProcessor");
		if(!getReports) {
			throw new SkipException("Skipping the report: RUN_FLAG set as “N”");
	    } else {
	    	Login();
	    }	
	}
	
	@When("^Navigated to Trades vs GL Deals and Data Processor report$")
	public void Navigated_to_Trades_vs_GL_Deals_and_Data_Processor_report() throws Throwable {
		MenuSubMenu("mnuMain", "mnuSub");
	}

	@Then("^Validate data logic with DB for Trades vs GL Deals and Data Processor$")
	public void Validate_data_logic_with_DB_for_Trades_vs_GL_Deals_and_Data_Processor() throws Throwable {
		for (String country:getCountriesData) {
			SelectFromList("lstCountry",country.split("_")[1]);
			BusinessDate.Select(country);
			for (String currency:getCurrenciesData) {
				SelectFromList("lstCurrency",currency.split("_")[1]);
				
			}
		}
	}
	
	@And("^Logout GFX for Trades vs GL Deals and Data Processor$")
	public void Logout_GFX_for_Trades_vs_GL_Deals_and_Data_Processor() throws Throwable {
		Logout();
	}
}