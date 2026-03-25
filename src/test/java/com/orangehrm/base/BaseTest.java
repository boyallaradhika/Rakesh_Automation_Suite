package com.orangehrm.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserDriverFactory;
import utils.ConfigReader;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        String browser = System.getProperty("browser") != null
                ? System.getProperty("browser")
                : ConfigReader.getBrowser();
        System.out.println(">>> Running tests on browser: " + browser);
        driver = BrowserDriverFactory.initializeDriver(browser);
        driver.get(ConfigReader.getAppUrl());
    }
    @AfterMethod
    public void teardown() {
        BrowserDriverFactory.quitDriver();
    }

}
