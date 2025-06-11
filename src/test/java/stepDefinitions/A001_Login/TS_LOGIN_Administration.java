package stepDefinitions.A001_Login;

import com.pages.Dashboards.AdminDashboard;
import com.pages.login.*;
import com.qa.factory.DriverFactory;
import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
//        To Do
    }

    @Then("Admin custom role user Role Post Login")
    public void adminCustomRoleUserRolePostLogin() {
        //        To Do
    }

}