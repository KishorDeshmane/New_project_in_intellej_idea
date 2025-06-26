@TS_PRO_PA
Feature: Partner admin profile

  Background:
    Given User is on the Partner admin login page
    When Partner Admin Login with Valid Credentials
    And Partner admin Profile Page is loaded

  @TC_PRO_PA_001 @retry
  Scenario: Verify Partner admin Profile Page Loads Correctly
    Then Partner admin Profile Page should load successfully

  @TC_PRO_PA_002 @retry
  Scenario: Verify all Partner admin Profile Fields are Displayed
    Then All Partner admin required profile fields should be visible