package org.brcloud.stepdefs.RevPort;

import org.brcloud.appUtils.AppAssertions;
import org.brcloud.appUtils.AppLogInOut;
import org.brcloud.appUtils.BusinessLayer;
import org.brcloud.appUtils.MenuNavigation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ST012_CreateHierarchy {
	@Given("^In hierarchy contact$") //Start: Scenario: Create New Contact
	public void in_hierarchy_contact() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubMenu("lblHierarchy", "lblHierarchyContact");
	}

	@When("^New contact is created$")
	public void new_contact_is_created() throws Throwable {
		BusinessLayer.CreateHierarchyContact();
	}

	@Then("^Validate created contact and logout$")
	public void validate_created_contact() throws Throwable {
		AppAssertions.VerifyHierarchyContact();
		BusinessLayer.searchHierarchyContact.clear();
		AppLogInOut.Logout();
	} //End: Scenario: Create New Contact

	@Given("^In hierarchy firm client$") //Start: Scenario: Create New Client
	public void in_hierarchy_firm_client() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubSubMenu("lblHierarchy", "lblFirms", "lblClient");
	}

	@When("^New client is created$")
	public void new_client_is_created() throws Throwable {
		BusinessLayer.CreateHierarchyClient();
	}

	@Then("^Validate created client and logout$")
	public void validate_created_client() throws Throwable {
		AppAssertions.VerifyHierarchyClient();
		BusinessLayer.searchHierarchyClient.clear();
		AppLogInOut.Logout();
	} //End: Scenario: Create New Client

	@Given("^In hierarchy remit client$") //Start: Scenario: Create New Remit Client
	public void in_hierarchy_remit_client() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubMenu("lblHierarchy", "lblRemitClient");
	}

	@When("^New remit client is created$")
	public void new_remit_client_is_created() throws Throwable {
		BusinessLayer.CreateHierarchyRemitClient();
	}

	@Then("^Validate created remit client and logout$")
	public void validate_created_remit_client() throws Throwable {
		AppAssertions.VerifyHierarchyRemitClient();
		BusinessLayer.searchHierarchyRemitClient.clear();
		AppLogInOut.Logout();
	} //End: Scenario: Create New Remit Client

	@Given("^In hierarchy accounts portfolio$") //Start: Scenario: Create New Portfolio
	public void in_hierarchy_accounts_portfolio() throws Throwable {
		AppLogInOut.Login("SIT");
		MenuNavigation.MenuSubSubMenu("lblHierarchy", "lblAccounts", "lblPortfolio");
	}

	@When("^New portfolio is created$")
	public void new_portfolio_is_created() throws Throwable {
		BusinessLayer.CreatePortfolio();
	}

	@Then("^Validate created portfolio and logout$")
	public void validate_created_portfolio() throws Throwable {
		AppAssertions.VerifyHierarchyRemitClient();
		BusinessLayer.searchPortfolioID.clear();
		AppLogInOut.Logout();
	} //End: Scenario: Create New Portfolio
}