package stepDefinitions.A002_Profile;

import com.pages.Dashboards.AdminDashboardPage;
import com.pages.Profile.AdminProfilePage;
import com.pages.Profile.ChangePasswordPage;
import com.pages.login.AdminLoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;

public class Admin_profile {

    private final AdminLoginPage lps = new AdminLoginPage(DriverFactory.getDriver());
    private final AdminDashboardPage aDash = new AdminDashboardPage(DriverFactory.getDriver());
    private final AdminProfilePage aprofile = new AdminProfilePage(DriverFactory.getDriver());
    private final ChangePasswordPage aChangePass = new ChangePasswordPage(DriverFactory.getDriver());
    Logger logger = LogManager.getLogger(Admin_profile.class);
    private int logoutResponseCode;

    @And("admin Profile Page is loaded")
    public void adminProfilePageIsLoaded() {
        aDash.profileImageIsClicked();
        aDash.profileTextIsClickedFromPopUp_JAVASCRIPT();
        logger.info("Admin Profile Page is loaded");
    }

    @Then("admin Profile Page should load successfully")
    public void adminProfilePageShouldLoadSuccessfully() {
        aprofile.verifyAdminProfilePageIsLoaded();
        logger.info("Admin Profile Page loaded successfully");
    }

    @Then("all admin required profile fields should be visible")
    public void allAdminRequiredProfileFieldsShouldBeVisible() {
        aprofile.verifyAllAdminRequiredProfileFieldsAreVisible();
        logger.info("All required Admin profile fields are visible");
    }

    @When("Admin updates all editable fields with valid information")
    public void adminUpdatesAllEditableFieldsWithValidInformation() {
        aprofile.enterFirstName("Kishor");
        aprofile.enterLastName("Admin");
    }

    @And("Admin clicks the Save button")
    public void adminClicksTheSaveButton() {
        aprofile.clickSaveButton();
        logger.info("Admin clicked the Save button to update profile");
    }

    @Then("Admin's profile should be updated successfully")
    public void adminSProfileShouldBeUpdatedSuccessfully() {
        aprofile.verifyProfileUpdatedSuccessfully();
        logger.info("Admin's profile updated successfully");
    }

    @And("a success message should be displayed to the Admin")
    public void aSuccessMessageShouldBeDisplayedToTheAdmin() {
        aprofile.verifyProfileUpdateSuccessToast();
        logger.info("Success message displayed to Admin after profile update");
    }

    @When("Admin enters an invalid last name format in the last name field")
    public void adminEntersAnInvalidLastNameFormatInTheLastNameField() {
        aprofile.enterLastName("@#$%%^FFF");
        logger.info("Admin entered an invalid email format in the email field");
    }

    @Then("an error message should be displayed for the last name field to the Admin")
    public void anErrorMessageShouldBeDisplayedForTheLastNameFieldToTheAdmin() {
        aprofile.verifyInvalidLastNameErrorMessage();
        logger.info("Error message displayed for invalid last name format");
    }

    @And("Admin's profile should not be updated")
    public void adminSProfileShouldNotBeUpdated() {
        aprofile.verifyProfileNotUpdated();
        logger.info("Admin's profile was not updated due to invalid last name format");
    }

    @When("Admin selects a valid image file JPG PNG under 2MB")
    public void adminSelectsAValidImageFileJPGPNGUnder2MB() {
        aprofile.selectValidImageFile("src/test/resources/org/raw_files/nature.png");
        logger.info("Admin selected a valid image file for profile picture upload");
    }

    @And("Admin uploads the file")
    public void adminUploadsTheFile() {
    }

    @Then("Admin's profile picture should be updated and displayed correctly")
    public void adminSProfilePictureShouldBeUpdatedAndDisplayedCorrectly() {
    }

    @When("Admin selects a file of unsupported type \\(e.g., .exe or .pdf)")
    public void adminSelectsAFileOfUnsupportedTypeEGExeOrPdf() {
    }

    @Then("an error message should be shown to the Admin indicating invalid file type")
    public void anErrorMessageShouldBeShownToTheAdminIndicatingInvalidFileType() {
    }

    @And("Admin's profile picture should remain unchanged")
    public void adminSProfilePictureShouldRemainUnchanged() {
    }

    @When("Admin makes some changes to the profile")
    public void adminMakesSomeChangesToTheProfile() {
        aprofile.enterFirstName("Kishor");
        aprofile.enterLastName("Admin");
        logger.info("Admin made changes to the profile");
    }

