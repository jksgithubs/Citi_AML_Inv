package org.brcloud.stepdefs.RevPort;

import org.brcloud.appUtils.AppAssertions;
import org.brcloud.appUtils.AppLogInOut;
import org.brcloud.appUtils.BusinessLayer;
import org.brcloud.appUtils.MenuNavigation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ST013_CreateMarketValue {
	@Given("^In data market values$") //Start: Scenario: Create New Market Value
	public void in_data_market_values() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubMenu("lblData", "lblMarketValues");
	}

	@When("^New market value is created$")
	public void new_market_value_is_created() throws Throwable {
		BusinessLayer.CreateMarketValue();
	}

	@Then("^Validate created market value and logout$")
	public void validate_created_market_value() throws Throwable {
		AppAssertions.VerifyMarketValue();
		BusinessLayer.searchAccountID.clear();
		BusinessLayer.searchLocalAmount.clear();
		AppLogInOut.Logout();
	} //End: Scenario: Create New Market Value
}
