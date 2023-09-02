package org.example.pages;

import org.example.enums.LogType;
import org.example.enums.WaitStrategy;
import org.example.report.ExtendLogger;
import org.example.utils.DecodeUtils;
import org.openqa.selenium.By;

import static org.example.report.FrameworkLogger.log;

/**
 * This class represents the login page.
 * <p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public final class OrangeHRMLoginPage extends BasePage{
    private final By txt_username = By.xpath("//input[@name='username']");

    private final By txt_password = By.xpath("//input[@name='password']");

    private final By btn_login = By.xpath("//button[@type='submit']");

    /**
     * Input username.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @since 1.0
     * @return {@link OrangeHRMLoginPage}
    */
    public OrangeHRMLoginPage enterUsername(String username) {
        sendText(txt_username, username, WaitStrategy.PRESENCE);
        log(LogType.EXTEND_PASS_AND_CONSOLE, "Send " + username + " in " + "username box", true);
        return this;
    }


    /**
     * Input password.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @since 1.0
     * @return {@link OrangeHRMLoginPage}
     */
    public OrangeHRMLoginPage enterPassword(String password) {
        sendText(txt_password, DecodeUtils.getDecodedString(password), WaitStrategy.PRESENCE);
        log(LogType.EXTEND_PASS_AND_CONSOLE, "Send " + password + " in " + "username box", true);
        return this;
    }

    /**
     * Click on login button
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @since 1.0
     * @return {@link OrangeHRMHomePage}
    */
    public OrangeHRMHomePage clickLogin() {
        click(btn_login, WaitStrategy.NONE);
        log(LogType.EXTEND_PASS_AND_CONSOLE, "login button" + " is clicked successfully", true);
        return new OrangeHRMHomePage();
    }

}
