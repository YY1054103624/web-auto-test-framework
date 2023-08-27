package org.example.testcases;

import org.example.report.ExtendReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Map;

import static org.example.drivers.Driver.initDriver;
import static org.example.drivers.Driver.quitDriver;
import static org.example.report.ExtendReport.flushExtentReport;
import static org.example.report.ExtendReport.initExtentReport;

public class BaseTestSettings{
    protected BaseTestSettings() {

    }


    @SuppressWarnings("unchecked")
    @BeforeMethod
    protected void beforeMethod(Object[] data) throws Exception {
        Map<String, String> map = (Map<String, String>) data[0];
        initDriver(map.get("browser"));
    }

    @AfterMethod
    protected void afterMethod() {
        quitDriver();
    }
}
