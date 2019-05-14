@Features
Feature: Create new users
  Verify create new users

	@CreateNewUser
	Scenario: Create New Users
		Given In Security Users
		When New user created
		Then Validate created new user
		And Validate values for new user