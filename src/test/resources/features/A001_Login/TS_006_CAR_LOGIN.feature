@LOGIN_ACR @TC_LOGIN_ACR_001 @TS_LOGIN_ACR_002 @TS_LOGIN_ACR_003
Feature: Custom role user login admin end

  Background:
    Given User is on the admin login page

  @TC_LOGIN_ACR_001
  Scenario: Verify that the admin custom role user should be able to log in to the application
    Then Admin custom role user Log in with Valid Credentials
    Then Admin custom role user Role Post Login

  @TS_LOGIN_ACR_002
  Scenario: Verify that the admin customer role user should not be able to log in to the application
    Then Admin custom role user Log in with Invalid Credentials
    Then Admin custom role user Log in with Blank Fields
    Then Administrator Password Field Masking

  @TS_LOGIN_ACR_003
  Scenario: Verify that the admin custom role user logged user back button from home should not redirect to the log in page
    Then Administrator Back button redirection
