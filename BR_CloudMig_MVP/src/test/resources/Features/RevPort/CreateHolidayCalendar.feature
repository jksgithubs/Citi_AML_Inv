@Features
Feature: Create new holiday calendar
  Verify create new holiday calendar
  
	@CreateNewHolidayCalendar
	Scenario: Create New Holiday Calendar
		Given In Holiday Calendar
		When New holiday calendar is created
		Then Validate created holiday calendar