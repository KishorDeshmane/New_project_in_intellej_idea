package com.qa.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.concurrent.ConcurrentHashMap;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final int maxRetry = 3;

    // Thread-safe map to track retry counts by test name + params
    private static ConcurrentHashMap<String, Integer> retryCountMap = new ConcurrentHashMap<>();

    @Override
    public boolean retry(ITestResult result) {
        String key = getKey(result);
        int currentCount = retryCountMap.getOrDefault(key, 0);

        if (currentCount < maxRetry) {
            retryCountMap.put(key, currentCount + 1);
            return true;
        }
        return false;
    }

    private String getKey(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String parameters = java.util.Arrays.toString(result.getParameters());
        return methodName + parameters;
    }
}



//
//package com.qa.utility;
//
//import org.testng.IRetryAnalyzer;
//import org.testng.ITestResult;
//
//public class RetryAnalyzer implements IRetryAnalyzer {
//    private int attempt = 0;
//    private static final int maxRetry = 2;
//
//    @Override
//    public boolean retry(ITestResult result) {
//        if (attempt < maxRetry) {
//            attempt++;
//            return true;
//        }
//        return false;
//    }
//}
//
//

//package com.qa.utility;
//
//import org.testng.IRetryAnalyzer;
//import org.testng.ITestResult;
//
//public class RetryAnalyzer implements IRetryAnalyzer {
//
//    private static final int MAX_RETRY = 2; // Total: 1 original + 2 retries
//    private final ThreadLocal<Integer> attempt = ThreadLocal.withInitial(() -> 0);
//
//    @Override
//    public boolean retry(ITestResult result) {
//        String retryEnabled = System.getProperty("RETRY_ENABLED", "false");
//
//        if (retryEnabled.equalsIgnoreCase("true")) {
//            int currentAttempt = attempt.get();
//            if (currentAttempt < MAX_RETRY) {
//                attempt.set(currentAttempt + 1);
//                System.out.println("Retry logic applied for: " + result.getName() + " | RetryEnabled: " + retryEnabled);
//                System.out.println("🔁 Retrying test: " + result.getName() + " (Attempt " + (currentAttempt + 2) + ")");
//                return true;
//            }
//        }
//
//        return false;
//    }
//}


//
//package com.qa.utility;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.TimeoutException;
//import org.testng.IRetryAnalyzer;
//import org.testng.ITestResult;
//import com.qa.factory.DriverFactory;
//
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class RetryAnalyzer implements IRetryAnalyzer {
//
//    private static final int DEFAULT_MAX_RETRY = 2;
//    private static final int DEFAULT_BACKOFF_MS = 2000;
//
//    private static final Map<String, AtomicInteger> retryCountMap = new ConcurrentHashMap<>();
//
//    private static final List<Class<? extends Throwable>> RETRY_ON_EXCEPTIONS = Arrays.asList(
//            org.openqa.selenium.StaleElementReferenceException.class,
//            NoSuchElementException.class,
//            TimeoutException.class,
//            ElementClickInterceptedException.class,
//            ElementNotInteractableException.class,
//            WebDriverException.class,
//            NoSuchWindowException.class,
//            NoSuchFrameException.class,
//            UnhandledAlertException.class,
//            InvalidElementStateException.class,
//            org.openqa.selenium.interactions.MoveTargetOutOfBoundsException.class,
//            JavascriptException.class,
//            org.testng.TestException.class,
//            AssertionError.class,
//            RuntimeException.class,
//            java.net.SocketTimeoutException.class,
//            java.net.ConnectException.class,
//            java.io.IOException.class
//    );
//
//    private int getMaxRetry() {
//        String max = System.getProperty("maxRetry");
//        return max != null ? Integer.parseInt(max) : DEFAULT_MAX_RETRY;
//    }
//
//    private int getBackoffTime() {
//        String delay = System.getProperty("retryBackoffMs");
//        return delay != null ? Integer.parseInt(delay) : DEFAULT_BACKOFF_MS;
//    }
//
//    @Override
//    public boolean retry(ITestResult result) {
//        String key = result.getTestClass().getName() + "." + result.getMethod().getMethodName();
//        retryCountMap.putIfAbsent(key, new AtomicInteger(0));
//        int currentAttempt = retryCountMap.get(key).incrementAndGet();
//
//        Throwable cause = result.getThrowable();
//        boolean isRetryable = (cause == null) || RETRY_ON_EXCEPTIONS.stream().anyMatch(e -> e.isInstance(cause));
//        int maxRetry = getMaxRetry();
//
////        if (currentAttempt == 1) {
////            RetryLogger.logInitialFailure(key, cause); // Log 1st failure
////        } else
////        if (currentAttempt <= maxRetry) {
////            RetryLogger.logRetryAttempt(key, cause, currentAttempt, maxRetry); // Log retry attempt
////        }
//
//        if (currentAttempt <= maxRetry && isRetryable) {
//            logRetry(result, currentAttempt);
//            captureScreenshotOnRetry(result, currentAttempt);
//
//            try {
//                int backoff = getBackoffTime() * currentAttempt;
//                System.out.println("⏱️ Backing off for " + backoff + "ms before retry...");
//                Thread.sleep(backoff);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//            return true;
//        } else {
//            RetryLogger.logFinalFailure(key, cause, currentAttempt, maxRetry); // Log final failure
//            if (!isRetryable && cause != null) {
//                System.out.printf("❌ Not retrying [%s]: Unhandled exception (%s)%n", key, cause.getClass().getSimpleName());
//            } else {
//                System.out.printf("❌ Max retries exceeded for [%s]%n", key);
//            }
//        }
//
//        return false;
//    }
//
//    private void logRetry(ITestResult result, int attempt) {
//        System.out.printf("🔁 RETRYING [%s.%s] — Attempt %d of %d%n",
//                result.getTestClass().getName(),
//                result.getMethod().getMethodName(),
//                attempt,
//                getMaxRetry() + 1);
//
//        if (result.getThrowable() != null) {
//            System.out.println("⚠️  Cause: " + result.getThrowable().getClass().getSimpleName() + " - " + result.getThrowable().getMessage());
//        }
//    }
//
//    private void captureScreenshotOnRetry(ITestResult result, int attempt) {
//        try {
//            WebDriver driver = DriverFactory.getDriver();
//            if (driver != null && driver instanceof TakesScreenshot) {
//                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//                String screenshotName = result.getMethod().getMethodName() + "_retry_" + attempt + ".png";
//                System.out.println("📸 Screenshot captured on retry: " + screenshotName);
//            }
//        } catch (Exception e) {
//            System.err.println("❌ Failed to capture screenshot on retry: " + e.getMessage());
//        }
//    }
//}
