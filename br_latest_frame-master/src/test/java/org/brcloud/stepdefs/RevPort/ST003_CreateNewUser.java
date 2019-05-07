package org.brcloud.stepdefs.RevPort;

import org.brcloud.appUtils.AppAssertions;
import org.brcloud.appUtils.AppLogInOut;
import org.brcloud.appUtils.BusinessLayer;
import org.brcloud.appUtils.MenuNavigation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ST003_CreateNewUser {
	@Given("^In Security Users$") //Start: Scenario: Create New Users
	public void in_Security_Users() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubMenu("lblSecurity", "lblUsers");
	}

	@When("^New user created$")
	public void new_user_created() throws Throwable {
		BusinessLayer.CreateUser();
	}

	@Then("^Validate created new user and logout$")
	public void validate_created_new_user() throws Throwable {
		AppAssertions.VerifyUser();
		BusinessLayer.searchUser.clear();
		AppLogInOut.Logout();
	} //End: Scenario: Create New Users
}