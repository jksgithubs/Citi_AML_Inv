@Features
Feature: Validate Data Logic for Combined Exceptions
  Verify Data Logic in DB for Combined Exceptions

	@ValidateDataLogicForCombinedExceptions
	Scenario: Data Logic Validation for Combined Exceptions
		Given Logged into GFX for Combined Exceptions
		When Navigated to Combined Exceptions
		Then Validate data logic with DB for Combined Exceptions
		And Logout GFX for Combined Exceptions