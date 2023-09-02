package org.example.listeners;

import org.example.enums.ConfigProperties;
import org.example.utils.PropertiesUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Implementation of {@link IRetryAnalyzer}
 * <p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public class Retry implements IRetryAnalyzer {
    int count = 0;
    int limit = 1;
    /**
     * Retry a test method once when it's failed.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
    */
    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean flag = false;
        if (PropertiesUtils.getValue(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("yes")) {
            flag = count < limit;
            count++;
        }
        return flag;
    }
}
