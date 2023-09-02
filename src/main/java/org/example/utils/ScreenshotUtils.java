package org.example.utils;

import org.example.drivers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * This class is for dealing with screenshots.
 * <p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public final class ScreenshotUtils {
    private ScreenshotUtils() {

    }

    /**
     * Get the screenshot of current web page as base64 string.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
     * @return
    */
    public static String getBase64() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
