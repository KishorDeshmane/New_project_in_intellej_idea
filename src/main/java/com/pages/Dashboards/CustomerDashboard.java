package com.pages.Dashboards;

import com.qa.utility.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDashboard {

    private WebDriver driver;

    /*
     *
     * Log in button
     *
     */

    @FindBy(xpath = "//*[normalize-space(text())='User logged in successfully']")
    private WebElement customerLoggedInSuccessfullyToast;

    @FindBy(xpath= "//*[normalize-space(text())='Booking History']")
    private WebElement bookingHistoryTab;




    /*
     *
     * Constructor
     *
     */

    public CustomerDashboard(WebDriver driver) {
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



    public boolean customerLoggedInSuccessfullyToastIsDisplayed() {
        ElementUtil.eu.wait_for_element_to_be_displayed(driver, 10, customerLoggedInSuccessfullyToast);
        return customerLoggedInSuccessfullyToast.isDisplayed();
    }

    public boolean bookingHistoryTabIsDisplayed() {
        return bookingHistoryTab.isDisplayed();
    }

    public String getTheDashboardUrl() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ElementUtil.eu.getCurrentPageURL(driver);
    }
}
