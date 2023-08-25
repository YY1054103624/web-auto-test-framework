package org.example.report;

import com.aventstack.extentreports.ExtentTest;

public final class ExtendReportManager {
    private ExtendReportManager() {

    }

    private static final ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    static void setExtTest(ExtentTest test) {
        extTest.set(test);
    }

    static ExtentTest getExtTest() {
        return extTest.get();
    }

    static void unload() {
        extTest.remove();
    }
}
