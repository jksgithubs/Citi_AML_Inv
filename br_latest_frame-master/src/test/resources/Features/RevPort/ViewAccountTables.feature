@Features
Feature: Viewing the Accounting Tables
  Verify viewing the Accounting Tables
  
	@ViewAccountingTables
	Scenario: View Accounting Tables
		Given In Invoices General Ledger General Ledger
		And Existing General Ledger is seached
		When Export to excel and review is clicked
		Then Validate rows displayinf post export