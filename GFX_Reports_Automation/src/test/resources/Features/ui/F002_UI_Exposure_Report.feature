@Features
Feature: Report UI Validation for Exposure Report
  Verify report ui for Exposure Report

	@UIValidationExposureReport
	Scenario: Report UI Validation for Exposure report
		Given Logged into GFX for ui val of Exposure Report
		When Navigated to Exposure report for ui val
		Then Validate report ui for Exposure report
		And Logout GFX for Exposure report ui val