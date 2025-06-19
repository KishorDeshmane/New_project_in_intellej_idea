@TS_PRO_ACR_001
Feature: Admin custom role user profile

  Background:
    Given User is on the admin login page
    When Admin custom role user Log in with Valid Credentials
    And Admin custom role user Profile Page is loaded

  @TC_PRO_ACR_001
  Scenario: Verify Admin custom role user Profile Page Loads Correctly
    Then Admin custom role user Profile Page should load successfully

  @TC_PRO_ACR_002
  Scenario: Verify all Admin custom role user Profile Fields are Displayed
    Then All Admin custom role user required profile fields should be visible