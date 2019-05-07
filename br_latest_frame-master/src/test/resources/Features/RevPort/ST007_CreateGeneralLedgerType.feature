@Features
Feature: Create New General Ledger Type
  Verify create New General Ledger Type
  
	@CreateNewGeneralLedgerType
	Scenario: Create General Ledger Type
		Given In General Ledger type
		When New Four General Ledger types are created
		Then Validate created General Ledger Type and logout