@Features
Feature: Report UI Validation for Control Adjustment Summary Report
  Verify report ui for Control Adjustment Summary Report

	@UIValidationControlAdjustmentSummary
	Scenario: Report UI Validation for Control Adjustment Summary report
		Given Logged into GFX for ui val of Control Adj Summary report
		When Navigated to Control Adj Summary report for ui val
		Then Validate report ui for Control Adj Summary report
		And Logout GFX for Control Adj Summary report ui val