package com.qa.utility;

import java.io.*;
import java.time.LocalDateTime;

public class RetryLogger {

//    private static final String INITIAL_LOG = "logs/initial-failures.log";
//    private static final String RETRY_LOG   = "logs/retry-attempts.log";
//    private static final String FINAL_LOG   = "logs/final-failures.log";

    // Ensure 'logs' directory is created
//    static {
//        new File("logs").mkdirs();
//    }

//    public static synchronized void logInitialFailure(String testName, Throwable throwable) {
//        writeToLog(INITIAL_LOG, "Initial Failure", testName, throwable, 1);
//    }
//
//    public static synchronized void logRetryAttempt(String testName, Throwable throwable, int attempt, int maxRetry) {
//        writeToLog(RETRY_LOG, "Retry Attempt", testName, throwable, attempt);
//    }

//    public static synchronized void logFinalFailure(String testName, Throwable throwable, int attempt, int maxRetry) {
//        writeToLog(FINAL_LOG, "Final Failure", testName, throwable, attempt);
//    }
//
//    private static void writeToLog(String filePath, String type, String testName, Throwable throwable, int attempt) {
//        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
//            writer.println("==================================================");
//            writer.println("Type           : " + type);
//            writer.println("Test Name      : " + testName);
//            writer.println("Timestamp      : " + LocalDateTime.now());
//            writer.println("Attempt        : " + attempt);
//            writer.println("Exception Type : " + (throwable != null ? throwable.getClass().getName() : "null"));
//            writer.println("Message        : " + (throwable != null ? throwable.getMessage() : "null"));
//            writer.println("Stack Trace    : ");
//            writer.println(getStackTraceAsString(throwable));
//            writer.println("==================================================\n");
//        } catch (IOException e) {
//            System.err.println("❌ Failed to write to log file: " + e.getMessage());
//        }
//    }
//
//    private static String getStackTraceAsString(Throwable throwable) {
//        if (throwable == null) return "No stack trace available.";
//        StringWriter sw = new StringWriter();
//        throwable.printStackTrace(new PrintWriter(sw));
//        return sw.toString();
//    }
}
