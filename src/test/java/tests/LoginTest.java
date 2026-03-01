package tests;

import com.orangehrm.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import poc.LoginPage;
import utils.BrowserDriverFactory;
import utils.ConfigReader;
import utils.JsonUtil;

public class LoginTest extends BaseTest {

    @Test
    public void loginTestFirst()
    {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUsername(JsonUtil.getloginTestData().getValidUsername());
        loginpage.enterPassword(JsonUtil.getloginTestData().getInvalidPassword());
        //System.out.println("username from Json:" + JsonUtil.getloginTestData().getValidUsername());
        loginpage.clickSubmitButton();
        Assert.assertTrue(loginpage.isErrorMessageDisplayed(), "error message is not displayed");
        Assert.assertEquals(loginpage.getErrormessage(),"Invalid credentials", "Error message is incorrect");

    }


}
