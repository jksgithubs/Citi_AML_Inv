@Features
Feature: Revport Security Copy group
  Verify copy groups for Admin Global and Admin Revenue

  @AdminGlobalCopyGroup
  Scenario: Copy Admin_Global group
    Given In Security/Groups search
    When Admin_Global is copied and saved
    Then New group is created
    And Search for created Admin_Global group

  @AdminRevenueCopyGroup
  Scenario: Copy Admin_Revenue group
    Given In Security/Groups search
    When Admin_Revenue is copied and saved
    Then New group is created
    And Search for created Admin_Revenus group