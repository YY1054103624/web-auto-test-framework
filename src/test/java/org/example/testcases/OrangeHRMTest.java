package org.example.testcases;

import org.assertj.core.api.Assertions;
import org.example.annotations.FrameworkAnnotation;
import org.example.enums.Author;
import org.example.enums.Category;
import org.example.pages.OrangeHRMLoginPage;
import org.testng.annotations.Test;

import java.util.Map;

public final class OrangeHRMTest extends BaseTestSettings{
    private OrangeHRMTest() {

    }

    @FrameworkAnnotation(authors = {Author.LEE}, categories = {Category.REGRESSION})
    @Test
    public void loginLogoutTest(Map<String, String> map) {
        String title = new OrangeHRMLoginPage().
                enterUsername(map.get("username")).enterPassword(map.get("password")).clickLogin()
                .clickProfile().clickLogout().getTitle();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @FrameworkAnnotation(authors = {Author.LEE}, categories = {Category.SMOKE})
    @Test
    public void newTest(Map<String, String> map) {
        String title = new OrangeHRMLoginPage().
                enterUsername(map.get("username")).enterPassword(map.get("password")).clickLogin()
                .clickProfile().clickLogout().getTitle();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @FrameworkAnnotation(authors = {Author.OSCAR}, categories = {Category.SMOKE, Category.REGRESSION})
    @Test
    public void enterAdminPageTest(Map<String, String> map) {
        String pageName = new OrangeHRMLoginPage().
                enterUsername(map.get("username")).enterPassword(map.get("password")).clickLogin()
                .clickAdminButton().getPageName();

        Assertions.assertThat(pageName)
                .isEqualTo("Admin");
    }

    @FrameworkAnnotation(authors = {Author.OSCAR, Author.JARRY}, categories = {Category.SMOKE, Category.MINIREGRESSION})
    @Test
    public void enterPIMPageTest(Map<String, String> map) {
        String pageName = new OrangeHRMLoginPage().
                enterUsername(map.get("username")).enterPassword(map.get("password")).clickLogin()
                .clickPIMButton().getPageName();

        Assertions.assertThat(pageName)
                .isEqualTo("PIM");
    }

}
