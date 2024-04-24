package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

//    ExtentReportNG
    ExtentReports extent=ExtentReportNG.getReport();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"");
    }

    @Override
    public void onTestFailure(ITestResult result) {
           test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // not implemented
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        // not implemented
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
