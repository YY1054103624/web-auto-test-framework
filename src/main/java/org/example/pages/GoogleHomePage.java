package org.example.pages;

import org.example.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Wait;

public class GoogleHomePage extends BasePage{

    By txt_search = By.xpath("//textarea[@id]");

    public GoogleSearchResultPage search(String text) {
        sendTextWithAction(txt_search, text, WaitStrategy.PRESENCE, "Search box", true, Keys.ENTER);
        return new GoogleSearchResultPage();
    }
}
