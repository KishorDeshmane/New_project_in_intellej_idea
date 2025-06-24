package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AllureSummaryParser {

    public static TestSummary parseSummary(String allureResultsPath) throws Exception {
        File folder = new File(allureResultsPath);
        ObjectMapper mapper = new ObjectMapper();

        int total = 0, passed = 0, failed = 0;
        long earliestStart = Long.MAX_VALUE;
        long latestStop = 0;

        for (File file : folder.listFiles()) {
            if (file.isFile() && file.getName().endsWith("-result.json")) {
                JsonNode root = mapper.readTree(file);

                total++;
                String status = root.path("status").asText();
                if ("passed".equalsIgnoreCase(status)) passed++;
                else failed++;

                long start = root.path("start").asLong();
                long stop = root.path("stop").asLong();

                if (start > 0) earliestStart = Math.min(earliestStart, start);
                if (stop > 0) latestStop = Math.max(latestStop, stop);
            }
        }

        String formattedStart = formatTime(earliestStart);
        String formattedEnd = formatTime(latestStop);
        String formattedDuration = formatDuration(latestStop - earliestStart);

        return new TestSummary(formattedStart, formattedEnd, formattedDuration, total, passed, failed);
    }

    private static String formatTime(long millis) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(millis));
    }

    private static String formatDuration(long millis) {
        long seconds = millis / 1000 % 60;
        long minutes = millis / (1000 * 60) % 60;
        long hours = millis / (1000 * 60 * 60);
        return String.format("%02dh %02dm %02ds", hours, minutes, seconds);
    }
}
