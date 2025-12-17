package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReportManager;

public class ExtentListener implements ITestListener {
    ExtentReports extent = ExtentReportManager.getInstances();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result){
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        test.get().log(Status.INFO,"Test Started: "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        test.get().log(Status.PASS,"Test Passed: "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        test.get().log(Status.FAIL,"Test Failed: "+result.getName());
        test.get().log(Status.FAIL,result.getThrowable());

        Object testClass = result.getInstance();

        try{
            WebDriver driver = ((base.BaseTest) testClass).getDriver();

            String screenshotPath = utils.screenshotUtil.captureScreenshot(driver,result.getMethod().getMethodName());

            test.get().addScreenCaptureFromPath(screenshotPath,"Failure Screenshot");
        }catch (Exception e){
            test.get().log(Status.WARNING,"Screenshot capture failed: "+e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result){
        test.get().log(Status.SKIP,"Test Skipped: "+result.getName());
    }

    @Override
    public void onFinish(ITestContext context){
        extent.flush();
    }
}
