@Features
Feature: Report UI Validation for Trades vs GL Deals and Data Processor
  Verify report ui for Trades vs GL Deals and Data Processor

	@UIValidationTradesVsGLDeals
	Scenario: UI Validation for Trades vs GL Deals
		Given Logged into GFX for ui val of Trades vs GL Deals
		When Navigated to Trades vs GL Deals report for ui val
		Then Validate ui for Trades vs GL Deals report
		And Logout GFX for Trades vs GL Deals report for ui val