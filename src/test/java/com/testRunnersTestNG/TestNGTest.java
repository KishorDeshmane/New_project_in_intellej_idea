package com.testRunnersTestNG;

//import org.junit.runner.RunWith;
import com.qa.utility.RetryAnalyzer;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
		features = "src/test/resources/features",
//		tags="@TS_PRO_A_001", 				// tags="@xyz or @abc", 	//	tags="@Positive",
		glue = {"stepDefinitions","com/applicationHooks"},
		monochrome=true, //	For example if you want console output from Cucumber in a readable format, you can specify it like this:
//		dryRun = false, //	For example if you want to check whether all feature file steps have corresponding step definitions, you can specify it like thi
		plugin = {"pretty",
			"html:target/html_report/cucumber_reports.html",
			"junit:target/junit_report/junit_reports.xml",
			"json:target/json_report/json_reports.json",
				"json:target/cucumber-reports/Cucumber.json",
//			"com.aventstack.chaintest.plugins.ChainTestCucumberListener:",
//			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" //allure serve allure-results---Runit in terminal a allure-results folder
		}
		)

public class TestNGTest extends AbstractTestNGCucumberTests {
	@Override
    @DataProvider
			(parallel = false)
	// Set parallel to true if you want to run scenarios in parallel RETRY logic not working with parallel execution
    public Object[][] scenarios() {
        return super.scenarios();
    }

// Retry Logic for failed tests
	@Test(
			groups = {"cucumber"},
			description = "Runs Cucumber Scenarios",
			dataProvider = "scenarios",
			retryAnalyzer = RetryAnalyzer.class // Retry logic for failed tests
	)
	public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
		super.runScenario(pickleWrapper, featureWrapper);
	}

	/**
	 * This method is executed before the class to set up any preconditions for the Cucumber tests.
	 * It sets the data provider thread count to 2, allowing parallel execution of scenarios.
	 */
	@BeforeClass
	public void beforeClass(ITestContext context) {
		System.out.println("Before Class: Setting up preconditions for Cucumber tests.");
		context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(2);
	}

	/**
	 * This method is executed before the test suite to set up any preconditions for the Cucumber tests.
	 * It can be used to initialize resources or configurations needed for the entire suite.
	 *
	 *
	 * 	    @BeforeSuite
	 *    public void beforeSuite(ITestContext context) {
	 * 		System.out.println("Before Suite: Setting up preconditions for Cucumber tests.");
	 *    }
	 *
	 */

}

