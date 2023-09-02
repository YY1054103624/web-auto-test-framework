package org.example.drivers;

import org.example.enums.ConfigProperties;
import org.example.selenoid.LogUrlManager;
import org.example.selenoid.VideoUrlManager;
import org.example.utils.PropertiesUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * <p>
* 2023/8/28
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public final class DriverFactory {
    private DriverFactory() {

    }

    public static WebDriver getDriver(String browser, String version, String testCaseName) throws MalformedURLException {
        WebDriver driver = null;
        MutableCapabilities options;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (PropertiesUtils.getValue(ConfigProperties.RUNMODE).equalsIgnoreCase("seleniumgrid")) {
            capabilities.setBrowserName(browser);
            capabilities.setVersion(version);
            driver = new RemoteWebDriver(new URL(PropertiesUtils.getValue(ConfigProperties.SELENIUMGRIDURL)), capabilities);
        } else if (PropertiesUtils.getValue(ConfigProperties.RUNMODE).equalsIgnoreCase("selenoid")) {
            options = new ChromeOptions();
            options.setCapability("browserVersion", version);
            options.setCapability("browserName", browser);
            Map<String, Object> optionsMap = new HashMap<>();
            optionsMap.put("name", testCaseName);
            optionsMap.put("enableVideo", Boolean.valueOf(PropertiesUtils.getValue(ConfigProperties.ENABLEVIDEO)));
            optionsMap.put("enableVNC", Boolean.valueOf(PropertiesUtils.getValue(ConfigProperties.ENABLEVNC)));
            optionsMap.put("enableLog", Boolean.valueOf(PropertiesUtils.getValue(ConfigProperties.ENABLELOG)));
            optionsMap.put("timeZone", PropertiesUtils.getValue(ConfigProperties.TIMEZONE));
            if (Objects.nonNull(VideoUrlManager.get()))
                optionsMap.put("videoName", VideoUrlManager.get().replace(PropertiesUtils.getValue(ConfigProperties.VIDEOURL), ""));
            if (Objects.nonNull(LogUrlManager.get()))
                optionsMap.put("logName", LogUrlManager.get().replace(PropertiesUtils.getValue(ConfigProperties.LOGURL), ""));
            options.setCapability("selenoid:options", optionsMap);
            driver = new RemoteWebDriver(new URL(PropertiesUtils.getValue(ConfigProperties.SELENOIDREMOTEURL)), options);
        } else {
            driver = switch (browser) {
                case "chrome" -> new ChromeDriver();
                case "edge" -> new EdgeDriver();
                case "firefox" -> new FirefoxDriver();
                default -> driver;
            };
        }
        return driver;
    }
}
