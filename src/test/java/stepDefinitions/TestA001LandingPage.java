package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.applicationHooks.AppHooks;
import com.pages.Landing_page_objects;
import com.qa.factory.DriverFactory;
import com.qa.utility.ElementUtil;

import io.cucumber.java.en.Given;

public class TestA001LandingPage {
//	private WebDriver driver;
//	String browser =ConfigManager.getProperty("browser").split("#")[0].trim();
//	String baseUrl = ConfigManager.getProperty("base.url").split("#")[0].trim();
	
	private final Landing_page_objects lp = new Landing_page_objects(DriverFactory.getDriver());
	Logger logger = LogManager.getLogger(TestA001LandingPage.class);

	/**
	 * 
	 * 
	 * SCR 
	 * 
	 * 
	 * 
	 * 
	 */



	@Given("User is on the landing page as expected page title {string} h")
	public void user_is_on_the_landing_page_as_expected_page_title_h(String string) {
//		System.out.println(Db_test.db.);
		DriverFactory.getDriver().get(AppHooks.prop.getProperty("base.url").split("#")[0].trim());
		String actual = ElementUtil.eu.current_page_title(DriverFactory.getDriver());
		System.out.println(actual);
		boolean actualsss = lp.user_log_in_button_is_displayed();
        Assert.assertTrue(actualsss);
		System.out.println("String: "+string);
		System.out.println("actual: "+actual);
		Assert.assertEquals(actual, string);
		System.out.println("Hello");
		logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
		AppHooks.log("First method name");
	}
	
	
	@Given("User is on the landing page as expected page title {string} he")
	public void user_is_on_the_landing_page_as_expected_page_title_he(String string) {
		DriverFactory.getDriver().get(AppHooks.prop.getProperty("base.url").split("#")[0].trim());
		String actual = ElementUtil.eu.current_page_title(DriverFactory.getDriver());
		lp.user_log_in_button_is_displayed();
		Assert.assertEquals(actual, string);
		logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
		AppHooks.log(new Object() {}.getClass().getEnclosingMethod().getName());
	}
	
//	@Given("User is on the landing page as expected page title {string} hel")
//	public void user_is_on_the_landing_page_as_expected_page_title_hel(String string) {
//		DriverFactory.getDriver().get(AppHooks.prop.getProperty("base.url"));
//		String actual = ElementUtil.eu.current_page_title(DriverFactory.getDriver());
////		AssertJUnit.assertEquals(actual, string);
//		logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
//		AppHooks.log(new Object() {}.getClass().getEnclosingMethod().getName());
//
//	}
//	
//	@Given("User is on the landing page as expected page title {string} hell")
//	public void user_is_on_the_landing_page_as_expected_page_title_hell(String string) {
//		DriverFactory.getDriver().get(AppHooks.prop.getProperty("base.url"));
//		String actual = ElementUtil.eu.current_page_title(DriverFactory.getDriver());
////		AssertJUnit.assertEquals(actual, string);
//		logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
//		AppHooks.log(new Object() {}.getClass().getEnclosingMethod().getName());
//	}
//	
//	@Given("User is on the landing page as expected page title {string} hello")
//	public void user_is_on_the_landing_page_as_expected_page_title_hello(String string) {
//		DriverFactory.getDriver().get(AppHooks.prop.getProperty("base.url"));
//		String actual = ElementUtil.eu.current_page_title(DriverFactory.getDriver());
////		AssertJUnit.assertEquals(actual, string);
//		logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
//		AppHooks.log(new Object() {}.getClass().getEnclosingMethod().getName());
//	}
//	@Given("User is on thfghfgh")
//	public void user_is_on_thfghfgh() {
//	    // Write code here that turns the phrase above into concrete actions
//	    System.out.println("HELLO");
//	}
//
	@Test
	public void method_name() {
		System.out.println("method two");
	}
}
