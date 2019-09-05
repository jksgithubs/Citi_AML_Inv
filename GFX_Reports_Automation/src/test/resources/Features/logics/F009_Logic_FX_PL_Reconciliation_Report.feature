@Features
Feature: Validate Data Logic for FX PL Reconciliation Report
  Verify Data Logic in DB for FX PL Reconciliation Report

	@ValidateDataLogicForFXPLReconciliationReport
	Scenario: Data Logic Validation for FX PL Reconciliation Report
		Given Logged into GFX for FX PL Reconciliation Report
		When Navigated to FX PL Reconciliation Report
		Then Validate data logic with DB for FX PL Reconciliation Report
		And Logout GFX for FX PL Reconciliation Report