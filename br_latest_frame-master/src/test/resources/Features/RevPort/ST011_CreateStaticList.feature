@Features
Feature: Create new static data list
  Create new Data Source, Bank Name, Business Unit, Phone, Client, Contact, Portfolio Types
  
	@CreateNewStaticList
	Scenario: Create new Static List
		Given In static list static data
		When New data source is created
		Then Validate created static list and logout