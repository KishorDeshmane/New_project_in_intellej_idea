package com.pages.login;

import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.*;

public class AdminLoginPage {
    private WebDriver driver;

    /*
     *
     * Log in page
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

    public AdminLoginPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in LandingPage. Ensure it is initialized before calling this constructor.");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*
     *
     *  Methods
     *
     */


    public void enterTheValidEmailIntoTheEmailField_SuperAdmin() {
        email_field.click();
        String email = ConfigManager.getConfigProperties().getProperty("Super_Admin_email");
        try {
            String decryptedEmail = ElementUtil.decrypt(email);
            email_field.sendKeys(decryptedEmail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

        public void enterTheValidPasswordIntoThePasswordField_SuperAdmin() {
        String password = ConfigManager.getConfigProperties().getProperty("Super_Admin_password");
        try {
            String descryptedpassword = ElementUtil.decrypt(password);
            password_Field.sendKeys(descryptedpassword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void enterTheValidEmailIntoTheEmailField_Admin() {
        email_field.click();
        String admin_email = ConfigManager.getConfigProperties().getProperty("Admin_email");
        email_field.sendKeys(admin_email);
    }

    public void enterTheValidPasswordIntoThePasswordField_Admin() {
        String admin_password = ConfigManager.getConfigProperties().getProperty("password");
        try {
            String decryptedPassword = ElementUtil.decrypt(admin_password);
            password_Field.sendKeys(decryptedPassword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void enterTheValidEmailIntoTheEmailField_executive() {
        email_field.click();
        String executive_email = ConfigManager.getConfigProperties().getProperty("Executive_email");
        email_field.sendKeys(executive_email);
    }

    public void enterTheValidPasswordIntoThePasswordField_executive() {
        String executive_password = ConfigManager.getConfigProperties().getProperty("password");
        try {
            String decryptedPassword = ElementUtil.decrypt(executive_password);
            password_Field.sendKeys(decryptedPassword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    public void redirectToTheLoginBackPage() {
        driver.navigate().back();
//        driver.navigate().to(ConfigManager.getConfigProperties().getProperty("base.url").split("#")[0].trim()+"admin/login/");
    }
}