    @Then("all unsaved changes made by the Admin should be discarded")
    public void allUnsavedChangesMadeByTheAdminShouldBeDiscarded() {
        aprofile.clickCancelButtonPopUp();
        logger.info("Admin clicked the Cancel button to discard changes");
    }

    @And("Admin should see fields reset to their original values")
    public void adminShouldSeeFieldsResetToTheirOriginalValues() {
        aprofile.verifyAdminProfilePageIsLoaded();
        logger.info("Admin should see fields reset to their original values after clicking Cancel");
    }

    @When("Admin clears all mandatory fields")
    public void adminClearsAllMandatoryFields() {
        aprofile.clearFirstNameField();
        aprofile.clearLastNameField();
        logger.info("Admin cleared all mandatory fields in the profile");
    }

    @Then("validation messages should be displayed for each empty mandatory field to the Admin")
    public void validationMessagesShouldBeDisplayedForEachEmptyMandatoryFieldToTheAdmin() {
        aprofile.verifyMandatoryFieldsValidationMessages();
        logger.info("Validation messages displayed for empty mandatory fields");
    }

    @And("Admin clicks the Cancel button")
    public void adminClicksTheCancelButton() {
        aprofile.clickCancelButton();
        logger.info("Admin clicks the Cancel button");
    }

    @Then("Admin should see the Username, Email, and Mobile Number fields as read-only")
    public void adminShouldSeeTheUsernameEmailAndMobileNumberFieldsAsReadOnly() {
        aprofile.verifyUsernameEmailMobileFieldsAreReadOnly();
        logger.info("Admin should see the Username, Email, and Mobile Number fields as read-only");
    }

    @And("Admin should not be able to edit the Username, Email, and Mobile Number fields")
    public void adminShouldNotBeAbleToEditTheUsernameEmailAndMobileNumberFields() {
        aprofile.verifyUsernameEmailMobileFieldsAreNotEditable();
        logger.info("Admin should not be able to edit the Username, Email, and Mobile Number fields");
    }

    @And("Admin navigates to the Change Password page")
    public void adminNavigatesToTheChangePasswordPage() {
        aprofile.clickChangePasswordLink();
        logger.info("Admin navigated to the Change Password page");
    }

    @Then("All elements on the Change Password page should match the UI design standards")
    public void allElementsOnTheChangePasswordPageShouldMatchTheUIDesignStandards() {
        aChangePass.verifyChangePasswordPageUI();
        logger.info("All elements on the Change Password page match the UI design standards");
    }

    @Then("Admin should be redirected to the Change Password page")
    public void adminShouldBeRedirectedToTheChangePasswordPage() {
        aChangePass.verifyChangePasswordPageIsLoaded();
        logger.info("Admin is redirected to the Change Password page");
    }

