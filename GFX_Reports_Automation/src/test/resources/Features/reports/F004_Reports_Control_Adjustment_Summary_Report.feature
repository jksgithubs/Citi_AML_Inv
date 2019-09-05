@Features
Feature: Report Data Validation for Control Adjustment Summary Report
  Verify report data for Control Adjustment Summary Report

	@ReportDataValidationControlAdjustmentSummary
	Scenario: Report Data Validation for Control Adjustment Summary report
		Given Logged into GFX for data val of Control Adj Summary report
		When Navigated to Control Adj Summary report for data val
		Then Validate report data for Control Adj Summary report
		And Logout GFX for Control Adj Summary report data val