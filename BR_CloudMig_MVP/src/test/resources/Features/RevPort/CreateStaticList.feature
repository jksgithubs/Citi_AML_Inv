@Features
Feature: Create new static data list
  Verify create new static data list
  
	@CreateNewDataSource
	Scenario: New Data Source
		Given In static list static data
		When New data source is created
		Then Validate created static data
		And Validate values for new static data

	@CreateNewBankName
	Scenario: New Bank Name
		Given In static list static data
		When New bank name is created
		Then Validate created static data
		And Validate values for new static data

	@CreateNewPhoneType
	Scenario: New Phone Type
		Given In static list static data
		When New phone type is created
		Then Validate created static data
		And Validate values for new static data

	@CreateNewClientType
	Scenario: New Client Type
		Given In static list static data
		When New client type is created
		Then Validate created static data
		And Validate values for new static data

	@CreateNewBusinessUnit
	Scenario: New Business Unit
		Given In static list static data
		When New business unit is created
		Then Validate created static data
		And Validate values for new static data

	@CreateNewPortfolioType
	Scenario: New Portfolio Type
		Given In static list static data
		When New portfolio type is created
		Then Validate created static data
		And Validate values for new static data

	@CreateNewContactType
	Scenario: New Contact Type
		Given In static list static data
		When New contact type is created
		Then Validate created static data
		And Validate values for new static data