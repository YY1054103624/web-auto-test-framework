package org.example.pages;

import org.example.enums.WaitStrategy;
import org.openqa.selenium.By;

public class BaiduSearchPage extends BasePage{
    By box_search = By.id("kw");
    By btn_search = By.id("su");

    public BaiduSearchPage search(String text) {
        sendText(box_search, text, WaitStrategy.PRESENCE);
        return this;
    }

    public BaiduSearchPage clickSearchButton() {
        click(btn_search, WaitStrategy.CLICKABLE);
        return this;
    }
}
