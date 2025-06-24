package com.pages.Profile;

import com.qa.utility.ElementUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ExecutiveProfilePage {
    private WebDriver driver;

    /*
     *
     * Executive_profile
     *
     */

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Dashboard'])[2]/preceding::h2[1]")
    private WebElement My_Profile;

    @FindBy(xpath = "//li[(text() = 'Dashboard' or . = 'Dashboard')]")
    private WebElement a_Dashboard;

    @FindBy(xpath = "//div/img")
    private WebElement Myprofile_profileImg;

    @FindBy(xpath = "//button[(text() = 'Change Password' or . = 'Change Password')]")
    private WebElement button_Change_Password;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='User Agent:'])[1]/following::h3[1]")
    private WebElement h3_userName_Executive;

    @FindBy(xpath = "//div[(text() = 'Personal Information' or . = 'Personal Information')]")
    private WebElement div_Personal_Information;

    @FindBy(xpath = "//label[(text() = 'First Name *' or . = 'First Name *')]")
    private WebElement label_First_Name;

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement input_first_name;

    @FindBy(xpath = "//label[(text() = 'Last Name *' or . = 'Last Name *')]")
    private WebElement label_Last_Name;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement input__last_name;

    @FindBy(xpath = "//label[(text() = 'Username ' or . = 'Username ')]")
    private WebElement label_Username;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement input_Username_username;

    @FindBy(xpath = "//span[(text() = 'Email*' or . = 'Email*')]")
    private WebElement span_Email;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement input__email;

    @FindBy(xpath = "//span[(text() = 'Verified' or . = 'Verified')]")
    private WebElement span_Verified;

    @FindBy(xpath = "//span[(text() = 'Mobile Number*' or . = 'Mobile Number*')]")
    private WebElement span_Mobile_Number;

    @FindBy(xpath = "//select[@name='country_code']")
    private WebElement select_SelectUAE;

    @FindBy(xpath = "//input[@name='mobile_number']")
    private WebElement input__mobile_number;

    @FindBy(xpath = "//label[(text() = 'Profile Image (File type should be JPG/JPEG/PNG. Max file size should be 2MB.) ' or . = 'Profile Image (File type should be JPG/JPEG/PNG. Max file size should be 2MB.) ')]")
    private WebElement label_Profile_Image;

    @FindBy(xpath = "//input[@id='profile_pic']")
    private WebElement input_Profile_Image;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement button_Save;

    @FindBy(xpath = "//button[@type = 'button' and (text() = 'Cancel' or . = 'Cancel')]")
    private WebElement button_Cancel;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='User Agent:'])[1]/preceding::span[3]")
    private WebElement last_login_time;

    @FindBy(xpath = "//div[contains(text(), 'My profile updated successfully.')]")
    private WebElement successToast;

    @FindBy(xpath = "//*[contains(text(), 'Only alphabets, space, dot, and hyphen are allowed. Must starts with three consecutive alphabets')]")
    private WebElement errorLastNameInputFieldErrorMessage;

    @FindBy(xpath = "(//*[contains(text(),'Cancel')])[2]")
    private WebElement cancelButtonPopUp;

    @FindBy(xpath = "//small[text()='Please enter your first name.']")
    private WebElement input_first_nameEmptyErrorMessage;

    @FindBy(xpath = "//small[text()='Please enter your last name.']")
    private WebElement input__last_nameEmptyErrorMessage;
    /**
     * Constructor for Admin_custom_role_profile.
     *
     * @param driver the WebDriver instance to use for this page.
     * @throws IllegalStateException if the driver is null.
     */

    public ExecutiveProfilePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in LandingPage. Ensure it is initialized before calling this constructor.");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * Gets the WebDriver instance used by this page.
     *
     * @return the WebDriver instance.
     */

    public void verifyExecutiveProfilePageIsLoaded() {
        ElementUtil.eu.wait_for_to_be_title_is_displayed(driver, 10, "Shield - Admin Profile");
        String pageTitle = ElementUtil.eu.current_page_title(driver);
        Assert.assertEquals(pageTitle, "Shield - Admin Profile", "Executive Profile page is not loaded");
    }

    public void verifyAllExecutiveRequiredProfileFieldsAreVisible() {
        Assert.assertTrue(My_Profile.isDisplayed(), "My Profile is not displayed");
        Assert.assertTrue(a_Dashboard.isDisplayed(), "Dashboard link is not displayed");
        Assert.assertTrue(Myprofile_profileImg.isDisplayed(), "Profile image is not displayed");
        Assert.assertTrue(button_Change_Password.isDisplayed(), "Change Password button is not displayed");
        Assert.assertTrue(h3_userName_Executive.isDisplayed(), "Shield Admin (Admin) header is not displayed");
        Assert.assertTrue(div_Personal_Information.isDisplayed(), "Personal Information section is not displayed");
        Assert.assertTrue(label_First_Name.isDisplayed(), "First Name label is not displayed");
        Assert.assertTrue(input_first_name.isDisplayed(), "First Name input field is not displayed");
        Assert.assertTrue(label_Last_Name.isDisplayed(), "Last Name label is not displayed");
        Assert.assertTrue(input__last_name.isDisplayed(), "Last Name input field is not displayed");
        Assert.assertTrue(label_Username.isDisplayed(), "Username label is not displayed");
        Assert.assertTrue(input_Username_username.isDisplayed(), "Username input field is not displayed");
        Assert.assertTrue(span_Email.isDisplayed(), "Email span is not displayed");
        Assert.assertTrue(input__email.isDisplayed(), "Email input field is not displayed");
        Assert.assertTrue(span_Verified.isDisplayed(), "Verified span is not displayed");
        Assert.assertTrue(span_Mobile_Number.isDisplayed(), "Mobile Number span is not displayed");
        Assert.assertTrue(select_SelectUAE.isDisplayed(), "Country code select dropdown is not displayed");
        Assert.assertTrue(input__mobile_number.isDisplayed(), "Mobile Number input field is not displayed");
        Assert.assertTrue(label_Profile_Image.isDisplayed(), "Profile Image label is not displayed");
        Assert.assertTrue(input_Profile_Image.isDisplayed(), "Profile Image input field is not displayed");
        Assert.assertTrue(button_Save.isDisplayed(), "Save button is not displayed");
        Assert.assertTrue(button_Cancel.isDisplayed(), "Cancel button is not displayed");
    }

    public void clickOnSaveButton() {
        if (button_Save.isDisplayed()) {
            button_Save.click();
        } else {
            Assert.fail("Save button is not displayed");
        }
    }

    public void verifySuccessMessage(String successMessage) {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, 10, successToast);
         Assert.assertTrue(successToast.isDisplayed(), "Success message is not displayed: " + successMessage);
    }

    public void enterFirstName(String kishor) {
        if (input_first_name.isDisplayed()) {
            input_first_name.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            input_first_name.sendKeys(kishor);
        } else {
            Assert.fail("First Name input field is not displayed");
        }
    }

    public void enterLastName(String executive) {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, 10, input__last_name);
        if (input__last_name.isDisplayed()) {
            input__last_name.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            input__last_name.sendKeys(executive);
        } else {
            Assert.fail("Last Name input field is not displayed");
        }
    }

    public void verifyInpurFieldErroMessage(String errorMessage) {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, 10, errorLastNameInputFieldErrorMessage);
        Assert.assertTrue(errorLastNameInputFieldErrorMessage.isDisplayed(), "Error message is not displayed: " + errorMessage);
    }

    public void clickOnCancelButton() {
        if (button_Cancel.isDisplayed()) {
            button_Cancel.click();
        } else {
            Assert.fail("Cancel button is not displayed");
        }
    }

    public void clickCancelButtonPopUp() {
        if (cancelButtonPopUp.isDisplayed()) {
            cancelButtonPopUp.click();
        } else {
            Assert.fail("Cancel button in the pop-up is not displayed");
        }
    }

    public void clearMandatoryFields() {
        if (input_first_name.isDisplayed()) {
            input_first_name.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        } else {
            Assert.fail("First Name input field is not displayed");
        }
        if (input__last_name.isDisplayed()) {
            input__last_name.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        } else {
            Assert.fail("Last Name input field is not displayed");
        }
    }

    public void verifyMandatoryFieldsValidationMessages() {
        Assert.assertTrue(input_first_nameEmptyErrorMessage.isDisplayed(), "First Name validation message is not displayed");
        Assert.assertTrue(input__last_nameEmptyErrorMessage.isDisplayed(), "Last Name validation message is not displayed");
    }

    public void verifyUsernameEmailMobileFieldsAreReadOnly() {
        Assert.assertEquals(input_Username_username.getAttribute("readonly"), "true", "Username field is not read-only");
        Assert.assertEquals(input__email.getAttribute("readonly"), "true", "Email field is not read-only");
        Assert.assertEquals(input__mobile_number.getAttribute("readonly"), "true", "Mobile Number field is not read-only");
    }

    public void verifyUsernameEmailMobileFieldsAreNotEditable() {
        Assert.assertTrue(isReadOnlyOrDisabled(input_Username_username), "Username field is editable");
        Assert.assertTrue(isReadOnlyOrDisabled(input__email), "Email field is editable");
        Assert.assertTrue(isReadOnlyOrDisabled(input__mobile_number), "Mobile Number field is editable");
    }

    private boolean isReadOnlyOrDisabled(WebElement element) {
        String readonly = element.getAttribute("readonly");
        String disabled = element.getAttribute("disabled");
        return ("true".equalsIgnoreCase(readonly) || "true".equalsIgnoreCase(disabled));
    }

}