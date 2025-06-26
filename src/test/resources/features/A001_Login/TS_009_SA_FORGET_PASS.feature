@TS_FP_SA
Feature: Super Admin Forget Password Functionality

  Background:
    Given the Super Admin is on the login page

  @TC_FP_SA_001 @retry
  Scenario: Super Admin requests password reset with valid email
    When the Super Admin clicks on Forgot Password
    And enters a valid registered email address
    And submits the request
    Then a password reset link should be sent to the Super Admins email
    And a confirmation message should be displayed

  @TC_FP_SA_002 @retry
  Scenario: Super Admin requests password reset with unregistered email
    When the Super Admin clicks on Forgot Password
    And enters an unregistered email address
    And submits the request
    Then an error message should be displayed indicating the email is not registered

  @TC_FP_SA_003 @retry
  Scenario: Super Admin requests password reset with invalid email format
    When the Super Admin clicks on Forgot Password
    And enters an invalid email format
    And submits the request
    Then an error message should be displayed indicating invalid email format

  # @TC_FP_SA_004 @retry
  # Scenario: Super Admin resets password using the reset link
  #   Given the Super Admin has received a password reset email
  #   When the Super Admin clicks the reset link
  #   And enters a new valid password and confirms it
  #   And submits the new password
  #   Then the password should be updated successfully
  #   And a success message should be displayed

  # @TC_FP_SA_005 @retry
  # Scenario: Super Admin tries to use an expired reset link
  #   Given the Super Admin has an expired password reset link
  #   When the Super Admin clicks the expired link
  #   Then an error message should be displayed indicating the link has expired
