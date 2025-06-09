package com.pages.Dashboards;

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

    @FindBy(id = "")
    private WebElement abc;

    @FindBy(id= "")
    private WebElement asd;

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



    public void enterTheEmailIntoTheEmailField() {

    }

    public void enterThePasswordIntoThePasswordField() {

    }

}
