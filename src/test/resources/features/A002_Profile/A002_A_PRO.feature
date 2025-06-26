@TS_PRO_A
Feature: Admin profile

  Background:
    Given User is on the admin login page
    When Admin Login with Valid Credentials
    And admin Profile Page is loaded

  @TC_PRO_A_001 @retry
  Scenario: Verify admin Profile Page Loads Correctly
    Then admin Profile Page should load successfully

  @TC_PRO_A_002 @retry
  Scenario: Verify all admin Profile Fields are Displayed
    Then all admin required profile fields should be visible

  @TC_PRO_A_003 @retry
  Scenario: Admin successfully edits profile with valid input
    When Admin updates all editable fields with valid information
    And Admin clicks the Save button
    Then Admin's profile should be updated successfully
    And a success message should be displayed to the Admin

  @TC_PRO_A_004 @retry
  Scenario: Admin attempts to edit profile with invalid input format
    When Admin enters an invalid last name format in the last name field
    And Admin clicks the Save button
    Then an error message should be displayed for the last name field to the Admin
    And Admin's profile should not be updated

#  @TC_PRO_A_005 @retry
#  Scenario: Admin uploads a valid profile picture
#    When Admin selects a valid image file JPG PNG under 2MB
#    And Admin uploads the file
#    Then Admin's profile picture should be updated and displayed correctly

#  @TC_PRO_A_006 @retry
#  Scenario: Admin uploads an invalid profile picture file type
#    When Admin selects a file of unsupported type (e.g., .exe or .pdf)
#    And Admin uploads the file
#    Then an error message should be shown to the Admin indicating invalid file type
#    And Admin's profile picture should remain unchanged

  @TC_PRO_A_007 @retry
  Scenario: Admin cancels the profile edit operation
    When Admin makes some changes to the profile
    And Admin clicks the Cancel button
    Then all unsaved changes made by the Admin should be discarded
    And Admin should see fields reset to their original values

  @TC_PRO_A_008 @retry
  Scenario: Admin attempts to save profile with mandatory fields empty
    When Admin clears all mandatory fields
    And Admin clicks the Save button
    Then validation messages should be displayed for each empty mandatory field to the Admin
    And Admin's profile should not be updated

  @TC_PRO_A_009 @retry
  Scenario: Admin verifies read-only fields: Username, Email, and Mobile Number
    Then Admin should see the Username, Email, and Mobile Number fields as read-only
    And Admin should not be able to edit the Username, Email, and Mobile Number fields


  @TC_PRO_A_010 @retry
  Scenario: UI Consistency Check for Change Password Page
    And Admin navigates to the Change Password page
    Then All elements on the Change Password page should match the UI design standards

  @TC_PRO_A_011 @retry
  Scenario: Verify navigation to Change Password page
    And Admin navigates to the Change Password page
    Then Admin should be redirected to the Change Password page

  @TC_PRO_A_012 @retry
  Scenario: Verify all fields are displayed on Change Password page
    And Admin navigates to the Change Password page
    Then Current Password, New Password, and Confirm Password fields should be visible

#  @TC_PRO_A_013 Run after TC_PRO_A Last test cases triggered

  @TC_PRO_A_014 @retry
  Scenario: Admin enters incorrect current password
    And Admin navigates to the Change Password page
    When Admin enters an incorrect current password
    Then An error message should be displayed indicating invalid current password

  @TC_PRO_A_015 @retry
  Scenario: New password and confirm password mismatch
    And Admin navigates to the Change Password page
    When Admin enters a current password
    And Admin enters a different value in confirm password
    Then An error message should be displayed indicating passwords do not match

  @TC_PRO_A_016 @retry
  Scenario: Weak new password
    And Admin navigates to the Change Password page
    When Admin enters a current password
    And Admin confirms a weak new password
    Then Admin should see a message suggesting to choose a stronger password

  @TC_PRO_A_017 @retry
  Scenario: Blank password fields
    And Admin navigates to the Change Password page
    When Admin enters a current password
    When Admin leaves one or more password fields blank
    Then Admin should see validation messages for each blank field

  @TC_PRO_A_018 @retry
  Scenario: Password complexity validation
    And Admin navigates to the Change Password page
    When Admin enters a current password
    When Admin enters a new password without required complexity (e.g., no uppercase or special characters)
    Then Admin should see a message enforcing password complexity rules

  @TC_PRO_A_019 @retry
  Scenario: Password length validation
    And Admin navigates to the Change Password page
    When Admin enters a current password
    When Admin enters a password shorter than 8 characters
    Then Admin should see a message indicating minimum password length requirement

