@Features
Feature: Create new workflow group
  Verify create new workflow group for Biller and Approver
  
	@CreateNewBillerGroup
	Scenario: Create New Biller Group
		Given In Workflow group
		When New Biller group is created
		Then Validate created workflow
		And Validate values for new workflow
 
	@CreateNewApproverGroup
	Scenario: Create New Approver Group
		Given In Workflow group
		When New Approver group is created
		Then Validate created workflow
		And Validate values for new workflow