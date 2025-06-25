package stepDefinitions.A002_Profile;

import com.pages.Dashboards.AdminDashboardPage;
import com.pages.Profile.ExecutiveProfilePage;
import com.pages.login.AdminLoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utility.ConfigManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Executive_profile {

    private final AdminLoginPage lps = new AdminLoginPage(DriverFactory.getDriver());
    private final AdminDashboardPage aDash = new AdminDashboardPage(DriverFactory.getDriver());
    private final ExecutiveProfilePage eprofile = new ExecutiveProfilePage(DriverFactory.getDriver());
    Logger logger = LogManager.getLogger(Executive_profile.class);


    @And("Executive Profile Page is loaded")
    public void executiveProfilePageIsLoaded() {
        aDash.profileImageIsClicked();
        aDash.profileTextIsClickedFromPopUp_JAVASCRIPT();
        logger.info("Executive Profile Page is loaded");
    }

    @Then("Executive Profile Page should load successfully")
    public void executiveProfilePageShouldLoadSuccessfully() {
        eprofile.verifyExecutiveProfilePageIsLoaded();
        logger.info("Admin Profile Page loaded successfully");
    }

    @Then("all Executive required profile fields should be visible")
    public void allExecutiveRequiredProfileFieldsShouldBeVisible() {
        eprofile.verifyAllExecutiveRequiredProfileFieldsAreVisible();
        logger.info("All required Executive profile fields are visible");
    }


    @When("Executive updates all editable fields with valid information")
    public void executiveUpdatesAllEditableFieldsWithValidInformation() {
        eprofile.enterFirstName("Kishor");
        eprofile.enterLastName("Executive");
        logger.info("Executive updates all editable fields with valid information: First Name and Last Name");
    }

    @And("Executive clicks the Save button")
    public void executiveClicksTheSaveButton() {
        eprofile.clickOnSaveButton();
        logger.info("Executive clicks the Save button");
    }

    @Then("Executive's profile should be updated successfully")
    public void executiveSProfileShouldBeUpdatedSuccessfully() {
        eprofile.verifyExecutiveProfilePageIsLoaded();
        logger.info("Executive's profile is updated successfully");
    }

    @And("a success message should be displayed to the Executive")
    public void aSuccessMessageShouldBeDisplayedToTheExecutive() {
        String successMessage = "Profile updated successfully";
        eprofile.verifySuccessMessage(successMessage);
        logger.info("Success message displayed to the Executive: " + successMessage);
    }

    @When("Executive enters an invalid last name format in the last name field")
    public void executiveEntersAnInvalidLastNameFormatInTheLastNameField() {
        eprofile.enterLastName("@#$%%^FFF");
        logger.info("Admin entered an invalid email format in the email field");
    }

    @Then("an error message should be displayed for the last name field to the Executive")
    public void anErrorMessageShouldBeDisplayedForTheLastNameFieldToTheExecutive() {
        String errorMessage = "Only alphabets, space, dot, and hyphen are allowed. Must starts with three consecutive alphabets";
        eprofile.verifyInpurFieldErroMessage(errorMessage);
        logger.info("Error message displayed for the last name field to the Executive: " + errorMessage);
    }

    @And("Executive's profile should not be updated")
    public void executiveSProfileShouldNotBeUpdated() {
        eprofile.verifyExecutiveProfilePageIsLoaded();
        logger.info("Executive's profile is not updated due to invalid last name format");
    }

    @When("Executive makes some changes to the profile")
    public void executiveMakesSomeChangesToTheProfile() {
        eprofile.enterFirstName("Kishor");
        eprofile.enterLastName("Executive");
        logger.info("Executive made changes to the profile");
    }

    @And("Executive clicks the Cancel button")
    public void executiveClicksTheCancelButton() {
        eprofile.clickOnCancelButton();
        logger.info("Executive clicks the Cancel button to discard changes");
    }

    @Then("all unsaved changes made by the Executive should be discarded")
    public void allUnsavedChangesMadeByTheExecutiveShouldBeDiscarded() {
        eprofile.clickCancelButtonPopUp();
        logger.info("Admin clicked the Cancel button to discard changes");
    }

    @And("Executive should see fields reset to their original values")
    public void executiveShouldSeeFieldsResetToTheirOriginalValues() {
        eprofile.verifyExecutiveProfilePageIsLoaded();
        logger.info("Executive should see fields reset to their original values");
    }

    @When("Executive clears all mandatory fields")
    public void executiveClearsAllMandatoryFields() {
        eprofile.clearMandatoryFields();
        logger.info("Executive clears all mandatory fields");
    }

    @Then("validation messages should be displayed for each empty mandatory field to the Executive")
    public void validationMessagesShouldBeDisplayedForEachEmptyMandatoryFieldToTheExecutive() {
        eprofile.verifyMandatoryFieldsValidationMessages();
        logger.info("Validation messages displayed for empty mandatory fields to the Executive");
    }

    @Then("Executive should see the Username, Email, and Mobile Number fields as read-only")
    public void executiveShouldSeeTheUsernameEmailAndMobileNumberFieldsAsReadOnly() {
        eprofile.verifyUsernameEmailMobileFieldsAreReadOnly();
        logger.info("Executive should see the Username, Email, and Mobile Number fields as read-only");
    }

    @And("Executive should not be able to edit the Username, Email, and Mobile Number fields")
    public void executiveShouldNotBeAbleToEditTheUsernameEmailAndMobileNumberFields() {
        eprofile.verifyUsernameEmailMobileFieldsAreNotEditable();
        logger.info("Executive should not be able to edit the Username, Email, and Mobile Number fields");
    }
}
