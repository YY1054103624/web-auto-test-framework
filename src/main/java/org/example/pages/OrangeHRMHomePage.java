package org.example.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.example.drivers.DriverManager;
import org.example.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHRMHomePage extends BasePage{
    private final By link_username = By.xpath("//p[@class='oxd-userdropdown-name']");

    private final By link_logout = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickProfile() {
        click(link_username, WaitStrategy.CLICKABLE, "link username", true);
        return this;
    }

    public OrangeHRMLoginPage clickLogout() {
        // Use this to replace Thread.sleep(3000)
//        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));

        click(link_logout, WaitStrategy.CLICKABLE, "link logout", true);
        return new OrangeHRMLoginPage();
    }
}
