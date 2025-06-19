@TS_PRO_A_001
Feature: Admin profile

  Background:
    Given User is on the admin login page
    When Admin Login with Valid Credentials
    And admin Profile Page is loaded

  @TC_PRO_A_001
  Scenario: Verify admin Profile Page Loads Correctly
    Then admin Profile Page should load successfully

  @TC_PRO_A_002
  Scenario: Verify all admin Profile Fields are Displayed
    Then all admin required profile fields should be visible