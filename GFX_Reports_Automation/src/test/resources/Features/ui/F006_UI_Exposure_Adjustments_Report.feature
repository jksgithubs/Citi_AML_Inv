@Features
Feature: Report UI Validation for Exposure Adjustment Report
  Verify report ui for Exposure Adjustment Report

	@UIValidationExposureAdjustment
	Scenario: Report UI Validation for Exposure Adjustment report
		Given Logged into GFX for ui val of Exposure Adj report
		When Navigated to Exposure Adj report for ui val
		Then Validate report ui for Exposure Adj report
		And Logout GFX for Exposure Adj report ui val