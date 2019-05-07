@Features
Feature: Posting an invoice
  Verify posting an invoice
  
	@PostingAnInvoice
	Scenario: Posting an Invoice
		Given Approved group owner is logged in
		And In Invoices Invoices
		And Existing created invoice is selected
		When Invoice link is clicked
		And Invoice is finalized
		Then Invoice status is mailed
		And Generate invoice link is displayed