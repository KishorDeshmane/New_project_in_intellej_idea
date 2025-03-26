package com.pages.login;

import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.Keys.*;

public class AdminLogin {
    private WebDriver driver;

    /*
     *
     * Log in button
     *
     */

    @FindBy(id = "formEmail")
    private WebElement email_field;

    @FindBy(id= "formpassword")
    private WebElement password_Field;

    @FindBy(xpath= "//button[contains(text(), 'Sign In')]")
    private WebElement login_button;

    @FindBy(xpath = "//*[contains(text(), 'Please enter a valid email address.')]")
    private WebElement pleaseEnterValidEmailAddressMessage;

    @FindBy(xpath = "//*[contains(text(), 'Please enter email address')]")
    private WebElement pleaseEnterEmailAddressMesssage;

    @FindBy(xpath = "//*[contains(text(), 'Please enter your password.')]")
    private WebElement pleaseEnterPasswordMesssage;

    @FindBy(xpath = "//span[contains(@class, 'password-eye-icon')]")
    private WebElement eyeIcon;

    /*
     *
     * Constructor
     *
     */

    public AdminLogin(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in Landing_page_objects. Ensure it is initialized before calling this constructor.");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /*
     *
     *  Methods
     *
     */



    public void enterTheValidEmailIntoTheEmailField() {
        email_field.click();
        String email = ConfigManager.getConfigProperties().getProperty("Super_Admin_email");
        email_field.sendKeys(email +Keys.TAB);
    }

    public void enterTheValidPasswordIntoThePasswordField() {
        String password = ConfigManager.getConfigProperties().getProperty("Super_Admin_password");
        password_Field.sendKeys(password +TAB +ENTER);
    }

    public void loginButtonIsClicked(){
        login_button.click();
    }

    public void enterTheInvalidEmailIntoTheEmailField() {
        email_field.click();
        String email = ConfigManager.getConfigProperties().getProperty("Invalid_email");
        email_field.sendKeys(email +Keys.TAB);
    }

    public void enterTheInavalidPasswordIntoThePasswordField() {
        String password = ConfigManager.getConfigProperties().getProperty("Invalid_password");
        password_Field.sendKeys(password +TAB +ENTER);
    }

    public boolean pleaseEnterValidEmailAddressMessageIsDisplayed(){
        return pleaseEnterValidEmailAddressMessage.isDisplayed();
    }

    public void enterTheBlankEmailIntoTheEmailField() {
        email_field.sendKeys("" +Keys.TAB);
    }

    public void enterTheBlankPasswordIntoThePasswordField() {
        password_Field.sendKeys("");
    }

    public boolean pleaseEnterEmailAddressMesssageIsDisplayed(){
        return pleaseEnterEmailAddressMesssage.isDisplayed();
    }

    public boolean pleaseEnterPasswordMesssageIsDisplayed(){
        return pleaseEnterPasswordMesssage.isDisplayed();
    }

    public void enterPassword(String password) {
        password_Field.sendKeys(password);
    }

    public String getPasswordFieldType() {
        return password_Field.getAttribute("type");
    }

    public void togglePasswordVisibility() {
        eyeIcon.click();
    }

    public boolean isPasswordMasked() {
        return getPasswordFieldType().equals("password");
    }

    public boolean isPasswordVisible() {
        return getPasswordFieldType().equals("text");
    }

}
