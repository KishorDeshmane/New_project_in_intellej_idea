@TS_FP_A
Feature: Admin Forget Password Functionality

  Background:
    Given the Admin is on the login page

  @TC_FP_A_001 @retry
  Scenario: Admin requests password reset with valid email
    When the Admin clicks on Forgot Password
    And enters admin valid registered email address
    And submits the request
    Then a password reset link should be sent to the Admins email
    And a confirmation message should be displayed

  @TC_FP_A_002 @retry
  Scenario: Admin requests password reset with unregistered email
    When the Admin clicks on Forgot Password
    And enters an unregistered email address
    And submits the request
    Then an error message should be displayed indicating the email is not registered

  @TC_FP_A_003 @retry
  Scenario: Admin requests password reset with invalid email format
    When the Admin clicks on Forgot Password
    And enters an invalid email format
    And submits the request
    Then an error message should be displayed indicating invalid email format

  # @TC_FP_A_004 @retry
  # Scenario: Admin resets password using the reset link
  #   Given the Admin has received a password reset email
  #   When the Admin clicks the reset link
  #   And enters a new valid password and confirms it
  #   And submits the new password
  #   Then the password should be updated successfully
  #   And a success message should be displayed

  ## @TC_FP_A_005 @retry
  # Scenario: Admin tries to use an expired reset link
  #   Given the Admin has an expired password reset link
  #   When the Admin clicks the expired link
  #   Then an error message should be displayed indicating the link has expired
