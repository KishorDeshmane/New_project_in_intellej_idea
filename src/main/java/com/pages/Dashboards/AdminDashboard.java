package com.pages.Dashboards;

import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboard {
    private WebDriver driver;

    /*
     *
     * Log in button
     *
     */

    @FindBy(xpath = "//*[@class='main-img-user']")
    private WebElement profileImage;

    @FindBy(xpath= "//p[text()='Super Admin']")
    private WebElement superAdminText;

    @FindBy(xpath= "//*[text()='User logged in successfully']")
    private WebElement loggedInSuccessfullyToast;

    /*
     *
     * Constructor
     *
     */

    public AdminDashboard(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in Landing_page_objects. Ensure it is initialized before calling this constructor.");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /*
     *
     *  Methods
     *
     */

    public void profileImageIsClicked() {
        loggedInSuccessfullyToast.click();
        ElementUtil.eu.wait_for_element_to_be_clickable(driver, ConfigManager.getPropertyinInt("implicit.wait"), profileImage);
        profileImage.click();
    }

    public boolean loggedInSuccessfullyToastIsDisplayed(){
        ElementUtil.eu.wait_for_element_to_be_clickable(driver, ConfigManager.getPropertyinInt("implicit.wait"), loggedInSuccessfullyToast);
        return loggedInSuccessfullyToast.isDisplayed();
    }

    public boolean superAdminTextInProfileIconDisplays() {
        return superAdminText.isDisplayed();
    }
}
