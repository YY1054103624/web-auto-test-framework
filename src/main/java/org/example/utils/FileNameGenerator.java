package org.example.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class FileNameGenerator {
    private FileNameGenerator() {

    }
    public static String getSelenoidVideoFileName(String browser, String version, String testCaseName) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String currentDateTime = localDateTime.toString();
        String threadOrder = Thread.currentThread().getName().split("-")[2];
        return String.format("%s_%s_%s_%s_%s.mp4", testCaseName, threadOrder, browser, version, currentDateTime);
    }

    public static String getSelenoidLogFileName(String browser, String version, String testCaseName) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String currentDateTime = localDateTime.toString();
        String threadOrder = Thread.currentThread().getName().split("-")[2];
        return String.format("%s_%s_%s_%s_%s.log", testCaseName, threadOrder, browser, version, currentDateTime);
    }
}
