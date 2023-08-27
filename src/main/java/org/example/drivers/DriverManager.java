package org.example.drivers;

import org.openqa.selenium.WebDriver;
/**
 * This class is for safely invoking {@link org.openqa.selenium.WebDriver} object in parallel by saving it in {@link java.lang.ThreadLocal}
 * <p></p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public final class DriverManager {
    private DriverManager() {
    }

    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    /**
     * Save the driver into {@link java.lang.ThreadLocal} object.
     * @param driver {@link org.openqa.selenium.WebDriver} object
     */
    public static void setDriver(WebDriver driver) {
        dr.set(driver);
    }

    /**
     * Get the driver
     * @return {@link org.openqa.selenium.WebDriver} object
     */
    public static WebDriver getDriver() {
        return dr.get();
    }

    /**
     * Remove the driver
     */
    public static void unload() {
        dr.remove();
    }
}
