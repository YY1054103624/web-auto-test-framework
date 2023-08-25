package org.example;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AttachLogoTest {
    @Test
    public void attachLogoTest() throws IOException {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        spark.loadXMLConfig(new File("src/test/resources/config/reportsettings.xml"));
        extent.attachReporter(spark);

        ExtentTest test = extent.createTest("First test");
        test.pass("Test started");
        test.pass("Test finished");

        extent.flush();
        Desktop.getDesktop().browse(new File("index.html").toURI());
    }
}
