package com.pages.Profile;

import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ChangePasswordPage {
    private WebDriver driver;

    /*
     *
     * Admin_profile
     *
     */

    @FindBy(xpath = "//h2[(text() = 'Change Password' or . = 'Change Password')]")
    private WebElement changePasswordTitle;

    @FindBy(xpath = "//ol[(text() = 'ProfileChange Password' or . = 'ProfileChange Password')]")
    private WebElement label_CurrentPassword;

    @FindBy(xpath = "//label[(text() = 'Current Password ' or . = 'Current Password ')]")
    private WebElement label_current_password;

    @FindBy(xpath = "//input[@id='current_password']")
    private WebElement input_CurrentPassword;

    @FindBy(xpath = "//button[@type = 'submit' and (text() = 'Submit' or . = 'Submit')]")
    private WebElement button_Submit_CurrentPassword;

    @FindBy(xpath = "//button[@type = 'button' and (text() = 'Cancel' or . = 'Cancel')]")
    private WebElement button_Cancel_CurrentPassword;

    @FindBy(xpath = "//label[(text() = 'New Password ' or . = 'New Password ')]")
    private WebElement label_NewPassword;

    @FindBy(xpath = "//input[@id='new_password']")
    private WebElement input_NewPassword;

    @FindBy(xpath = "//label[(text() = 'Confirm Password ' or . = 'Confirm Password ')]")
    private WebElement label_ConfirmPassword;

    @FindBy(xpath = "//input[@id='confirm_password']")
    private WebElement input_ConfirmPassword;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement button_Submit_NewPassword;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement button_Cancel_NewPassword;

    @FindBy(xpath = "//small[(text() = 'Please enter your password.' or . = 'Please enter your password.')]")
    private WebElement small_Please_enter_your_password;

    @FindBy(xpath = "//small[(text() = 'Please confirm your password.' or . = 'Please confirm your password.')]")
    private WebElement small_Please_confirm_your_password;

    @FindBy(xpath = "//*[contains(text(), 'Password is successfully updated.')]")
    private WebElement successMessage;

    @FindBy(xpath = "//div[normalize-space(text())='Password is incorrect!']")
    private WebElement small_Please_enter_correct_password;

    @FindBy(xpath = "//small[contains(text(), 'Your password do not match.')]")
    private WebElement small_Your_password_do_not_match;

    @FindBy(xpath = "//small[contains(text(), 'Your password must contain at least one uppercase letter, one lowercase letter, one number, and one special character with no whitespaces.')]")
    private WebElement small_Please_enter_strong_your_password;

    @FindBy(xpath = "//*[contains(text(), 'Your password must have at least 8 characters or more long.')]")
    private WebElement small_enter_long_password_message;

    /**
     *
     *
     *
     *
     * @param driver
     */

    public ChangePasswordPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in LandingPage. Ensure it is initialized before calling this constructor.");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     *
     *
     *
     *
     *
     *
     *
     */



    public void verifyChangePasswordPageIsLoaded() {
        if (!changePasswordTitle.isDisplayed()) {
            throw new IllegalStateException("Change Password page is not loaded properly.");
        }
    }

    public void verifyAllChangePasswordFieldsAreVisible() {
        if (!label_CurrentPassword.isDisplayed() || !input_CurrentPassword.isDisplayed() ||
            !button_Submit_CurrentPassword.isDisplayed() || !button_Cancel_CurrentPassword.isDisplayed()) {
            throw new IllegalStateException("Not all Change Password fields are visible.");
        }

    }

    public void verifyChangePasswordPageUI() {
        verifyChangePasswordPageIsLoaded();
        verifyAllChangePasswordFieldsAreVisible();
    }

    public void enterCurrentPassword(String currentPassword) {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver,10, input_CurrentPassword);
        input_CurrentPassword.sendKeys(currentPassword);
    }

    public void clickOnSubmitCurrentPasswordButton() {
        ElementUtil.eu.waitForPageToLoad(driver);
        button_Submit_CurrentPassword.click();
    }

    public void clickOnCancelCurrentPasswordButton() {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, 10, button_Cancel_CurrentPassword);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        button_Cancel_CurrentPassword.click();
    }

    public void enterNewPassword(String newPassword) {
//        ElementUtil.eu.waitForPageToLoad(driver);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        input_NewPassword.sendKeys(newPassword);
    }

    public void enterConfirmPassword(String confirmPassword) {
        input_ConfirmPassword.sendKeys(confirmPassword);
    }

    public void clickOnSubmitNewPasswordButton() {
        button_Submit_NewPassword.click();
    }

    public void clickOnCancelNewPasswordButton() {
        button_Cancel_NewPassword.click();
    }

    public void verifyPasswordUpdatedSuccessfully() {
        ElementUtil.eu.wait_for_element_to_be_clickable(driver, 10, successMessage);
        Assert.assertTrue(successMessage.isDisplayed(), "Password update success message is not displayed.");
    }

    public void verifyPasswordUpdateSuccessToast() {
        String expectedMessage = "Password is successfully updated.";
        String actualMessage = successMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Password update success message does not match.");
    }

    public void verifyInvalidCurrentPasswordErrorMessage() {
        String expectedMessage = "Password is incorrect!";
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, 10, small_Please_enter_correct_password);
        String actualMessage = small_Please_enter_correct_password.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Invalid current password error message does not match.");
    }

    public void verifyPasswordsDoNotMatchErrorMessage() {
        String expectedMessage = "Your password do not match.";
        String actualMessage = small_Your_password_do_not_match.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Passwords do not match error message does not match.");
    }

    public void verifyWeakPasswordErrorMessage() {
        String expectedMessage = "Your password must contain at least one uppercase letter, one lowercase letter, one number, and one special character with no whitespaces.";
        String actualMessage = small_Please_enter_strong_your_password.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Weak password error message does not match.");
    }

    public void clearCurrentPasswordField() {
        input_CurrentPassword.clear();
    }

    public void clearNewPasswordField() {
        input_NewPassword.clear();
    }

    public void clearConfirmPasswordField() {
        input_ConfirmPassword.clear();
    }

    public void verifyMandatoryFieldsValidationMessages() {
        if (!small_Please_enter_your_password.isDisplayed() || !small_Please_confirm_your_password.isDisplayed()) {
            throw new IllegalStateException("Mandatory fields validation messages are not displayed.");
        }
    }

    public void verifyPasswordFieldsAreMasked() {
        String currentPasswordType = input_CurrentPassword.getAttribute("type");
        try {
            enterCurrentPassword(ElementUtil.decrypt(ConfigManager.getProperty("password")));
            clickOnSubmitCurrentPasswordButton();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String newPasswordType = input_NewPassword.getAttribute("type");
        String confirmPasswordType = input_ConfirmPassword.getAttribute("type");

        Assert.assertEquals(currentPasswordType, "password", "Current Password field is not masked.");
        Assert.assertEquals(newPasswordType, "password", "New Password field is not masked.");
        Assert.assertEquals(confirmPasswordType, "password", "Confirm Password field is not masked.");
    }

    public void verifyAllChangePasswordFieldsAreVisibleSecondPage() {
        if (!label_NewPassword.isDisplayed() || !input_NewPassword.isDisplayed() ||
            !label_ConfirmPassword.isDisplayed() || !input_ConfirmPassword.isDisplayed() ||
            !button_Submit_NewPassword.isDisplayed() || !button_Cancel_NewPassword.isDisplayed()) {
            throw new IllegalStateException("Not all Change Password fields are visible on the second page.");
        }
    }

    public void verifyShortPasswordErrorMessage() {
        String expectedMessage = "Your password must have at least 8 characters or more long.";
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, 10, small_enter_long_password_message);
        String actualMessage = small_enter_long_password_message.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Short password error message does not match.");
    }
}
