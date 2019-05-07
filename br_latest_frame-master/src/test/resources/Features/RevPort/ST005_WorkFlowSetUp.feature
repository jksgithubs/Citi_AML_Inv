@Features
Feature: Setup workflow orders
  Verify Setup workflow orders
  
	@SetUpWorkFlow
	Scenario: Workflow set up
		Given In Workflow setup
		When Workflows are added and saved
		Then Validate workflow setup and logout