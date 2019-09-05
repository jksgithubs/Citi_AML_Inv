@Features
Feature: Validate Data Logic for LTD Exposure Summary Report
  Verify Data Logic in DB for LTD Exposure Summary Report

	@ValidateDataLogicForLTDExposureSummaryReport
	Scenario: Data Logic Validation for LTD Exposure Summary Report
		Given Logged into GFX for LTD Exposure Summary Report
		When Navigated to LTD Exposure Summary Report
		Then Validate data logic with DB for LTD Exposure Summary Report
		And Logout GFX for LTD Exposure Summary Report