package org.example.testcases;

import com.google.common.util.concurrent.Uninterruptibles;
import org.assertj.core.api.Assertions;
import org.example.pages.OrangeHRMLoginPage;
import org.example.report.ExtendReport;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public final class OrangeHRMTest extends BaseTestSettings{
    private OrangeHRMTest() {

    }

    @Test(dataProvider = "loginDataProvider")
    public void loginLogoutTest(String username, String password) {
        String title = new OrangeHRMLoginPage().
                enterUsername(username).enterPassword(password).clickLogin()
                .clickProfile().clickLogout().getTitle();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @Test(dataProvider = "loginDataProvider")
    public void newTest(String username, String password) {
        String title = new OrangeHRMLoginPage().
                enterUsername(username).enterPassword(password).clickLogin()
                .clickProfile().clickLogout().getTitle();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @DataProvider(name = "loginDataProvider", parallel = true)
    public Object[][] getData() {
        return new Object[][] {
                {"Admin", "admin123"}
//                {"Admin123", "Admin123admin"}
//                {"Admin", "admin123"}
//                {"Admin123", "admin"}
        };
    }
}
