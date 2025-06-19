@TS_PRO_PA_001
Feature: Partner admin profile

  Background:
    Given User is on the Partner admin login page
    When Partner Admin Login with Valid Credentials
    And Partner admin Profile Page is loaded

  @TC_PRO_PA_001
  Scenario: Verify Partner admin Profile Page Loads Correctly
    Then Partner admin Profile Page should load successfully

  @TC_PRO_PA_002
  Scenario: Verify all Partner admin Profile Fields are Displayed
    Then All Partner admin required profile fields should be visible