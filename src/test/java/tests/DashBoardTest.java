package tests;

import com.orangehrm.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import poc.DashBoardPage;
import poc.LoginPage;

public class DashBoardTest extends BaseTest {
    @BeforeMethod
    public void Login() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUsername("Admin");
        loginpage.enterPassword("admin123");
        DashBoardPage dashBoardPage = loginpage.clickSubmitButton();
        dashBoardPage.isDashboardHeaderDisplayed(); // waits for dashboard to fully load
    }

    @Test
    public void DashBoardTest() {
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        Assert.assertTrue(dashBoardPage.isDashboardHeaderDisplayed(), "Dashboard header is not displayed");
    }

    @Test
    public void LogoutOptionTest() {
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        LoginPage loginPage = dashBoardPage.clickLogOutButton();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
    }
}
