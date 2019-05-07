package org.brcloud.stepdefs.RevPort;

import org.brcloud.appUtils.AppAssertions;
import org.brcloud.appUtils.AppLogInOut;
import org.brcloud.appUtils.BusinessLayer;
import org.brcloud.appUtils.MenuNavigation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ST009_CreateHolidayCalendar {
	@Given("^In Holiday Calendar$") //Start: Scenario: Create New Holiday Calendar
	public void in_Holiday_Calendar() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubSubMenu("lblSystem", "lblCalendars", "lblHolidayCalendar");
	}

	@When("^New holiday calendar is created$")
	public void new_holiday_calendar_is_created() throws Throwable {
		BusinessLayer.CreateHolidayCalendar();
	}

	@Then("^Validate created holiday calendar and logout$")
	public void validate_created_holiday_calendar() throws Throwable {
		AppAssertions.VerifyHolidayCalendar();
		BusinessLayer.searchHolidayCalendar.clear();
		AppLogInOut.Logout();
	} //End: Scenario: Create New Holiday Calendar
}
