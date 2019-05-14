@Features
Feature: Different Accural Calculations
  Verify Different Accural calculations

	@AccuralCalculation
	Scenario: Accural Calculation
		Given Biller Group Member is logged in
		And In Calculations Calculation group
		And ST Calculation group is run
		And Next cycle columns are correctly populated
		And No error in calculation record
		When Accural link is clicked
		Then Single Accural calculation is shown

	@AccuralPost
	Scenario: Accural Post
		Given Biller Group Member is logged in
		And In Calculations Calculation group
		And ST Calculation group is run
		And No error in calculation record
		When Accural link is clicked
		Then Posted column is current date
	
	@AccuralUnPost
	Scenario: Accural Un-post
		Given Biller Group Member is logged in
		And Accural calculation is done
		And Accural post is done
		And ST Calculation group is run
		And No error in calculation record
		When Accural link is clicked
		Then Posted column is empty

	@AccuralReCalculation
	Scenario: Accural Re-Calculation
		Given Biller Group Member is logged in
		And Unposted accural is selected
		And ST Calculation group is run
		And No error in calculation record
		When Accural link is clicked
		Then Single Accural calculation is shown
	
	@AccuralAdjustment
	Scenario: Accural Adjustment
		Given Biller Group Member is logged in
		And Posted accural is selected
		And Accural Adjustment is added
		When Accural Adjustment is applied
		Then Adjustment is added to table

	@AccuralFinalRecalculation
	Scenario: Accural Final Calculation
		Given Biller Group Member is logged in
		And Un-Posted and adjusted accural is selected
		And Accural is posted
		And Another Accural is added
		And Accural is posted
		When Accural link is clicked
		Then Posted column is current date
		And Validate accural details breakdown 