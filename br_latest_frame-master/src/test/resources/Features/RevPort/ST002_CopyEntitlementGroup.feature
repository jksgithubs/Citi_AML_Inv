@Features
Feature: Revport Security Copy entitlement group
  Verify copy groups for Admin Global and Admin Revenue

  @CopyEntitlementGroup
  Scenario: Copy Entitlement group
    Given Valid login to Revport application
    When Entitlement group is copied and saved
    Then Verify Entitlement group is created and logout