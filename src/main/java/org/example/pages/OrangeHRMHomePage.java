package org.example.pages;

import org.example.enums.LogType;
import org.example.enums.WaitStrategy;
import org.example.report.ExtendLogger;
import org.example.utils.LocatorUtils;
import org.openqa.selenium.By;

import static org.example.report.FrameworkLogger.log;

/**
 * This class represents the home page.
 * <p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public class OrangeHRMHomePage extends BasePage{
    private final By link_username = By.xpath("//p[@class='oxd-userdropdown-name']");

    private final By link_logout = By.xpath("//a[text()='Logout']");

    /**
     * Click the area of account picture.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
     * @return {@link OrangeHRMHomePage}
    */
    public OrangeHRMHomePage clickProfile() {
        click(link_username, WaitStrategy.CLICKABLE);
        log(LogType.EXTEND_PASS_AND_CONSOLE, "link username" + " is clicked successfully", true);
        return this;
    }

    private static final String DYNAMIC_XPATH = "//a/span[text()='%s']";

    /**
     * Click on logout button.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
     * @return {@link OrangeHRMLoginPage}
    */
    public OrangeHRMLoginPage clickLogout() {
        click(link_logout, WaitStrategy.CLICKABLE);
        log(LogType.EXTEND_PASS_AND_CONSOLE, "link logout" + " is clicked successfully", true);
        return new OrangeHRMLoginPage();
    }

    /**
     * Click on Admin button to Admin page.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
     * @return {@link OrangeHRMAdminPage}
    */
    public OrangeHRMAdminPage clickAdminButton() {
        String xpath = LocatorUtils.dynamicReplace(DYNAMIC_XPATH, "Admin");
        click(By.xpath(xpath), WaitStrategy.CLICKABLE);
        log(LogType.EXTEND_PASS_AND_CONSOLE, "Admin button" + " is clicked successfully", true);
        return new OrangeHRMAdminPage();
    }

    /**
     * Click on PIM button to PIM page.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
     * @return {@link OrangeHRMPIMPage}
    */
    public OrangeHRMPIMPage clickPIMButton() {
        String xpath = LocatorUtils.dynamicReplace(DYNAMIC_XPATH, "PIM");
        click(By.xpath(xpath), WaitStrategy.CLICKABLE);
        log(LogType.EXTEND_PASS_AND_CONSOLE, "PIM button" + " is clicked successfully", true);
        return new OrangeHRMPIMPage();
    }
}
