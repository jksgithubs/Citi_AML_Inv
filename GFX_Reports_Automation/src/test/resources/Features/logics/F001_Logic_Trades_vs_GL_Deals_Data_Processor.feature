@Features
Feature: Validate Data Logic for Trades vs GL Deals and Data Processor
  Verify Data Logic in DB for Trades vs GL Deals and Data Processor

	@ValidateDataLogicForTradesGLDealsAndDataProcessor
	Scenario: Data Logic Validation for Trades vs GL Deals and Data Processor
		Given Logged into GFX for Trades vs GL Deals and Data Processor
		When Navigated to Trades vs GL Deals and Data Processor report
		Then Validate data logic with DB for Trades vs GL Deals and Data Processor
		And Logout GFX for Trades vs GL Deals and Data Processor