package stepDefinitions.A001_Login;

import com.pages.Dashboards.AdminDashboardPage;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class Administration_login {
    private final AdminLoginPage lps = new AdminLoginPage(DriverFactory.getDriver());
    private final AdminDashboardPage aDash = new AdminDashboardPage(DriverFactory.getDriver());
    Logger logger = LogManager.getLogger(Administration_login.class);

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
        ElementUtil.eu.wait_for_to_be_title_is_displayed(DriverFactory.getDriver(), 10, "Shield - Admin Dashboard");
        String currentURL = aDash.getDashboardUrl();
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
        lps.enterValidRegisteredEmailAddress_superadmin();
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
        lps.enterTheUnregisteredEmailIntoTheEmailField();
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
        boolean actualValues = lps.passwordResetLinkSentMessageIsDisplayed();
        assertTrue(actualValues);
        logger.info("Password reset link sent to Admin's email");
    }

    @Given("the Admin has received a password reset email")
    public void theAdminHasReceivedAPasswordResetEmail() {
        DriverFactory.getDriver().get("https://mailtrap.io/signin");
        ElementUtil.eu.waitForPageToLoad(DriverFactory.getDriver());
//        ElementUtil.eu.scroll_down_body_click(1, DriverFactory.getDriver());
        WebElement emailmailtrap = DriverFactory.getDriver().findElement(By.xpath("//input[@type='email' and @name='user[email]' and @id='user_email']"));
        emailmailtrap.sendKeys("kishor.deshmane@iffort.com");
        DriverFactory.getDriver().findElement(By.xpath("//a[contains(@class, 'login_next_button') and text()='Next']")).click();
        ElementUtil.eu.scroll_down_body_click(1, DriverFactory.getDriver());
        WebElement passwordmailtrap = DriverFactory.getDriver().findElement(By.xpath("//input[@type='password' and @id='user_password']"));
        passwordmailtrap.sendKeys("Test@123");
        DriverFactory.getDriver().findElement(By.xpath("//*[@type='submit']")).click();

        // Maitrap need the verification code to login, which can not beb handled.

        logger.info("Admin has received a password reset email");
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

    @And("enters admin valid registered email address")
    public void entersAdminValidRegisteredEmailAddress() {
        lps.enterValidRegisteredEmailAddress_admin();
        logger.info("Admin enters a valid registered email address");
    }

    @And("enters executive valid registered email address")
    public void entersExecutiveValidRegisteredEmailAddress() {
        lps.enterValidRegisteredEmailAddress_executive();
        logger.info("Executive enters a valid registered email address");
    }
}