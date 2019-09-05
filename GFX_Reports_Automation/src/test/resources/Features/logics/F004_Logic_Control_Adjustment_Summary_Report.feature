@Features
Feature: Validate Data Logic for Control Adjustment Summary Report
  Verify Data Logic in DB for Control Adjustment Summary Report

	@ValidateDataLogicForControlAdjustmentSummaryReport
	Scenario: Data Logic Validation for Control Adjustment Summary Report
		Given Logged into GFX for Control Adjustment Summary Report
		When Navigated to Control Adjustment Summary Report
		Then Validate data logic with DB for Control Adjustment Summary Report
		And Logout GFX for Control Adjustment Summary Report