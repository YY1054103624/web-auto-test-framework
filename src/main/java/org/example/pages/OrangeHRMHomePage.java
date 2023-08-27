package org.example.pages;

import org.example.enums.WaitStrategy;
import org.example.utils.LocatorUtils;
import org.openqa.selenium.By;

public class OrangeHRMHomePage extends BasePage{
    private final By link_username = By.xpath("//p[@class='oxd-userdropdown-name']");

    private final By link_logout = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickProfile() {
        click(link_username, WaitStrategy.CLICKABLE, "link username", true);
        return this;
    }

    private final String dynamicXpath = "//a/span[text()='%s']";
    public OrangeHRMLoginPage clickLogout() {
        // Use this to replace Thread.sleep(3000)
//        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));

        click(link_logout, WaitStrategy.CLICKABLE, "link logout", true);
        return new OrangeHRMLoginPage();
    }

    public OrangeHRMAdminPage clickAdminButton() {
        String xpath = LocatorUtils.dynamicReplace(dynamicXpath, "Admin");
        click(By.xpath(xpath), WaitStrategy.CLICKABLE, "Admin button", true);
        return new OrangeHRMAdminPage();
    }

    public OrangeHRMPIMPage clickPIMButton() {
        String xpath = LocatorUtils.dynamicReplace(dynamicXpath, "PIM");
        click(By.xpath(xpath), WaitStrategy.CLICKABLE, "PIM button", false);
        return new OrangeHRMPIMPage();
    }
}
