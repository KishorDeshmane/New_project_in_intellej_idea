package com.pages.Profile;

import com.qa.utility.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SuperAdminProfilePage {
    private WebDriver driver;

    /*
     *
     * Admin_custom_role_profile
     *
     */

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Dashboard'])[2]/preceding::h2[1]")
    private WebElement My_Profile;

    @FindBy(id = "//a[contains(text(),'Dashboard')]")
    private WebElement a_Dashboard;

    @FindBy(id = "//img[@alt='Ashish_Upadhyay']")
    private WebElement Myprofile_profileImg;

    @FindBy(id = "//button[(text() = 'Change Password' or . = 'Change Password')]")
    private WebElement button_Change_Password;

    @FindBy(id = "//h3[(text() = 'Ashish Upadhyay (Super Admin)' or . = 'Ashish Upadhyay (Super Admin)')]")
    private WebElement h3_Ashish_Upadhyay_Super_Admin;

    @FindBy(id = "//div[(text() = 'Personal Information' or . = 'Personal Information')]")
    private WebElement div_Personal_Information;

    @FindBy(id = "//label[(text() = 'First Name *' or . = 'First Name *')]")
    private WebElement label_First_Name;

    @FindBy(id = "//input[@id='first_name']")
    private WebElement input_first_name;

    @FindBy(id = "//label[(text() = 'Last Name *' or . = 'Last Name *')]")
    private WebElement label_Last_Name;

    @FindBy(id = "//input[@id='last_name']")
    private WebElement input__last_name;

    @FindBy(id = "//label[(text() = 'Username ' or . = 'Username ')]")
    private WebElement label_Username;

    @FindBy(id = "//input[@id='username']")
    private WebElement input_Username_username;

    @FindBy(id = "//span[(text() = 'Email*' or . = 'Email*')]")
    private WebElement span_Email;

    @FindBy(id = "//input[@name='email']")
    private WebElement input__email;

    @FindBy(id = "//span[(text() = 'Verified' or . = 'Verified')]")
    private WebElement span_Verified;

    @FindBy(id = "//span[(text() = 'Mobile Number*' or . = 'Mobile Number*')]")
    private WebElement span_Mobile_Number;

    @FindBy(id = "//select[@name='country_code']")
    private WebElement select_SelectUAE;

    @FindBy(id = "//input[@name='mobile_number']")
    private WebElement input__mobile_number;

    @FindBy(id = "//label[(text() = 'Profile Image (File type should be JPG/JPEG/PNG. Max file size should be 2MB.) ' or . = 'Profile Image (File type should be JPG/JPEG/PNG. Max file size should be 2MB.) ')]")
    private WebElement label_Profile_Image;

    @FindBy(id = "//input[@id='profile_pic']")
    private WebElement input_Profile_Image;

    @FindBy(id = "//button[@type='submit']")
    private WebElement button_Save;

    @FindBy(id = "//button[@type = 'button' and (text() = 'Cancel' or . = 'Cancel')]")
    private WebElement button_Cancel;

    @FindBy(id = "(.//*[normalize-space(text()) and normalize-space(.)='User Agent:'])[1]/preceding::span[3]")
    private WebElement last_login_time;


    /**
     * Constructor for Admin_custom_role_profile.
     *
     * @param driver the WebDriver instance to use for this page.
     * @throws IllegalStateException if the driver is null.
     */

    public SuperAdminProfilePage(WebDriver driver) {
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

    public void verifySuperAdminProfilePageIsLoaded() {
        String pageTitle = ElementUtil.eu.current_page_title(driver);
        Assert.assertEquals(pageTitle, "Shield - Profile", "Super Admin Profile page is not loaded");
    }

    public void verifyAllRequiredSuperAdminProfileFieldsAreVisible() {
        Assert.assertTrue( My_Profile.isDisplayed(), "My Profile is not displayed");
        Assert.assertTrue(a_Dashboard.isDisplayed(), "Dashboard link is not displayed");
        Assert.assertTrue(Myprofile_profileImg.isDisplayed(), "Profile Image is not displayed");
        Assert.assertTrue(button_Change_Password.isDisplayed(), "Change Password button is not displayed");
        Assert.assertTrue(h3_Ashish_Upadhyay_Super_Admin.isDisplayed(), "Super Admin name is not displayed");
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
        Assert.assertTrue(select_SelectUAE.isDisplayed(), "Country Code select dropdown is not displayed");
        Assert.assertTrue(input__mobile_number.isDisplayed(), "Mobile Number input field is not displayed");
        Assert.assertTrue(label_Profile_Image.isDisplayed(), "Profile Image label is not displayed");
        Assert.assertTrue(input_Profile_Image.isDisplayed(), "Profile Image input field is not displayed");
        Assert.assertTrue(button_Save.isDisplayed(), "Save button is not displayed");
        Assert.assertTrue(button_Cancel.isDisplayed(), "Cancel button is not displayed");
    }
}
