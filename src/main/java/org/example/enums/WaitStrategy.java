package org.example.enums;

import org.example.constants.FrameworkConstants;
import org.example.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class all the element explicit-wait strategies.
 * <p>
* 2023/8/28
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public enum WaitStrategy {
    CLICKABLE {
        @Override
        public WebElement explicitWait(By by) {
            return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitlyDuration()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        }
    },
    PRESENCE {
        @Override
        public WebElement explicitWait(By by) {
            return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitlyDuration()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        }
    },
    VISIBLE {
        @Override
        public WebElement explicitWait(By by) {
            return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitlyDuration()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        }
    },
    NONE {
        @Override
        public WebElement explicitWait(By by) {
            return DriverManager.getDriver().findElement(by);
        }
    };

    public abstract WebElement explicitWait(By by);
}