#  @TC_PRO_A_020 @retry
#  Scenario: Reuse of old password
#    And Admin navigates to the Change Password page
#    When Admin enters the current password as the new password
#    And Admin clicks the Save button
#    Then Admin should see an error message preventing reuse of the old password

#  @TC_PRO_A_021 @retry
#  Scenario: Login verification after successful password change
#    And Admin navigates to the Change Password page
#    Given Admin successfully changes the password
#    When Admin logs out
#    And Admin logs in using the new password
#    Then Admin should be logged in successfully

#  @TC_PRO_A_022 @retry
#  Scenario: Attempt login with old password after change
#    And Admin navigates to the Change Password page
#    Given Admin successfully changes the password
#    When Admin tries to login using the old password
#    Then Admin should see an authentication failure message

  @TC_PRO_A_023 @retry
  Scenario: Cancel button on Change Password page
    And Admin navigates to the Change Password page
    When Admin clicks the Cancel button from the Change Password page
    Then Admin should be redirected back to the Profile page

  @TC_PRO_A_024 @retry
  Scenario: Password fields are masked
    And Admin navigates to the Change Password page
    Then All password input fields should be masked (displayed as dots or asterisks)





  @TC_PRO_A_025 @retry
  Scenario: Admin verifies presence of Logout option
    Then Admin should see the Logout option in the navigation menu

  @TC_PRO_A_026 @retry
  Scenario: Admin successfully logs out from the system
    When Admin clicks the Logout option
    Then Admin should be redirected to the login page
    And Admin should see a logout success message

  @TC_PRO_A_027 @retry
  Scenario: Admin session is terminated after logout
    When Admin clicks the Logout option
    And Admin tries to navigate to the dashboard using browser back button
    Then Admin should be redirected to the login page

  @TC_PRO_A_028 @retry
  Scenario: Admin token and session storage are cleared on logout
    When Admin clicks the Logout option
    Then Admin's token and session data should be removed from local storage

  @TC_PRO_A_029 @retry
  Scenario: Admin attempts to access dashboard without logging in
    When Admin clicks the Logout option
    When Admin directly accesses the dashboard URL
    Then Admin should be redirected to the login page

  @TC_PRO_A_030 @retry
  Scenario: Admin verifies UI of the Logout button
    Then Admin should see a visible and properly styled Logout button in the top-right corner

#  @TC_PRO_A_031 @retry
#  Scenario: Admin is auto-logged out after session timeout
#    Given Admin is idle for the configured session timeout duration
#    Then Admin should be auto-logged out
#    And Admin should see a session timeout message on the login page

#  @TC_PRO_A_032 @retry
#  Scenario: Admin cancels logout from confirmation prompt
#    When Admin clicks the Logout button
#    And a logout confirmation dialog is shown
#    And Admin clicks the Cancel button
#    Then Admin should remain on the dashboard page

#  @TC_PRO_A_033 @retry
#  Scenario: Admin logs out from all devices if feature is supported
#    When Admin selects "Logout from all devices" option
#    Then Admin should be logged out from all active sessions
#    And Admin should receive a confirmation message

#  @TC_PRO_A_034 @retry
#  Scenario: Admin triggers API call upon logout
#    When Admin clicks the Logout option
#    Then an API call should be made to the logout endpoint
#    And Admin should receive a 200 OK response from the server







  @TC_PRO_A_013 @retry
  Scenario: Admin changes password with valid inputs
    And Admin navigates to the Change Password page
    When Admin enters valid current password
    And Admin enters a strong new password
    And Admin confirms the new password correctly
    Then Password should be updated successfully
    And Admin should see a success message
    And Admin should be redirected back to the admin login page

    When Admin tries to login using the old password
    Then Admin should see an authentication failure message

    When Admin logs in with the new password
    Then Admin should be logged in successfully with new password
    Then Admin update the Older saved password in the database


