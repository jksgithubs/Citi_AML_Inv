package org.brcloud.stepdefs.test;

import org.openqa.selenium.Keys;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.brcloud.appUtils.*;
import org.brcloud.utils.*;
import org.brcloud.resources.*;

public class pocFeatureStep {
	@Given("^Angular.org is displaying$")
	public void angular_org_is_displaying() throws Throwable {
		pubConstants.bDriver = openUrl.openBrowser(getProperties.retPropertyValue("browser"));
		openUrl.openHome("urlAngular", pubConstants.bDriver);
		pubConstants.expTitle = "AngularJS — Superheroic JavaScript MVW Framework";
	}
    
    @Then("^Interact with ng-model$")
    public void interact_with_ng_model() throws Throwable {    	
    	getTestData.retTestData(sqlReference.interact_with_ng_model);
    	
    	while (pubConstants.dataResultSet.next()) {
    		for (int loopRS = 1; loopRS <= pubConstants.colNum; loopRS++) {
    			pubConstants.rootSelector = "[app-run=\"hello.html\"]";
    	    	actionKeywords.actSendKeys("ng-model", "txtEnterYourName", pubConstants.bDriver, 
    	    			pubConstants.dataResultSet.getString(1));
    	    	Thread.sleep(1000);
    	    	actionKeywords.actAssertEquals("ng-model", "txtEnterYourName", pubConstants.bDriver, 
    	    			pubConstants.dataResultSet.getString(1));
    	    	System.out.println(pubConstants.dataResultSet.getString(1));
    		}	
		}
    	pubConstants.dbConn.close();
    	pubConstants.dataResultSet.close();
    }
    
    @And("^Validate Entered Name$")
    public void validate_entered_name() throws Throwable{ 	
		pubConstants.rootSelector = "[app-run=\"hello.html\"]";
		//actionKeywords.actAssertEquals("ng-model", "txtEnterYourName", pubConstants.bDriver, "Selenium");
    }
    
	@Given("^google.com is displaying$")
	public void google_com_is_displaying() throws Throwable {
		openUrl.openHome("urlHome", pubConstants.bDriver);
		pubConstants.expTitle = "Google";
	}
    
    @When("^Validate title of the page$")
    public void validate_title_of_the_page() throws Throwable{   
    	actionKeywords.actVerifyPageTitle(pubConstants.bDriver, pubConstants.expTitle);
    }
    	        
    @Then("^Interact with non-angular locator$")
    public void interact_with_non_angular_locator() throws Throwable{    	
    	actionKeywords.actSendKeys("name", "txtSearch", pubConstants.bDriver, "Protractor");
    	actionKeywords.actKeys("name", "txtSearch", pubConstants.bDriver, Keys.ESCAPE);
    	actionKeywords.actKeys("name", "txtSearch", pubConstants.bDriver, Keys.ENTER);

    	pubConstants.expTitle = "Protractor - Google Search";
    }  
    
    @And("^quit the browser$")
    public void quit_the_browser() throws Throwable{    	
    	pubConstants.bDriver.quit();
    }  
}