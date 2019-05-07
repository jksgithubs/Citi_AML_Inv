package org.brcloud.stepdefs.RevPort;

import org.brcloud.appUtils.AppAssertions;
import org.brcloud.appUtils.AppLogInOut;
import org.brcloud.appUtils.BusinessLayer;
import org.brcloud.appUtils.MenuNavigation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ST011_CreateStaticList {
	@Given("^In static list static data$") //Start: Scenario: New Data Source
	public void in_static_list_static_data() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubSubMenu("lblSystem", "lblStaticData", "lblStaticList");
	}

	@When("^New data source is created$")
	public void new_data_source_is_created() throws Throwable {
		BusinessLayer.CreateStaticList();
	}

	@Then("^Validate created static list and logout$")
	public void validate_created_static_data() throws Throwable {
		AppAssertions.VerifyStaticList();
		BusinessLayer.searchStaticList.clear();
		AppLogInOut.Logout();
	} //End: Scenario: New Data Source
}
