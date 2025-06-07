package Utils;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;

	public BaseTest() {
		PageFactory.initElements(driver, this);
	}

	public void initDriver() {
		ChromeOptions options = new ChromeOptions();
		// Run in incognito
		options.addArguments("--incognito");

		// Add CI-friendly options
		options.addArguments("--headless=new"); // Use --headless=new for Chrome 109+, Remove this for local runs
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-gpu");

		String userDataDir = System.getProperty("java.io.tmpdir") + "/profile-" + System.nanoTime();
		options.addArguments("--user-data-dir=" + userDataDir);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
