@Features
Feature: Different Accrual Calculations
  Verify Different Accrual calculations

	@AccrualCalculation
	Scenario: Accrual Calculation
		Given Biller Group Member is logged in
		And In Calculations Calculation group
		And ST Calculation group is run
		And Next cycle columns are correctly populated
		And No error in calculation record
		When Accrual link is clicked
		Then Single Accrual calculation is shown

	@AccrualPost
	Scenario: Accrual Post
		Given Biller Group Member is logged in
		And In Calculations Calculation group
		And ST Calculation group is run
		And No error in calculation record
		When Accrual link is clicked
		Then Posted column is current date
	
	@AccrualUnPost
	Scenario: Accrual Un-post
		Given Biller Group Member is logged in
		And Accrual calculation is done
		And Accrual post is done
		And ST Calculation group is run
		And No error in calculation record
		When Accrual link is clicked
		Then Posted column is empty

	@AccrualReCalculation
	Scenario: Accrual Re-Calculation
		Given Biller Group Member is logged in
		And Unposted accrual is selected
		And ST Calculation group is run
		And No error in calculation record
		When Accrual link is clicked
		Then Single Accrual calculation is shown
	
	@AccrualAdjustment
	Scenario: Accrual Adjustment
		Given Biller Group Member is logged in
		And Posted accrual is selected
		And Accrual Adjustment is added
		When Accrual Adjustment is applied
		Then Adjustment is added to table

	@AccrualFinalRecalculation
	Scenario: Accrual Final Calculation
		Given Biller Group Member is logged in
		And Un-Posted and adjusted accrual is selected
		And Accrual is posted
		And Another Accrual is added
		And Accrual is posted
		When Accrual link is clicked
		Then Posted column is current date
		And Validate accrual details breakdown 