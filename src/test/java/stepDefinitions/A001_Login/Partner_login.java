package stepDefinitions.A001_Login;

import com.pages.Dashboards.PartnerDashbaordPage;
import com.pages.LandingPage;
import com.pages.login.PartnerLoginPage;
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

public class Partner_login {

    private final LandingPage lpo = new LandingPage(DriverFactory.getDriver());
    private  final PartnerLoginPage plp = new PartnerLoginPage(DriverFactory.getDriver());
    private final PartnerDashbaordPage pDash = new PartnerDashbaordPage(DriverFactory.getDriver());
    Logger logger = LogManager.getLogger(Partner_login.class);


    @Given("User is on the Partner admin login page")
    public void userIsOnThePartnerAdminLoginPage() {
//        DriverFactory.getDriver().get(ConfigManager.getProperty("base.url"));

        String baseUrl = ConfigManager.getProperty("base.url");
        String changedUrl;
        assert baseUrl != null;
        changedUrl = baseUrl.replaceFirst("s", "");
        System.out.println("Modified URL: " + changedUrl);
        DriverFactory.getDriver().get(changedUrl);

        lpo.loginButtonMouseHover();
        lpo.loginAsPartnerClicked();
        ElementUtil.eu.wait_for_to_be_title_is_displayed(DriverFactory.getDriver(), 10,"Shield - Partner Sign In");
        String currentTitle = plp.getTheCurrentPageTitle();
        Assert.assertEquals(currentTitle, "Shield - Partner Sign In");
    }

    @Then("Partner Admin Login with Valid Credentials")
    public void partnerAdminLoginWithValidCredentials() {
        plp.enterTheValidEmailIntoTheEmailField_Partner_Admin();
        plp.enterTheValidPasswordIntoThePasswordField_Partner_Admin();
        plp.loginButtonIsClicked();
        boolean actualValue = pDash.loggedInSuccessfullyToastIsDisplayed();
        Assert.assertTrue(actualValue);
        logger.info("Partner Admin Login with Valid Credentials");
    }

    @Then("Partner Admin Role Post Login")
    public void partnerAdminRolePostLogin() {
        pDash.profileImageIsClicked();
        boolean actualValues;
        actualValues = pDash.partnerAdminTextInProfileIconDisplays();
        assertTrue(actualValues);
        logger.info("Partner Admin Role Post Login");
    }


    @Then("Partner Admin Login with Invalid Credentials")
    public void partnerAdminLoginWithInvalidCredentials() {
        plp.enterTheInvalidEmailIntoTheEmailField();
        plp.enterTheInavalidPasswordIntoThePasswordField();
        boolean actualValues;
        actualValues = plp.pleaseEnterValidEmailAddressMessageIsDisplayed();
        assertTrue(actualValues);
        logger.info("Partner Admin Login with Invalid Credentials");
    }

    @Then("Partner Admin Login with Blank Fields")
    public void partnerAdminLoginWithBlankFields() {
        ElementUtil.eu.refresh_your_page(DriverFactory.getDriver());
        plp.enterTheBlankEmailIntoTheEmailField();
        plp.enterTheBlankPasswordIntoThePasswordField();
        plp.loginButtonIsClicked();
        boolean actualValues1 = plp.pleaseEnterEmailAddressMesssageIsDisplayed();
        assertTrue(actualValues1);
        boolean actualValues2 = plp.pleaseEnterPasswordMesssageIsDisplayed();
        assertTrue(actualValues2);
        logger.info("Partner Admin Login with Blank Fields");
    }

    @Then("Partner Password Field Masking")
    public void partnerPasswordFieldMasking() {
        ElementUtil.eu.refresh_your_page(DriverFactory.getDriver());
        plp.enterPassword("YourSecurePassword");
        Assert.assertTrue(plp.isPasswordMasked());
        plp.togglePasswordVisibility();
        Assert.assertTrue(plp.isPasswordVisible());
        plp.togglePasswordVisibility();
        Assert.assertTrue(plp.isPasswordMasked());
        logger.info("Partner Password Field Masking");
    }

    @Then("Partner Back button redirection")
    public void partnerBackButtonRedirection() {
        plp.enterTheValidEmailIntoTheEmailField_Partner_Admin();
        plp.enterTheValidPasswordIntoThePasswordField_Partner_Admin();
        plp.loginButtonIsClicked();
        pDash.loggedInSuccessfullyToastIsDisplayed();
        String currentURL = pDash.getTheDashboardUrl();
        System.out.println(currentURL +"----current DASH URL");
        plp.redirectToTheLoginBackPage();
        String expectedURL =
                ConfigManager.getProperty("base.url")
                        .replaceFirst("s","")+"partner/dashboard/";
        ElementUtil.eu.waitForExpectedURL(DriverFactory.getDriver(), expectedURL);
        System.out.println(expectedURL +"----expectedURL");
        Assert.assertEquals(currentURL, expectedURL);
        logger.info("Back button redirection");
    }

