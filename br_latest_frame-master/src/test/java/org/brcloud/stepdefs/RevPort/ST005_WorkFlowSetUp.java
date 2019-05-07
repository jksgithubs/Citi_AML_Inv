package org.brcloud.stepdefs.RevPort;

import org.brcloud.appUtils.AppAssertions;
import org.brcloud.appUtils.AppLogInOut;
import org.brcloud.appUtils.BusinessLayer;
import org.brcloud.appUtils.MenuNavigation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ST005_WorkFlowSetUp {
	@Given("^In Workflow setup$") //Start: Scenario: Workflow set up
	public void in_Workflow_setup() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubSubMenu("lblSystem", "lstWorkFlowSetUp", "lstWorkFlow");
	}

	@When("^Workflows are added and saved$")
	public void workflows_are_added_and_saved() throws Throwable {
		BusinessLayer.SetupWorkFlow();
	}

	@Then("^Validate workflow setup and logout$")
	public void validate_workflow_setup() throws Throwable {
		AppAssertions.VerifySetupWorkflow();
		BusinessLayer.searchWorkflowGroup.clear();
		AppLogInOut.Logout();
	} //End: Scenario: Workflow set up
}