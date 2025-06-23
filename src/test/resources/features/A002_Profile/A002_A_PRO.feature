@TS_PRO_A_001
Feature: Admin profile

  Background:
    Given User is on the admin login page
    When Admin Login with Valid Credentials
    And admin Profile Page is loaded

  @TC_PRO_A_001
  Scenario: Verify admin Profile Page Loads Correctly
    Then admin Profile Page should load successfully

  @TC_PRO_A_002
  Scenario: Verify all admin Profile Fields are Displayed
    Then all admin required profile fields should be visible

  @TC_PRO_A_003
  Scenario: Admin successfully edits profile with valid input
    When Admin updates all editable fields with valid information
    And Admin clicks the Save button
    Then Admin's profile should be updated successfully
    And a success message should be displayed to the Admin

  @TC_PRO_A_004
  Scenario: Admin attempts to edit profile with invalid input format
    When Admin enters an invalid last name format in the last name field
    And Admin clicks the Save button
    Then an error message should be displayed for the last name field to the Admin
    And Admin's profile should not be updated

#  @TC_PRO_A_005
#  Scenario: Admin uploads a valid profile picture
#    When Admin selects a valid image file JPG PNG under 2MB
#    And Admin uploads the file
#    Then Admin's profile picture should be updated and displayed correctly

#  @TC_PRO_A_006
#  Scenario: Admin uploads an invalid profile picture file type
#    When Admin selects a file of unsupported type (e.g., .exe or .pdf)
#    And Admin uploads the file
#    Then an error message should be shown to the Admin indicating invalid file type
#    And Admin's profile picture should remain unchanged

  @TC_PRO_A_007
  Scenario: Admin cancels the profile edit operation
    When Admin makes some changes to the profile
    And Admin clicks the Cancel button
    Then all unsaved changes made by the Admin should be discarded
    And Admin should see fields reset to their original values

  @TC_PRO_A_008
  Scenario: Admin attempts to save profile with mandatory fields empty
    When Admin clears all mandatory fields
    And Admin clicks the Save button
    Then validation messages should be displayed for each empty mandatory field to the Admin
    And Admin's profile should not be updated

  @TC_PRO_A_009
  Scenario: Admin verifies read-only fields: Username, Email, and Mobile Number
    Then Admin should see the Username, Email, and Mobile Number fields as read-only
    And Admin should not be able to edit the Username, Email, and Mobile Number fields


  @TC_PRO_A_010
  Scenario: UI Consistency Check for Change Password Page
    And Admin navigates to the Change Password page
    Then All elements on the Change Password page should match the UI design standards

  @TC_PRO_A_011
  Scenario: Verify navigation to Change Password page
    And Admin navigates to the Change Password page
    Then Admin should be redirected to the Change Password page

  @TC_PRO_A_012
  Scenario: Verify all fields are displayed on Change Password page
    And Admin navigates to the Change Password page
    Then Current Password, New Password, and Confirm Password fields should be visible

  @TC_PRO_A_013
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

  @TC_PRO_A_014
  Scenario: Admin enters incorrect current password
    And Admin navigates to the Change Password page
    When Admin enters an incorrect current password
    Then An error message should be displayed indicating invalid current password

  @TC_PRO_A_015
  Scenario: New password and confirm password mismatch
    And Admin navigates to the Change Password page
    When Admin enters a current password
    And Admin enters a different value in confirm password
    Then An error message should be displayed indicating passwords do not match

  @TC_PRO_A_016
  Scenario: Weak new password
    And Admin navigates to the Change Password page
    When Admin enters a current password
    And Admin confirms a weak new password
    Then Admin should see a message suggesting to choose a stronger password

  @TC_PRO_A_017
  Scenario: Blank password fields
    And Admin navigates to the Change Password page
    When Admin enters a current password
    When Admin leaves one or more password fields blank
    Then Admin should see validation messages for each blank field

  @TC_PRO_A_018
  Scenario: Password complexity validation
    And Admin navigates to the Change Password page
    When Admin enters a current password
    When Admin enters a new password without required complexity (e.g., no uppercase or special characters)
    Then Admin should see a message enforcing password complexity rules

  @TC_PRO_A_019
  Scenario: Password length validation
    And Admin navigates to the Change Password page
    When Admin enters a current password
    When Admin enters a password shorter than 8 characters
    Then Admin should see a message indicating minimum password length requirement

#  @TC_PRO_A_020
#  Scenario: Reuse of old password
#    And Admin navigates to the Change Password page
#    When Admin enters the current password as the new password
#    And Admin clicks the Save button
#    Then Admin should see an error message preventing reuse of the old password

#  @TC_PRO_A_021
#  Scenario: Login verification after successful password change
#    And Admin navigates to the Change Password page
#    Given Admin successfully changes the password
#    When Admin logs out
#    And Admin logs in using the new password
#    Then Admin should be logged in successfully

#  @TC_PRO_A_022
#  Scenario: Attempt login with old password after change
#    And Admin navigates to the Change Password page
#    Given Admin successfully changes the password
#    When Admin tries to login using the old password
#    Then Admin should see an authentication failure message

  @TC_PRO_A_023
  Scenario: Cancel button on Change Password page
    And Admin navigates to the Change Password page
    When Admin clicks the Cancel button from the Change Password page
    Then Admin should be redirected back to the Profile page

  @TC_PRO_A_024
  Scenario: Password fields are masked
    And Admin navigates to the Change Password page
    Then All password input fields should be masked (displayed as dots or asterisks)


