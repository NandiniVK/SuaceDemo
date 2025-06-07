package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.BaseTest;
import Utils.WaitUtils;

public class LoginPage extends BaseTest {

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement txtUsername;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginBtn;
	
	WaitUtils utils = new WaitUtils(getDriver());

	public void login(String username, String password) {
		utils.waitForVisibility(txtUsername).sendKeys(username);
		utils.waitForVisibility(txtPassword).sendKeys(password);
		utils.waitForVisibility(loginBtn).click();
	}
	
	public boolean isOnInventory() {
		return getDriver().getCurrentUrl().contains("inventory");
	}
	
	public boolean isErrorMessageDisplayed() {
		List<WebElement> errorMessages = getDriver().findElements(By.xpath("//input[@class='input_error form_input error']"));
		return errorMessages.size()>0;
	}
	
	public String getErrorMessage() {
		WebElement error = getDriver().findElement(By.xpath("//h3[@data-test='error']"));
		String error_message = utils.waitForVisibility(error).getText();
		return error_message;
	}
	
	public void clickLogin() {
		utils.waitForVisibility(loginBtn).click();
	}
}
