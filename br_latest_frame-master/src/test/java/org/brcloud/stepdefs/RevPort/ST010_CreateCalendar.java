package org.brcloud.stepdefs.RevPort;

import org.brcloud.appUtils.AppAssertions;
import org.brcloud.appUtils.AppLogInOut;
import org.brcloud.appUtils.BusinessLayer;
import org.brcloud.appUtils.MenuNavigation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ST010_CreateCalendar {
	@Given("^In Calendars$") //Start: Scenario: Create Calendar
	public void in_Calendars() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubSubMenu("lblSystem", "lblCalendars", "lblNewCalendars");
	}

	@When("^New calendar is created$")
	public void new_calendar_is_created() throws Throwable {
		BusinessLayer.CreateCalendar();
	}

	@Then("^Validate created calendar and logout$")
	public void validate_created_calendar() throws Throwable {
		AppAssertions.VerifyCalendar();
		BusinessLayer.searchCalendar.clear();
		AppLogInOut.Logout();
	} //End: Scenario: Create Calendar
}