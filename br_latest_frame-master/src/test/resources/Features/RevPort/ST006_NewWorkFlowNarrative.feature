@Features
Feature: Create new workflow narrative
  Verify create new workflow narrative
  
	@NewWorkflowNarrative
	Scenario: New workflow narrative
		Given In Workflow narrative
		When New narrative and rules are created
		Then Validate created workflow narrative and logout