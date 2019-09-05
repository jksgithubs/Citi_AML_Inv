@Features
Feature: Report Data Validation for LTD Exposure Summary Report
  Verify report data for LTD Exposure Summary Report

	@ReportDataValidationLTDExposureSummary
	Scenario: Report Data Validation for LTD Exposure Summary Report
		Given Logged into GFX for data val of LTD Exposure Sum report
		When Navigated to LTD Exposure Sum report for data val
		Then Validate report data for LTD Exposure Sum report
		And Logout GFX for LTD Exposure Sum report data val