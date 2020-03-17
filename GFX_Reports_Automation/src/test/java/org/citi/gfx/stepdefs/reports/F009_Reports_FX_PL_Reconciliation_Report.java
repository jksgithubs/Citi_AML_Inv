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

public class F009_Reports_FX_PL_Reconciliation_Report {
	@Given("^Logged into GFX for data val of FX PL Recon report$")
	public void Logged_into_GFX_for_data_val_of_FX_PL_Recon_report() throws Throwable {		
		boolean getReports = getReportsReport.contains("RPT_FXP&LReconciliationReport");
		if(!getReports) {
			throw new SkipException("Skipping the report: RUN_FLAG set as “N”");
	    } else {
	    	Login();
	    }
	}

	@When("^Navigated to FX PL Recon report for data val$")
	public void Navigated_to_FX_PL_Recon_report_for_data_val() throws Throwable {
		MenuSubMenu("mnuMain", "mnuSub");
	}

	@Then("^Validate report data for FX PL Recon report$")
	public void Validate_report_data_for_FX_PL_Recon_report() throws Throwable {
		for (String country:getCountriesReport) {
			SelectFromList("lstCountry",country.split("_")[1]);
			BusinessDate.Select(country);
			for (String currency:getCurrenciesData) {
				SelectFromList("lstCurrency",currency.split("_")[1]);
				
			}
		}
	}
	
	@And("^Logout GFX for FX PL Recon report data val$")
	public void Logout_GFX_for_FX_PL_Recon_report_data_val() throws Throwable {
		Logout();
	}
}