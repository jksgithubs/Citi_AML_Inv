@Features
Feature: Report UI Validation for Combined Exception Report
  Verify report UI for Combined Exception Report

	@UIValidationFXPLRecon
	Scenario: Report UI Validation for Combined Exception Report
		Given Logged into GFX for ui val of Combined Exception report
		When Navigated to Combined Exception report for ui val
		Then Validate report ui for Combined Exception report
		And Logout GFX for Combined Exception report ui val