package stepDefinitions.A002_Profile;

import com.pages.Dashboards.CustomerDashboardPage;
import com.pages.LandingPage;
import com.pages.login.CustomerLoginPage;
import com.pages.login.VerifyOTPPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Customer_profile {

    private final LandingPage laP = new LandingPage(DriverFactory.getDriver());
    private final CustomerLoginPage clp = new CustomerLoginPage(DriverFactory.getDriver());
    private final VerifyOTPPage vop = new VerifyOTPPage(DriverFactory.getDriver());
    private final CustomerDashboardPage cDash = new CustomerDashboardPage(DriverFactory.getDriver());
    Logger logger = LogManager.getLogger(Customer_profile.class);

    @And("Customer Profile Page is loaded")
    public void customerProfilePageIsLoaded() {
    }

    @Then("Customer Profile Page should load successfully")
    public void customerProfilePageShouldLoadSuccessfully() {
    }

    @Then("All Customer required profile fields should be visible")
    public void allCustomerRequiredProfileFieldsShouldBeVisible() {
    }
}
