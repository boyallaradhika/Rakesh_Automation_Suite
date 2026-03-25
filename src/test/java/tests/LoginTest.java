package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.orangehrm.base.BaseTest;
import listeners.Retry;
import models.testdata.LoginTestData;

import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;
import poc.DashBoardPage;
import poc.LoginPage;
import utils.JsonUtil;

import java.util.Map;

public class LoginTest extends BaseTest {

    public static Map<String, LoginTestData> testDataFromJson;
    static {
        try {
            testDataFromJson = JsonUtil.getJsonData("testdata/LoginPageTestData.json", new TypeReference<Map<String, LoginTestData>>() {});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test(testName = "Invalid test",retryAnalyzer = Retry.class)
    public void invalidLoginTest() {
        LoginTestData tc02 = JsonUtil.getTestDataFromList(testDataFromJson, "tc02");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUsername(tc02.getUsername());
        loginpage.enterPassword(tc02.getPassword());
        loginpage.clickSubmitButton();
        Assert.assertTrue(loginpage.isErrorMessageDisplayed(), "error message is not displayed");
        Assert.assertEquals(loginpage.getErrormessage(),"Invalid credentials", "Error message is incorrect");
    }

    @Test(testName = "validTest")
    public void validLoginTest() {
        LoginTestData tc01 = JsonUtil.getTestDataFromList(testDataFromJson, "tc01");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUsername(tc01.getUsername());
        loginpage.enterPassword(tc01.getPassword());
        DashBoardPage dashBoardPage = loginpage.clickSubmitButton();
        Assert.assertTrue(dashBoardPage.isDashboardHeaderDisplayed(), "Dashboard header is not displayed");
    }


}
