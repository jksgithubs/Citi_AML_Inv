@Features
Feature: Validate Data Logic for Exception Matching Report
  Verify Data Logic in DB for Exception Matching Report

	@ValidateDataLogicForExceptionMatchingReport
	Scenario: Data Logic Validation for Exception Matching Report
		Given Logged into GFX for Exception Matching Report
		When Navigated to Exception Matching Report
		Then Validate data logic with DB for Exception Matching Report
		And Logout GFX for Exception Matching Report