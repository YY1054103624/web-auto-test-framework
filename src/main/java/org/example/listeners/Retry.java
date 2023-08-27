package org.example.listeners;

import org.example.enums.ConfigProperties;
import org.example.utils.PropertiesUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int count = 0;
    int limit = 1;
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
