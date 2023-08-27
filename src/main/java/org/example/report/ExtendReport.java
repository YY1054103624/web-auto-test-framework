package org.example.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.example.constants.FrameworkConstants;
import org.example.enums.Author;
import org.example.enums.Category;
import org.example.enums.ConfigProperties;
import org.example.exceptions.OpenReportIOException;

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

    public static void flushExtentReport() {
        if (Objects.nonNull(extent)) {
            extent.flush();
            try {
                Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportPath(ConfigProperties.OVERRIDEREPORT)).toURI());
            } catch (IOException e) {
                throw new OpenReportIOException("Fail to open report " + FrameworkConstants.getExtentReportPath(ConfigProperties.OVERRIDEREPORT), e);
            }
        }
    }

    public static void createExtentTest(String testName) {
        ExtendReportManager.setExtTest(extent.createTest(testName));
    }

    public static void setAuthor(Author[] authors) {
        for (Author author: authors) {
            ExtendReportManager.getExtTest().assignAuthor(author.getAuthor());
        }
    }

    public static void setCategories(Category[] categories) {
        for (Category category: categories) {
            ExtendReportManager.getExtTest().assignCategory(category.getCategory());
        }
    }
}
