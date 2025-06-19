package stepDefinitions;

import com.pages.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.applicationHooks.AppHooks;
import com.qa.factory.DriverFactory;
import com.qa.utility.ElementUtil;

import io.cucumber.java.en.Given;

public class TestA001LandingPage {
//	private WebDriver driver;
//	String browser =ConfigManager.getProperty("browser").split("#")[0].trim();
//	String baseUrl = ConfigManager.getProperty("base.url").split("#")[0].trim();

	private final LandingPage lp = new LandingPage(DriverFactory.getDriver());
	Logger logger = LogManager.getLogger(TestA001LandingPage.class);

	/**
	 *
	 *
	 * SCR
	 *
	 *
	 *
	 */

	@Given("User is on the landing page as expected page title {string}")
	public void user_is_on_the_landing_page_as_expected_page_title(String string) {
//		System.out.println(Db_test.db.);
		DriverFactory.getDriver().get(AppHooks.prop.getProperty("base.url").split("#")[0].trim());
		String actual = ElementUtil.eu.current_page_title(DriverFactory.getDriver());
		System.out.println(actual);
		// boolean actualsss = lp.user_log_in_button_is_displayed();
		// Assert.assertTrue(actualsss);
		System.out.println("String: " + string);
		System.out.println("actual: " + actual);
		// Assert.assertEquals(actual, string);
		System.out.println("Hello");
		logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
		AppHooks.log("First method name");
	}

	@Test
	public void method_name() {
		System.out.println("method two");
	}
}