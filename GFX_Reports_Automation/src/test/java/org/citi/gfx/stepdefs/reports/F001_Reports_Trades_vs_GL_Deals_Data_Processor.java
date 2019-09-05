package org.citi.gfx.stepdefs.reports;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.SkipException;
import io.cucumber.java.en.And;
import static org.citi.gfx.utils.GlobalVariables.*;
import static org.citi.gfx.utils.Keywords.*;

import org.citi.gfx.apputils.BusinessDate;

import static org.citi.gfx.apputils.MenuNavigation.*;
import static org.citi.gfx.apputils.AppAccess.*;

public class F001_Reports_Trades_vs_GL_Deals_Data_Processor {
	@Given("^Logged into GFX for data val of Trades vs GL Deals$")
	public void Logged_into_GFX_for_data_val_of_Trades_vs_GL_Deals() throws Throwable {		
		boolean getReports = getReportsReport.contains("RPT_TradesvsGLDealsAndDataProcessor");
		if(!getReports) {
			throw new SkipException("Skipping the report: RUN_FLAG set as “N”");
	    } else {
	    	Login();
	    }
	}

	@When("^Navigated to Trades vs GL Deals report$")
	public void Navigated_to_Trades_vs_GL_Deals_report() throws Throwable {
		MenuSubMenu("mnuMain", "mnuSub");
	}

	@Then("^Validate report data for Trades vs GL Deals report$")
	public void Validate_report_data_for_Trades_vs_GL_Deals_report() throws Throwable {
		for (String country:getCountriesReport) {
			SelectFromList("lstCountry",country.split("_")[1]);
			BusinessDate.Select(country);
			for (String currency:getCurrenciesData) {
				SelectFromList("lstCurrency",currency.split("_")[1]);
				
			}
		}
	}
	
	@And("^Logout GFX for Trades vs GL Deals report$")
	public void Logout_GFX_for_Trades_vs_GL_Deals_report() throws Throwable {
		Logout();
	}
}