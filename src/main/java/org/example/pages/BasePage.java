package org.example.pages;

import org.example.drivers.DriverManager;
import org.example.enums.WaitStrategy;
import org.example.report.ExtendLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected void click(By by, WaitStrategy waitStrategy, String elementName, boolean getScreenshot) {
        WebElement element = waitStrategy.explicitWait(by);
        element.click();
        ExtendLogger.pass(elementName + " is clicked successfully", getScreenshot);
    }

    protected void sendText(By by, String text, WaitStrategy waitStrategy, String elementName, boolean getScreenshot) {
        WebElement element = waitStrategy.explicitWait(by);
        element.sendKeys(text);
        ExtendLogger.pass("Send " + text + " in " + elementName, getScreenshot);
    }

    protected void sendTextWithAction(By by, String text, WaitStrategy waitStrategy, String elementName, boolean getScreenshot, Keys action) {
        WebElement element = waitStrategy.explicitWait(by);
        element.sendKeys(text, action);
        ExtendLogger.pass("Send " + text + " in " + elementName, getScreenshot);
    }


    public String getTitle() {
        return DriverManager.getDriver().getTitle();
    }

    protected String getElementText(By by, WaitStrategy waitStrategy, String elementName, boolean getScreenshot) {
        WebElement element = waitStrategy.explicitWait(by);
        String text = element.getText();
        ExtendLogger.pass("Get " + text + " from " + elementName, getScreenshot);
        return text;
    }
}
