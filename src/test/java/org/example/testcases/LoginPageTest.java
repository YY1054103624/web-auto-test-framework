package org.example.testcases;

import org.example.drivers.Driver;
import org.example.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public final class LoginPageTest extends BaseTestSettings{
    private LoginPageTest() {

    }

    @Test
    public void test1() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
    }

    @Test
    public void test2() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Oscar", Keys.ENTER);
    }
}
