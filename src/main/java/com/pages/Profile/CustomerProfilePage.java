package com.pages.Profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerProfilePage {
    private WebDriver driver;

    /*
     *
     * Admin_custom_role_profile
     *
     */

    @FindBy(id = "")
    private WebElement xyz;

    /**
     * Constructor for Admin_custom_role_profile.
     *
     * @param driver the WebDriver instance to use for this page.
     * @throws IllegalStateException if the driver is null.
     */

    public CustomerProfilePage(WebDriver driver) {
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

    public void setXyz( ) {
        xyz.click();
    }
}
