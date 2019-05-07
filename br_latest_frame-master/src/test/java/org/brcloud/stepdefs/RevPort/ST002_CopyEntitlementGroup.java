package org.brcloud.stepdefs.RevPort;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.brcloud.appUtils.*;

public class ST002_CopyEntitlementGroup {
	@Given("^Valid login to Revport application$") //Start: Scenario: Copy Admin_Global group
	public void valid_login_to_revport_application() throws Throwable {
		//Login Revport application
		AppLogInOut.Login("SIT");
	}

	@When("^Entitlement group is copied and saved$")
	public void entitlement_group_is_copied_and_saved() throws Throwable {	
		//copy and create entitlement group
		BusinessLayer.CopyEntGroup();
	}

	@Then("^Verify Entitlement group is created and logout$")
	public void verify_entitlement_group_is_created_and_logout() throws Throwable {
		//Validate new Admin_Global group is created, search for the Group
		AppAssertions.VerifyEntGroup();
		BusinessLayer.searchEntGroup.clear();
		AppLogInOut.Logout();
		ErrorHandler.softAssertion.assertAll();
	} //End: Scenario: Copy Admin_Revenue group
}