@TS_PRO_PE_001
Feature: Partner executive profile

  Background:
    Given User is on the Partner admin login page
    When Partner executive Login with Valid Credentials
    And Partner executive Profile Page is loaded

  @TC_PRO_PE_001
  Scenario: Verify Partner executive Profile Page Loads Correctly
    Then Partner executive Profile Page should load successfully

  @TC_PRO_PE_002
  Scenario: Verify all Partner executive Profile Fields are Displayed
    Then All Partner executive required profile fields should be visible