@TS_PRO_SA
Feature: Super Admin Profile

  Background:
    Given User is on the admin login page
    When Super Admin Login with Valid Credentials
    And Super Admin Profile Page is loaded

  @TC_PRO_SA_001 @retry
  Scenario: Verify Super Admin Profile Page Loads Correctly
    Then Super Admin Profile Page should load successfully

  @TC_PRO_SA_002 @retry
  Scenario: Verify All Super Admin Profile Fields are Displayed
    Given Super Admin Profile Page is loaded
    Then All required Super Admin profile fields should be visible