package stepDefinitions.A002_Profile;

import com.pages.Dashboards.PartnerDashbaordPage;
import com.pages.LandingPage;
import com.pages.login.PartnerLoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Partner_executive_profile {
    private final LandingPage lpo = new LandingPage(DriverFactory.getDriver());
    private  final PartnerLoginPage plp = new PartnerLoginPage(DriverFactory.getDriver());
    private final PartnerDashbaordPage pDash = new PartnerDashbaordPage(DriverFactory.getDriver());
    Logger logger = LogManager.getLogger(Partner_executive_profile.class);

    @And("Partner executive Profile Page is loaded")
    public void partnerExecutiveProfilePageIsLoaded() {
    }

    @Then("Partner executive Profile Page should load successfully")
    public void partnerExecutiveProfilePageShouldLoadSuccessfully() {
    }

    @Then("All Partner executive required profile fields should be visible")
    public void allPartnerExecutiveRequiredProfileFieldsShouldBeVisible() {
    }
}
