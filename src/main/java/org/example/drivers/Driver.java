package org.example.drivers;

import org.example.enums.ConfigProperties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Objects;

import static org.example.utils.PropertiesUtils.getValue;
/**
* This class is for initializing {@link org.openqa.selenium.WebDriver}
 * <p></p>
* 2023/8/27
* @author yangyong
* @version 1.0
* @since 1.0
*/
public final class Driver {
    private Driver() {

    }

    /**
     * Initialize {@link org.openqa.selenium.WebDriver}
     * @param browser The browser to open
     */
    public static void initDriver(String browser) {
        // this if statement makes code more stable, in case someone invoke this method multiple times
        if (Objects.isNull(DriverManager.getDriver())) {
            if (browser.equalsIgnoreCase("chrome")) {
                DriverManager.setDriver(new ChromeDriver());
            } else if (browser.equalsIgnoreCase("edge")) {
                DriverManager.setDriver(new EdgeDriver());
            }
            DriverManager.getDriver().get(getValue(ConfigProperties.URL));
        }
    }

    /**
     * Close browser
     */
    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            // after driver is quit, it's still none-null,
            // so we need to set it null manually to make sure initDriver() work well
            DriverManager.unload();
        }
    }
}
