package stepDefinitions.A002_Profile;

import com.pages.Dashboards.AdminDashboardPage;
import com.pages.login.AdminLoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Admin_custom_profile {

    private final AdminLoginPage lps = new AdminLoginPage(DriverFactory.getDriver());
    private final AdminDashboardPage aDash = new AdminDashboardPage(DriverFactory.getDriver());
    Logger logger = LogManager.getLogger(Admin_custom_profile.class);

    @And("Admin custom role user Profile Page is loaded")
    public void adminCustomRoleUserProfilePageIsLoaded() {
    }

    @Then("Admin custom role user Profile Page should load successfully")
    public void adminCustomRoleUserProfilePageShouldLoadSuccessfully() {
    }

    @Then("All Admin custom role user required profile fields should be visible")
    public void allAdminCustomRoleUserRequiredProfileFieldsShouldBeVisible() {
    }
}