    @Then("Partner executive Login with Valid Credentials")
    public void partnerExecutiveLoginWithValidCredentials() {
        plp.enterTheValidEmailIntoTheEmailField_Partner_Executive();
        plp.enterTheValidPasswordIntoThePasswordField_Partner_Admin();
        plp.loginButtonIsClicked();
        boolean actualValue = pDash.loggedInSuccessfullyToastIsDisplayed();
        Assert.assertTrue(actualValue);
        logger.info("Partner executive Login with Valid Credentials");
    }

    @Then("Partner executive Role Post Login")
    public void partnerExecutiveRolePostLogin() {
        pDash.profileImageIsClicked();
        boolean actualValues;
        actualValues = pDash.partnerExecutiveTextInProfileIconDisplays();
        assertTrue(actualValues);
        logger.info("Partner executive Role Post Login");
    }

    @Then("Partner executive Login with Invalid Credentials")
    public void partnerExecutiveLoginWithInvalidCredentials() {
        plp.enterTheInvalidEmailIntoTheEmailField();
        plp.enterTheInavalidPasswordIntoThePasswordField();
        boolean actualValues;
        actualValues = plp.pleaseEnterValidEmailAddressMessageIsDisplayed();
        assertTrue(actualValues);
        logger.info("Partner executive Login with Invalid Credentials");
    }

    @Then("Partner executive Login with Blank Fields")
    public void partnerExecutiveLoginWithBlankFields() {
        ElementUtil.eu.refresh_your_page(DriverFactory.getDriver());
        plp.enterTheBlankEmailIntoTheEmailField();
        plp.enterTheBlankPasswordIntoThePasswordField();
        plp.loginButtonIsClicked();
        boolean actualValues1 = plp.pleaseEnterEmailAddressMesssageIsDisplayed();
        assertTrue(actualValues1);
        boolean actualValues2 = plp.pleaseEnterPasswordMesssageIsDisplayed();
        assertTrue(actualValues2);
        logger.info("Partner executive Login with Blank Fields");
    }


    @Then("Partner custom role user Log in with Valid Credentials")
    public void partnerCustomRoleUserLogInWithValidCredentials() {
        plp.enterTheValidEmailIntoTheEmailField_Partner_Custom_Role_User();
        plp.enterTheValidPasswordIntoThePasswordField_Partner_Admin();
        plp.loginButtonIsClicked();
        boolean actualValue = pDash.loggedInSuccessfullyToastIsDisplayed();
        Assert.assertTrue(actualValue);
        logger.info("Partner custom role user Log in with Valid Credentials");
    }

    @Then("Partner custom role user Role Post Login")
    public void partnerCustomRoleUserRolePostLogin() {
        pDash.profileImageIsClicked();
        boolean actualValues;
        actualValues = pDash.partnerCustomRoleUserTextInProfileIconDisplays();
        assertTrue(actualValues);
        logger.info("Partner custom role user Role Post Login");
    }

    @Then("Partner custom role user Log in with Invalid Credentials")
    public void partnerCustomRoleUserLogInWithInvalidCredentials() {
        plp.enterTheInvalidEmailIntoTheEmailField();
        plp.enterTheInavalidPasswordIntoThePasswordField();
        boolean actualValues;
        actualValues = plp.pleaseEnterValidEmailAddressMessageIsDisplayed();
        assertTrue(actualValues);
        logger.info("Partner custom role user Log in with Invalid Credentials");
    }

    @Then("Partner custom role user Log in with Blank Fields")
    public void partnerCustomRoleUserLogInWithBlankFields() {
        ElementUtil.eu.refresh_your_page(DriverFactory.getDriver());
        plp.enterTheBlankEmailIntoTheEmailField();
        plp.enterTheBlankPasswordIntoThePasswordField();
        plp.loginButtonIsClicked();
        boolean actualValues1 = plp.pleaseEnterEmailAddressMesssageIsDisplayed();
        assertTrue(actualValues1);
        boolean actualValues2 = plp.pleaseEnterPasswordMesssageIsDisplayed();
        assertTrue(actualValues2);
        logger.info("Partner custom role user Log in with Blank Fields");
    }


    /**
     *
     *
     * This method is used to navigate the Partner Admin to the login page.
     *
     *
     */

