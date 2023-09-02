package org.example.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.enums.ConfigProperties;
import org.example.exceptions.OpenBrowserException;
import org.example.utils.PropertiesUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import static org.example.utils.PropertiesUtils.getValue;
/**
* This class is for initializing {@link org.openqa.selenium.WebDriver}
 * <p>
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
     * @param version The version of browser
     * @param testCaseName The name of the test case
     */
    public static void initDriver(String browser, String version, String testCaseName) {
        // this if statement makes code more stable, in case someone invoke this method multiple times
        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser, version, testCaseName));
            } catch (MalformedURLException e) {
                throw new OpenBrowserException("Please check the WebDriver capabilities.", e);
            }
            DriverManager.getDriver().manage().window().maximize();
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
