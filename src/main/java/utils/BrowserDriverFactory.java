package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BrowserDriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initializeDriver(String browser) {
        switch (browser.toLowerCase().trim()) {
            case "chrome":
                driver.set(new ChromeDriver());
                break;
            case "edge":
                driver.set(new EdgeDriver());
                break;
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
            case "safari":
                driver.set(new SafariDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getimplicitWait()));
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }




}
