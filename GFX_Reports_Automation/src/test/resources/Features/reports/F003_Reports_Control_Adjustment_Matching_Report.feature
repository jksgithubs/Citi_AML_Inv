@Features
Feature: Report Data Validation for Control Adjustment Matching Report
  Verify report data for Control Adjustment Matching Report

	@ReportDataValidationControlAdjustmentMatching
	Scenario: Report Data Validation for Control Adjustment Matching report
		Given Logged into GFX for data val of Control Adj Matching report
		When Navigated to Control Adj Matching report for data val
		Then Validate report data for Control Adj Matching report
		And Logout GFX for Control Adj Matching report data val