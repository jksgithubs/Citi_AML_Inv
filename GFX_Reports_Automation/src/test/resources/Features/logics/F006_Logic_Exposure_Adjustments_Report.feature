@Features
Feature: Validate Data Logic for Exposure Adjustments Report
  Verify Data Logic in DB for Exposure Adjustments Report

	@ValidateDataLogicForExposureAdjustmentReport
	Scenario: Data Logic Validation for Exposure Adjustments Report
		Given Logged into GFX for Exposure Adjustments Report
		When Navigated to Exposure Adjustments Report
		Then Validate data logic with DB for Exposure Adjustments Report
		And Logout GFX for Exposure Adjustments Report