@Features
Feature: Report UI Validation for LTD Exposure Summary Report
  Verify report UI for LTD Exposure Summary Report

	@UIValidationLTDExposureSummary
	Scenario: Report UI Validation for LTD Exposure Summary Report
		Given Logged into GFX for ui val of LTD Exposure Sum report
		When Navigated to LTD Exposure Sum report for ui val
		Then Validate report ui for LTD Exposure Sum report
		And Logout GFX for LTD Exposure Sum report ui val