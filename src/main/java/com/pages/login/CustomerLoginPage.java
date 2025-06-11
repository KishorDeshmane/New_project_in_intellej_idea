package com.pages.login;

import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CustomerLoginPage {
    private WebDriver driver;

    /*
     *
     * Log in button
     *
     */

    @FindBy(xpath = "//input[@name='mobile_number']")
    private WebElement mobileNumberInputField;

    @FindBy(xpath= "//*[text()='Get OTP']")
    private WebElement getOtpButton;

    /*
     *
     * Constructor
     *
     */

    public CustomerLoginPage(WebDriver driver) {
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

    public boolean mobileNumberInputFieldIsDisplayed() {
        return mobileNumberInputField.isDisplayed();
    }

    public void mobileNumberInputFieldSendNumber() {
        mobileNumberInputField.sendKeys(ConfigManager.getProperty("Customer_Number"));
    }

    public void getOtpButtonIsClicked() {
        getOtpButton.click();
    }

    public boolean getOtpButtonIsClickable() {
        return getOtpButton.isEnabled();
    }

    public void redirectToTheLoginBackPage() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ElementUtil.eu.navigate_back(driver);
    }
}