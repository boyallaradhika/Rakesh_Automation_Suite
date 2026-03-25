package poc;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashBoardPage extends BasePage {

    @FindBy(xpath = "//h6[contains(normalize-space(),'Dashboard')]")
    private WebElement dashboardHeader;

    @FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
    private WebElement userDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement LogoutButton;

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardHeaderDisplayed() {
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h6[contains(text(),'Dashboard')]")
        ));*/
        return dashboardHeader.isDisplayed();
    }

    public DashBoardPage clickDropDown() {
        userDropdown.click();
        return this;
    }

    public LoginPage clickLogOutButton() {
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(userDropdown));*/
        userDropdown.click();
        LogoutButton.click();
        return new LoginPage(driver);
    }
}
