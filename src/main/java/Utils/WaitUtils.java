package Utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private WebDriver driver;
    private static final int DEFAULT_TIMEOUT = 10;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public <T> T waitFor(ExpectedCondition<T> condition, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(condition);
    }

    public <T> T waitFor(ExpectedCondition<T> condition) {
        return waitFor(condition, DEFAULT_TIMEOUT);
    }

    // Optional: Shortcut for visibility of element located
    public WebElement waitForVisibility(WebElement element) {
        return waitFor(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf(element));
    }

    // Optional: Shortcut for element to be clickable
    public WebElement waitForClickable(WebElement locator) {
        return waitFor(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(locator));
    }
    
    public void handleAlertIfPresent(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert found: " + alert.getText());
            alert.accept(); // Clicks "OK"
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present.");
        }
    }
}

