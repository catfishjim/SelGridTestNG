package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.practicetestautomation.base.BaseTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager extends BaseTest {

   static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
   static ExtentReports extent = ExtentManager.getInstance();

   public static synchronized ExtentTest getTest() {
       System.out.println(Thread.currentThread().getId());
       return extentTestMap.get((int) Thread.currentThread().getId());
   }

   public static synchronized void endTest() {
       extent.flush();
   }

   public static synchronized ExtentTest startTest(String testName) {
       ExtentTest test = extent.createTest(testName);
       extentTestMap.put((int) Thread.currentThread().getId(), test);
       return test;
   }
}