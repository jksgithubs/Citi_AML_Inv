@Features
Feature: Report UI Validation for FX Profit Reconciliation Report
  Verify report UI for FX Profit Reconciliation Report

	@UIValidationFXProfitRecon
	Scenario: Report UI Validation for FX Profit Reconciliation Report
		Given Logged into GFX for ui val of FX Profit Recon report
		When Navigated to FX Profit Recon report for ui val
		Then Validate report ui for FX Profit Recon report
		And Logout GFX for FX Profit Recon report ui val