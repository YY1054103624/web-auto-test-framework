package org.example.listeners;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.example.enums.ConfigProperties;
import org.example.report.ExtendLogger;
import org.example.report.ExtendReport;
import org.testng.*;

import java.io.IOException;

import static org.example.report.ExtendReport.flushExtentReport;
import static org.example.report.ExtendReport.initExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        initExtentReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            flushExtentReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtendReport.createExtentTest(result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtendLogger.pass(result.getMethod().getMethodName() + " is passed", ConfigProperties.PASSEDSCREENSHOTS);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtendLogger.fail(result.getMethod().getMethodName() + " is failed", ConfigProperties.FAILEDSCREENSHOTS);
        ExtendLogger.fail(result.getThrowable().toString());
        ExtendLogger.fail(MarkupHelper.createUnorderedList(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtendLogger.skip(result.getMethod().getMethodName() + " is skipped", ConfigProperties.SHIPPEDSCREENSHOTS);
    }
}
