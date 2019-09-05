@Features
Feature: Report Data Validation for Exposure Report
  Verify report data for Exposure Report

	@ReportDataValidationExposureReport
	Scenario: Report Data Validation for Exposure report
		Given Logged into GFX for data val of Exposure Report
		When Navigated to Exposure report for data val
		Then Validate report data for Exposure report
		And Logout GFX for Exposure report data val