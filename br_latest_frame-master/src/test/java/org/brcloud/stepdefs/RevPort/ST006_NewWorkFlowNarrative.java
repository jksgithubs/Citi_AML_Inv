package org.brcloud.stepdefs.RevPort;

import org.brcloud.appUtils.AppAssertions;
import org.brcloud.appUtils.AppLogInOut;
import org.brcloud.appUtils.BusinessLayer;
import org.brcloud.appUtils.MenuNavigation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ST006_NewWorkFlowNarrative {
	@Given("^In Workflow narrative$") //Start: Scenario: New workflow narrative
	public void in_Workflow_narrative() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubSubMenu("lblSystem", "lstWorkFlowSetUp", "lstWorkFlowNarrative");
	}

	@When("^New narrative and rules are created$")
	public void new_narrative_and_rules_are_created() throws Throwable {
		BusinessLayer.CreateWorkflowNarrative();
	}

	@Then("^Validate created workflow narrative and logout$")
	public void validate_created_workflow_narrative() throws Throwable {
		AppAssertions.VerifyWorkflowNarrative();
		BusinessLayer.searchWorkflowNarrativeName.clear();
		AppLogInOut.Logout();
	} //End: Scenario: New workflow narrative
}
