package com.qa.utility;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import com.qa.factory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AllureReportHelper {

    private static final String RESULTS_DIR = "target/allure-results";
    private static final String REPORT_DIR = "target/allure-report";
    private static final String ALLURE_COMMAND = "allure"; // assumes 'allure' is in system PATH

    public static void generateAllureSupportFiles() {
        createEnvironmentProperties();
        createExecutorJson();
        createCategoriesJson();
        copyHistoryFromLastRun();         // ✅ Add this before generating the report
        generateAllureReport();
    }

    public static void createEnvironmentProperties() {
        try {
            Properties props = new Properties();

            // App-specific config
            Capabilities cap = ((RemoteWebDriver) DriverFactory.getDriver()).getCapabilities();
            String browserName = cap.getBrowserName();
            String baseUrl = getConfigValue("base.url", "http://localhost:8080");
            String env = getSystemOrEnv("test.env", "QA");

            // System metadata
            String os = System.getProperty("os.name") + " " + System.getProperty("os.version");
            String javaVersion = System.getProperty("java.version");
            String user = System.getProperty("user.name");
            String timezone = System.getProperty("user.timezone");

            // Set Allure environment properties
            props.setProperty("Environment", env);
            props.setProperty("Browser", browserName);
            props.setProperty("BaseURL", baseUrl);
            props.setProperty("OS", os);
            props.setProperty("Java Version", javaVersion);
            props.setProperty("Executed By", user);
            props.setProperty("Time Zone", timezone);

            ensureDirExists(RESULTS_DIR);

            try (FileOutputStream out = new FileOutputStream(RESULTS_DIR + "/environment.properties")) {
                props.store(out, "Allure Environment Properties");
                System.out.println("✅ environment.properties created");
//                props.forEach((k, v) ->
//                        System.out.println("  → " + k + ": " + v));
            }
        } catch (Exception e) {
            System.err.println("❌ Failed to create environment.properties: " + e.getMessage());
        }
    }


    private static String getConfigValue(String key, String defaultValue) {
        try {
            String value = ConfigManager.getProperty(key);
            return (value != null && !value.isEmpty()) ? value.split("#")[0].trim() : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    private static String getSystemOrEnv(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value != null && !value.isEmpty()) return value;
        value = System.getenv(key);
        return (value != null && !value.isEmpty()) ? value : defaultValue;
    }


    public static void createExecutorJson() {
        String buildName = "Build-101";
        String buildUrl = "http://localhost:8080/job/qa-project/101"; // Update if using Jenkins/GitHub Actions
        String reportUrl = ""; // Optional: Link to hosted Allure report if available
        String executionName = "Local Execution";
        String executionType = "Local"; // or "CI", "Jenkins", etc.

        String gitBranch = getGitBranch();
        String gitCommit = getGitCommit();

        String json = "{\n" +
                "  \"name\": \"" + executionName + "\",\n" +
                "  \"type\": \"" + executionType + "\",\n" +
                "  \"buildName\": \"" + buildName + "\",\n" +
                "  \"buildOrder\": 1,\n" +
                "  \"buildUrl\": \"" + buildUrl + "\",\n" +
                "  \"reportUrl\": \"" + reportUrl + "\",\n" +
                "  \"branchName\": \"" + gitBranch + "\",\n" +
                "  \"commitHash\": \"" + gitCommit + "\"\n" +
                "}";

        writeToFile(RESULTS_DIR + "/executor.json", json, "executor.json");
    }

    private static String getGitBranch() {
        try {
            Process process = Runtime.getRuntime().exec("git rev-parse --abbrev-ref HEAD");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String branch = reader.readLine();
            process.waitFor();
            return branch != null ? branch.trim() : "unknown-branch";
        } catch (Exception e) {
            return "unknown-branch";
        }
    }

    private static String getGitCommit() {
        try {
            Process process = Runtime.getRuntime().exec("git rev-parse --short HEAD");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String commit = reader.readLine();
            process.waitFor();
            return commit != null ? commit.trim() : "unknown-commit";
        } catch (Exception e) {
            return "unknown-commit";
        }
    }


    public static void createCategoriesJson() {
        String json = "[\n" +
                "  {\n" +
                "    \"name\": \"Assertion Failure\",\n" +
                "    \"matchedStatuses\": [\"failed\"],\n" +
                "    \"traceRegex\": \".*AssertionError.*\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Null Pointer Exception\",\n" +
                "    \"matchedStatuses\": [\"broken\"],\n" +
                "    \"traceRegex\": \".*NullPointerException.*\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Timeout Exception\",\n" +
                "    \"matchedStatuses\": [\"failed\"],\n" +
                "    \"traceRegex\": \".*TimeoutException.*\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Element Not Found\",\n" +
                "    \"matchedStatuses\": [\"failed\"],\n" +
                "    \"traceRegex\": \".*NoSuchElementException.*\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Stale Element Reference\",\n" +
                "    \"matchedStatuses\": [\"failed\"],\n" +
                "    \"traceRegex\": \".*StaleElementReferenceException.*\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"WebDriver Exception\",\n" +
                "    \"matchedStatuses\": [\"broken\"],\n" +
                "    \"traceRegex\": \".*WebDriverException.*\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Invalid Argument\",\n" +
                "    \"matchedStatuses\": [\"broken\"],\n" +
                "    \"traceRegex\": \".*IllegalArgumentException.*\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Interrupted Exception\",\n" +
                "    \"matchedStatuses\": [\"broken\"],\n" +
                "    \"traceRegex\": \".*InterruptedException.*\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"IO Exception\",\n" +
                "    \"matchedStatuses\": [\"broken\"],\n" +
                "    \"traceRegex\": \".*IOException.*\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Unhandled Exception\",\n" +
                "    \"matchedStatuses\": [\"broken\", \"failed\"],\n" +
                "    \"traceRegex\": \".*Exception.*\"\n" +
                "  }\n" +
                "]";

        writeToFile(RESULTS_DIR + "/categories.json", json, "categories.json");
    }


    public static void copyHistoryFromLastRun() {
        File source = new File(REPORT_DIR + "/history");
        File dest = new File(RESULTS_DIR + "/history");

        if (source.exists()) {
            try {
                FileUtils.copyDirectory(source, dest);
                System.out.println("✅ Copied history from previous report for trends.");
            } catch (IOException e) {
                System.err.println("❌ Failed to copy history: " + e.getMessage());
            }
        } else {
            System.out.println("ℹ️ No previous history folder found to copy.");
        }
    }

    private static void writeToFile(String path, String content, String label) {
        try {
            ensureDirExists(Paths.get(path).getParent().toString());
            Files.write(Paths.get(path), content.getBytes());
            System.out.println("✅ " + label + " written to " + path);
        } catch (IOException e) {
            System.err.println("❌ Failed to write " + label + ": " + e.getMessage());
        }
    }

    private static void ensureDirExists(String dirPath) throws IOException {
        File dir = new File(dirPath);
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("Unable to create directory: " + dirPath);
        }
    }

    public static void generateAllureReport() {
        try {
            Process generateProcess = Runtime.getRuntime().exec(
                    "C:\\Users\\HP\\scoop\\shims\\allure.cmd generate target/allure-results --clean --single-file -o target/allure-report"
            );
            printProcessOutput(generateProcess);
            generateProcess.waitFor();
            System.out.println("Allure report generated successfully as a single file.");

//            Open the Allure report in the default browser Opening report creating problem for the sending the report need to work on this
//            Process openProcess = Runtime.getRuntime().exec("C:\\Users\\HP\\scoop\\shims\\allure.cmd open target/allure-report");
//            printProcessOutput(openProcess);
//            openProcess.waitFor();
//            System.out.println("Allure report opened successfully.");

        } catch (InterruptedException | IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("Now sharing the report to the user via email.");
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
    }
}
