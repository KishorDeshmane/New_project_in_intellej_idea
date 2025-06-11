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

    /*
     *
     * Constructor
     *
     */

    public AdminDashboard(WebDriver driver) {
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
        ElementUtil.eu.wait_for_element_to_be_clickable(driver, ConfigManager.getPropertyinInt("implicit.wait"), loggedInSuccessfullyToast);
        loggedInSuccessfullyToast.click();
//        ElementUtil.waitForInvisibility(driver, loggedInSuccessfullyToast);
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

    public boolean adminTextInProfileIconDisplays() {
        return adminText.isDisplayed();
    }

    public boolean executiveTextInProfileIconDisplays() {
        return executiveText.isDisplayed();
    }

    public String getTheDashboardUrl() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String DashURL = ElementUtil.eu.getCurrentPageURL(driver);
//        String dashboardURL = ConfigManager.getProperty("base.url")+"admin/dashboard/";
//        ElementUtil.eu.waitForExpectedURL(driver, dashURL);
//        System.out.println(dashboardURL + "------dashboardURL");
        return DashURL;
    }

    public boolean adminCustomRoleUserTextInProfileIconDisplays() {
        ElementUtil.eu.wait_for_element_to_be_clickable(driver, ConfigManager.getPropertyinInt("implicit.wait"), customRoleText);
        return customRoleText.isDisplayed();
    }
}
