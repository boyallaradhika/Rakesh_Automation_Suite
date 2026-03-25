package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ElementUtil;
import utils.ExtentReportManager;

public class ListenerTest implements ITestListener {
    private static ExtentReports extentReports;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        extentReports = ExtentReportManager.setup();
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        if (extentReports == null) {
            extentReports = ExtentReportManager.setup();
        }
        ExtentTest extentTest = extentReports.createTest(result.getName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            String screenshotPath = ElementUtil.takeScreenshot(result.getTestName());
            System.out.println("Screenshot Path: " + screenshotPath);
            test.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        } finally {
            test.get().fail(result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}
