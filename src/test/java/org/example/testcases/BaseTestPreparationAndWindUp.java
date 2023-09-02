package org.example.testcases;

import org.example.enums.ConfigProperties;
import org.example.selenoid.LogUrlManager;
import org.example.selenoid.VideoUrlManager;
import org.example.utils.PropertiesUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

import static org.example.drivers.Driver.initDriver;
import static org.example.drivers.Driver.quitDriver;
import static org.example.selenoid.LogUrl.initLogUrl;
import static org.example.selenoid.LogUrl.removeLogUrl;
import static org.example.selenoid.VideoUrl.initVideoUrl;
import static org.example.selenoid.VideoUrl.removeVideoUrl;

/**
 * This class is for invoking methods of {@link org.example.drivers.Driver} to open and close browser.
 * <p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public class BaseTestPreparationAndWindUp {
    protected BaseTestPreparationAndWindUp() {

    }

    /**
     * Invoke method to open specific browser.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
     * @param data Data from Excel.
    */
    @SuppressWarnings("unchecked")
    @BeforeMethod
    protected void beforeMethod(Object[] data) throws Exception {
        Map<String, String> map = (Map<String, String>) data[0];

        String browser = map.get("browser");
        String version = map.get("version");
        String testCaseName = map.get("testname");

        // Create video and log file name for each test case
        // This block of code must be executed before iniDriver, because this method will invoke VideoUrlManager.get()
        if (PropertiesUtils.getValue(ConfigProperties.RUNMODE).equalsIgnoreCase("selenoid")) {
            if (PropertiesUtils.getValue(ConfigProperties.ENABLEVIDEO).equalsIgnoreCase("true"))
                initVideoUrl(browser, version, testCaseName);
            if (PropertiesUtils.getValue(ConfigProperties.ENABLELOG).equalsIgnoreCase("true"))
                initLogUrl(browser, version, testCaseName);
        }
        //
        initDriver(browser, version, testCaseName);
    }

    /**
     * Invoke method to close browser.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
    */
    @AfterMethod
    protected void afterMethod() {
        quitDriver();
        if (PropertiesUtils.getValue(ConfigProperties.RUNMODE).equalsIgnoreCase("selenoid")) {
            if (PropertiesUtils.getValue(ConfigProperties.ENABLEVIDEO).equalsIgnoreCase("true"))
                removeVideoUrl();
            if (PropertiesUtils.getValue(ConfigProperties.ENABLELOG).equalsIgnoreCase("true"))
                removeLogUrl();
        }
    }
}
