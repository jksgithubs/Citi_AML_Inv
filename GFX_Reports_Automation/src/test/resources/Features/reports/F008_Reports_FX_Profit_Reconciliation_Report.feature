@Features
Feature: Report Data Validation for FX Profit Reconciliation Report
  Verify report data for FX Profit Reconciliation Report

	@ReportDataValidationFXProfitRecon
	Scenario: Report Data Validation for FX Profit Reconciliation Report
		Given Logged into GFX for data val of FX Profit Recon report
		When Navigated to FX Profit Recon report for data val
		Then Validate report data for FX Profit Recon report
		And Logout GFX for FX Profit Recon report data val