@Features
Feature: Google Home Page title validation
  Verify the title in google home page

  @Scenario1
  Scenario: Interact with Angular Controls
    Given Angular.org is displaying
    When Validate title of the page
    Then Interact with ng-model
    And Validate the header
    
  @Scenario2
  Scenario: Interact with non-Angular Controls
    Given google.com is displaying
    When Validate title of the page
    Then Interact with non ng-model and search for Protracor
    And Validate title of the page