@TS_PRO_C
Feature: Customer profile

  Background:
    Given User is on the Customer login page
    When Customer Log in with Valid Credentials
    And Customer Profile Page is loaded

  @TC_PRO_C_001 @retry
  Scenario: Verify Customer Profile Page Loads Correctly
    Then Customer Profile Page should load successfully

  @TC_PRO_C_002 @retry
  Scenario: Verify all Customer Profile Fields are Displayed
    Then All Customer required profile fields should be visible