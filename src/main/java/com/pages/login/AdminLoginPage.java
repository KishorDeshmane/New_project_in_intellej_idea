package com.pages.login;

import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import org.openqa.selenium.*;
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


    @FindBy(xpath = "//a[contains(@href, '/forgot-password') and text()='Forgot password?']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[contains(text(), 'User logged out successfully')]")
    private WebElement loggedOutSuccessfullyToast;

    /*
     *
     * Reset Password Page
     *
     */

    @FindBy(xpath = "//input[@id='formEmail' and @name='email' and @type='email' and @placeholder='Enter your email address']")
    private WebElement emailFieldforgetPassword;

    @FindBy(xpath = "//button[@type='submit' and text()='Request reset link']")
    private WebElement resetPasswordButton;

    @FindBy(xpath = "//div[text()='Password reset link sent successfully']")
    private WebElement successMessage;

    @FindBy(xpath = "//div[text()='Password reset link sent successfully']")
    private WebElement confirmationMessage;

    @FindBy(xpath = "//div[text()='Password reset link sent successfully']")
    private WebElement passwordResetLinkSentMessage;

    @FindBy(xpath = "//small[contains(text(), 'The email is invalid')]")
    private WebElement errorMessageForUnregisteredEmail;

    @FindBy(xpath = "//small[@class='text-danger form-text' and text()='Please enter a valid email address.']")
    private WebElement errorMessageForInvalidEmailFormat;

    @FindBy(xpath = "//div[contains(text(), 'Invalid credentials')]")
    private WebElement invalidCredentialMessage;

    @FindBy(xpath = "")
    private WebElement resetLink;

    @FindBy(xpath = "")
    private WebElement newPasswordField;

    @FindBy(xpath = "")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "")
    private WebElement submitNewPassword;

    @FindBy(xpath = "")
    private WebElement passwordUpdatedSuccessfullyMessage;

    @FindBy(xpath = "")
    private WebElement successMessageAfterPasswordUpdate;

    @FindBy(xpath = "")
    private WebElement errorMessageForExpiredLink;

    @FindBy(xpath = "")
    private WebElement submitButton;

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

    public void enterTheNewValidPasswordIntoThePasswordField_Admin(String password) {
        try {
            password_Field.sendKeys(password);
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
        ElementUtil.eu.wait_for_element_to_be_clickable(
                driver, ConfigManager.getPropertyinInt("implicit.wait"), login_button);
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

    public void enterTheValidEmailIntoTheEmailField_AdminCustomRoleUser() {
        email_field.click();
        String admin_custom_role_user_email = ConfigManager.getConfigProperties().getProperty("Admin_custom_role_user_email");
        try {
            //String decryptedEmail = ElementUtil.decrypt(admin_custom_role_user_email);
            email_field.sendKeys(admin_custom_role_user_email);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void enterTheValidPasswordIntoThePasswordField_AdminCustomRoleUser() {
        String admin_custom_role_user_password = ConfigManager.getConfigProperties().getProperty("password");
        try {
            String decryptedPassword = ElementUtil.decrypt(admin_custom_role_user_password);
            password_Field.sendKeys(decryptedPassword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     *
     *
     *
     *Checks if the "Forgot Password?" link is clickable.
     * @return true if the link is clickable, false otherwise
     *
     *
     *
     *
     *
     */



    public boolean isForgotPasswordLinkClickable() {
        try {
            return forgotPasswordLink.isDisplayed() && forgotPasswordLink.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickOnForgotPasswordLink() {
        try {
            if (forgotPasswordLink.isDisplayed() && forgotPasswordLink.isEnabled()) {
                forgotPasswordLink.click();
            } else {
                throw new RuntimeException("Forgot Password link is not clickable.");
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Forgot Password link not found.", e);
        }
    }

    public void enterValidRegisteredEmailAddress_superadmin() {
        String registeredEmail = ConfigManager.getConfigProperties().getProperty("Super_Admin_email");
        try {
            String decryptedEmail = ElementUtil.decrypt(registeredEmail);
            emailFieldforgetPassword.sendKeys(decryptedEmail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void clickOnResetPasswordButton() {
        ElementUtil.eu.wait_for_element_to_be_clickable(
                driver, ConfigManager.getPropertyinInt("implicit.wait"), resetPasswordButton);
        if (resetPasswordButton.isDisplayed() && resetPasswordButton.isEnabled()) {
            resetPasswordButton.click();
        } else {
            throw new RuntimeException("Reset Password button is not clickable.");
        }
    }

    public boolean isPasswordResetEmailSent() {
        try {
            ElementUtil.eu.wait_for_element_to_be_displayed(
                    driver,ConfigManager.getPropertyinInt("implicit.wait"), successMessage);
            return successMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isConfirmationMessageDisplayed() {
        try {
            ElementUtil.eu.wait_for_element_to_be_displayed(
                    driver, ConfigManager.getPropertyinInt("implicit.wait"), confirmationMessage);
            return confirmationMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void forgotPasswordLinkIsClicked() {
        if (isForgotPasswordLinkClickable()) {
            clickOnForgotPasswordLink();
        } else {
            throw new RuntimeException("Forgot Password link is not clickable.");
        }
    }

    public void submitForgotPasswordRequest() {
        if (resetPasswordButton.isDisplayed() && resetPasswordButton.isEnabled()) {
            resetPasswordButton.click();
        } else {
            throw new RuntimeException("Reset Password button is not clickable.");
        }
    }

    public boolean passwordResetLinkSentMessageIsDisplayed() {
            ElementUtil.eu.wait_for_element_to_be_displayed(
                    driver, ConfigManager.getPropertyinInt("implicit.wait"), passwordResetLinkSentMessage);
            return passwordResetLinkSentMessage.isDisplayed();
    }

    public boolean confirmationMessageIsDisplayed() {
            ElementUtil.eu.wait_for_element_to_be_displayed(
                    driver, ConfigManager.getPropertyinInt("implicit.wait"), confirmationMessage);
            return confirmationMessage.isDisplayed();
    }

    public boolean errorMessageForUnregisteredEmailIsDisplayed() {
        try {
            ElementUtil.eu.wait_for_element_to_be_displayed(
                    driver, ConfigManager.getPropertyinInt("implicit.wait"), errorMessageForUnregisteredEmail);
            return errorMessageForUnregisteredEmail.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean errorMessageForInvalidEmailFormatIsDisplayed() {
        try {
            return errorMessageForInvalidEmailFormat.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void resetLinkIsClicked() {
        if (resetLink.isDisplayed() && resetLink.isEnabled()) {
            resetLink.click();
        } else {
            throw new RuntimeException("Reset Password link is not clickable.");
        }
    }

    public void enterNewPassword(String newSecurePassword123) {
        newPasswordField.sendKeys(newSecurePassword123);
    }

    public void confirmNewPassword(String newSecurePassword123) {
        confirmPasswordField.sendKeys(newSecurePassword123 + TAB + ENTER);
    }

    public boolean isNewPasswordValid(String newSecurePassword123) {
        String enteredPassword = newPasswordField.getAttribute("value");
        return enteredPassword.equals(newSecurePassword123);
    }

    public void submitNewPassword() {
        if (submitNewPassword.isDisplayed() && submitNewPassword.isEnabled()) {
            submitButton.click();
        } else {
            throw new RuntimeException("Submit button is not clickable.");
        }
    }

    public boolean passwordUpdatedSuccessfullyMessageIsDisplayed() {
        try {
            return passwordUpdatedSuccessfullyMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean successMessageAfterPasswordUpdateIsDisplayed() {
        try {
            return errorMessageForExpiredLink.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void setExpiredLink(boolean b) {
        // This method is a placeholder for setting the expired link state.
        // Implementation details would depend on how the application handles expired links.
        // For example, you might set a flag or modify a configuration to simulate an expired link scenario.
        throw new UnsupportedOperationException("Method not implemented yet.");
    }

    public void clickExpiredResetLink() {
        // This method is a placeholder for clicking the expired reset link.
        // Implementation details would depend on how the application handles expired links.
        // For example, you might find the link by its text or ID and click it.
        throw new UnsupportedOperationException("Method not implemented yet.");
    }

    public boolean errorMessageForExpiredLinkIsDisplayed() {
        try {
            return errorMessageForExpiredLink.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public void enterTheUnregisteredEmailIntoTheEmailField() {
        email_field.click();
        String unregisteredEmail = ConfigManager.getConfigProperties().getProperty("Unregistered_email");
        email_field.sendKeys(unregisteredEmail);
    }

    public void enterValidRegisteredEmailAddress_admin() {
    String registeredEmail = ConfigManager.getConfigProperties().getProperty("Admin_email");
        try {
            emailFieldforgetPassword.click();
            emailFieldforgetPassword.sendKeys(registeredEmail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void enterValidRegisteredEmailAddress_executive() {
    String registeredEmail = ConfigManager.getConfigProperties().getProperty("Executive_email");
        try {
            emailFieldforgetPassword.click();
            emailFieldforgetPassword.sendKeys(registeredEmail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyAuthenticationFailureMessage() {
        try {
            ElementUtil.eu.wait_for_element_to_be_displayed(driver, ConfigManager.getPropertyinInt("implicit.wait"), invalidCredentialMessage);
            if (invalidCredentialMessage.isDisplayed()) {
                System.out.println("Authentication failure message is displayed: " + invalidCredentialMessage.getText());
            } else {
                System.out.println("Authentication failure message is not displayed.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Authentication failure message element not found.");
        }

    }

    public void verifyAdminDashboardPageIsLoaded() {
        String expectedUrl = ConfigManager.getConfigProperties().getProperty("base.url").split("#")[0].trim() + "admin/dashboard/";
        ElementUtil.eu.waitForExpectedURL(driver, expectedUrl);
        if (!driver.getCurrentUrl().equals(expectedUrl)) {
            throw new IllegalStateException("Admin Dashboard page is not loaded properly. Expected URL: " + expectedUrl);
        }
    }

    public void verifyAdminLoginPageIsLoaded() {
        if (!login_button.isDisplayed()) {
            throw new IllegalStateException("Admin Login page is not loaded properly. The login button is not displayed.");
        }
    }

    public void clearThePasswordField() {
        try {
            password_Field.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
//            password_Field.clear();
        } catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", password_Field);
        }
    }

    public void enterTheOldPasswordIntoThePasswordField_Admin(String password) {
        try {
            password_Field.sendKeys(password);
        } catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", password_Field, password);
        }
    }

    public void loggedOutSuccessfullyToastIsDisplayed() {
        try {
            ElementUtil.eu.wait_for_element_to_be_displayed(
                    driver, ConfigManager.getPropertyinInt("implicit.wait"), loggedOutSuccessfullyToast);
            if (loggedOutSuccessfullyToast.isDisplayed()) {
                System.out.println("Logged out successfully toast is displayed.");
            } else {
                System.out.println("Logged out successfully toast is not displayed.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Logged out successfully toast element not found.");
        }
    }
}
