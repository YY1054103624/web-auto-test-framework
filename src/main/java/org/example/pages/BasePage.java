package org.example.pages;

import org.example.constants.FrameworkConstants;
import org.example.drivers.DriverManager;
import org.example.enums.WaitStrategy;
import org.example.report.ExtendLogger;
import org.example.report.ExtendReport;
import org.example.report.ExtendReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected void click(By by, WaitStrategy waitStrategy, String elementName, boolean getScreenshot) {
        WebElement element = waitStrategy.wait(by);
        element.click();
        ExtendLogger.pass(elementName + " is clicked successfully", getScreenshot);
    }

    protected void sendText(By by, String text, WaitStrategy waitStrategy, String elementName, boolean getScreenshot) {
        WebElement element = waitStrategy.wait(by);
        element.sendKeys(text);
        ExtendLogger.pass("Send " + text + " in " + elementName, getScreenshot);
    }

    public String getTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
