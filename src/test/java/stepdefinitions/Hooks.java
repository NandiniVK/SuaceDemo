package stepdefinitions;

import Utils.Config;
import Utils.ExtentReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Utils.BaseTest;

public class Hooks extends BaseTest {

	@Before
	public void setUp(Scenario scenario) {
		initDriver();
		Config.init();
		ExtentReportManager.initReport();
		ExtentReportManager.startTest(scenario.getName());
		
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) getDriver();
			File src = ts.getScreenshotAs(OutputType.FILE);
			String screenshotPath = "target/screenshots/" + scenario.getName() + ".png";
			try {
				FileUtils.copyFile(src, new File(screenshotPath));
				ExtentReportManager.logFail("Scenario Failed");
				ExtentReportManager.attachScreenshot(screenshotPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		else {
			ExtentReportManager.logPass("Scenario Passed");
		}
		quitDriver();
		ExtentReportManager.flush();
	}

}
