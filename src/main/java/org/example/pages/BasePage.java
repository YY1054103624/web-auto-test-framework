package org.example.pages;

import org.example.drivers.DriverManager;
import org.example.enums.LogType;
import org.example.enums.WaitStrategy;
import org.example.report.ExtendLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.example.report.FrameworkLogger.log;

/**
 * Provides with basic interaction methods with web elements
 * <p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public class BasePage {
    /**
     * Click on a web element.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
     * @param by Locator of the element.
     * @param waitStrategy The waiting mode.
    */
    protected void click(By by, WaitStrategy waitStrategy) {
        WebElement element = waitStrategy.explicitWait(by);
        element.click();
    }

    /**
     * Send message into a web element.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     * @param by Locator of the element.
     * @param text The message that is going to be sent.
     * @param waitStrategy The waiting mode.
     */
    protected void sendText(By by, String text, WaitStrategy waitStrategy) {
        WebElement element = waitStrategy.explicitWait(by);
        element.sendKeys(text);
    }

    /**
     * Send message into a web element with the specific action.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     * @param by Locator of the element.
     * @param text The message that is going to be sent.
     * @param waitStrategy The waiting mode.
     * @param elementName The name of the element that is used for logging.
     * @param getScreenshot Whether a screenshot is needed.
     * @param action The action that is going to be sent.
     */
    protected void sendTextWithAction(By by, String text, WaitStrategy waitStrategy, String elementName, boolean getScreenshot, Keys action) {
        WebElement element = waitStrategy.explicitWait(by);
        element.sendKeys(text, action);
        ExtendLogger.pass("Send " + text + " in " + elementName, getScreenshot);
    }


    /**
     * Get the title of current web page.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
     * @return The title.
    */
    public String getTitle() {
        return DriverManager.getDriver().getTitle();
    }


    /**
     * Get the text of the located element.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     * @param by Locator of the element.
     * @param waitStrategy The waiting mode.
     * @param elementName The name of the element that is used for logging.
     * @param getScreenshot Whether a screenshot is needed.
     * @return The text on the element.
     */
    protected String getElementText(By by, WaitStrategy waitStrategy) {
        WebElement element = waitStrategy.explicitWait(by);
        String text = element.getText();
        return text;
    }
}
