package com.applicationHooks;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.example.EmailReportSender;
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
        String browserName = prop.getProperty("browser");
        df = new DriverFactory(); // like baseUtility class
        driver = df.init_driver(browserName); // like startup method

    }

    @BeforeStep
    public void getScenarioInstance(Scenario scenario) {
        AppHooks.scenario = scenario;
    }

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
        } else {
            System.out.println("No active browser session found.");
        }
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
        try {
            // Generate the Allure report as a single file
            Process generateProcess = Runtime.getRuntime().exec(
                    "C:\\Users\\HP\\scoop\\shims\\allure.cmd generate target/allure-results --clean --single-file -o target/allure-report"
            );
            printProcessOutput(generateProcess);
            generateProcess.waitFor(); // Wait for process to complete
            System.out.println("Allure report generated successfully as a single file.");

//            Open the Allure report in the default browser
//            Opening report creating problem for the sending the report need to work on this
//            Process openProcess = Runtime.getRuntime().exec(
//                    "C:\\Users\\HP\\scoop\\shims\\allure.cmd open target/allure-report"
//            );
//            printProcessOutput(openProcess);
//            openProcess.waitFor(); // Wait for process to complete
//            System.out.println("Allure report opened successfully.");

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(2000);

        System.out.println("****Now sharing the report to the user****");

//        Zip file was the older one TODO
        EmailReportSender.zipLargeFile("target/allure-report/index.html","target/allure-report/index.zip");
        EmailReportSender.sendEmailWithReport("kishor.deshmane@iffort.com");
    }

    private static void printProcessOutput(Process process) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
             BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("OUTPUT: " + line);
            }
            while ((line = errorReader.readLine()) != null) {
                System.err.println("ERROR: " + line);
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
//	}

    }
}
