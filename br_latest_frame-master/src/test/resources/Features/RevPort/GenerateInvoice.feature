@Features
Feature: Generate Invoice
  Verify generate invoice
  
	@GenerateInvoice
	Scenario: Generate Invoice
		Given In Calculation Calculation Group
		And Existing valid ST Calculation group is selected
		And Calculation group has run
		When Link under status column is clicked
		Then Status column is queued or success
		And No error should be displaying
		And Invoice details are displaying correct