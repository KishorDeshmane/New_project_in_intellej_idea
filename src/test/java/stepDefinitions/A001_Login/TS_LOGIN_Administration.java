package stepDefinitions.A001_Login;

import com.pages.Dashboards.AdminDashboard;
import com.pages.login.*;
import com.qa.factory.DriverFactory;
import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class TS_LOGIN_Administration {
    private final AdminLoginPage lps = new AdminLoginPage(DriverFactory.getDriver());
    private final AdminDashboard aDash = new AdminDashboard(DriverFactory.getDriver());
    Logger logger = LogManager.getLogger(TS_LOGIN_Administration.class);

    @Given("User is on the admin login page")
    public void userIsOnTheAdminLoginPage() {
        String baseUrl = ConfigManager.getProperty("base.url");
//        DriverFactory.getDriver().get(baseUrl + "admin/login");

        System.out.println("Original URL: " + baseUrl);
        String changedUrl;
        assert baseUrl != null;
        changedUrl = baseUrl.replaceFirst("s", "");
        System.out.println("Modified URL: " + changedUrl);
        DriverFactory.getDriver().get(changedUrl +"admin/login");
    }

    @Then("Super Admin Login with Valid Credentials")
    public void superAdminLoginWithValidCredentials() {
        lps.enterTheValidEmailIntoTheEmailField_SuperAdmin();
        lps.enterTheValidPasswordIntoThePasswordField_SuperAdmin();
        lps.loginButtonIsClicked();
        boolean actualValues;
        actualValues = aDash.loggedInSuccessfullyToastIsDisplayed();
        assertTrue(actualValues);
        logger.info("Super Admin Login with Valid Credentials");
    }

    @Then("Super Admin Role Post Login")
    public void superAdminRolePostLogin() {
        aDash.profileImageIsClicked();
        boolean actualValues;
        actualValues = aDash.superAdminTextInProfileIconDisplays();
        assertTrue(actualValues);
        logger.info("Super Admin Role Post Login");
    }

    @Then("Super Admin Login with Invalid Credentials")
    public void superAdminLoginWithInvalidCredentials() {
        lps.enterTheInvalidEmailIntoTheEmailField();
        lps.enterTheInavalidPasswordIntoThePasswordField();
        boolean actualValues;
        actualValues = lps.pleaseEnterValidEmailAddressMessageIsDisplayed();
        assertTrue(actualValues);
        logger.info("Super Admin Login with Invalid Credentials");
    }

    @Then("Super Admin Login with Blank Fields")
    public void superAdminLoginWithBlankFields() {
        ElementUtil.eu.refresh_your_page(DriverFactory.getDriver());
        lps.enterTheBlankEmailIntoTheEmailField();
        lps.enterTheBlankPasswordIntoThePasswordField();
        lps.loginButtonIsClicked();
        boolean actualValues1 = lps.pleaseEnterEmailAddressMesssageIsDisplayed();
        assertTrue(actualValues1);
        boolean actualValues2 = lps.pleaseEnterPasswordMesssageIsDisplayed();
        assertTrue(actualValues2);
        logger.info("Super Admin Login with Blank Fields");
    }

    @Then("Administrator Password Field Masking")
    public void AdministratorPasswordFieldMasking() {
        ElementUtil.eu.refresh_your_page(DriverFactory.getDriver());
        lps.enterPassword("YourSecurePassword");
        Assert.assertTrue(lps.isPasswordMasked());
        lps.togglePasswordVisibility();
        Assert.assertTrue(lps.isPasswordVisible());
        lps.togglePasswordVisibility();
        Assert.assertTrue(lps.isPasswordMasked());
        logger.info("Password Field Masking");
    }

    @Then("Administrator Back button redirection")
    public void AdministratorBackButtonRedirection() {
        lps.enterTheValidEmailIntoTheEmailField_SuperAdmin();
        lps.enterTheValidPasswordIntoThePasswordField_SuperAdmin();
        lps.loginButtonIsClicked();
        aDash.loggedInSuccessfullyToastIsDisplayed();
        String currentURL = aDash.getTheDashboardUrl();
        System.out.println(currentURL +"----current DASH URL");
        lps.redirectToTheLoginBackPage();
        String expectedURL =
                ConfigManager.getProperty("base.url")
                        .replaceFirst("s","")+"admin/dashboard/";
        ElementUtil.eu.waitForExpectedURL(DriverFactory.getDriver(), expectedURL);
        System.out.println(expectedURL +"----expectedURL");
        Assert.assertEquals(currentURL, expectedURL);
        logger.info("Back button redirection");
    }

    @Then("Admin Login with Valid Credentials")
    public void adminLoginWithValidCredentials() {
        lps.enterTheValidEmailIntoTheEmailField_Admin();
        lps.enterTheValidPasswordIntoThePasswordField_Admin();
        lps.loginButtonIsClicked();
        boolean actualValue= aDash.loggedInSuccessfullyToastIsDisplayed();
        assertTrue(actualValue);
    }

    @Then("Admin Role Post Login")
    public void adminRolePostLogin() {
        aDash.profileImageIsClicked();
        boolean actualValues;
        actualValues = aDash.adminTextInProfileIconDisplays();
        assertTrue(actualValues);
    }

    @Then("Admin Login with Invalid Credentials")
    public void adminLoginWithInvalidCredentials() {
        lps.enterTheInvalidEmailIntoTheEmailField();
        lps.enterTheInavalidPasswordIntoThePasswordField();
        boolean actualValues;
        actualValues = lps.pleaseEnterValidEmailAddressMessageIsDisplayed();
        assertTrue(actualValues);
        logger.info("Admin Login with Invalid Credentials");
    }

    @Then("Admin Login with Blank Fields")
    public void adminLoginWithBlankFields() {
        ElementUtil.eu.refresh_your_page(DriverFactory.getDriver());
        lps.enterTheBlankEmailIntoTheEmailField();
        lps.enterTheBlankPasswordIntoThePasswordField();
        lps.loginButtonIsClicked();
        boolean actualValues1 = lps.pleaseEnterEmailAddressMesssageIsDisplayed();
        assertTrue(actualValues1);
        boolean actualValues2 = lps.pleaseEnterPasswordMesssageIsDisplayed();
        assertTrue(actualValues2);
        logger.info("Admin Login with Blank Fields");
    }

    @Then("Executive Log in with Valid Credentials")
    public void executiveLogInWithValidCredentials() {
        lps.enterTheValidEmailIntoTheEmailField_executive();
        lps.enterTheValidPasswordIntoThePasswordField_executive();
        lps.loginButtonIsClicked();
        boolean actualValue= aDash.loggedInSuccessfullyToastIsDisplayed();
        assertTrue(actualValue);
        logger.info("Executive Log in with Valid Credentials");
    }

    @Then("Executive Role Post Login")
    public void executiveRolePostLogin() {
        aDash.profileImageIsClicked();
        boolean actualValues;
        actualValues = aDash.executiveTextInProfileIconDisplays();
        assertTrue(actualValues);
    }

    @Then("Executive Login with Invalid Credentials")
    public void executiveLoginWithInvalidCredentials() {
        lps.enterTheInvalidEmailIntoTheEmailField();
        lps.enterTheInavalidPasswordIntoThePasswordField();
        boolean actualValues;
        actualValues = lps.pleaseEnterValidEmailAddressMessageIsDisplayed();
        assertTrue(actualValues);
        logger.info("Executive Login with Invalid Credentials");
    }

    @Then("Executive Login with Blank Fields")
    public void executiveLoginWithBlankFields() {
        ElementUtil.eu.refresh_your_page(DriverFactory.getDriver());
        lps.enterTheBlankEmailIntoTheEmailField();
        lps.enterTheBlankPasswordIntoThePasswordField();
        lps.loginButtonIsClicked();
        boolean actualValues1 = lps.pleaseEnterEmailAddressMesssageIsDisplayed();
        assertTrue(actualValues1);
        boolean actualValues2 = lps.pleaseEnterPasswordMesssageIsDisplayed();
        assertTrue(actualValues2);
        logger.info("Executive Login with Blank Fields");
    }

    @Then("Admin custom role user Log in with Valid Credentials")
    public void adminCustomRoleUserLogInWithValidCredentials() {
        lps.enterTheValidEmailIntoTheEmailField_AdminCustomRoleUser();
        lps.enterTheValidPasswordIntoThePasswordField_AdminCustomRoleUser();
        lps.loginButtonIsClicked();
        boolean actualValue = aDash.loggedInSuccessfullyToastIsDisplayed();
        assertTrue(actualValue);
        logger.info("Admin custom role user Log in with Valid Credentials");
    }

    @Then("Admin custom role user Role Post Login")
    public void adminCustomRoleUserRolePostLogin() {
        aDash.profileImageIsClicked();
        boolean actualValues = aDash.adminCustomRoleUserTextInProfileIconDisplays();
        assertTrue(actualValues);
        logger.info("Admin custom role user Role Post Login");
    }

    @Then("Admin custom role user Log in with Invalid Credentials")
    public void adminCustomRoleUserLogInWithInvalidCredentials() {
        lps.enterTheInvalidEmailIntoTheEmailField();
        lps.enterTheInavalidPasswordIntoThePasswordField();
        boolean actualValues;
        actualValues = lps.pleaseEnterValidEmailAddressMessageIsDisplayed();
        assertTrue(actualValues);
        logger.info("Admin custom role user Log in with Invalid Credentials");
    }

    @Then("Admin custom role user Log in with Blank Fields")
    public void adminCustomRoleUserLogInWithBlankFields() {
        ElementUtil.eu.refresh_your_page(DriverFactory.getDriver());
        lps.enterTheBlankEmailIntoTheEmailField();
        lps.enterTheBlankPasswordIntoThePasswordField();
        lps.loginButtonIsClicked();
        boolean actualValues1 = lps.pleaseEnterEmailAddressMesssageIsDisplayed();
        assertTrue(actualValues1);
        boolean actualValues2 = lps.pleaseEnterPasswordMesssageIsDisplayed();
        assertTrue(actualValues2);
        logger.info("Admin custom role user Log in with Blank Fields");
    }



    /*
    *
    *
    *
    * Forget password steps
    *
    *
    *
    *
    *
    *
    *
    *
    */

    @Given("the Super Admin is on the login page")
    public void theSuperAdminIsOnTheLoginPage() {
        String baseUrl = ConfigManager.getProperty("base.url");
        System.out.println("Original URL: " + baseUrl);
        String changedUrl;
        assert baseUrl != null;
        changedUrl = baseUrl.replaceFirst("s", "");
        System.out.println("Modified URL: " + changedUrl);
        DriverFactory.getDriver().get(changedUrl + "admin/login");
        logger.info("Super Admin is on the login page");
    }

    @When("the Super Admin clicks on Forgot Password")
    public void theSuperAdminClicksOnForgotPassword() {
        lps.forgotPasswordLinkIsClicked();
        logger.info("Super Admin clicks on Forgot Password");
    }

    @And("enters a valid registered email address")
    public void entersAValidRegisteredEmailAddress() {
        lps.enterTheValidEmailIntoTheEmailField_SuperAdmin();
        logger.info("Super Admin enters a valid registered email address");
    }

    @And("submits the request")
    public void submitsTheRequest() {
        lps.submitForgotPasswordRequest();
    }

    @Then("a password reset link should be sent to the Super Admins email")
    public void aPasswordResetLinkShouldBeSentToTheSuperAdminSEmail() {
        boolean actualValues = lps.passwordResetLinkSentMessageIsDisplayed();
        assertTrue(actualValues);
        logger.info("Password reset link sent to Super Admin's email");
    }

    @And("a confirmation message should be displayed")
    public void aConfirmationMessageShouldBeDisplayed() {
        boolean actualValues = lps.confirmationMessageIsDisplayed();
        assertTrue(actualValues);
        logger.info("Confirmation message displayed after password reset request");
    }

    @And("enters an unregistered email address")
    public void entersAnUnregisteredEmailAddress() {
        lps.enterTheInvalidEmailIntoTheEmailField();
        logger.info("Super Admin enters an unregistered email address");
    }

    @Then("an error message should be displayed indicating the email is not registered")
    public void anErrorMessageShouldBeDisplayedIndicatingTheEmailIsNotRegistered() {
        boolean actualValues = lps.errorMessageForUnregisteredEmailIsDisplayed();
        assertTrue(actualValues);
        logger.info("Error message displayed for unregistered email address");
    }

    @And("enters an invalid email format")
    public void entersAnInvalidEmailFormat() {
        lps.enterTheInvalidEmailIntoTheEmailField();
        logger.info("Super Admin enters an invalid email format");
    }

    @Then("an error message should be displayed indicating invalid email format")
    public void anErrorMessageShouldBeDisplayedIndicatingInvalidEmailFormat() {
        boolean actualValues = lps.errorMessageForInvalidEmailFormatIsDisplayed();
        assertTrue(actualValues);
        logger.info("Error message displayed for invalid email format");
    }

    @Given("the Super Admin has received a password reset email")
    public void theSuperAdminHasReceivedAPasswordResetEmail() {
        // This step would typically involve checking the email inbox for a password reset email.
        // For testing purposes, we assume the email has been received.
        logger.info("Super Admin has received a password reset email");
    }

    @When("the Super Admin clicks the reset link")
    public void theSuperAdminClicksTheResetLink() {
        lps.resetLinkIsClicked();
        logger.info("Super Admin clicks the reset link in the password reset email");
    }

    @And("enters a new valid password and confirms it")
    public void entersANewValidPasswordAndConfirmsIt() {
        lps.enterNewPassword("NewSecurePassword123");
        lps.confirmNewPassword("NewSecurePassword123");
        logger.info("Super Admin enters a new valid password and confirms it");
        // Here, you would typically check that the new password meets security requirements,
        // such as length, complexity, etc. This can be done in the AdminLoginPage class.
        boolean isPasswordValid = lps.isNewPasswordValid("NewSecurePassword123");
        Assert.assertTrue(isPasswordValid, "New password does not meet security requirements.");
        logger.info("New password meets security requirements");
    }

    @And("submits the new password")
    public void submitsTheNewPassword() {
        lps.submitNewPassword();
        logger.info("Super Admin submits the new password");
    }

    @Then("the password should be updated successfully")
    public void thePasswordShouldBeUpdatedSuccessfully() {
        boolean actualValues = lps.passwordUpdatedSuccessfullyMessageIsDisplayed();
        assertTrue(actualValues);
        logger.info("Password updated successfully for Super Admin");
    }

    @And("a success message should be displayed")
    public void aSuccessMessageShouldBeDisplayed() {
        boolean actualValues = lps.successMessageAfterPasswordUpdateIsDisplayed();
        assertTrue(actualValues);
        logger.info("Success message displayed after password update");
    }

    @Given("the Super Admin has an expired password reset link")
    public void theSuperAdminHasAnExpiredPasswordResetLink() {
        // This step would typically involve simulating an expired link.
        // For testing purposes, we assume the link has expired.
        logger.info("Super Admin has an expired password reset link");
        // You might want to set a flag or a condition in the AdminLoginPage class to simulate this.
        lps.setExpiredLink(true); // Assuming this method exists to set the state of the link.
    }

    @When("the Super Admin clicks the expired link")
    public void theSuperAdminClicksTheExpiredLink() {
        lps.clickExpiredResetLink();
        logger.info("Super Admin clicks the expired password reset link");
    }

    @Then("an error message should be displayed indicating the link has expired")
    public void anErrorMessageShouldBeDisplayedIndicatingTheLinkHasExpired() {
        boolean actualValues = lps.errorMessageForExpiredLinkIsDisplayed();
        assertTrue(actualValues);
        logger.info("Error message displayed for expired password reset link");
    }

    @Given("the Admin is on the login page")
    public void theAdminIsOnTheLoginPage() {
        String baseUrl = ConfigManager.getProperty("base.url");
        System.out.println("Original URL: " + baseUrl);
        String changedUrl;
        assert baseUrl != null;
        changedUrl = baseUrl.replaceFirst("s", "");
        System.out.println("Modified URL: " + changedUrl);
        DriverFactory.getDriver().get(changedUrl + "admin/login");
        logger.info("Admin is on the login page");
    }

    @When("the Admin clicks on Forgot Password")
    public void theAdminClicksOnForgotPassword() {
        lps.forgotPasswordLinkIsClicked();
        logger.info("Admin clicks on Forgot Password");
    }

    @Then("a password reset link should be sent to the Admins email")
    public void aPasswordResetLinkShouldBeSentToTheAdminsEmail() {
        lps.enterTheValidEmailIntoTheEmailField_Admin();
        lps.submitForgotPasswordRequest();
        boolean actualValues = lps.passwordResetLinkSentMessageIsDisplayed();
        assertTrue(actualValues);
        logger.info("Password reset link sent to Admin's email");
    }

    @Given("the Admin has received a password reset email")
    public void theAdminHasReceivedAPasswordResetEmail() {
        // This step would typically involve checking the email inbox for a password reset email.
        // For testing purposes, we assume the email has been received.
        logger.info("Admin has received a password reset email");
        // You might want to set a flag or a condition in the AdminLoginPage class to simulate this.
    }

    @When("the Admin clicks the reset link")
    public void theAdminClicksTheResetLink() {
        lps.resetLinkIsClicked();
        logger.info("Admin clicks the reset link in the password reset email");
    }

    @Given("the Admin has an expired password reset link")
    public void theAdminHasAnExpiredPasswordResetLink() {
        // This step would typically involve simulating an expired link.
        // For testing purposes, we assume the link has expired.
        logger.info("Admin has an expired password reset link");
        // You might want to set a flag or a condition in the AdminLoginPage class to simulate this.
        lps.setExpiredLink(true); // Assuming this method exists to set the state of the link.
    }

    @When("the Admin clicks the expired link")
    public void theAdminClicksTheExpiredLink() {
        lps.clickExpiredResetLink();
        logger.info("Admin clicks the expired password reset link");
    }

    @Given("the Executive is on the login page")
    public void theExecutiveIsOnTheLoginPage() {
        String baseUrl = ConfigManager.getProperty("base.url");
        System.out.println("Original URL: " + baseUrl);
        String changedUrl;
        assert baseUrl != null;
        changedUrl = baseUrl.replaceFirst("s", "");
        System.out.println("Modified URL: " + changedUrl);
        DriverFactory.getDriver().get(changedUrl + "admin/login");
        logger.info("Executive is on the login page");
    }

    @When("the Executive clicks on Forgot Password")
    public void theExecutiveClicksOnForgotPassword() {
        lps.forgotPasswordLinkIsClicked();
        logger.info("Executive clicks on Forgot Password");
    }

    @Then("a password reset link should be sent to the Executive's email")
    public void aPasswordResetLinkShouldBeSentToTheExecutiveSEmail() {
        lps.enterTheValidEmailIntoTheEmailField_executive();
        lps.submitForgotPasswordRequest();
        boolean actualValues = lps.passwordResetLinkSentMessageIsDisplayed();
        assertTrue(actualValues);
        logger.info("Password reset link sent to Executive's email");
    }

    @Given("the Executive has received a password reset email")
    public void theExecutiveHasReceivedAPasswordResetEmail() {
        // This step would typically involve checking the email inbox for a password reset email.
        // For testing purposes, we assume the email has been received.
        logger.info("Executive has received a password reset email");
        // You might want to set a flag or a condition in the AdminLoginPage class to simulate this.
    }

    @When("the Executive clicks the reset link")
    public void theExecutiveClicksTheResetLink() {
        lps.resetLinkIsClicked();
        logger.info("Executive clicks the reset link in the password reset email");
    }

    @Given("the Executive has an expired password reset link")
    public void theExecutiveHasAnExpiredPasswordResetLink() {
        // This step would typically involve simulating an expired link.
        // For testing purposes, we assume the link has expired.
        logger.info("Executive has an expired password reset link");
        // You might want to set a flag or a condition in the AdminLoginPage class to simulate this.
        lps.setExpiredLink(true); // Assuming this method exists to set the state of the link.
    }

    @When("the Executive clicks the expired link")
    public void theExecutiveClicksTheExpiredLink() {
        lps.clickExpiredResetLink();
        logger.info("Executive clicks the expired password reset link");
    }
}