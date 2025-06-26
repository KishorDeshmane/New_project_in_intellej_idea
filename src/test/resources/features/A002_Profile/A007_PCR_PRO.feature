@TS_PRO_PCR
Feature: Partner custom role user profile

  Background:
    Given User is on the Partner admin login page
    When Partner custom role user Log in with Valid Credentials
    And Partner custom role user Profile Page is loaded

  @TC_PRO_PCR_001 @retry
  Scenario: Verify Partner custom role user Profile Page Loads Correctly
    Then Partner custom role user Profile Page should load successfully

  @TC_PRO_PCR_002 @retry
  Scenario: Verify all Partner custom role user Profile Fields are Displayed
    Then All Partner custom role user required profile fields should be visible