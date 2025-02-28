package com.practicetestautomation.tests;

//import java.lang.reflect.Method;
import java.time.Duration;
//import org.testng.Reporter;
import org.testng.annotations.Test;
//import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import extentReports.ExtentManager;
import extentReports.ExtentTestManager;
import com.practicetestautomation.base.BaseTest;
import com.practicetestautomation.pages.LandingPage;
import com.practicetestautomation.pages.DemoPage;
import utils.Constants;
import utils.ElementFetch;
//import org.testng.annotations.Test;
public class DemoPageTests extends BaseTest{
	ExtentSparkReporter htmlReporter;
	ExtentTest test;
//	private static final ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest logger;

	ElementFetch ele = new ElementFetch();

	@Test ()
	public void demoPageSmoke() {
		ExtentTest test = ExtentTestManager.getTest();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(Constants.landingPageUrl);
		String curUrl = driver.getCurrentUrl();
		System.out.println(curUrl);
		test.info("click Demo");
		ele.getWebElement("XPATH", LandingPage.demoButton).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  //switch To IFrame using index
		test.info("Switch to Demo modal");
        driver.switchTo().frame(0);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      //  ele.getWebElement("XPATH", DemoPage.closeButton).click();
        test.info("Enter email address");
    	ele.getWebElement("XPATH", DemoPage.emailInput).sendKeys("jjnospam68@gmail.com");
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	
        //leave frame
        driver.switchTo().defaultContent();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	ele.getWebElement("XPATH", DemoPage.closeButton).click();
        
		//ele.getWebElement("XPATH", LandingPage.signInButtonText).click();

	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//ring curUrl = driver.getCurrentUrl();
	//	System.out.println(curUrl);
		//driver.get(curUrl);
		//test.info("verify URL");
		//driver.getCurrentUrl();
		//ele.getWebElement("XPATH", LandingPage.demoButton).click();
	}	
	@Test ()
	public void demoPageSmoke2() {
		ExtentTest test = ExtentTestManager.getTest();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(Constants.landingPageUrl);
		String curUrl = driver.getCurrentUrl();
		System.out.println(curUrl);
		test.info("click Demo");
		ele.getWebElement("XPATH", LandingPage.demoButton).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  //switch To IFrame using index
		test.info("Switch to Demo modal");
        driver.switchTo().frame(0);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      //  ele.getWebElement("XPATH", DemoPage.closeButton).click();
        test.info("Enter email address");
    	ele.getWebElement("XPATH", DemoPage.emailInput).sendKeys("jjnospam68@gmail.com");
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	
        //leave frame
        driver.switchTo().defaultContent();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	ele.getWebElement("XPATH", DemoPage.closeButton).click();
        
		//ele.getWebElement("XPATH", LandingPage.signInButtonText).click();

	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//ring curUrl = driver.getCurrentUrl();
	//	System.out.println(curUrl);
		//driver.get(curUrl);
		//test.info("verify URL");
		//driver.getCurrentUrl();
		//ele.getWebElement("XPATH", LandingPage.demoButton).click();
	}	


	private void startTest(String name, String string) {
		// TODO Auto-generated method stub

	}
}

//switch To IFrame using Web Element
//WebElement iframe = driver.findElement(By.id("iframe1"));
//Switch to the frame
//driver.switchTo().frame(iframe);
//assertEquals(true, driver.getPageSource().contains("We Leave From Here"));
//Now we can type text into email field
//WebElement emailE= driver.findElement(By.id("email"));
//emailE.sendKeys("admin@selenium.dev");
//emailE.clear();
