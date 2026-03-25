package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ElementUtil {
    private WebDriver driver;

    public  ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public static String takeScreenshot ( String testName) {
        WebDriver driver = BrowserDriverFactory.getDriver();
        String screenshotPath = ConfigReader.getProperty("screenshot.path") + "failed" + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
         File source = ts.getScreenshotAs(OutputType.FILE);
         File dest = new File(screenshotPath);
         try {
             FileUtils.copyFile(source,dest);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
        return screenshotPath;
    }

}
