@Features
Feature: Create New Fee Type
  Verify create New Fee Type
  
	@CreateNewFeeType
	Scenario: Create new Fee Type
		Given In Fee types
		When New Fee types are created
		Then Search for created Fee Types