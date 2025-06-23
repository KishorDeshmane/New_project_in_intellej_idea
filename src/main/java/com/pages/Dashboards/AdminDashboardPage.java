package com.pages.Dashboards;

import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {
    private WebDriver driver;

    /*
     *
     * Admin Dashboard
     *
     */

    @FindBy(xpath = "//*[@class='main-img-user']")
    private WebElement profileImage;

    @FindBy(xpath= "//p[text()='Super Admin']")
    private WebElement superAdminText;

    @FindBy(xpath= "//p[text()='Admin']")
    private WebElement adminText;

    @FindBy(xpath= "//p[text()='Executive']")
    private WebElement executiveText;

    @FindBy(xpath= "//*[text()='User logged in successfully']")
    private WebElement loggedInSuccessfullyToast;

    @FindBy(xpath = "//p[@class='main-notification-text']")
    private WebElement customRoleText;

    @FindBy(xpath = "//*[contains(normalize-space(text()), 'My Profile')]")
    private WebElement myProfileText;

    /*
     *
     * Constructor
     *
     */

    public AdminDashboardPage(WebDriver driver) {
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

    public void profileImageIsClicked() {
        try {
            if (loggedInSuccessfullyToast.isDisplayed()) {
                loggedInSuccessfullyToast.click();
//                ElementUtil.eu.wait_for_element_to_be_invisible(driver, 10, loggedInSuccessfullyToast);
            }
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            System.out.println("loggedInSuccessfullyToast - Element not found or not clickable — ignore silently");
        }
        // Wait for the profile image to be clickable before clicking
        ElementUtil.eu.wait_for_element_to_be_clickable(driver, 10, profileImage);
        profileImage.click();
    }

    public void profileImageIsClicked_withJAVASCRIPT() {
        ElementUtil.eu.clickByJS(driver, profileImage);
    }

    public boolean loggedInSuccessfullyToastIsDisplayed(){
        ElementUtil.eu.wait_for_element_to_be_clickable(driver, 10, loggedInSuccessfullyToast);
        return loggedInSuccessfullyToast.isDisplayed();
    }

    public boolean superAdminTextInProfileIconDisplays() {
        return superAdminText.isDisplayed();
    }

    public boolean adminTextInProfileIconDisplays() {
        return adminText.isDisplayed();
    }

    public boolean executiveTextInProfileIconDisplays() {
        return executiveText.isDisplayed();
    }

    public String getTheDashboardUrl() {
        return null;
    }

    public boolean adminCustomRoleUserTextInProfileIconDisplays() {
        ElementUtil.eu.wait_for_element_to_be_clickable(driver, ConfigManager.getPropertyinInt("implicit.wait"), customRoleText);
        return customRoleText.isDisplayed();
    }

    public void profileTextIsClickedFromPopUp() {
        ElementUtil.eu.wait_for_element_to_be_clickable(driver, 10, myProfileText);
        myProfileText.click();
    }

    public void profileTextIsClickedFromPopUp_JAVASCRIPT() {
        ElementUtil.eu.clickByJS(driver, myProfileText);
    }

    public void logout() {

    }

    public void verifyAdminDashboardPageIsLoadedAfterPasswordChanges() {
        ElementUtil.eu.wait_for_element_to_be_clickable(driver, ConfigManager.getPropertyinInt("implicit.wait"), profileImage);
        if (!profileImage.isDisplayed()) {
            throw new IllegalStateException("Admin Dashboard page is not loaded properly after password changes.");
        }
    }
}
