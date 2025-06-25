package com.pages.login;

import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.TAB;

public class PartnerLoginPage {
    private WebDriver driver;

    /*
     *
     * PArtner Log in page
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

    @FindBy(xpath = "//i[contains(@class, 'ti-eye')]")
    private WebElement eyeIcon;


    /**
     *
     *
     *
     * @param driver
     */

    @FindBy(xpath = "//a[@class='linkStyles' and contains(text(), 'Forgot password')]")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//button[contains(text(), 'Request')]")
    private WebElement requestlinkButton;

    @FindBy(xpath = "//div[text()='Password reset link sent successfully']")
    private WebElement requestLinkSentMessage;

    @FindBy(xpath = "//small[contains(@class, 'text-danger') and contains(text(), 'email')]")
    private WebElement errorMessageForUnregisteredEmail;

    @FindBy(xpath = "//small[@class='text-danger form-text' and text()='Please enter a valid email address.']")
    private WebElement invalidEmailErrorMessage;


    /*
     *
     * Constructor
     *
     */

    public PartnerLoginPage(WebDriver driver) {
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

    public void enterTheValidEmailIntoTheEmailField_Partner_Admin() {
        email_field.click();
        String email = ConfigManager.getConfigProperties().getProperty("Partner_Admin_email");
        email_field.sendKeys(email);
    }

    public void enterTheValidPasswordIntoThePasswordField_Partner_Admin() {
        String password = ConfigManager.getConfigProperties().getProperty("password");
        try {
            String descryptedPassword = ElementUtil.decrypt(password);
            password_Field.sendKeys(descryptedPassword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void enterTheValidEmailIntoTheEmailField_Partner_Executive() {
        email_field.click();
        String email = ConfigManager.getConfigProperties().getProperty("Partner_executive_email");
        email_field.sendKeys(email);
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

    public String getTheCurrentPageTitle() {
        ElementUtil.eu.waitForPageToLoad(driver);
        return ElementUtil.eu.current_page_title(driver);
    }

    public void enterTheValidEmailIntoTheEmailField_Partner_Custom_Role_User() {
        email_field.click();
        String email = ConfigManager.getConfigProperties().getProperty("Partner_Custom_Role_User_email");
        email_field.sendKeys(email);
    }

    /**
     *
     *
     * This method is a placeholder for the "Forgot Password" link click action.
     *
     *
     *
     *
     */

    public void forgotPasswordLinkIsClicked() {
        ElementUtil.eu.wait_for_element_to_be_clickable(driver, ConfigManager.getPropertyinInt("implicit.wait"), forgotPasswordLink);
        ElementUtil.eu.waitForPageToLoad(driver);
        forgotPasswordLink.click();
        ElementUtil.eu.wait_for_to_be_title_is_displayed(driver, ConfigManager.getPropertyinInt("implicit.wait"), "Shield - Forgot Password");
    }

    public void submitPasswordResetRequest() {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, ConfigManager.getPropertyinInt("implicit.wait"), requestlinkButton);
        requestlinkButton.click();
    }

    public void requestLinkSentMessageIsDisplayed() {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, ConfigManager.getPropertyinInt("implicit.wait"), requestlinkButton);
        if (!requestlinkButton.isDisplayed()) {
            throw new RuntimeException("Request link button is not displayed after clicking 'Forgot Password' link.");
        }
    }

    public String getRequestLinkSentMessage() {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, ConfigManager.getPropertyinInt("implicit.wait"), requestLinkSentMessage);
        if (!requestLinkSentMessage.isDisplayed()) {
            throw new RuntimeException("Request link button is not displayed after clicking 'Forgot Password' link.");
        }
        System.out.println("-"+requestLinkSentMessage.getText());
        return requestLinkSentMessage.getText();
    }

    public void enterTheunregisteredEmailIntoTheEmailField(String unregisteredEmail) {
        email_field.click();
        email_field.sendKeys(unregisteredEmail + Keys.TAB);
    }

    public boolean errorMessageForUnregisteredEmailIsDisplayed() {
        try {
            ElementUtil.eu.wait_for_element_to_be_displayed(driver, ConfigManager.getPropertyinInt("implicit.wait"), errorMessageForUnregisteredEmail);
            return errorMessageForUnregisteredEmail.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getUnregisteredEmailErrorMessage() {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, ConfigManager.getPropertyinInt("implicit.wait"), errorMessageForUnregisteredEmail);
        return errorMessageForUnregisteredEmail.getText();
    }

    public boolean pleaseEnterValidEmailAddressMessageForgetPasswordIsDisplayed() {
        try {
            return invalidEmailErrorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false; // Element not found, so the message is not displayed
        }
    }

    public String getInvalidEmailErrorMessage() {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, ConfigManager.getPropertyinInt("implicit.wait"), invalidEmailErrorMessage);
        return invalidEmailErrorMessage.getText();
    }
}