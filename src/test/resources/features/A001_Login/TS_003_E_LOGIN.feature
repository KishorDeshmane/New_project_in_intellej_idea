@TS_LOGIN_E
Feature: Executive login

  Background:
    Given User is on the admin login page

  @TS_LOGIN_E_001 @retry
  Scenario: Verify that the executive should be able to log in to the application
    Then Executive Log in with Valid Credentials
    Then Executive Role Post Login

  @TS_LOGIN_E_002 @retry
  Scenario: Verify that the executive should not be able to log in to the application
    Then Executive Login with Invalid Credentials
    Then Executive Login with Blank Fields
    Then Administrator Password Field Masking

  @TS_LOGIN_E_003 @retry
  Scenario: Verify that the executive logged user back button from dashboard should not redirect to the log in page
    Then Administrator Back button redirection
