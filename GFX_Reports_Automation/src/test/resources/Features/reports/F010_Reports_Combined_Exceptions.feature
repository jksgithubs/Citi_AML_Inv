@Features
Feature: Report Data Validation for Combined Exception Report
  Verify report data for Combined Exception Report

	@ReportDataValidationFXPLRecon
	Scenario: Report Data Validation for Combined Exception Report
		Given Logged into GFX for data val of Combined Exception report
		When Navigated to Combined Exception report for data val
		Then Validate report data for Combined Exception report
		And Logout GFX for Combined Exception report data val