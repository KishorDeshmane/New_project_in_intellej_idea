Feature: Executive Forget Password Functionality

  Scenario: Executive requests password reset with valid email
    Given the Executive is on the login page
    When the Executive clicks on Forgot Password
    And enters a valid registered email address
    And submits the request
    Then a password reset link should be sent to the Executive's email
    And a confirmation message should be displayed

  Scenario: Executive requests password reset with unregistered email
    Given the Executive is on the login page
    When the Executive clicks on Forgot Password
    And enters an unregistered email address
    And submits the request
    Then an error message should be displayed indicating the email is not registered

  Scenario: Executive requests password reset with invalid email format
    Given the Executive is on the login page
    When the Executive clicks on Forgot Password
    And enters an invalid email format
    And submits the request
    Then an error message should be displayed indicating invalid email format

  Scenario: Executive resets password using the reset link
    Given the Executive has received a password reset email
    When the Executive clicks the reset link
    And enters a new valid password and confirms it
    And submits the new password
    Then the password should be updated successfully
    And a success message should be displayed

  Scenario: Executive tries to use an expired reset link
    Given the Executive has an expired password reset link
    When the Executive clicks the expired link
    Then an error message should be displayed indicating the link has expired