    @Given("the partner admin is on the login page")
    public void thePartnerAdminIsOnTheLoginPage() {
        String baseUrl = ConfigManager.getProperty("base.url");
        String changedUrl;
        assert baseUrl != null;
        changedUrl = baseUrl.replaceFirst("s", "");
        System.out.println("Modified URL: " + changedUrl);
        DriverFactory.getDriver().get(changedUrl);

        lpo.loginButtonMouseHover();
        lpo.loginAsPartnerClicked();
        String currentTitle = plp.getTheCurrentPageTitle();
        ElementUtil.eu.waitForPageToLoad(DriverFactory.getDriver());
        Assert.assertEquals(currentTitle, "Shield - Partner Sign In");
    }


    @And("the partner admin clicks on Forgot Password")
    public void thePartnerAdminClicksOnForgotPassword() {
        plp.forgotPasswordLinkIsClicked();
        ElementUtil.eu.waitForPageToLoad(DriverFactory.getDriver());
        String currentTitle = plp.getTheCurrentPageTitle();
        Assert.assertEquals(currentTitle, "Shield - Forgot Password");
        logger.info("Partner Admin navigated to Forgot Password page");
    }

    @When("the partner admin enters a valid registered email address")
    public void thePartnerAdminEntersAValidRegisteredEmailAddress() {
        String email = ConfigManager.getConfigProperties().getProperty("Partner_Admin_email");
        if (email != null && !email.isEmpty()) {
            plp.enterTheValidEmailIntoTheEmailField_Partner_Admin();
        } else {
            throw new IllegalArgumentException("Email address is not configured in the properties file.");
        }
        logger.info("Partner Admin entered a valid registered email address for password reset.");
    }

    @And("the partner admin submits the password reset request")
    public void thePartnerAdminSubmitsThePasswordResetRequest() {
        plp.submitPasswordResetRequest();
        logger.info("Partner Admin submitted the password reset request.");
    }

