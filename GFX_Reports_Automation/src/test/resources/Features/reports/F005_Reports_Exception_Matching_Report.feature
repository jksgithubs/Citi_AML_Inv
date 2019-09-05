@Features
Feature: Report Data Validation for Exception Matching Report
  Verify report data for Exception Matching Report

	@ReportDataValidationExceptionMatching
	Scenario: Report Data Validation for Exception Matching report
		Given Logged into GFX for data val of Exception Matching report
		When Navigated to Exception Matching report for data val
		Then Validate report data for Exception Matching report
		And Logout GFX for Exception Matching report data val