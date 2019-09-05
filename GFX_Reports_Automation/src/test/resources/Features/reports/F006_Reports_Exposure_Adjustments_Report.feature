@Features
Feature: Report Data Validation for Exposure Adjustment Report
  Verify report data for Exposure Adjustment Report

	@ReportDataValidationExposureAdjustment
	Scenario: Report Data Validation for Exposure Adjustment report
		Given Logged into GFX for data val of Exposure Adj report
		When Navigated to Exposure Adj report for data val
		Then Validate report data for Exposure Adj report
		And Logout GFX for Exposure Adj report data val