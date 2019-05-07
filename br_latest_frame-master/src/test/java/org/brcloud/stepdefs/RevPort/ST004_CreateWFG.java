package org.brcloud.stepdefs.RevPort;

import org.brcloud.appUtils.AppAssertions;
import org.brcloud.appUtils.AppLogInOut;
import org.brcloud.appUtils.BusinessLayer;
import org.brcloud.appUtils.MenuNavigation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ST004_CreateWFG {
	@Given("^In Workflow group$") //Start: Scenario: Create New Biller and Approver Group
	public void in_Workflow_group() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubSubMenu("lblSystem", "lstWorkFlowSetUp", "lstWorkFlowGroup");
	}

	@When("^New group is created$")
	public void new_group_is_created() throws Throwable {
		BusinessLayer.CreateWorkFlowGroup();
	}

	@Then("^Validate created workflow and logout$")
	public void validate_created_workflow() throws Throwable {
		AppAssertions.VerifyWorkflowGroup();
		BusinessLayer.searchWorkflowGroup.clear();
		AppLogInOut.Logout();
	} //End: Scenario: Create New Biller and Approver Group
}
