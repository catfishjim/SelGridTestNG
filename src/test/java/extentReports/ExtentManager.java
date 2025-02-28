package extentReports;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import pages.ConfigurationReader;


import java.io.File;
import java.nio.charset.StandardCharsets;

/*
Extent Manager class is used to generate an HTML report on the user-specified path.
It is required to start and attach reporters to ExtentManager class in order to successfully generate test information.
 */

public class ExtentManager {

    public static final String TIME_STAMP_FORMAT = "EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'";
    private static final String REPORT_FILE_NAME = "Test-Automation-Report";
    private static final String REPORT_FILEPATH = System.getProperty("user.home") + File.separator + "TestReport";
    private static final String REPORT_FILE_LOCATION = REPORT_FILEPATH + File.separator + REPORT_FILE_NAME + ".html";
    private static ExtentReports extent;
    public ExtentSparkReporter sparkReporter;
    public static ExtentReports getInstance() {
        if (null == extent) {
            createInstance();
        }
        return extent;
    }
    
    public static ExtentReports createInstance() {
        String fileName = getReportPath(REPORT_FILEPATH);
// initialize the HtmlReporter
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        ExtentSparkReporterConfig config = htmlReporter.config();
        config.setTheme(Theme.STANDARD);
        config.setDocumentTitle(REPORT_FILE_NAME + ".html");
        config.setEncoding(StandardCharsets.UTF_8.toString());
        config.setReportName(REPORT_FILE_NAME + " :: " + "chrome");
        config.setTimeStampFormat(TIME_STAMP_FORMAT);

// initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Environment", "QA");
        return extent;
    }
/*
below method checks if report directory exists or not else creates a new directory for report.
 */
    private static String getReportPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println(String.format("Directory created: %s", path));

                return REPORT_FILE_LOCATION;
            } else {
                System.out.println(String.format("Failed to create directory: %s", path));

                return System.getProperty("user.home");
            }
        } else {
            System.out.println(String.format("Directory already exists: %s", path));
        }

        return REPORT_FILE_LOCATION;
    }
}