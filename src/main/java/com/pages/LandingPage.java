package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.utility.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	private WebDriver driver;

	/* 
	 * 
	 * Log in button
	 * 
	 */
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement log_in_button;

	@FindBy(xpath = "//a[@href='/partner/login/']")
	private WebElement log_in_as_partner_button;

	@FindBy(xpath = "//a[@href='/login/']")
	private WebElement log_in_as_customer_button;

	
	/* 
	 * 
	 * Constructor 
	 * 
	 */

	public LandingPage(WebDriver driver) {
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

	
	
	public boolean user_log_in_button_is_displayed() {
		return log_in_button.isDisplayed();
	}

	public void loginButtonMouseHover() {
		ElementUtil.eu.wait_for_element_to_be_displayed(driver, 10, log_in_button);
		ElementUtil.eu.mouseHover(driver, log_in_button);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ElementUtil.eu.wait_for_element_to_be_displayed(driver, 10, log_in_as_partner_button);
	}

	public void loginAsPartnerClicked() {
		log_in_as_partner_button.click();
	}

	public String getTheCurrentPageTitle() {
		String str= ElementUtil.eu.current_page_title(DriverFactory.getDriver());
		System.out.println(str);
		return str;
	}

	public void loginAsCustomerClicked() {
		log_in_as_customer_button.click();
	}

}
