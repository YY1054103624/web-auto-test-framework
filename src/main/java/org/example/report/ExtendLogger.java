package org.example.report;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import org.example.drivers.DriverManager;
import org.example.enums.ConfigProperties;
import org.example.utils.PropertiesUtils;
import org.example.utils.ScreenshotUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * This class for logging.
 * <p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public final class ExtendLogger {
    private ExtendLogger() {

    }

    /**
     * Log as pass with Markup as parameter.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
     * @param markup {@link com.aventstack.extentreports.markuputils.Markup}
    */
    public static void pass(Markup markup) {
        ExtendReportManager.getExtTest().pass(markup);
    }

    /**
     * log as fail with markup as parameter.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     * @param markup {@link com.aventstack.extentreports.markuputils.Markup}
     */
    public static void fail(Markup markup) {
        ExtendReportManager.getExtTest().fail(markup);
    }

    /**
     * Log as skip with Markup as parameter.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     * @param markup {@link com.aventstack.extentreports.markuputils.Markup}
     */
    public static void skip(Markup markup) {
        ExtendReportManager.getExtTest().skip(markup);
    }


    /**
     * Log as pass with a string as parameter.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     * @param message {@link java.lang.String}
     */
    public static void pass(String message) {
        ExtendReportManager.getExtTest().pass(message);
    }

    /**
     * Log as fail with a string as parameter.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     * @param message {@link java.lang.String}
     */
    public static void fail(String message) {
        ExtendReportManager.getExtTest().fail(message);
    }

    /**
     * Log as skip with a string as parameter.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     * @param message {@link java.lang.String}
     */
    public static void skip(String message) {
        ExtendReportManager.getExtTest().skip(message);
    }

    /**
     * Log as info with a string as parameter.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     * @param message {@link java.lang.String}
     */
    public static void info(String message) {
        ExtendReportManager.getExtTest().skip(message);
    }

    /**
     * Log as pass with a message and screenshot.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
     * @param message {@link java.lang.String}
     * @param getScreenshot {@link java.lang.Boolean} whether a screenshot is needed.
    */
    public static void pass(String message, boolean getScreenshot) {
        if (getScreenshot) {
            ExtendReportManager.getExtTest().
                    pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64()).build());
        } else {
            pass(message);
        }
    }

    /**
     * Log as fail with a message and screenshot.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     * @param message {@link java.lang.String}
     * @param getScreenshot {@link java.lang.Boolean} whether a screenshot is needed.
     */
    public static void fail(String message, boolean getScreenshot) {
        if (getScreenshot) {
            ExtendReportManager.getExtTest().
                    fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64()).build());
        } else {
            fail(message);
        }
    }

    /**
     * Log as skip with a message and screenshot.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     * @param message {@link java.lang.String}
     * @param getScreenshot {@link java.lang.Boolean} whether a screenshot is needed.
     */
    public static void skip(String message, boolean getScreenshot) {
        if (getScreenshot) {
            ExtendReportManager.getExtTest().
                    skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64()).build());
        } else {
            skip(message);
        }
    }

    /**
     * Log as info with a message and screenshot.
     * <p>
     * 2023/8/30
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     * @param message {@link java.lang.String}
     * @param getScreenshot {@link java.lang.Boolean} whether a screenshot is needed.
     */
    public static void info(String message, boolean getScreenshot) {
        if (getScreenshot) {
            ExtendReportManager.getExtTest().
                    info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64()).build());
        } else {
            info(message);
        }
    }


    /**
     * Log as pass when test case is passed.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     * @param message {@link java.lang.String}
     * @param property {@link org.example.enums.ConfigProperties}
     */
    public static void pass(String message, ConfigProperties property) {
        if (PropertiesUtils.getValue(property).equalsIgnoreCase("yes")) {
            ExtendReportManager.getExtTest().
                    pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64()).build());
        } else {
            pass(message);
        }
    }

    /**
     * Log as failed when test case is failed.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     * @param message {@link java.lang.String}
     * @param property {@link org.example.enums.ConfigProperties}
     */
    public static void fail(String message, ConfigProperties property) {
        if (PropertiesUtils.getValue(property).equalsIgnoreCase("yes")) {
            ExtendReportManager.getExtTest().
                    fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64()).build());
        } else {
            fail(message);
        }
    }

    /**
     * Log as skipped when test case is skipped.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     * @param message {@link java.lang.String}
     * @param property {@link org.example.enums.ConfigProperties}
     */
    public static void skip(String message, ConfigProperties property) {
        if (PropertiesUtils.getValue(property).equalsIgnoreCase("yes")) {
            ExtendReportManager.getExtTest().
                    skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64()).build());
        } else {
            skip(message);
        }
    }

}
