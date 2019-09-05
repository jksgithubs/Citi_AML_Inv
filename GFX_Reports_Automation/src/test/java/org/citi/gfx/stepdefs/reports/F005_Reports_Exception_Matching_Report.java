package org.citi.gfx.stepdefs.reports;

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

public class F005_Reports_Exception_Matching_Report {
	@Given("^Logged into GFX for data val of Exception Matching report$")
	public void Logged_into_GFX_for_data_val_of_Exception_Matching_report() throws Throwable {		
		boolean getReports = getReportsReport.contains("RPT_ExceptionMatchingReport");
		if(!getReports) {
			throw new SkipException("Skipping the report: RUN_FLAG set as “N”");
	    } else {
	    	Login();
	    }
	}

	@When("^Navigated to Exception Matching report for data val$")
	public void Navigated_to_Exception_Matching_report_for_data_val() throws Throwable {
		MenuSubMenu("mnuMain", "mnuSub");
	}

	@Then("^Validate report data for Exception Matching report$")
	public void Validate_report_data_for_Exception_Matching_report() throws Throwable {
		for (String country:getCountriesReport) {
			SelectFromList("lstCountry",country.split("_")[1]);
			BusinessDate.Select(country);
			for (String currency:getCurrenciesData) {
				SelectFromList("lstCurrency",currency.split("_")[1]);
				
			}
		}
	}
	
	@And("^Logout GFX for Exception Matching report data val$")
	public void Logout_GFX_for_Exception_Matching_report_data_val() throws Throwable {
		Logout();
	}
}