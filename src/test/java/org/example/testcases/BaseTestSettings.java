package org.example.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static org.example.drivers.Driver.initDriver;
import static org.example.drivers.Driver.quitDriver;
import static org.example.report.ExtendReport.flushExtentReport;
import static org.example.report.ExtendReport.initExtentReport;

public class BaseTestSettings{
    protected BaseTestSettings() {

    }


    @BeforeMethod
    protected void beforeMethod() throws Exception {
        initDriver();
    }

    @AfterMethod
    protected void afterMethod() {
        quitDriver();
    }
}
