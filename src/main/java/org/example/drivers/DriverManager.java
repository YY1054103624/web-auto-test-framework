package org.example.drivers;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private DriverManager() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * ThreadLocal makes sure only the thread which creates the object is able to access the object
     */
    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();
    public static void setDriver(WebDriver driver) {
        dr.set(driver);
    }

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void unload() {
        dr.remove();
    }
}
