package org.example.pages;

import org.example.enums.WaitStrategy;
import org.example.utils.DecodeUtils;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage{
    private final By txt_username = By.xpath("//input[@name='username']");

    private final By txt_password = By.xpath("//input[@name='password']");

    private final By btn_login = By.xpath("//button[@type='submit']");

    public OrangeHRMLoginPage enterUsername(String username) {
        sendText(txt_username, username, WaitStrategy.PRESENCE, "username box", true);
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        sendText(txt_password, DecodeUtils.getDecodedString(password), WaitStrategy.PRESENCE, "password box", true);
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
        click(btn_login, WaitStrategy.NONE, "login button", true);
        return new OrangeHRMHomePage();
    }

}
