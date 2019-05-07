@Features
Feature: Different Accural Calculations
  Verify Different Accural calculations

	@AccuralCalculation
	Scenario: Accural Calculation
		Given Biller Group Member is logged in
		When Accural link is clicked
		Then Single Accural calculation is shown