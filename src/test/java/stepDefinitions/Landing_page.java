package stepDefinitions;

import com.pages.LandingPage;
import com.qa.utility.ConfigManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.applicationHooks.AppHooks;
import com.qa.factory.DriverFactory;
import com.qa.utility.ElementUtil;

import io.cucumber.java.en.Given;

public class Landing_page {

	private final LandingPage lp = new LandingPage(DriverFactory.getDriver());
	Logger logger = LogManager.getLogger(Landing_page.class);

	/**
	 *
	 *
	 * SCR
	 *
	 *
	 *
	 */

	@Given("User is on the landing page as expected page title")
	public void user_is_on_the_landing_page_as_expected_page_title() {
		String baseUrl = ConfigManager.getProperty("base.url");
//      DriverFactory.getDriver().get(baseUrl + "admin/login");
		String changedUrl;
		assert baseUrl != null;
		changedUrl = baseUrl.replaceFirst("s", "");
		DriverFactory.getDriver().get(changedUrl);

		String actual = ElementUtil.eu.current_page_title(DriverFactory.getDriver());
		String landingPageTitle = ConfigManager.getTestDataProperties().getProperty("landing_page").split("#")[0].trim();
		Assert.assertEquals(actual, landingPageTitle);
		logger.info("User is on the landing page as expected page title");
	}

	@Test
	public void method_name() {
		//		System.out.println(Db_test.db.);
				System.out.println("method two");
	}
}