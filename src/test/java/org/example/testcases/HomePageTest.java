package org.example.testcases;

import org.assertj.core.api.Assertions;
import org.example.drivers.Driver;
import org.example.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public final class HomePageTest extends BaseTestSettings{
    private HomePageTest() {

    }

    @Test
    public void test1() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - Youtube", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();
        Assertions.assertThat(title)
                .as("Object is actual null").isNotNull()
                        .hasSizeBetween(15, 100)
                                .contains("Google 搜索");


        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3"));
        Assert.assertEquals(elements.size(), 9);


        Assertions.assertThat(elements)
                .hasSize(9)
                .extracting(WebElement::getText)
                .contains("Testing Mini Bytes");
    }
}
