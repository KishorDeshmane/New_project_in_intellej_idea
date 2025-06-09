@TS_LOGIN_SA_001
Feature: Super admin login

  @TC_LOGIN_SA_001
  Scenario: Verify that the super admin should be able to log in to the application
    Given User is on the admin login page
    Then Super Admin Login with Valid Credentials
    Then Super Admin Role Post Login

  @TS_LOGIN_SA_002
  Scenario: Verify that the super admin should not be able to log in to the application
    Given User is on the admin login page
    Then Super Admin Login with Invalid Credentials
    Then Super Admin Login with Blank Fields
    Then Administrator Password Field Masking

  @TS_LOGIN_SA_003
  Scenario: Verify that the super admin logged user back button from dashboard should not redirect to the log in page
    Given User is on the admin login page
    Then Administrator Back button redirection