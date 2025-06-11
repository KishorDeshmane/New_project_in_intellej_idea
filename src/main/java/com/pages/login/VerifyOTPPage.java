package com.pages.login;

import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VerifyOTPPage {
    private WebDriver driver;

    /*
     *
     * Verify OTP
     *
     */

    @FindBy(xpath= "//h6[text()='Verify OTP']")
    private WebElement verifyOTPTextHeader;

    @FindBy(xpath = "//*[text()='A 6-digit OTP has been sent to your mobile number and email successfully.']")
    private WebElement OtpSendToastSuccess;

    @FindBy(xpath= "//button[normalize-space(text())='Verify OTP']")
    private WebElement verifyOTPButton;

    @FindBy(xpath = "//input[contains(@aria-label, 'Please enter OTP character')]")
    List<WebElement> otpInputs;

    /*
     *
     * Constructor
     *
     */

    public VerifyOTPPage(WebDriver driver) {
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

    public boolean verifyOTPTextHeaderIsDisplayed() {
        return verifyOTPTextHeader.isDisplayed();
    }

    public boolean OtpSendToastSuccessIsDisplayed() {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, 10, OtpSendToastSuccess);
        return OtpSendToastSuccess.isDisplayed();
    }

    public void verifyOTPTextIsclicked() {
        ElementUtil.eu.wait_for_element_to_be_clickable(driver, 10, verifyOTPButton);
        verifyOTPButton.click();
    }

    public boolean verifyOTPTextIsclickable() {
        return verifyOTPButton.isEnabled();
    }

    public void sendValuesIntoTheOTPField() {
        try {
            String otp = ConfigManager.getProperty("OTP");
            String decryptedOTP = ElementUtil.decrypt(otp);
//            System.out.println(decryptedOTP);

            for (int i = 0; i < decryptedOTP.length(); i++) {
            otpInputs.get(i).sendKeys(String.valueOf(decryptedOTP.charAt(i)));
            }
            } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean maskedOTPFieldValidation(){
        for (int i = 0; i < otpInputs.size(); i++) {
            WebElement input = otpInputs.get(i);
            String inputType = input.getAttribute("type");
            // If even one field is not masked, return false
            if (!inputType.equals("password")) {
                return false;
            }
        }
        return true; // All fields are masked
    }

}