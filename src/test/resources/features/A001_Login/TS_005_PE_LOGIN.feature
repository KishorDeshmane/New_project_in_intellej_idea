@TS_LOGIN_PE_001 @TC_LOGIN_PE_001 @TC_LOGIN_PE_002 @TC_LOGIN_PE_003
Feature: Partner Executive login

  Background:
    Given User is on the Partner admin login page

  @TC_LOGIN_PE_001
  Scenario: Verify that the partner executive should be able to log in to the application
    Then Partner executive Login with Valid Credentials
    Then Partner executive Role Post Login

  @TC_LOGIN_PE_002
  Scenario: Verify that the partner executive should not be able to log in to the application
    Then Partner executive Login with Invalid Credentials
    Then Partner executive Login with Blank Fields
    Then Partner Password Field Masking

  @TC_LOGIN_PE_003
  Scenario: Verify that the partner executive logged user back button from dashboard should not redirect to the log in page
    Then Partner Back button redirection
