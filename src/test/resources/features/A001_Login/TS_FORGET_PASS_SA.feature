Feature: Super Admin Forget Password Functionality

  Scenario: Super Admin requests password reset with valid email
    Given the Super Admin is on the login page
    When the Super Admin clicks on Forgot Password
    And enters a valid registered email address
    And submits the request
    Then a password reset link should be sent to the Super Admins email
    And a confirmation message should be displayed

  Scenario: Super Admin requests password reset with unregistered email
    Given the Super Admin is on the login page
    When the Super Admin clicks on Forgot Password
    And enters an unregistered email address
    And submits the request
    Then an error message should be displayed indicating the email is not registered

  Scenario: Super Admin requests password reset with invalid email format
    Given the Super Admin is on the login page
    When the Super Admin clicks on Forgot Password
    And enters an invalid email format
    And submits the request
    Then an error message should be displayed indicating invalid email format

  Scenario: Super Admin resets password using the reset link
    Given the Super Admin has received a password reset email
    When the Super Admin clicks the reset link
    And enters a new valid password and confirms it
    And submits the new password
    Then the password should be updated successfully
    And a success message should be displayed

  Scenario: Super Admin tries to use an expired reset link
    Given the Super Admin has an expired password reset link
    When the Super Admin clicks the expired link
    Then an error message should be displayed indicating the link has expired