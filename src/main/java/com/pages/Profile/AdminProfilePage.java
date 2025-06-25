package com.pages.Profile;

import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AdminProfilePage {
    private WebDriver driver;

    /*
     *
     * Admin_profile
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
    private WebElement h3_shield_admin_Admin;

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

    @FindBy(xpath = "(//button[text()='Cancel'])[2]")
    private WebElement button_Cancel_pop_Up;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='User Agent:'])[1]/preceding::span[3]")
    private WebElement last_login_time;

    @FindBy(xpath = "//div[contains(text(), 'My profile updated successfully.')]")
    private WebElement profileUpdateSuccessToast;

    @FindBy(xpath = "//small[@class='text-danger form-text' and contains(text(), 'Only alphabets, space, dot, and hyphen are allowed. Must starts with three consecutive alphabets')]")
    private WebElement errorLastNameMessage;

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

    public AdminProfilePage(WebDriver driver) {
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

    public void verifyAdminProfilePageIsLoaded() {
        String title = ConfigManager.getTestDataProperties().getProperty("admin_profile");
        ElementUtil.eu.wait_for_to_be_title_is_displayed(
                driver, ConfigManager.getPropertyinInt("implicit.wait"), title);
        String pageTitle = ElementUtil.eu.current_page_title(driver);
        Assert.assertEquals(pageTitle, title, "Admin Profile page is not loaded");
    }

    public void verifyAllAdminRequiredProfileFieldsAreVisible() {
        Assert.assertTrue(My_Profile.isDisplayed(), "My Profile is not displayed");
        Assert.assertTrue(a_Dashboard.isDisplayed(), "Dashboard link is not displayed");
        Assert.assertTrue(Myprofile_profileImg.isDisplayed(), "Profile image is not displayed");
        Assert.assertTrue(button_Change_Password.isDisplayed(), "Change Password button is not displayed");
        Assert.assertTrue(h3_shield_admin_Admin.isDisplayed(), "Shield Admin (Admin) header is not displayed");
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

    public void enterFirstName(String kishor) {
        if (input_first_name.isDisplayed()) {
            input_first_name.click();
            input_first_name.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            input_first_name.sendKeys(kishor);
        } else {
            throw new IllegalStateException("First Name input field is not displayed");
        }
    }

    public void enterLastName(String admin) {
        if (input__last_name.isDisplayed()) {
            input__last_name.click();
            input__last_name.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
            input__last_name.sendKeys(admin);
        } else {
            throw new IllegalStateException("Last Name input field is not displayed");
        }
    }

    public void clickSaveButton() {
        //            button_Save.click();
        if (button_Save.isDisplayed()) ElementUtil.eu.clickByJS(driver, button_Save);
        else {
            throw new IllegalStateException("Save button is not displayed");
        }
    }

    public void verifyProfileUpdatedSuccessfully() {
        profileUpdateSuccessToast.isDisplayed();
    }

    public void verifyProfileUpdateSuccessToast() {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, ConfigManager.getPropertyinInt("implicit.wait"), profileUpdateSuccessToast);
        if (profileUpdateSuccessToast.isDisplayed()) {
            String toastMessage = profileUpdateSuccessToast.getText();
            Assert.assertEquals(toastMessage, "My profile updated successfully.", "Profile update success toast message is incorrect");
        } else {
            throw new IllegalStateException("Profile update success toast is not displayed");
        }
    }

    public void verifyInvalidLastNameErrorMessage() {
        if (errorLastNameMessage.isDisplayed()) {
            String errorText = errorLastNameMessage.getText();
            Assert.assertEquals(errorText, "Only alphabets, space, dot, and hyphen are allowed. Must starts with three consecutive alphabets", "Error message for invalid last name is incorrect");
        } else {
            throw new IllegalStateException("Error message for invalid last name is not displayed");
        }
    }


    public void verifyProfileNotUpdated() {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, ConfigManager.getPropertyinInt("implicit.wait"), button_Save);
        if (button_Save.isEnabled()) {
            Assert.fail("Admin's profile was updated despite invalid last name format");
        } else {
            System.out.println("Admin's profile was not updated due to invalid last name format");
        }
    }

    public void selectValidImageFile(String s) {
        if (input_Profile_Image.isDisplayed()) {
            input_Profile_Image.sendKeys(s);
        } else {
            throw new IllegalStateException("Profile Image input field is not displayed");
        }
    }

    public void clickCancelButton() {
        ElementUtil.eu.wait_for_element_to_be_displayed(
                driver, ConfigManager.getPropertyinInt("implicit.wait"), button_Cancel);
        //            button_Cancel.click();
        if (button_Cancel.isDisplayed()) ElementUtil.eu.clickByJS(driver, button_Cancel);
        else {
            throw new IllegalStateException("Cancel button is not displayed");
        }
    }

    public void clickCancelButtonPopUp() {
        if (button_Cancel_pop_Up.isDisplayed()) {
            button_Cancel_pop_Up.click();
            ElementUtil.eu.wait_for_element_to_be_invisible(driver, ConfigManager.getPropertyinInt("implicit.wait"), button_Cancel_pop_Up);
        } else {
            throw new IllegalStateException("Cancel button is not displayed");
        }
    }

    public void clearFirstNameField() {
        if (input_first_name.isDisplayed()) {
            input_first_name.click();
            input_first_name.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        } else {
            throw new IllegalStateException("First Name input field is not displayed");
        }
    }

    public void clearLastNameField() {
        if (input__last_name.isDisplayed()) {
            input__last_name.click();
            input__last_name.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        } else {
            throw new IllegalStateException("Last Name input field is not displayed");
        }
    }

    public void verifyMandatoryFieldsValidationMessages() {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, ConfigManager.getPropertyinInt("implicit.wait"), input_first_nameEmptyErrorMessage);
        if (input_first_nameEmptyErrorMessage.isDisplayed()) {
            Assert.assertTrue(input_first_nameEmptyErrorMessage.isDisplayed(), "First Name validation message is not displayed");
        }
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, ConfigManager.getPropertyinInt("implicit.wait"), input__last_nameEmptyErrorMessage);
        if (input__last_nameEmptyErrorMessage.isDisplayed()) {
            Assert.assertTrue(input__last_nameEmptyErrorMessage.isDisplayed(), "Last Name validation message is not displayed");
        }

    }

    public void verifyUsernameEmailMobileFieldsAreReadOnly() {
//        ElementUtil.eu.wait_for_element_to_be_displayed(driver, ConfigManager.getPropertyinInt("implicit.wait"), input_Username_username);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (input_Username_username.isEnabled()) {
            Assert.fail("Username field is not read-only");
        }
        String emailReadOnly = input__email.getAttribute("readonly");
        if (emailReadOnly == null) {
            Assert.fail("❌ Email field is not read-only");
        }
        String mobileReadOnly = input__mobile_number.getAttribute("readonly");
        if (mobileReadOnly == null) {
            Assert.fail("❌ Mobile number field is not read-only");
        }
    }

    public void verifyUsernameEmailMobileFieldsAreNotEditable() {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, ConfigManager.getPropertyinInt("implicit.wait"), input_Username_username);
        if (input_Username_username.isEnabled()) {
            Assert.fail("Username field is editable");
        }
        String emailReadOnly = input__email.getAttribute("readonly");
        if (emailReadOnly == null) {
            Assert.fail("❌ Email field is not read-only");
        }
        String mobileReadOnly = input__mobile_number.getAttribute("readonly");
        if (mobileReadOnly == null) {
            Assert.fail("❌ Mobile number field is not read-only");
        }
    }

    public void clickChangePasswordLink() {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver,ConfigManager.getPropertyinInt("implicit.wait"), button_Change_Password);
        if (button_Change_Password.isDisplayed()) {
            ElementUtil.eu.clickByJS(driver, button_Change_Password);
//            button_Change_Password.click();
        } else {
            throw new IllegalStateException("Change Password button is not displayed");
        }
    }

}