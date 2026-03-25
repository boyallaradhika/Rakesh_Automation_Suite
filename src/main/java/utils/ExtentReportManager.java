package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {
    public static ExtentReports setup() {
    String reportPath = ConfigReader.getReportPath();
    String reportName = ConfigReader.getReportName();
        File reportDir = new File(reportPath);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }
    String path = reportPath + reportName;

    ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
    ExtentReports extentReports = new ExtentReports();
    sparkReporter.config().setTheme(Theme.STANDARD);
    sparkReporter.config().setDocumentTitle("Automation-TestResults");
    sparkReporter.config().setReportName("Orange-HRM-TestResults");

    extentReports.attachReporter(sparkReporter);
    extentReports.setSystemInfo("Tester","Radhika");
    extentReports.setSystemInfo("browser",ConfigReader.getBrowser());
    return extentReports;

    }
}
