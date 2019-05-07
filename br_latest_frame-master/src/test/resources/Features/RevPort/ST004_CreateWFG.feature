@Features
Feature: Create new workflow group
  Verify create new workflow group for Biller and Approver
  
	@CreateNewWorkFlowGroup
	Scenario: Create New Biller and Approver Group
		Given In Workflow group
		When New group is created
		Then Validate created workflow and logout