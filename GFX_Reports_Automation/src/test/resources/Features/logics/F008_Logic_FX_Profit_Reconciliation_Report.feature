@Features
Feature: Validate Data Logic for FX Profit Reconciliation Report
  Verify Data Logic in DB for FX Profit Reconciliation Report

	@ValidateDataLogicForFXProfitReconciliationReport
	Scenario: Data Logic Validation for FX Profit Reconciliation Report
		Given Logged into GFX for FX Profit Reconciliation Report
		When Navigated to FX Profit Reconciliation Report
		Then Validate data logic with DB for FX Profit Reconciliation Report
		And Logout GFX for FX Profit Reconciliation Report