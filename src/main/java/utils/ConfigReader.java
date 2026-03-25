package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties;
    private static final String CONFIG_FILE_PATH = "src/main/resources/config/config.properties";

    static {
        try {
            FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH);
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static String getAppUrl() {
        return properties.getProperty("app.url");
    }
    public static int getimplicitWait() {
        return Integer.parseInt(properties.getProperty("implicit.wait"));
    }
    public static String getReportPath() {
        return properties.getProperty("extent.report.path");
    }
    public static String getReportName() {
        return properties.getProperty("extent.report.name");
    }

}
