@Features
Feature: Report UI Validation for Control Adjustment Matching Report
  Verify report ui for Control Adjustment Matching Report

	@UIValidationControlAdjustmentMatching
	Scenario: Report UI Validation for Control Adjustment Matching report
		Given Logged into GFX for ui val of Control Adj Matching report
		When Navigated to Control Adj Matching report for ui val
		Then Validate report ui for Control Adj Matching report
		And Logout GFX for Control Adj Matching report ui val