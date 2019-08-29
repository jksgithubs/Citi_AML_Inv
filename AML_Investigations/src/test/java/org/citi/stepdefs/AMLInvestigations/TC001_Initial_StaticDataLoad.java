package org.citi.stepdefs.AMLInvestigations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import org.citi.appUtils.*;
//import org.citi.utils.DataFromDB;
import org.citi.utils.GetDriver;
import org.citi.utils.OpenUrl;
import org.citi.utils.PubVariables;
//import org.openqa.selenium.By;
//import static org.citi.utils.PubVariables.*;
import static org.citi.utils.ReadProperties.*;

public class TC001_Initial_StaticDataLoad {
	@Given("^Biller Group Member is logged in$") //Start: Scenario: Create New Business Work Group
	public void in_Security_Business_Work_Group() throws Throwable {		
		//Login to Revport application
		//AppAccess.Login();
		
		System.out.println(GetLocator("browser"));
		System.out.println(GetLocator("url"));
		
		//Open browser
		PubVariables.bDriver = GetDriver.Get(GetLocator("browser"));
		
		//Open URL
		OpenUrl.Open(GetLocator("url"));
		
		//bDriver.get(GetLocator("url"));
	}

	@When("^Accural link is clicked$")
	public void new_business_work_group_is_created() throws Throwable {
		//Create new Business work group
		//BusinessLayer.CreateBWG();
	}

	@Then("^Single Accural calculation is shown$")
	public void validate_created_new_business_work_group() throws Throwable {
		//Validate if Business Work Group is created
		//AppAssertions.VerifyBWG();
		//BusinessLayer.searchBWGroup.clear();
		//AppAccess.Logout();
		//ErrorHandler.softAssertion.assertAll();
	} //End: Scenario: Create New Business Work Group
}