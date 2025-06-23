@TS_PRO_E_001
Feature: Executive profile

  Background:
    Given User is on the admin login page
    When Executive Log in with Valid Credentials
    And Executive Profile Page is loaded

  @TC_PRO_E_001
  Scenario: Verify Executive Profile Page Loads Correctly
    Then Executive Profile Page should load successfully

  @TC_PRO_E_002
  Scenario: Verify all Executive Profile Fields are Displayed
    Then all Executive required profile fields should be visible


  @TC_PRO_E_003
  Scenario: Executive successfully edits profile with valid input
    When Executive updates all editable fields with valid information
    And Executive clicks the Save button
    Then Executive's profile should be updated successfully
    And a success message should be displayed to the Executive

  @TC_PRO_E_004
  Scenario: Executive attempts to edit profile with invalid input format
    When Executive enters an invalid last name format in the last name field
    And Executive clicks the Save button
    Then an error message should be displayed for the last name field to the Executive
    And Executive's profile should not be updated

#  @TC_PRO_E_005
#  Scenario: Executive uploads a valid profile picture
#    When Executive selects a valid image file JPG PNG under 2MB
#    And Executive uploads the file
#    Then Executive's profile picture should be updated and displayed correctly

#  @TC_PRO_E_006
#  Scenario: Executive uploads an invalid profile picture file type
#    When Executive selects a file of unsupported type (e.g., .exe or .pdf)
#    And Executive uploads the file
#    Then an error message should be shown to the Executive indicating invalid file type
#    And Executive's profile picture should remain unchanged

  @TC_PRO_E_007
  Scenario: Executive cancels the profile edit operation
    When Executive makes some changes to the profile
    And Executive clicks the Cancel button
    Then all unsaved changes made by the Executive should be discarded
    And Executive should see fields reset to their original values

  @TC_PRO_E_008
  Scenario: Executive attempts to save profile with mandatory fields empty
    When Executive clears all mandatory fields
    And Executive clicks the Save button
    Then validation messages should be displayed for each empty mandatory field to the Executive
    And Executive's profile should not be updated

  @TC_PRO_E_009
  Scenario: Executive verifies read-only fields: Username, Email, and Mobile Number
    Then Executive should see the Username, Email, and Mobile Number fields as read-only
    And Executive should not be able to edit the Username, Email, and Mobile Number fields
