package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserDriverFactory {

    private static WebDriver driver = null;


    public static WebDriver initializeDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome" :
                driver = new ChromeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getimplicitWait()));
        return driver;
    }
    public static void quitDriver() {
        driver.quit();
    }



}
