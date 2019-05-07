package org.brcloud.stepdefs.RevPort;

import org.brcloud.appUtils.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ST001_NewBusinessWorkGroup {
	@Given("^In Security Business Work Group$") //Start: Scenario: Create New Business Work Group
	public void in_Security_Business_Work_Group() throws Throwable {		
		//Login to Revport application
		AppLogInOut.Login("SIT");
	}

	@When("^New business work group is created$")
	public void new_business_work_group_is_created() throws Throwable {
		//Create new Business work group
		BusinessLayer.CreateBWG();
	}

	@Then("^Validate created new business work group$")
	public void validate_created_new_business_work_group() throws Throwable {
		//Validate if Business Work Group is created
		AppAssertions.VerifyBWG();
		BusinessLayer.searchBWGroup.clear();
		AppLogInOut.Logout();
		ErrorHandler.softAssertion.assertAll();
	} //End: Scenario: Create New Business Work Group
}