@Features
Feature: Create new market value
  Verify create new market value
  
	@CreateNewMarketValue
	Scenario: Create New Market Value
		Given In data market values
		When New market value is created
		Then Validate created market value