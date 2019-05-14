@Features
Feature: Validation of Angular and Non-Angular Interactions
  Verify Angular and Non-Angular interactions

  @ValidateAngularInteraction
  Scenario: Interact with Angular Controls
    Given Angular.org is displaying
    When Validate title of the page
    Then Interact with ng-model
    And Validate Entered Name
    
  @ValidateNonAngularInteraction
  Scenario: Interact with non-Angular Controls
    Given google.com is displaying
    When Validate title of the page
    Then Interact with non-angular locator
    And Validate title of the page
    And quit the browser