package org.example.report;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import org.example.drivers.DriverManager;
import org.example.enums.ConfigProperties;
import org.example.utils.PropertiesUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public final class ExtendLogger {
    private ExtendLogger() {

    }
    public static void pass(Markup markup) {
        ExtendReportManager.getExtTest().pass(markup);
    }

    public static void fail(Markup markup) {
        ExtendReportManager.getExtTest().fail(markup);
    }

    public static void skip(Markup markup) {
        ExtendReportManager.getExtTest().skip(markup);
    }

    public static void pass(String message) {
        ExtendReportManager.getExtTest().pass(message);
    }

    public static void fail(String message) {
        ExtendReportManager.getExtTest().fail(message);
    }

    public static void skip(String message) {
        ExtendReportManager.getExtTest().skip(message);
    }

    public static void pass(String message, boolean getScreenshot) {
        if (getScreenshot) {
            ExtendReportManager.getExtTest().
                    pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
        } else {
            pass(message);
        }
    }

    public static void fail(String message, boolean getScreenshot) {
        if (getScreenshot) {
            ExtendReportManager.getExtTest().
                    fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
        } else {
            fail(message);
        }
    }

    public static void skip(String message, boolean getScreenshot) {
        if (getScreenshot) {
            ExtendReportManager.getExtTest().
                    skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
        } else {
            skip(message);
        }
    }

    public static void pass(String message, ConfigProperties property) {
        try {
            if (PropertiesUtils.getValue(property).equalsIgnoreCase("yes")) {
                ExtendReportManager.getExtTest().
                        pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
            } else {
                pass(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void fail(String message, ConfigProperties property) {
        try {
            if (PropertiesUtils.getValue(property).equalsIgnoreCase("yes")) {
                ExtendReportManager.getExtTest().
                        fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
            } else {
                fail(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void skip(String message, ConfigProperties property) {
        try {
            if (PropertiesUtils.getValue(property).equalsIgnoreCase("yes")) {
                ExtendReportManager.getExtTest().
                        skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
            } else {
                skip(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getBase64() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
