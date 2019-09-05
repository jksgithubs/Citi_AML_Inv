package org.citi.gfx.stepdefs.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.SkipException;
import io.cucumber.java.en.And;
import static org.citi.gfx.utils.GlobalVariables.*;
import static org.citi.gfx.apputils.AppAccess.*;
import static org.citi.gfx.utils.Keywords.*;

import org.citi.gfx.apputils.BusinessDate;

import static org.citi.gfx.apputils.MenuNavigation.*;

public class F002_UI_Exposure_Report {
	@Given("^Logged into GFX for ui val of Exposure Report$")
	public void Logged_into_GFX_for_ui_val_of_Exposure_Report() throws Throwable {		
		boolean getReports = getReportsUI.contains("RPT_ExposureReport");
		if(!getReports) {
			throw new SkipException("Skipping the report: RUN_FLAG set as “N”");
	    } else {
	    	Login();
	    }
	}

	@When("^Navigated to Exposure report for ui val$")
	public void Navigated_to_Exposure_report_for_ui_val() throws Throwable {
		MenuSubMenu("mnuMain", "mnuSub");
	}

	@Then("^Validate report ui for Exposure report$")
	public void Validate_report_ui_for_Exposure_report() throws Throwable {
		for (String country:getCountriesUI) {
			SelectFromList("lstCountry",country.split("_")[1]);
			BusinessDate.Select(country);
			for (String currency:getCurrenciesData) {
				SelectFromList("lstCurrency",currency.split("_")[1]);
				
			}
		}
	}
	
	@And("^Logout GFX for Exposure report ui val$")
	public void Logout_GFX_for_Exposure_report_ui_val() throws Throwable {
		Logout();
	}
}