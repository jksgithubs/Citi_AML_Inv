package org.brcloud.stepdefs.RevPort;

import org.brcloud.appUtils.AppAssertions;
import org.brcloud.appUtils.AppLogInOut;
import org.brcloud.appUtils.BusinessLayer;
import org.brcloud.appUtils.MenuNavigation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ST014_CreateCalculations {
	@Given("^In calculations Fee Schedules$") //Start: Scenario: Create new fee schedule
	public void in_calculations_Fee_Schedules() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubMenu("lblCalculations", "lblFeeSchedules");
	}

	@When("^New fee schedule is created$")
	public void new_fee_schedule_is_created() throws Throwable {
		BusinessLayer.CreateFeeSchedule();
	}

	@Then("^Validate created fee schedule and logout$")
	public void validate_created_fee_schedule() throws Throwable {
		AppAssertions.VerifyFeeSchedule();
		BusinessLayer.searchFeeSchedule.clear();
		AppLogInOut.Logout();
	} //End: Scenario: Create new fee schedule

	@Given("^In calculations rules$") //Start: Scenario: Create new calculation rules
	public void in_calculations_rules() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubSubMenu("lblCalculations", "lblRules", "lblNewRules");
	}

	@When("^New calculation rule is created$")
	public void new_calculation_rule_is_created() throws Throwable {
		BusinessLayer.CreateCalcRules();
	}

	@Then("^Validate created calculation rule and logout$")
	public void validate_created_calculation_rule() throws Throwable {
		AppAssertions.VerifyCalcRules();
		BusinessLayer.searchCalcRules.clear();
		AppLogInOut.Logout();
	} //End: Scenario: Create new calculation rules

	@Given("^In calculations calculation group$") // Start: Scenario: Create new calculation group
	public void in_calculations_calculation_group() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubMenu("lblCalculations", "lblCalculationGroups");
	}

	@When("^New calculation group is created$")
	public void new_calculation_group_is_created() throws Throwable {
		BusinessLayer.CreateCalculationGroup();
	}

	@Then("^Validate created calculation group and logout$")
	public void validate_created_calculation_group() throws Throwable {
		AppAssertions.VerifyCalculationGroup();
		BusinessLayer.searchCalculationGroup.clear();
		AppLogInOut.Logout();
	} // End: Scenario: Create new calculation group

	@Given("^In calculations calculation records$") //Start: Scenario: Create new calculation record
	public void in_calculations_calculation_records() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubMenu("lblCalculations", "lblCalculationRecords");
	}

	@When("^New calculation record is created$")
	public void new_calculation_record_is_created() throws Throwable {
		BusinessLayer.CreateCalculationRecord();
	}

	@Then("^Validate created calculation record and logout$")
	public void validate_created_calculation_record() throws Throwable {
		AppAssertions.VerifyCalculationRecord();
		BusinessLayer.searchCalculationRecord.clear();
		AppLogInOut.Logout();
	} //End: Scenario: Create new calculation record
}