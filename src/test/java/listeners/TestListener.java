package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import extentReports.ExtentManager;
//import extentReports.ExtentManager6;
import extentReports.ExtentTestManager;
import com.practicetestautomation.base.BaseTest;
import utils.Constants;
//import utils.DriverFactoryThreadLocal;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;
/*
Listener is defined as interface that modifies the default TestNG's behavior.
As the name suggests Listeners 'listen' to the event defined in the selenium script and behave accordingly.
 It is used in selenium by implementing Listeners Interface.
  It allows customizing TestNG reports or logs.

  This class is called in testng.xml file before @test tags
 */

public class TestListener extends BaseTest implements ITestListener, IInvokedMethodListener, IReporter {
	private static final ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest logger;
	public WebDriver getDriver() {
		return driver;
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {


	}
	//OnStart method is called when any Test starts.
	@Override
	public void onStart(ITestContext context) {

		System.out.println(String.format("*** Test Suite %s started ***", context.getName()));
	}
	//onFinish method is called after all Tests are executed.
	@Override
	public void onFinish(ITestContext context) {
		System.out.println(String.format("*** Test Suite %s ending ***", context.getName()));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
		//driver.quit();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(String.format("*** Running test method %s...", result.getMethod().getMethodName()));
		ExtentTestManager.startTest(result.getMethod().getMethodName() + "<br/>" + (result.getMethod().getDescription()));

	}
	
	//onTestSuccess method is called on the success of any Test.
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(String.format("*** Executed %s test successfully...", result.getMethod().getMethodName()));
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		driver.close();
	}
	//onTestFailure method is called on the failure of any Test.
	@Override
	public void onTestFailure(ITestResult result) {
		//ExtentTestManager.getTest().log(Status.FAIL, "Test failed");
		ITestContext context = result.getTestContext();
		driver = (WebDriver) context.getAttribute("WebDriver");
		//TakesScreenshot takesScreenshot = ((TakesScreenshot) DriverFactoryThreadLocal.getInstance().getDriver());
		//String destination = takesScreenshot.getScreenshotAs(OutputType.BASE64);
		System.out.println(String.format("*** Executed %s test unsuccessful...", result.getMethod().getMethodName()));

	//	ExtentTestManager.getTest().addScreenCaptureFromPath(String.format("data:image/jpg;base64, %s", destination));
		ExtentTestManager.getTest().log(Status.FAIL, String.format("%s FAIL with error %s", result.getName(), result.getThrowable(), ExtentColor.BROWN));
	}

	/*
	 * @AfterMethod public void afterMethod(ITestResult result) {
	 * if(result.getStatus() == ITestResult.FAILURE) { logger.log(Status.FAIL,
	 * MarkupHelper.createLabel(result.getName() + " - test case Failed",
	 * ExtentColor.RED)); logger.log(Status.FAIL,
	 * MarkupHelper.createLabel(result.getThrowable() + " - test case Failed",
	 * ExtentColor.RED)); } else if(result.getStatus() == ITestResult.SKIP) {
	 * logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() +
	 * " - test case Skipped", ExtentColor.ORANGE)); } else if(result.getStatus() ==
	 * ITestResult.SUCCESS) { logger.log(Status.PASS,
	 * MarkupHelper.createLabel(result.getName() + " - test case Passed",
	 * ExtentColor.GREEN)); } }
	 */
	
	//onTestSkipped method is called on skipped of any Test.
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTest test = extent.createTest(result.getName());
		test.skip(MarkupHelper.createLabel(String.format("%s - Test Case Skipped", result.getName()), ExtentColor.YELLOW));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(String.format("*** Test failed but within percentage %% %s", result.getMethod().getMethodName()));
	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		System.out.println("Generate Report");
		//SendReport.execute();
	}
}