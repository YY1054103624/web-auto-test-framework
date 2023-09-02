package org.example.pages;

import org.example.enums.LogType;
import org.example.enums.WaitStrategy;
import org.example.report.ExtendLogger;
import org.example.utils.LocatorUtils;
import org.openqa.selenium.By;

import static org.example.report.FrameworkLogger.log;

/**
 * This class represents common page for all the functional pages.
 * <p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public class OrangeHRMCommonFunctionalPage extends BasePage{
    private static final String PAGE_NAME_XPATH = "//h6[text()='%s']";

    /**
     * The
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     */
    public String getPageName(String pageNameText) {
        String text = getElementText(By.xpath(LocatorUtils.dynamicReplace(PAGE_NAME_XPATH, pageNameText)), WaitStrategy.VISIBLE);
        ExtendLogger.pass("Get " + text + " from " + "Page name", true);
        log(LogType.CONSOLE, "Get " + text + " from " + "Page name", true);
        return text;
    }
}
