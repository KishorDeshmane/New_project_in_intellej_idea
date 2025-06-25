package stepDefinitions.A001_Login;

import com.pages.Dashboards.CustomerDashboardPage;
import com.pages.LandingPage;
import com.pages.login.CustomerLoginPage;
import com.pages.login.VerifyOTPPage;
import com.qa.factory.DriverFactory;
import com.qa.utility.ConfigManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.Objects;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Customer_login {

    private final LandingPage laP = new LandingPage(DriverFactory.getDriver());
    private final CustomerLoginPage clp = new CustomerLoginPage(DriverFactory.getDriver());
    private final VerifyOTPPage vop = new VerifyOTPPage(DriverFactory.getDriver());
    private final CustomerDashboardPage cDash = new CustomerDashboardPage(DriverFactory.getDriver());
    Logger logger = LogManager.getLogger(Customer_login.class);


    @Given("User is on the Customer login page")
    public void userIsOnTheCustomerLoginPage() {
//        DriverFactory.getDriver().get(ConfigManager.getProperty("base.url"));
        String baseUrl = ConfigManager.getProperty("base.url");
        String changedUrl;
        assert baseUrl != null;
        changedUrl = baseUrl.replaceFirst("s", "");
        DriverFactory.getDriver().get(changedUrl);
        laP.loginButtonMouseHover();
        laP.loginAsCustomerClicked();
        boolean value = clp.mobileNumberInputFieldIsDisplayed();
        assertTrue(value);
    }

    @Then("Customer Log in with Valid Credentials")
    public void customerLogInWithValidCredentials() {
        clp.mobileNumberInputFieldSendNumber();
        clp.getOtpButtonIsClicked();
        boolean value = vop.OtpSendToastSuccessIsDisplayed();
        assertTrue(value);
        vop.sendValuesIntoTheOTPField();
        vop.verifyOTPTextIsclicked();
        boolean actual = cDash.customerLoggedInSuccessfullyToastIsDisplayed();
        assertTrue(actual);
        logger.info("Customer Log in with Valid Credentials");
    }

    @Then("Customer Role Post Login")
    public void customerRolePostLogin() {
        boolean actual = cDash.bookingHistoryTabIsDisplayed();
        assertTrue(actual);
        logger.info("Customer Role Post Login");
    }

    @Then("Customer Log in with Blank Fields")
    public void customerLogInWithBlankFields() {
        boolean actual = clp.getOtpButtonIsClickable();
        System.out.println(actual);
        assertTrue(actual);
        clp.mobileNumberInputFieldSendNumber();
        clp.getOtpButtonIsClicked();
        boolean actualresult = vop.verifyOTPTextIsclickable();
        assertFalse(actualresult);
        logger.info("Customer Log in with Blank Fields");
    }

    @Then("Customer OTP Field Masking")
    public void customerOTPFieldMasking() {
    boolean result = vop.maskedOTPFieldValidation();
    assertTrue(result);
    logger.info("Customer OTP Field Masking");
    }

    @Then("Customer Back button redirection")
    public void customerBackButtonRedirection() {
        clp.mobileNumberInputFieldSendNumber();
        clp.getOtpButtonIsClicked();
        vop.sendValuesIntoTheOTPField();
        vop.verifyOTPTextIsclicked();
        cDash.bookingHistoryTabIsDisplayed();
        String currentURL = cDash.getTheDashboardUrl();
        clp.redirectToTheLoginBackPage();
        String expectedURL =
                Objects.requireNonNull(ConfigManager.getProperty("base.url"))
                        .replaceFirst("s","");
        Assert.assertEquals(currentURL, expectedURL);
        logger.info("Back button redirection");
    }
}
