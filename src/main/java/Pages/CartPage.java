package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.BaseTest;
import Utils.WaitUtils;

public class CartPage extends BaseTest {

	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkoutButton;

	WaitUtils utils = new WaitUtils(getDriver());

	public void clickCheckout() {
		utils.waitForVisibility(checkoutButton).click();
	}

}
