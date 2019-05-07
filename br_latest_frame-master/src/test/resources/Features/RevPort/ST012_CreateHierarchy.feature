@Features
Feature: Create new Hierarchy account
  Verify create new Hierarchy account
  
	@CreateNewContact
	Scenario: Create New Contact
		Given In hierarchy contact
		When New contact is created
		Then Validate created contact and logout

	@CreateNewClient
	Scenario: Create New Client
		Given In hierarchy firm client
		When New client is created
		Then Validate created client and logout

	@CreateNewRemitClient
	Scenario: Create New Remit Client
		Given In hierarchy remit client
		When New remit client is created
		Then Validate created remit client and logout

	@CreateNewPortfolio
	Scenario: Create New Portfolio
		Given In hierarchy accounts portfolio
		When New portfolio is created
		Then Validate created portfolio and logout