package org.brcloud.stepdefs.RevPort;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ST015_AccrualCalculations {
	@Given("^Biller Group Member is logged in$") //Start: Scenario: Accrual Calculation
	public void biller_Group_Member_is_logged_in() throws Throwable {
		//Logging.Log("error Log");
		
	}
	
	@And("^In Calculations Calculation group$")
	public void in_Calculations_Calculation_group() throws Throwable {

	}
	
	@And("^ST Calculation group is run$")
	public void st_Calculation_group_is_run() throws Throwable {

	}
	
	@And("^Next cycle columns are correctly populated$")
	public void next_cycle_columns_are_correctly_populated() throws Throwable {

	}
	
	@And("^No error in calculation record$")
	public void no_error_in_calculation_record() throws Throwable {

	}
	
	@When("^Accrual link is clicked$")
	public void accural_link_is_clicked() throws Throwable {

	}
	
	@Then("^Single Accrual calculation is shown$")
	public void single_Accural_calculation_is_shown() throws Throwable {

	} //End: Scenario: Accrual Calculation
	
	@Then("^Posted column is current date$") //Start: Scenario: Accrual Post
	public void posted_column_is_current_date() throws Throwable {

	} //End: Scenario: Accrual Post
	
	@And("^Accrual calculation is done$") //Start: Scenario: Accrual Un-post
	public void accrual_calculation_is_done() throws Throwable {

	}

	@And("^Accrual post is done$")
	public void accrual_post_is_done() throws Throwable {

	}

	@Then("^Posted column is empty$")
	public void posted_column_is_empty() throws Throwable {

	} //End: Scenario: Accrual Un-post
	
	@And("^Unposted accrual is selected$") //Start: Scenario: Accrual Re-Calculation
	public void unposted_accrual_is_selected() throws Throwable {

	} //End: Scenario: Accrual Re-Calculation
	
	@And("^Posted accrual is selected$") //Start: Scenario: Accrual Adjustment
	public void posted_accrual_is_selected() throws Throwable {

	}

	@And("^Accrual Adjustment is added$")
	public void accrual_Adjustment_is_added() throws Throwable {

	}

	@When("^Accrual Adjustment is applied$")
	public void accrual_Adjustment_is_applied() throws Throwable {

	}

	@Then("^Adjustment is added to table$")
	public void adjustment_is_added_to_table() throws Throwable {

	} //End: Scenario: Accrual Adjustment
	
	@And("^Un-Posted and adjusted accrual is selected$") //Start: Scenario: Accrual Final Calculation
	public void un_Posted_and_adjusted_accrual_is_selected() throws Throwable {

	}

	@And("^Accrual is posted$")
	public void accrual_is_posted() throws Throwable {

	}

	@And("^Another Accrual is added$")
	public void another_accrual_is_added() throws Throwable {

	}

	@Then("^Validate accrual details breakdown$")
	public void validate_accrual_details_breakdown() throws Throwable {

	} //End: Scenario: Accrual Final Calculation
}
