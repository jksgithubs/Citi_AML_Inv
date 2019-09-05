@Features
Feature: Report UI Validation for FX PL Reconciliation Report
  Verify report UI for FX PL Reconciliation Report

	@ReportDataValidationFXPLRecon
	Scenario: Report UI Validation for FX PL Reconciliation Report
		Given Logged into GFX for ui val of FX PL Recon report
		When Navigated to FX PL Recon report for ui val
		Then Validate report ui for FX PL Recon report
		And Logout GFX for FX PL Recon report ui val