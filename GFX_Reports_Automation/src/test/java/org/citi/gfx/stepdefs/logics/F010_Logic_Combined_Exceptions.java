package org.citi.gfx.stepdefs.logics;

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

public class F010_Logic_Combined_Exceptions {
	@Given("^Logged into GFX for Combined Exceptions$")
	public void Logged_into_GFX_for_Combined_Exceptions() throws Throwable {		
		boolean getReports = getReportsData.contains("RPT_CombinedExceptions");
		if(!getReports) {
			throw new SkipException("Skipping the report: RUN_FLAG set as “N”");
	    } else {
	    	Login();
	    }
	}

	@When("^Navigated to Combined Exceptions$")
	public void Navigated_to_Combined_Exceptions() throws Throwable {
		MenuSubMenu("mnuMain", "mnuSub");
	}

	@Then("^Validate data logic with DB for Combined Exceptions$")
	public void Validate_data_logic_with_DB_for_Combined_Exceptions() throws Throwable {
		for (String country:getCountriesData) {
			SelectFromList("lstCountry",country.split("_")[1]);
			BusinessDate.Select(country);
			for (String currency:getCurrenciesData) {
				SelectFromList("lstCurrency",currency.split("_")[1]);
				
			}
		}
	}
	
	@And("^Logout GFX for Combined Exceptions$")
	public void Logout_GFX_for_Combined_Exceptions() throws Throwable {
		Logout();
	}
}