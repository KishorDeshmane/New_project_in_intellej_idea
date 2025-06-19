@TS_LOGIN_A_001
Feature: Admin login

  @TC_LOGIN_A_001
  Scenario: Verify that the admin should be able to log in to the application
    Given User is on the admin login page
    Then Admin Login with Valid Credentials
    Then Admin Role Post Login

  @TS_LOGIN_A_002
  Scenario: Verify that the admin should not be able to log in to the application
    Given User is on the admin login page
    Then Admin Login with Invalid Credentials
    Then Admin Login with Blank Fields
    Then Administrator Password Field Masking

  @TS_LOGIN_A_003
  Scenario: Verify that the admin logged user back button from dashboard should not redirect to the log in page
    Given User is on the admin login page
    Then Administrator Back button redirection