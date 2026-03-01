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
        String browser = ConfigReader.getBrowser();
        driver = BrowserDriverFactory.initializeDriver(browser);
        driver.get(ConfigReader.getAppUrl());
    }
    @AfterMethod
    public void teardown() {
        BrowserDriverFactory.quitDriver();
    }

}