    @Then("a password reset link should be sent to the partner admin's email")
    public void aPasswordResetLinkShouldBeSentToThePartnerAdminSEmail() {
        plp.requestLinkSentMessageIsDisplayed();
        String expectedMessage = "Password reset link sent successfully";
        String actualMessage = plp.getRequestLinkSentMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "The confirmation message does not match the expected message.");
    }

    @And("a confirmation message should be displayed to the partner admin")
    public void aConfirmationMessageShouldBeDisplayedToThePartnerAdmin() {
        String expectedMessage = "Password reset link sent successfully";
        String actualMessage = plp.getRequestLinkSentMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "The confirmation message does not match the expected message.");
        logger.info("Confirmation message displayed to the partner admin: " + actualMessage);
    }

    @When("the partner admin enters an unregistered email address")
    public void thePartnerAdminEntersAnUnregisteredEmailAddress() {
        String unregisteredEmail = ConfigManager.getProperty("Unregistered_email");
        if (unregisteredEmail != null && !unregisteredEmail.isEmpty()) {
            plp.enterTheunregisteredEmailIntoTheEmailField(unregisteredEmail);
        } else {
            throw new IllegalArgumentException("Unregistered email address is not configured in the properties file.");
        }
    }

    @Then("an error message should be displayed to the partner admin indicating the email is not registered")
    public void anErrorMessageShouldBeDisplayedToThePartnerAdminIndicatingTheEmailIsNotRegistered() {
        boolean isErrorDisplayed = plp.errorMessageForUnregisteredEmailIsDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Error message for unregistered email is not displayed.");
        String expectedErrorMessage = "The email is invalid!";
        String actualErrorMessage = plp.getUnregisteredEmailErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The error message does not match the expected message.");
        logger.info("Error message displayed to the partner admin for unregistered email: " + actualErrorMessage);
    }

    @When("the partner admin enters an invalid email format")
    public void thePartnerAdminEntersAnInvalidEmailFormat() {
        plp.enterTheInvalidEmailIntoTheEmailField();
        logger.info("Partner Admin entered an invalid email format for password reset.");
    }

    @Then("an error message should be displayed to the partner admin indicating an invalid email format")
    public void anErrorMessageShouldBeDisplayedToThePartnerAdminIndicatingAnInvalidEmailFormat() {
        boolean isErrorDisplayed = plp.pleaseEnterValidEmailAddressMessageForgetPasswordIsDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Error message for invalid email format is not displayed.");
        String expectedErrorMessage = "Please enter a valid email address.";
        String actualErrorMessage = plp.getInvalidEmailErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The error message does not match the expected message.");
        logger.info("Error message displayed to the partner admin for invalid email format: " + actualErrorMessage);
    }

    @Given("the partner executive is on the login page")
    public void thePartnerExecutiveIsOnTheLoginPage() {
        String baseUrl = ConfigManager.getProperty("base.url");
        String changedUrl;
        assert baseUrl != null;
        changedUrl = baseUrl.replaceFirst("s", "");
        System.out.println("Modified URL: " + changedUrl);
        DriverFactory.getDriver().get(changedUrl);

        lpo.loginButtonMouseHover();
        lpo.loginAsPartnerClicked();
        String currentTitle = plp.getTheCurrentPageTitle();
        ElementUtil.eu.waitForPageToLoad(DriverFactory.getDriver());
        Assert.assertEquals(currentTitle, "Shield - Partner Sign In");
    }

    @And("the partner executive clicks on Forgot Password")
    public void thePartnerExecutiveClicksOnForgotPassword() {
        plp.forgotPasswordLinkIsClicked();
        ElementUtil.eu.waitForPageToLoad(DriverFactory.getDriver());
        String currentTitle = plp.getTheCurrentPageTitle();
        Assert.assertEquals(currentTitle, "Shield - Forgot Password");
        logger.info("Partner Executive navigated to Forgot Password page");
    }


    @When("the partner executive enters a valid registered email address")
    public void thePartnerExecutiveEntersAValidRegisteredEmailAddress() {
        String email = ConfigManager.getConfigProperties().getProperty("Partner_executive_email");
        if (email != null && !email.isEmpty()) {
            plp.enterTheValidEmailIntoTheEmailField_Partner_Executive();
        } else {
            throw new IllegalArgumentException("Email address is not configured in the properties file.");
        }
        logger.info("Partner Executive entered a valid registered email address for password reset.");
    }


    @And("the partner executive submits the password reset request")
    public void thePartnerExecutiveSubmitsThePasswordResetRequest() {
        plp.submitPasswordResetRequest();
        logger.info("Partner Executive submitted the password reset request.");
    }


    @Then("a password reset link should be sent to the partner executive's email")
    public void aPasswordResetLinkShouldBeSentToThePartnerExecutiveSEmail() {
        plp.requestLinkSentMessageIsDisplayed();
        String expectedMessage = "Password reset link sent successfully";
        String actualMessage = plp.getRequestLinkSentMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "The confirmation message does not match the expected message.");
    }


    @And("a confirmation message should be displayed to the partner executive")
    public void aConfirmationMessageShouldBeDisplayedToThePartnerExecutive() {
        String expectedMessage = "Password reset link sent successfully";
        String actualMessage = plp.getRequestLinkSentMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "The confirmation message does not match the expected message.");
        logger.info("Confirmation message displayed to the partner executive: " + actualMessage);
    }

    @When("the partner executive enters an unregistered email address")
    public void thePartnerExecutiveEntersAnUnregisteredEmailAddress() {
        String unregisteredEmail = ConfigManager.getProperty("Unregistered_email");
        if (unregisteredEmail != null && !unregisteredEmail.isEmpty()) {
            plp.enterTheunregisteredEmailIntoTheEmailField(unregisteredEmail);
        } else {
            throw new IllegalArgumentException("Unregistered email address is not configured in the properties file.");
        }
    }


    @Then("an error message should be displayed to the partner executive indicating the email is not registered")
    public void anErrorMessageShouldBeDisplayedToThePartnerExecutiveIndicatingTheEmailIsNotRegistered() {
        boolean isErrorDisplayed = plp.errorMessageForUnregisteredEmailIsDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Error message for unregistered email is not displayed.");
        String expectedErrorMessage = "The email is invalid!";
        String actualErrorMessage = plp.getUnregisteredEmailErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The error message does not match the expected message.");
        logger.info("Error message displayed to the partner executive for unregistered email: " + actualErrorMessage);
    }

    @When("the partner executive enters an invalid email format")
    public void thePartnerExecutiveEntersAnInvalidEmailFormat() {
        plp.enterTheInvalidEmailIntoTheEmailField();
        logger.info("Partner Executive entered an invalid email format for password reset.");
    }


    @Then("an error message should be displayed to the partner executive indicating an invalid email format")
    public void anErrorMessageShouldBeDisplayedToThePartnerExecutiveIndicatingAnInvalidEmailFormat() {
        boolean isErrorDisplayed = plp.pleaseEnterValidEmailAddressMessageForgetPasswordIsDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Error message for invalid email format is not displayed.");
        String expectedErrorMessage = "Please enter a valid email address.";
        String actualErrorMessage = plp.getInvalidEmailErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The error message does not match the expected message.");
        logger.info("Error message displayed to the partner executive for invalid email format: " + actualErrorMessage);
    }
}