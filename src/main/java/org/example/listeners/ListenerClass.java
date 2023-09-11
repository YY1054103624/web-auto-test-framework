package org.example.listeners;

import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.example.annotations.FrameworkAnnotation;
import org.example.enums.ConfigProperties;
import org.example.enums.LogType;
import org.example.report.ExtendLogger;
import org.example.report.ExtendReport;
import org.example.report.ExtendReportManager;
import org.example.selenoid.LogUrlManager;
import org.example.selenoid.VideoUrl;
import org.example.selenoid.VideoUrlManager;
import org.example.utils.ELKUtils;
import org.example.utils.FileNameGenerator;
import org.example.utils.PropertiesUtils;
import org.testng.*;

import java.io.IOException;
import java.util.Objects;

import static org.example.report.ExtendReport.flushExtentReport;
import static org.example.report.ExtendReport.initExtentReport;
import static org.example.report.FrameworkLogger.log;

/**
 * Implementations of {@link ITestListener} and {@link ISuiteListener}
 * <p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public class ListenerClass implements ITestListener, ISuiteListener {
    /**
     * Invoke initExtentReport() to initialize extent report before suite.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
    */
    @Override
    public void onStart(ISuite suite) {
        initExtentReport();
    }

    /**
     * Invoke flushExtentReport() to generate the extent report after suite.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
    */
    @Override
    public void onFinish(ISuite suite) {
        flushExtentReport();
    }

    /**
     * Create extent test node for each test method before it starts executing.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
    */
    @Override
    public void onTestStart(ITestResult result) {
        // Create and set test node for each test case
        ExtendReport.createExtentTest(result.getMethod().getDescription());
        ExtendReport.setAuthor(
                result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).authors()
        );
        ExtendReport.setCategories(
                result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).categories()
        );
    }

    /**
     * Log as pass when a test case is passed.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
    */
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtendLogger.pass(result.getMethod().getMethodName() + " is passed", ConfigProperties.PASSEDSCREENSHOTS);
        // Selenoid video and log (this works because testng runs onTestFailure before @AfterMethod
        if (Objects.nonNull(VideoUrlManager.get()))
            ExtendLogger.pass("The video link of Selenoid is " + VideoUrlManager.get());
        if (Objects.nonNull(LogUrlManager.get()))
            ExtendLogger.pass("The log link of Selenoid is " + LogUrlManager.get());
    }

    /**
     * Log as fail when a test case is failed.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
    */
    @Override
    public void onTestFailure(ITestResult result) {
        ExtendLogger.fail(result.getMethod().getMethodName() + " is failed", ConfigProperties.FAILEDSCREENSHOTS);
        ExtendLogger.fail(result.getThrowable().toString());
        ExtendLogger.fail(MarkupHelper.createUnorderedList(result.getThrowable().getStackTrace()));
        // Elasticsearch
        ELKUtils.post(result.getMethod().getDescription(), "fail");
        // Selenoid video and log (this works because testng runs onTestFailure before @AfterMethod
        if (Objects.nonNull(VideoUrlManager.get()))
            ExtendLogger.fail("The video link of Selenoid is " + VideoUrlManager.get());
        if (Objects.nonNull(LogUrlManager.get()))
            ExtendLogger.fail("The log link of Selenoid is " + LogUrlManager.get());
    }

    /**
     * Log as skip when a test case is skipped.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
    */
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtendLogger.skip(result.getMethod().getMethodName() + " is skipped", ConfigProperties.SHIPPEDSCREENSHOTS);
        ELKUtils.post(result.getMethod().getDescription(), "skip");
    }
}
