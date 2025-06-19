@LOGIN_PCR @TC_LOGIN_PCR_001 @TS_LOGIN_PCR_002 @TS_LOGIN_PCR_003
Feature: Custom partner role user login admin end

    Background:
        Given User is on the Partner admin login page

    @TC_LOGIN_PCR_001
    Scenario: Verify that the partner custom role user should be able to log in to the application
        Then Partner custom role user Log in with Valid Credentials
        Then Partner custom role user Role Post Login

    @TS_LOGIN_PCR_002
    Scenario: Verify that the partner customer role user should not be able to log in to the application
        Then Partner custom role user Log in with Invalid Credentials
        Then Partner custom role user Log in with Blank Fields
        Then Partner Password Field Masking

    @TS_LOGIN_PCR_003
    Scenario: Verify that the partner custom role user logged user back button from home should not redirect to the log in page
        Then Partner Back button redirection