    @Then("Current Password, New Password, and Confirm Password fields should be visible")
    public void currentPasswordNewPasswordAndConfirmPasswordFieldsShouldBeVisible() {
        try {
            aChangePass.enterCurrentPassword(ElementUtil.decrypt(ConfigManager.getProperty("password")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        aChangePass.clickOnSubmitCurrentPasswordButton();
        aChangePass.verifyAllChangePasswordFieldsAreVisibleSecondPage();
        logger.info("Current Password, New Password, and Confirm Password fields are visible on the Change Password page");
    }

    @When("Admin enters valid current password")
    public void adminEntersValidCurrentPassword() {
        try {
            aChangePass.enterCurrentPassword(ElementUtil.decrypt(ConfigManager.getProperty("password")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        aChangePass.clickOnSubmitCurrentPasswordButton();
        logger.info("Admin entered valid current password");
    }

    @And("Admin enters a strong new password")
    public void adminEntersAStrongNewPassword() {
        aChangePass.enterNewPassword("Test@1234");
        logger.info("Admin entered a strong new password");
    }

    @And("Admin confirms the new password correctly")
    public void adminConfirmsTheNewPasswordCorrectly() {
        aChangePass.enterConfirmPassword("Test@1234");
        logger.info("Admin confirmed the new password correctly");
    }

    @Then("Password should be updated successfully")
    public void passwordShouldBeUpdatedSuccessfully() {
        aChangePass.clickOnSubmitNewPasswordButton();
        aChangePass.verifyPasswordUpdatedSuccessfully();
        logger.info("Admin's password updated successfully");
    }

    @And("Admin should see a success message")
    public void adminShouldSeeASuccessMessage() {
        aChangePass.verifyPasswordUpdateSuccessToast();
        logger.info("Success message displayed to Admin after password update");
    }

    @When("Admin enters an incorrect current password")
    public void adminEntersAnIncorrectCurrentPassword() {
        aChangePass.enterCurrentPassword("WrongPassword@123");
        logger.info("Admin entered an incorrect current password");
    }

    @And("Admin enters valid new and confirm passwords")
    public void adminEntersValidNewAndConfirmPasswords() {
        aChangePass.enterNewPassword("NewAdmin@123");
        aChangePass.enterConfirmPassword("NewAdmin@123");
        logger.info("Admin entered valid new and confirm passwords");
    }

    @Then("An error message should be displayed indicating invalid current password")
    public void anErrorMessageShouldBeDisplayedIndicatingInvalidCurrentPassword() {
        aChangePass.clickOnSubmitCurrentPasswordButton();
        aChangePass.verifyInvalidCurrentPasswordErrorMessage();
        logger.info("Error message displayed for invalid current password");
    }

    @When("Admin enters a current password")
    public void adminEntersACurrentPassword() {
        try {
            aChangePass.enterCurrentPassword(ElementUtil.decrypt(ConfigManager.getProperty("password")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        aChangePass.clickOnSubmitCurrentPasswordButton();
        logger.info("Admin entered a new password");
    }

    @And("Admin enters a different value in confirm password")
    public void adminEntersADifferentValueInConfirmPassword() {
        aChangePass.enterNewPassword("NewPassword@123");
        aChangePass.enterConfirmPassword("DifferentPassword@123");
        logger.info("Admin entered a different value in confirm password");
    }

    @Then("An error message should be displayed indicating passwords do not match")
    public void anErrorMessageShouldBeDisplayedIndicatingPasswordsDoNotMatch() {
        aChangePass.clickOnSubmitNewPasswordButton();
        aChangePass.verifyPasswordsDoNotMatchErrorMessage();
        logger.info("Error message displayed indicating passwords do not match");
    }

    @When("Admin confirms a weak new password")
    public void AdminConfirmsAWeakNewPassword() {
        aChangePass.enterNewPassword("12345ppppp");
        aChangePass.enterConfirmPassword("12345ppppp");
        logger.info("Admin entered a weak new password");
    }

    @Then("Admin should see a message suggesting to choose a stronger password")
    public void adminShouldSeeAMessageSuggestingToChooseAStrongerPassword() {
        aChangePass.clickOnSubmitNewPasswordButton();
        aChangePass.verifyWeakPasswordErrorMessage();
        logger.info("Admin sees a message suggesting to choose a stronger password");
    }

    @When("Admin leaves one or more password fields blank")
    public void adminLeavesOneOrMorePasswordFieldsBlank() {
        aChangePass.clearNewPasswordField();
        aChangePass.clearConfirmPasswordField();
        logger.info("Admin left one or more password fields blank");
    }

    @Then("Admin should see validation messages for each blank field")
    public void adminShouldSeeValidationMessagesForEachBlankField() {
        aChangePass.clickOnSubmitNewPasswordButton();
        aChangePass.verifyMandatoryFieldsValidationMessages();
        logger.info("Validation messages displayed for each blank password field");
    }

    @When("Admin enters a new password without required complexity \\(e.g., no uppercase or special characters)")
    public void adminEntersANewPasswordWithoutRequiredComplexityEGNoUppercaseOrSpecialCharacters() {
        aChangePass.enterNewPassword("weakpassword");
        aChangePass.enterConfirmPassword("weakpassword");
        logger.info("Admin entered a new password without required complexity");
    }

    @Then("Admin should see a message enforcing password complexity rules")
    public void adminShouldSeeAMessageEnforcingPasswordComplexityRules() {
        aChangePass.clickOnSubmitNewPasswordButton();
        aChangePass.verifyWeakPasswordErrorMessage();
        logger.info("Admin sees a message enforcing password complexity rules");
    }

    @When("Admin enters a password shorter than 8 characters")
    public void adminEntersAPasswordShorterThanCharacters() {
        aChangePass.enterNewPassword("short");
        aChangePass.enterConfirmPassword("short");
        logger.info("Admin entered a password shorter than 8 characters");
    }

    @Then("Admin should see a message indicating minimum password length requirement")
    public void adminShouldSeeAMessageIndicatingMinimumPasswordLengthRequirement() {
        aChangePass.clickOnSubmitNewPasswordButton();
        aChangePass.verifyShortPasswordErrorMessage();
        logger.info("Admin sees a message indicating minimum password length requirement");
    }

    @When("Admin enters the current password as the new password")
    public void adminEntersTheCurrentPasswordAsTheNewPassword() {
        aChangePass.enterCurrentPassword("Admin@123");
        aChangePass.enterNewPassword("Admin@123");
        aChangePass.enterConfirmPassword("Admin@123");
        logger.info("Admin entered the current password as the new password");
    }

    @Then("Admin should see an error message preventing reuse of the old password")
    public void adminShouldSeeAnErrorMessagePreventingReuseOfTheOldPassword() {
        aChangePass.clickOnSubmitNewPasswordButton();
        aChangePass.verifyWeakPasswordErrorMessage();
        logger.info("Admin sees an error message preventing reuse of the old password");
    }

    @Given("Admin successfully changes the password")
    public void adminSuccessfullyChangesThePassword() {
        aChangePass.enterCurrentPassword("Admin@123");
        aChangePass.enterNewPassword("NewAdmin@123");
        aChangePass.enterConfirmPassword("NewAdmin@123");
        aChangePass.clickOnSubmitNewPasswordButton();
        aChangePass.verifyPasswordUpdatedSuccessfully();
        logger.info("Admin successfully changed the password");
    }

    @When("Admin logs out")
    public void adminLogsOut() {
        aDash.profileImageIsClicked();
        aDash.logout();
        logger.info("Admin logged out successfully");
    }

    @And("Admin logs in using the new password")
    public void adminLogsInUsingTheNewPassword() {

    }

    @Then("Admin should be logged in successfully")
    public void adminShouldBeLoggedInSuccessfully() {
        lps.verifyAdminDashboardPageIsLoaded();
        logger.info("Admin logged in successfully using the new password");
    }

    @When("Admin tries to login using the old password")
    public void adminTriesToLoginUsingTheOldPassword() {
        lps.enterTheValidEmailIntoTheEmailField_Admin();
        try {
            lps.enterTheOldPasswordIntoThePasswordField_Admin(ElementUtil.decrypt(ConfigManager.getProperty("password")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        lps.loginButtonIsClicked();
        logger.info("Admin tries to login using the old password");
    }

    @Then("Admin should see an authentication failure message")
    public void adminShouldSeeAnAuthenticationFailureMessage() {
        lps.verifyAuthenticationFailureMessage();
        lps.clearThePasswordField();
        ElementUtil.eu.refresh_your_page(DriverFactory.getDriver());
        logger.info("Admin sees an authentication failure message when trying to login with the old password");
    }

    @Then("Admin should be redirected back to the Profile page")
    public void adminShouldBeRedirectedBackToTheProfilePage() {
        aprofile.verifyAdminProfilePageIsLoaded();
        logger.info("Admin is redirected back to the Profile page after attempting to change password");
    }

    @Then("All password input fields should be masked \\(displayed as dots or asterisks)")
    public void allPasswordInputFieldsShouldBeMaskedDisplayedAsDotsOrAsterisks() {
        aChangePass.verifyPasswordFieldsAreMasked();
        logger.info("All password input fields are masked (displayed as dots or asterisks)");
    }

    @And("Admin should be redirected back to the admin login page")
    public void adminShouldBeRedirectedBackToTheAdminLoginPage() {
        lps.verifyAdminLoginPageIsLoaded();
        logger.info("Admin is redirected back to the admin login page after changing password");
    }

    @When("Admin logs in with the new password")
    public void adminLogsInWithTheNewPassword() {
        lps.enterTheValidEmailIntoTheEmailField_Admin();
        lps.enterTheNewValidPasswordIntoThePasswordField_Admin("Test@1234");
        ElementUtil.eu.waitForPageToLoad(DriverFactory.getDriver());
        lps.loginButtonIsClicked();
        logger.info("Admin logs in with the new password");
    }

    @Then("Admin should be logged in successfully with new password")
    public void adminShouldBeLoggedInSuccessfullyWithNewPassword() {
        aDash.verifyAdminDashboardPageIsLoadedAfterPasswordChanges();
        logger.info("Admin is logged in successfully with the new password");
    }

    @Then("Admin update the Older saved password in the database")
    public void adminUpdateTheOlderSavedPasswordInTheDatabase() {
        aDash.profileImageIsClicked_withJAVASCRIPT();
        aDash.profileTextIsClickedFromPopUp_JAVASCRIPT();
        aprofile.clickChangePasswordLink();
        aChangePass.enterCurrentPassword("Test@1234");
        aChangePass.clickOnSubmitCurrentPasswordButton();
        aChangePass.enterNewPassword("Test@123");
        aChangePass.enterConfirmPassword("Test@123");
        aChangePass.clickOnSubmitNewPasswordButton();
        aChangePass.verifyPasswordUpdatedSuccessfully();
        logger.info("Admin updated the older saved password in the database");
    }

    @When("Admin clicks the Cancel button from the Change Password page")
    public void adminClicksTheCancelButtonFromTheChangePasswordPage() {
        aChangePass.clickOnCancelCurrentPasswordButton();
        logger.info("Admin clicked the Cancel button from the Change Password page");
    }

    @Then("Admin should see the Logout option in the navigation menu")
    public void adminShouldSeeTheLogoutOptionInTheNavigationMenu() {
        aDash.profileImageIsClicked();
        aDash.verifyLogoutOptionIsVisible();
        logger.info("Admin sees the Logout option in the navigation menu");
    }

    @When("Admin clicks the Logout option")
    public void adminClicksTheLogoutOption() {
        aDash.profileImageIsClicked();
        aDash.logout();
        logger.info("Admin clicked the Logout option");
    }

    @Then("Admin should be redirected to the login page")
    public void adminShouldBeRedirectedToTheLoginPage() {
        try {
            Thread.sleep(1000); // Wait for the page to load
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lps.verifyAdminLoginPageIsLoaded();
        logger.info("Admin is redirected to the login page after logging out");
    }

    @And("Admin should see a logout success message")
    public void adminShouldSeeALogoutSuccessMessage() {
        lps.loggedOutSuccessfullyToastIsDisplayed();
        logger.info("Admin sees a logout success message after logging out");
    }

    @And("Admin tries to navigate to the dashboard using browser back button")
    public void adminTriesToNavigateToTheDashboardUsingBrowserBackButton() {
        ElementUtil.eu.navigate_back(DriverFactory.getDriver());
        logger.info("Admin tries to navigate to the dashboard using browser back button");
    }

    @Then("Admin's token and session data should be removed from local storage")
    public void adminSTokenAndSessionDataShouldBeRemovedFromLocalStorage() {
        // Wait for logout redirection (e.g., to login page)
        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("login"));
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        // Replace these keys with actual ones used in your app
        String[] localStorageKeys = {"token", "authToken", "userInfo"};
        String[] sessionStorageKeys = {"session", "sessionID"};
        for (String key : localStorageKeys) {
            Object value = js.executeScript("return window.localStorage.getItem(arguments[0]);", key);
            Assert.assertNull(value, "LocalStorage key '" + key + "' was not cleared after logout");
        }
        for (String key : sessionStorageKeys) {
            Object value = js.executeScript("return window.sessionStorage.getItem(arguments[0]);", key);
            Assert.assertNull(value, "SessionStorage key '" + key + "' was not cleared after logout");
        }
        System.out.println("✅ Admin's token and session storage were cleared successfully.");
    }


    @When("Admin directly accesses the dashboard URL")
    public void adminDirectlyAccessesTheDashboardURL() {
        String dashboardUrl = aDash.getTheDashboardUrl();
        DriverFactory.getDriver().get(dashboardUrl);
        logger.info("Admin directly accessed the dashboard URL: " + dashboardUrl);
    }

    @Then("Admin should see a visible and properly styled Logout button in the top-right corner")
    public void adminShouldSeeAVisibleAndProperlyStyledLogoutButtonInTheTopRightCorner() {
        aDash.profileImageIsClicked();
        boolean isLogoutButtonVisible = aDash.logoutButtonIsVisible();
        Assert.assertTrue(isLogoutButtonVisible, "Logout button is not visible in the top-right corner");
        logger.info("Admin sees a visible and properly styled Logout button in the top-right corner");
    }

    @Then("an API call should be made to the logout endpoint")
    public void anAPICallShouldBeMadeToTheLogoutEndpoint() {

    }

    @And("Admin should receive a {int} OK response from the server")
    public void adminShouldReceiveAOKResponseFromTheServer(int arg0) {
        Assert.assertEquals(logoutResponseCode, arg0, "Logout API did not return expected status code");
    }
}
