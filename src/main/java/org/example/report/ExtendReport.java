package org.example.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.example.constants.FrameworkConstants;
import org.example.enums.ConfigProperties;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtendReport {
    private ExtendReport() {

    }
    private static ExtentReports extent;
    public static void initExtentReport() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportPath(ConfigProperties.OVERRIDEREPORT));
            spark.config().setDocumentTitle("Test Result");
            spark.config().setReportName("Web UI Automation");
            extent.attachReporter(spark);
        }
    }

    public static void flushExtentReport() throws IOException {
        if (Objects.nonNull(extent)) {
            extent.flush();
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportPath(ConfigProperties.OVERRIDEREPORT)).toURI());
        }
    }

    public static void createExtentTest(String testName) {
        ExtendReportManager.setExtTest(extent.createTest(testName));
    }
}
