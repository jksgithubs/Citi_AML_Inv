@Features
Feature: Create new Hierarchy account
  Verify create new Hierarchy account
  
	@CreateNewContact
	Scenario: Create New Contact
		Given In hierarchy contact
		When New contact is created
		Then Validate created contact
		And Validate values for new contact

	@CreateNewClient
	Scenario: Create New Client
		Given In hierarchy firm client
		When New client is created
		Then Validate created client
		And Validate values for new client

	@CreateNewRemitClient
	Scenario: Create New Remit Client
		Given In hierarchy remit client
		When New remit client is created
		Then Validate created remit client
		And Validate values for new remit client

	@CreateNewPortfolio
	Scenario: Create New Portfolio
		Given In hierarchy accounts portfolio
		When New portfolio is created
		Then Validate created portfolio
		And Validate values for new portfolio