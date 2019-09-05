@Features
Feature: Validate Data Logic for Exposure Report
  Verify Data Logic in DB for Exposure Report

	@ValidateDataLogicForExposureReport
	Scenario: Data Logic Validation for Exposure Report
		Given Logged into GFX for Exposure Report
		When Navigated to Exposure Report
		Then Validate data logic with DB for Exposure Report
		And Logout GFX for Exposure Report