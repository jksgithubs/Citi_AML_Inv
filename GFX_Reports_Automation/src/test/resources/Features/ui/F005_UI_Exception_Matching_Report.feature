@Features
Feature: Report UI Validation for Exception Matching Report
  Verify report ui for Exception Matching Report

	@UIValidationExceptionMatching
	Scenario: Report UI Validation for Exception Matching report
		Given Logged into GFX for ui val of Exception Matching report
		When Navigated to Exception Matching report for ui val
		Then Validate report ui for Exception Matching report
		And Logout GFX for Exception Matching report ui val