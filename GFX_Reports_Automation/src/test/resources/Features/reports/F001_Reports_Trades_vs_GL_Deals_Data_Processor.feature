@Features
Feature: Report Data Validation for Trades vs GL Deals and Data Processor
  Verify report data for Trades vs GL Deals and Data Processor

	@ReportDataValidationTradesVsGLDeals
	Scenario: Report Data Validation for Trades vs GL Deals
		Given Logged into GFX for data val of Trades vs GL Deals
		When Navigated to Trades vs GL Deals report
		Then Validate report data for Trades vs GL Deals report
		And Logout GFX for Trades vs GL Deals report