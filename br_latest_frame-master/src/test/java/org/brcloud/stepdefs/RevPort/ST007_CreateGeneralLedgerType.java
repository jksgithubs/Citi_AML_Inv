package org.brcloud.stepdefs.RevPort;

import org.brcloud.appUtils.AppAssertions;
import org.brcloud.appUtils.AppLogInOut;
import org.brcloud.appUtils.BusinessLayer;
import org.brcloud.appUtils.MenuNavigation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ST007_CreateGeneralLedgerType {
	@Given("^In General Ledger type$") //Start: Scenario: Create General Ledger Type
	public void in_General_Ledger_type() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubSubMenu("lblSystem", "lblFeeType", "lblGeneralLedgerTypes");
	}

	@When("^New Four General Ledger types are created$")
	public void new_Four_General_Ledger_types_are_created() throws Throwable {
		BusinessLayer.CreateGeneralLedgerType();
	}

	@Then("^Validate created General Ledger Type and logout$")
	public void search_for_created_General_Ledger_Type() throws Throwable {
		AppAssertions.VerifyGeneralLedgerType();
		BusinessLayer.searchGeneralLedgerType.clear();
		AppLogInOut.Logout();
	} //End: Scenario: Create General Ledger Type
}
