package stepDefinitions.A002_Profile;

import com.pages.Dashboards.AdminDashboardPage;
import com.pages.login.AdminLoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Executive_profile {

    private final AdminLoginPage lps = new AdminLoginPage(DriverFactory.getDriver());
    private final AdminDashboardPage aDash = new AdminDashboardPage(DriverFactory.getDriver());
    Logger logger = LogManager.getLogger(Executive_profile.class);


    @And("Executive Profile Page is loaded")
    public void executiveProfilePageIsLoaded() {
        
    }

    @Then("Executive Profile Page should load successfully")
    public void executiveProfilePageShouldLoadSuccessfully() {
    }

    @Then("all Executive required profile fields should be visible")
    public void allExecutiveRequiredProfileFieldsShouldBeVisible() {
    }



}
