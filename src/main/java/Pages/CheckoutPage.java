package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.BaseTest;
import Utils.WaitUtils;

public class CheckoutPage extends BaseTest {

	@FindBy(xpath = "//input[@id='first-name']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='last-name']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement txtPostalCode;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueBtn;

	WaitUtils utils = new WaitUtils(getDriver());

	public void fillCheckoutInformation(String firstName, String lastName, String zip) {
		utils.waitForVisibility(txtFirstName).sendKeys(firstName);
		utils.waitForVisibility(txtLastName).sendKeys(lastName);
		utils.waitForVisibility(txtPostalCode).sendKeys(zip);
	}

	public void continueCheckout() {
		utils.handleAlertIfPresent(getDriver());
		utils.waitForVisibility(continueBtn).click();
	}

}
