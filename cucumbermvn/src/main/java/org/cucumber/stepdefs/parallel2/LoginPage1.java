package org.cucumber.stepdefs.parallel2;

import org.cucumber.tests.OpenMRSTests1;
import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 
 
public class LoginPage1  
{
	@Given("^Open Application and Enter url$")
	public void open_Application_and_Enter_url() throws Throwable {
	  OpenMRSTests1.driver1.get("https://demo.openmrs.org/openmrs/login.htm");
	  
	}
 
	@When("^enter username$")
	public void enter_username() throws Throwable {
		OpenMRSTests1.driver1.findElement(By.id("username")).sendKeys("Admin");
	}
 
	@And("^enter password$")
	public void enter_password() throws Throwable {
		OpenMRSTests1.driver1.findElement(By.id("password")).sendKeys("Admin123");
		OpenMRSTests1.driver1.findElement(By.id("Inpatient Ward")).click();
		OpenMRSTests1.driver1.findElement(By.id("loginButton")).click();
	}
 
	@Then("^verify Msg$")
	public void verify_Msg() throws Throwable {
	   boolean result =  OpenMRSTests1.driver1.findElement(By.tagName("h4")).getText().contains("Logged");
	   Assert.assertTrue(result);
	}
}
