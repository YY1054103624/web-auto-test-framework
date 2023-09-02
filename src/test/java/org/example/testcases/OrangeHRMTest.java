package org.example.testcases;

import org.assertj.core.api.Assertions;
import org.example.annotations.FrameworkAnnotation;
import org.example.enums.Author;
import org.example.enums.Category;
import org.example.pages.OrangeHRMLoginPage;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * This class is for testing OrangeHRM system
 * <p>
* 2023/8/27
* @author Yong Yang
* @version 1.0
* @since 1.0
*/
public final class OrangeHRMTest extends BaseTestPreparationAndWindUp {
    private OrangeHRMTest() {

    }

    /**
     * Test whether user is able to login and logout the system.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
    */
    @FrameworkAnnotation(authors = {Author.LEE}, categories = {Category.REGRESSION})
    @Test
    public void loginLogoutTest(Map<String, String> map) {
        String title = new OrangeHRMLoginPage().
                enterUsername(map.get("username")).enterPassword(map.get("password")).clickLogin()
                .clickProfile().clickLogout().getTitle();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }


    /**
     * Test whether user is able to enter Admin page.
     * <p>
    * 2023/8/27
    * @author Yong Yang
    * @version 1.0
    * @since 1.0
    */
    @FrameworkAnnotation(authors = {Author.OSCAR}, categories = {Category.SMOKE, Category.REGRESSION})
    @Test
    public void enterAdminPageTest(Map<String, String> map) {
        String pageName = new OrangeHRMLoginPage().
                enterUsername(map.get("username")).enterPassword(map.get("password")).clickLogin()
                .clickAdminButton().getPageName("Admin");

        Assertions.assertThat(pageName)
                .isEqualTo("Admin");
    }

    /**
     * Test whether user is able to enter PIM page.
     * <p>
     * 2023/8/27
     * @author Yong Yang
     * @version 1.0
     * @since 1.0
     */
    @FrameworkAnnotation(authors = {Author.OSCAR, Author.JARRY}, categories = {Category.SMOKE, Category.MINIREGRESSION})
    @Test
    public void enterPIMPageTest(Map<String, String> map) {
        String pageName = new OrangeHRMLoginPage().
                enterUsername(map.get("username")).enterPassword(map.get("password")).clickLogin()
                .clickPIMButton().getPageName("PIM");

        Assertions.assertThat(pageName)
                .isEqualTo("PIM");
    }

}
