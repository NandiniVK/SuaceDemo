package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	public static void initReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
		spark.config().setDocumentTitle("Automation Test Report");
		spark.config().setReportName("BDD Test Results");
		spark.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);


		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Author", "Nandini VK");
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
	}
	
	public static void startTest(String scenarioName) {
		ExtentTest extentTest = extent.createTest(scenarioName);
		test.set(extentTest);
	}
	
	public static void logInfo(String message) {
        test.get().info(message);
    }
	
	public static void logPass(String message) {
        test.get().pass(message);
    }

    public static void logFail(String message) {
        test.get().fail(message);
    }
    
    public static void attachScreenshot(String screenshotPath) {
        try {
            test.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            test.get().warning("Could not attach screenshot");
        }
    }

    public static void flush() {
        extent.flush();
    }
}
