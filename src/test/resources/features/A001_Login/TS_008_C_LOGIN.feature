@TS_LOGIN_CW
Feature: Customer log in into the web app

  Background:
    Given User is on the Customer login page

  @TS_LOGIN_CW_001 @retry
  Scenario: Verify that the customer should be able to log in to the mobile application
    Then Customer Log in with Valid Credentials
    Then Customer Role Post Login

  @TS_LOGIN_CW_002 @retry
  Scenario: Verify that the customer should be able to log in to the mobile application
    Then Customer Log in with Blank Fields
    Then Customer OTP Field Masking

  @TS_LOGIN_CW_003 @retry
  Scenario: Verify that the Customer logged user back button from home should not redirect to the log in page
    Then Customer Back button redirection

# Edit function is pending to write in this page
