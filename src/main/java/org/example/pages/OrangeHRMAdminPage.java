package org.example.pages;

import org.example.enums.WaitStrategy;
import org.openqa.selenium.By;

public class OrangeHRMAdminPage extends BasePage {
    By label_page_name = By.xpath("//h6[text()='Admin']");

    public String getPageName() {
        return getElementText(label_page_name, WaitStrategy.VISIBLE, "Page name", false);
    }
}
