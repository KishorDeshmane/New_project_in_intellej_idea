@TS_LOGIN_SA
Feature: Super admin login

  Background:
    Given User is on the admin login page

  @Severity(SeverityLevel.CRITICAL)
  @TC_LOGIN_SA_001 @retry
  Scenario: Verify that the super admin should be able to log in to the application
    Then Super Admin Login with Valid Credentials
    Then Super Admin Role Post Login

  @Severity(SeverityLevel.CRITICAL)
  @TS_LOGIN_SA_002 @retry
  Scenario: Verify that the super admin should not be able to log in to the application
    Then Super Admin Login with Invalid Credentials
    Then Super Admin Login with Blank Fields
    Then Administrator Password Field Masking

  @Severity(SeverityLevel.CRITICAL)
  @TS_LOGIN_SA_003 @retry
  Scenario: Verify that the super admin logged user back button from dashboard should not redirect to the log in page
    Then Administrator Back button redirection
