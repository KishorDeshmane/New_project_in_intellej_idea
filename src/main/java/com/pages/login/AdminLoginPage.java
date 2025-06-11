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
            WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
            return forgotPasswordLink.isDisplayed() && forgotPasswordLink.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickOnForgotPasswordLink() {
        try {
            WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
            if (forgotPasswordLink.isDisplayed() && forgotPasswordLink.isEnabled()) {
                forgotPasswordLink.click();
            } else {
                throw new RuntimeException("Forgot Password link is not clickable.");
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Forgot Password link not found.", e);
        }
    }

    public void enterValidRegisteredEmailAddress() {
        WebElement emailField = driver.findElement(By.id("formEmail"));
        String registeredEmail = ConfigManager.getConfigProperties().getProperty("Registered_email");
        try {
            String decryptedEmail = ElementUtil.decrypt(registeredEmail);
            emailField.sendKeys(decryptedEmail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void clickOnResetPasswordButton() {
        WebElement resetPasswordButton = driver.findElement(By.xpath("//button[contains(text(), 'Reset Password')]"));
        if (resetPasswordButton.isDisplayed() && resetPasswordButton.isEnabled()) {
            resetPasswordButton.click();
        } else {
            throw new RuntimeException("Reset Password button is not clickable.");
        }
    }

    public boolean isPasswordResetEmailSent() {
        try {
            WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(), 'Password reset email sent successfully.')]"));
            return successMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isConfirmationMessageDisplayed() {
        try {
            WebElement confirmationMessage = driver.findElement(By.xpath("//*[contains(text(), 'Please check your email for the password reset link.')]"));
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
        enterValidRegisteredEmailAddress();
        clickOnResetPasswordButton();
        if (!isPasswordResetEmailSent()) {
            throw new RuntimeException("Password reset email was not sent successfully.");
        }
        if (!isConfirmationMessageDisplayed()) {
            throw new RuntimeException("Confirmation message is not displayed after submitting the forgot password request.");
        }
    }

    public boolean passwordResetLinkSentMessageIsDisplayed() {
        try {
            WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(), 'Password reset email sent successfully.')]"));
            return successMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean confirmationMessageIsDisplayed() {
        try {
            WebElement confirmationMessage = driver.findElement(By.xpath("//*[contains(text(), 'Please check your email for the password reset link.')]"));
            return confirmationMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean errorMessageForUnregisteredEmailIsDisplayed() {
        try {
            WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(), 'Email address not registered.')]"));
            return errorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean errorMessageForInvalidEmailFormatIsDisplayed() {
        try {
            WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(), 'Please enter a valid email address.')]"));
            return errorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void resetLinkIsClicked() {
        WebElement resetLink = driver.findElement(By.linkText("Reset Password"));
        if (resetLink.isDisplayed() && resetLink.isEnabled()) {
            resetLink.click();
        } else {
            throw new RuntimeException("Reset Password link is not clickable.");
        }
    }

    public void enterNewPassword(String newSecurePassword123) {
        WebElement newPasswordField = driver.findElement(By.id("newPassword"));
        newPasswordField.sendKeys(newSecurePassword123);
    }

    public void confirmNewPassword(String newSecurePassword123) {
        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
        confirmPasswordField.sendKeys(newSecurePassword123 + TAB + ENTER);
    }

    public boolean isNewPasswordValid(String newSecurePassword123) {
        WebElement newPasswordField = driver.findElement(By.id("newPassword"));
        String enteredPassword = newPasswordField.getAttribute("value");
        return enteredPassword.equals(newSecurePassword123);
    }

    public void submitNewPassword() {
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), 'Submit')]"));
        if (submitButton.isDisplayed() && submitButton.isEnabled()) {
            submitButton.click();
        } else {
            throw new RuntimeException("Submit button is not clickable.");
        }
    }

    public boolean passwordUpdatedSuccessfullyMessageIsDisplayed() {
        try {
            WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(), 'Password updated successfully.')]"));
            return successMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean successMessageAfterPasswordUpdateIsDisplayed() {
        try {
            WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(), 'Password updated successfully.')]"));
            return successMessage.isDisplayed();
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
            WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(), 'This link has expired. Please request a new password reset link.')]"));
            return errorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }
}
