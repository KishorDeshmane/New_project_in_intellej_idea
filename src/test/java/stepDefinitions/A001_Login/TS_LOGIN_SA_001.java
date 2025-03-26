package stepDefinitions.A001_Login;

import com.pages.Dashboards.AdminDashboard;
import com.pages.login.AdminLogin;
import com.qa.factory.DriverFactory;
import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class TS_LOGIN_SA_001 {
    private final AdminLogin lps = new AdminLogin(DriverFactory.getDriver());
    private final AdminDashboard aDash = new AdminDashboard(DriverFactory.getDriver());
    Logger logger = LogManager.getLogger(TS_LOGIN_SA_001.class);

    @Given("User is on the admin login page")
    public void userIsOnTheAdminLoginPage() {
        String baseUrl = ConfigManager.getProperty("base.url");
        DriverFactory.getDriver().get(baseUrl + "admin/login");
    }

    @Then("Super Admin Login with Valid Credentials")
    public void superAdminLoginWithValidCredentials() {
        lps.enterTheValidEmailIntoTheEmailField();
        lps.enterTheValidPasswordIntoThePasswordField();
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
        System.out.println("Refresh this page");
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

    @Then("Password Field Masking")
    public void passwordFieldMasking() {
        ElementUtil.eu.refresh_your_page(DriverFactory.getDriver());
        lps.enterPassword("YourSecurePassword");
        // Step 1: Verify default masking
        Assert.assertTrue(lps.isPasswordMasked());
        // Step 2: Toggle to show password
        lps.togglePasswordVisibility();
        Assert.assertTrue(lps.isPasswordVisible());
        // Step 3: Toggle to hide password again
        lps.togglePasswordVisibility();
        Assert.assertTrue(lps.isPasswordMasked());
    }






}