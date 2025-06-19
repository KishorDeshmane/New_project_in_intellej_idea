@TS_PRO_SA_001
Feature: Executive profile

  Background:
    Given User is on the admin login page
    When Executive Log in with Valid Credentials
    And Executive Profile Page is loaded

  @TC_PRO_SA_001
  Scenario: Verify Executive Profile Page Loads Correctly
    Then Executive Profile Page should load successfully

  @TC_PRO_SA_002
  Scenario: Verify all Executive Profile Fields are Displayed
    Then all Executive required profile fields should be visible