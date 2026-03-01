package poc;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name="password")
    private WebElement passwordField;

    @FindBy(xpath="//button[@type ='submit']")
    private WebElement submitButtonElement;

    @FindBy(xpath="//p[contains(@class,'oxd-alert-content-text')]")
    private WebElement errorElement;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
         usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        submitButtonElement.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorElement.isDisplayed();
    }
    public String getErrormessage() {
        return errorElement.getText();
    }



}
