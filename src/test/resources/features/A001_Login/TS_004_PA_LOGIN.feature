@TS_LOGIN_PA_001
Feature: Partner admin login

  @TC_LOGIN_PA_001
  Scenario: Verify that the Partner admin should be able to log in to the application
    Given User is on the Partner admin login page
    Then Partner Admin Login with Valid Credentials
    Then Partner Admin Role Post Login

  @TC_LOGIN_PA_002
  Scenario: Verify that the partner admin should not be able to log in to the application
    Given User is on the Partner admin login page
    Then Partner Admin Login with Invalid Credentials
    Then Partner Admin Login with Blank Fields
    Then Partner Password Field Masking

  @TC_LOGIN_PA_003
  Scenario: Verify that the partner admin logged user back button from dashboard should not redirect to the log in page
    Given User is on the Partner admin login page
    Then Partner Back button redirection

