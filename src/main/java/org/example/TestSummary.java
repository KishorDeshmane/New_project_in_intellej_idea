package org.example;

public class TestSummary {
    public String startTime;
    public String endTime;
    public String duration;
    public int total;
    public int passed;
    public int failed;

    public TestSummary(String startTime, String endTime, String duration, int total, int passed, int failed) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.total = total;
        this.passed = passed;
        this.failed = failed;
    }
}
