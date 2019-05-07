@Features
Feature: Create new calendar
  Verify create new calendar
  
	@CreateNewCalendar
	Scenario: Create Calendar
		Given In Calendars
		When New calendar is created
		Then Validate created calendar and logout