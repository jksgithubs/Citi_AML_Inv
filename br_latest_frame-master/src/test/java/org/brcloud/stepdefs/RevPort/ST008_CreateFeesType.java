package org.brcloud.stepdefs.RevPort;

import org.brcloud.appUtils.AppAssertions;
import org.brcloud.appUtils.AppLogInOut;
import org.brcloud.appUtils.BusinessLayer;
import org.brcloud.appUtils.MenuNavigation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ST008_CreateFeesType {
	@Given("^In Fee types$") //Start: Scenario: Create new Fee Type
	public void in_Fee_types() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubSubMenu("lblSystem", "lblFeeType", "lblFeeTypes");
	}

	@When("^New Fee types are created$")
	public void new_Fee_types_are_created() throws Throwable {
		BusinessLayer.CreateFeeType();
	}

	@Then("^Validate created Fee Types and logout$")
	public void search_for_created_Fee_Types() throws Throwable {
		AppAssertions.VerifyFeeType();
		BusinessLayer.searchFeeType.clear();
		AppLogInOut.Logout();
	} //End: Scenario: Create new Fee Type
}
