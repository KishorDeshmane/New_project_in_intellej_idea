package com.pages.Dashboards;

import com.qa.utility.ConfigManager;
import com.qa.utility.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PartnerDashbaord {

    private WebDriver driver;

    /*
     *
     * Partner Dashboard
     *
     */

    @FindBy(xpath = "//*[@class='main-img-user']")
    private WebElement profileImage;

    @FindBy(xpath= "//p[text()='Partner Admin']")
    private WebElement partnerAdminText;

    @FindBy(xpath= "//p[text()='Partner Executive']")
    private WebElement partnerExecutiveText;

    @FindBy(xpath= "//*[text()='User logged in successfully']")
    private WebElement loggedInSuccessfullyToast;

    /*
     *
     * Constructor
     *
     */

    public PartnerDashbaord(WebDriver driver) {
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
        loggedInSuccessfullyToast.click();
        ElementUtil.eu.wait_for_element_to_be_clickable(driver, ConfigManager.getPropertyinInt("implicit.wait"), profileImage);
        profileImage.click();
    }

    public boolean loggedInSuccessfullyToastIsDisplayed(){
        ElementUtil.eu.wait_for_element_to_be_clickable(driver, ConfigManager.getPropertyinInt("implicit.wait"), loggedInSuccessfullyToast);
        return loggedInSuccessfullyToast.isDisplayed();
    }

    public boolean partnerAdminTextInProfileIconDisplays() {
        return partnerAdminText.isDisplayed();
    }

    public boolean partnerExecutiveTextInProfileIconDisplays() {
        return partnerExecutiveText.isDisplayed();
    }

    public String getTheDashboardUrl() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String DashURL = ElementUtil.eu.getCurrentPageURL(driver);
//        System.out.println(DashURL + "------partber is looed in now then p dash URL");
        return DashURL;
    }
}