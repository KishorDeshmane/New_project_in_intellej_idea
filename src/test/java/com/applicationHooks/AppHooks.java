package com.applicationHooks;

import java.util.Properties;

import com.qa.utility.AllureReportHelper;
import org.emailConfig.EmailReportSender;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.qa.factory.DriverFactory;
import com.qa.utility.ConfigManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class AppHooks {
    // like baseUtility class
    //	private static ThreadLocal<Scenario> scenario = new ThreadLocal<>();
    private DriverFactory df;
    private WebDriver driver;
    public static Properties prop;
    public static Properties tdata;
    public static Scenario scenario;



    @Before(order = 0)
    public void getProperty() {
        new ConfigManager();
        prop = ConfigManager.getConfigProperties();
        tdata = ConfigManager.getTestDataProperties();
    }

    @Before(order = 1)
    public void launchBrowser() {
        df = new DriverFactory();
        driver = df.init_driver(prop.getProperty("browser"));
    }

    @BeforeStep
    public void getScenarioInstance(Scenario scenario) {
        AppHooks.scenario = scenario;

    }

//    @BeforeStep
//    public void setRetryProperty(Scenario scenario) {
//        boolean hasRetryTag = scenario.getSourceTagNames().contains("@retry");
//        System.setProperty("RETRY_ENABLED", String.valueOf(hasRetryTag));
//        System.out.println("🔖 Scenario: " + scenario.getName() + " | Retry tag present: " + hasRetryTag + " Tags: " + scenario.getSourceTagNames());
//    }

    public static void log(String message) {
//		Scenario activeScenario = scenario.get();
        if (scenario != null) {
            try {
                System.out.println("Scenario is in try");
//	            scenario.log(message);
            } catch (IllegalStateException e) {
                System.err.println("ERROR: Scenario is not in an active step - " + e.getMessage());
            }
        } else {
            System.err.println("ERROR: Scenario object is null.");
        }
    }

    @After(order = 0)
    public void quitBrowser() {
        if (driver != null) {
            System.out.println("Closing browser...");
            driver.quit();
            System.out.println("Browser closed.");
        }
        DriverFactory.quitDriver();
    }

    @After(order = 1)
    public void takeScreenshot(Scenario scenario) {
        if (driver == null) {
            System.err.println("Cannot take screenshot: WebDriver is null.");
            return;
        }
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            // Add in Allure report
            final byte[] sourcePaths = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // Allure.addAttachment(screenshotName, new ByteArrayInputStream(sourcePaths));
            scenario.attach(sourcePaths, "image/png", screenshotName);
        }
    }

    @AfterAll(order = 1)
    public static void generateAndOpenReports() throws Exception {
        AllureReportHelper.generateAllureSupportFiles();

//        Zip file was the older one TO dO
        EmailReportSender.zipLargeFile("target/allure-report1/index.html", "target/allure-report1/index.zip");
        EmailReportSender.sendEmailWithReport("kishor.deshmane@iffort.com");
    }
}


//    @AfterAll(order = 0)
//    public static void sendMyGeneratedReport() {
//        System.out.println("After all order 0 method");
//        try {
//            EmailReportSender.sendEmailWithReport("kishor.deshmane@iffort.com");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//  @AfterAll(order = 2)
//	public static void OpenExtendReports() throws Exception {
//		 Spark HTML Report
//		try {
//			File htmlFile = new File("Reports/SparkReport.html");
//			if (htmlFile.exists()) {
//				Desktop.getDesktop().browse(htmlFile.toURI());
//			} else {
//				System.out.println("Spark HTML report not found: " + htmlFile.getAbsolutePath());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	    }
//    }
//}