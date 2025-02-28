package listeners;

import com.aventstack.extentreports.Status;
import extentReports.ExtentTestManager;
import com.practicetestautomation.base.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.IOException;
/*
Retry class is used for failed tests to retry again.
 */

public class Retry implements IRetryAnalyzer {

    private static final int maxTry = 1; //Run the failed test 2 times
    private int count = 1;

    @Override
    public boolean retry(ITestResult testResult) {

        if (!testResult.isSuccess()) { //Check if test not succeed
            if (testResult.getThrowable().toString()
                    .contains("TimeoutException")) // Checking for specific reasons of failure
                if (count < maxTry) {                            //Check if maxTry count is reached
                    count++;      //Increase the maxTry count by 1
                    testResult.setStatus(ITestResult.FAILURE);  //Mark test as failed and take base64Screenshot
                    try {
                        extendReportsFailOperations(testResult);  //ExtentReports fail operations
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return true;   //Tells TestNG to re-run the test
                } else {
                    testResult.setStatus(ITestResult.FAILURE); //If  count  reached,test marked as failed
                }
        } else {
            testResult.setStatus(ITestResult.SUCCESS); //If test passes, TestNG marks it as passed
        }
        return false;
    }

    public void extendReportsFailOperations(ITestResult testResult) throws IOException {
        Object testClass = testResult.getInstance();
       // WebDriver webDriver = ((BaseTest) testClass).getDriver();
       // String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(Status.SKIP, "Test Failed in First attempt ");
       // ExtentTestManager.getTest().addScreenCaptureFromPath(base64Screenshot);
    }
}