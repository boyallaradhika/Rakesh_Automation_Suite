package poc;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name="password")
    private WebElement passwordField;

    @FindBy(xpath="//button[@type ='submit']")
    private WebElement submitButtonElement;

    @FindBy(xpath="//p[contains(@class,'oxd-alert-content-text')]")
    private WebElement errorElement;

    @FindBy(xpath = "//h5[text()='Login']")
    private WebElement loginHeader;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
         usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public DashBoardPage clickSubmitButton() {
        submitButtonElement.click();
        return new DashBoardPage(driver);
    }
    public boolean isErrorMessageDisplayed() {
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(@class,'oxd-alert-content-text')]")));*/
        return errorElement.isDisplayed();
    }

    public String getErrormessage() {
        return errorElement.getText();
    }
    public boolean isLoginPageDisplayed() {
        return loginHeader.isDisplayed();
    }




}
