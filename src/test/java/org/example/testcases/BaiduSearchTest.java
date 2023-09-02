package org.example.testcases;


import com.google.common.util.concurrent.Uninterruptibles;
import org.assertj.core.api.Assertions;
import org.example.annotations.FrameworkAnnotation;
import org.example.enums.Author;
import org.example.enums.Category;
import org.example.pages.BaiduSearchPage;
import org.example.report.ExtendLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

public final class BaiduSearchTest extends BaseTestPreparationAndWindUp{
    private BaiduSearchTest() {

    }

    @FrameworkAnnotation(authors = {Author.OSCAR}, categories = {Category.REGRESSION})
    @Test
    public void baiduSearchTest(Map<String, String> map) {
        BaiduSearchPage baiduSearchPage = new BaiduSearchPage()
                .search(map.get("searchText"))
                .clickSearchButton();

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
        String title = baiduSearchPage.getTitle();
        Assertions.assertThat(title)
                .contains("Automation");
        ExtendLogger.pass("Title is " + title);
    }
}
