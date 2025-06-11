package stepDefinitions.A001_Login;

import com.pages.Dashboards.AdminDashboard;
import com.pages.Dashboards.PartnerDashbaord;
import com.pages.LandingPage;
import com.pages.login.PartnerLoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class TS_LOGIN_Partner {

    private final LandingPage lpo = new LandingPage(DriverFactory.getDriver());
    private  final PartnerLoginPage plp = new PartnerLoginPage(DriverFactory.getDriver());
    private final PartnerDashbaord pDash = new PartnerDashbaord(DriverFactory.getDriver());
    Logger logger = LogManager.getLogger(TS_LOGIN_Partner.class);


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
        String currentTitle = plp.getTheCurrentPageTitle();
        Assert.assertEquals(currentTitle, "Shield - Partner Sign-In");
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
}