package stepDefinitions.A002_Profile;

import com.pages.Dashboards.AdminDashboardPage;
import com.pages.Profile.SuperAdminProfilePage;
import com.pages.login.AdminLoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Super_admin_profile {

    private final AdminLoginPage lps = new AdminLoginPage(DriverFactory.getDriver());
    private final AdminDashboardPage aDash = new AdminDashboardPage(DriverFactory.getDriver());
    private final SuperAdminProfilePage saProfile = new SuperAdminProfilePage(DriverFactory.getDriver());
    Logger logger = LogManager.getLogger(Admin_custom_profile.class);


    @And("Super Admin Profile Page is loaded")
    public void superAdminProfilePageIsLoaded() {
        aDash.profileImageIsClicked();
        aDash.profileTextIsClickedFromPopUp();
        logger.info("Super Admin Profile Page is loaded");
    }

    @Then("Super Admin Profile Page should load successfully")
    public void superAdminProfilePageShouldLoadSuccessfully() {
        saProfile.verifySuperAdminProfilePageIsLoaded();
        logger.info("Super Admin Profile Page loaded successfully");
    }

    @Then("All required Super Admin profile fields should be visible")
    public void allRequiredSuperAdminProfileFieldsShouldBeVisible() {
        saProfile.verifyAllRequiredSuperAdminProfileFieldsAreVisible();
        logger.info("All required Super Admin profile fields are visible");
    }

}
