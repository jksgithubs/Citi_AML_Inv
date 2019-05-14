@Features
Feature: Create New Business work group
  Verify Create New Business work group

  @NewBusinessWorkGroup
  Scenario: Create New Business Work Group
    Given In Security Business Work Group
    When New business work group is created
    Then Validate created new business work group
    And Validate values for new business work group