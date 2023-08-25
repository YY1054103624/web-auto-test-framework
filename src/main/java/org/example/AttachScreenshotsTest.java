package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.net.InetAddresses;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class AttachScreenshotsTest {
    WebDriver driver;
    @Test
    public void attachScreenshotsTest() throws IOException {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        spark.loadXMLConfig(new File("src/test/resources/config/reportsettings.xml"));
        extent.attachReporter(spark);

        ExtentTest test = extent.createTest("First test");
        driver = new ChromeDriver();
        test.pass("Open browser");

        driver.get("https://www.google.com");
        test.pass("Open google search");

        driver.findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
        test.pass("Search Automation", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());

        driver.quit();

        extent.flush();
        Desktop.getDesktop().browse(new File("index.html").toURI());
    }

    public String getScreenshotPath() throws IOException {
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String imagePath = "Screenshot/image.png";
        FileUtils.copyFile(source, new File(imagePath));
        return imagePath;
    }

    public String getScreenshotBase64() throws IOException {
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String imagePath = "Screenshot/image.png";
        FileUtils.copyFile(source, new File(imagePath));
        byte[] bytes = IOUtils.toByteArray(new FileInputStream(imagePath));
        return Base64.getEncoder().encodeToString(bytes);
    }

    public String getBase64() {
       return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    }
}
