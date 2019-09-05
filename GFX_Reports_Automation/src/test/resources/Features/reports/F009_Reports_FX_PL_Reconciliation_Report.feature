@Features
Feature: Report Data Validation for FX PL Reconciliation Report
  Verify report data for FX PL Reconciliation Report

	@ReportDataValidationFXPLRecon
	Scenario: Report Data Validation for FX PL Reconciliation Report
		Given Logged into GFX for data val of FX PL Recon report
		When Navigated to FX PL Recon report for data val
		Then Validate report data for FX PL Recon report
		And Logout GFX for FX PL Recon report data val