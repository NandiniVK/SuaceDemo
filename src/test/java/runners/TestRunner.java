package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "stepdefinitions", "Hooks" }, plugin = { "pretty", // Console
																													// output
		"html:target/cucumber-reports/html-report.html", // HTML report
		"json:target/cucumber-reports/report.json", // JSON report
		"junit:target/cucumber-reports/report.xml" // JUnit XML report
}, monochrome = true, // Clean console output
		dryRun = false, tags = "not @skip")
public class TestRunner {

}
