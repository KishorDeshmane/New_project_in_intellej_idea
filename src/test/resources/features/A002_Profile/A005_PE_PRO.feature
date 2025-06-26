@TS_PRO_PE
Feature: Partner executive profile

  Background:
    Given User is on the Partner admin login page
    When Partner executive Login with Valid Credentials
    And Partner executive Profile Page is loaded

  @TC_PRO_PE_001 @retry
  Scenario: Verify Partner executive Profile Page Loads Correctly
    Then Partner executive Profile Page should load successfully

  @TC_PRO_PE_002 @retry
  Scenario: Verify all Partner executive Profile Fields are Displayed
    Then All Partner executive required profile fields should be visible