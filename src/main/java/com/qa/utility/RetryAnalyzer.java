package com.qa.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int attempt = 0;
    private final int maxRetry = 2; // 🔁 Will retry 2 times (total 3 attempts including first)

    @Override
    public boolean retry(ITestResult result) {
        if (attempt < maxRetry) {
            attempt++;
            System.out.println("🔁 Retrying test: " + result.getName() + " (Attempt " + (attempt + 1) + ")");
            return true;
        }
        return false;
    }
}
