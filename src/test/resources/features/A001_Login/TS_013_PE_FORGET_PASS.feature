@TS_FP_PE_001
Feature: Partner Executive Forget Password Functionality

  Background:
    Given the partner executive is on the login page
    And the partner executive clicks on Forgot Password

  @TC_FP_PE_001
  Scenario: Partner Executive requests password reset with valid email
    When the partner executive enters a valid registered email address
    And the partner executive submits the password reset request
    Then a password reset link should be sent to the partner executive's email
    And a confirmation message should be displayed to the partner executive

  @TC_FP_PE_002
  Scenario: Partner Executive requests password reset with unregistered email
    When the partner executive enters an unregistered email address
    And the partner executive submits the password reset request
    Then an error message should be displayed to the partner executive indicating the email is not registered

  @TC_FP_PE_003
  Scenario: Partner Executive requests password reset with invalid email format
    When the partner executive enters an invalid email format
    And the partner executive submits the password reset request
    Then an error message should be displayed to the partner executive indicating an invalid email format