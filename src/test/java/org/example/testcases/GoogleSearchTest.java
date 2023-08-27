package org.example.testcases;

import org.assertj.core.api.Assertions;
import org.example.constants.FrameworkConstants;
import org.example.listeners.Retry;
import org.example.pages.GoogleHomePage;
import org.example.utils.DataProviderUtils;
import org.example.utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoogleSearchTest extends BaseTestSettings{
    @Test()
    public void googleSearchTest(Map<String, String> map) {
        String title = new GoogleHomePage().search(map.get("searchText"))
                .getTitle();
        Assertions.assertThat(title)
                .isEqualTo(map.get("searchText") + " - Google");
    }
}
