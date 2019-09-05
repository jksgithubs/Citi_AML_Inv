@Features
Feature: Validate Data Logic for Control Adjustment Matching Report
  Verify Data Logic in DB for Control Adjustment Matching Report

	@ValidateDataLogicForControlAdjustmentMarchingReport
	Scenario: Data Logic Validation for Control Adjustment Matching Report
		Given Logged into GFX for Control Adjustment Matching Report
		When Navigated to Control Adjustment Matching Report
		Then Validate data logic with DB for Control Adjustment Matching Report
		And Logout GFX for Control Adjustment Matching Report