package org.example.drivers;

import org.example.enums.ConfigProperties;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Objects;

import static org.example.utils.PropertiesUtils.getValue;

public final class Driver {
    private Driver() {

    }
    public static void initDriver() throws Exception {
        // this if statement makes code more stable, in case someone invoke this method multiple times
        if (Objects.isNull(DriverManager.getDriver())) {
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().get(getValue(ConfigProperties.URL));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            // after driver is quit, it's still none-null,
            // so we need to set it null manually to make sure initDriver() work well
            DriverManager.unload();
        }
    }
}
