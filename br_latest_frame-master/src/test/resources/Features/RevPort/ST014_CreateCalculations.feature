@Features
Feature: Create new workflow group
  Verify create new workflow group for Biller and Approver
  
	@CreateNewFeeSchedule
	Scenario: Create new fee schedule
		Given In calculations Fee Schedules
		When New fee schedule is created
		Then Validate created fee schedule and logout

	@CreateNewCalculationRules
	Scenario: Create new calculation rules
		Given In calculations rules
		When New calculation rule is created
		Then Validate created calculation rule and logout

	@CreateNewCalculationGroup
	Scenario: Create new calculation group
		Given In calculations calculation group
		When New calculation group is created
		Then Validate created calculation group and logout

	@CreateNewCalculationRecord
	Scenario: Create new calculation record
		Given In calculations calculation records
		When New calculation record is created
		Then Validate created calculation record and logout