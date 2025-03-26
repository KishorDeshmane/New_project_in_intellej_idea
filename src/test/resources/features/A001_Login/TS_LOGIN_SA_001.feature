@TS_LOGIN_SA_001
Feature: Verify that the super admin should be able to log in to the application

  @TC_LOGIN_SA_001
  Scenario: Validate log in button functionality from the landing page
    Given User is on the admin login page
    Then Super Admin Login with Valid Credentials
    Then Super Admin Role Post Login

  @TS_LOGIN_SA_002
  Scenario: Verify that the super admin should not be able to log in to the application
    Given User is on the admin login page
    Then Super Admin Login with Invalid Credentials
    Then Super Admin Login with Blank Fields
    Then Password Field Masking
