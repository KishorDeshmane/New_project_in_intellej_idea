@TS_FP_PA
Feature: Partner Admin Forget Password Functionality

  Background:
    Given the partner admin is on the login page
    And the partner admin clicks on Forgot Password

  @TC_FP_PA_001 @retry
  Scenario: Partner Admin requests password reset with valid email
    When the partner admin enters a valid registered email address
    And the partner admin submits the password reset request
    Then a password reset link should be sent to the partner admin's email
    And a confirmation message should be displayed to the partner admin

  @TC_FP_PA_002 @retry
  Scenario: Partner Admin requests password reset with unregistered email
    When the partner admin enters an unregistered email address
    And the partner admin submits the password reset request
    Then an error message should be displayed to the partner admin indicating the email is not registered

  @TC_FP_PA_003 @retry
  Scenario: Partner Admin requests password reset with invalid email format
    When the partner admin enters an invalid email format
    And the partner admin submits the password reset request
    Then an error message should be displayed to the partner admin indicating an invalid email format
