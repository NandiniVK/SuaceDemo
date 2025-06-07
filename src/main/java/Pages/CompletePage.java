package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.BaseTest;
import Utils.WaitUtils;

public class CompletePage extends BaseTest {

	@FindBy(xpath = "//span[@class='title']")
	WebElement header;

	WaitUtils utils = new WaitUtils(getDriver());

	public String getHeaderText() {
		return utils.waitForVisibility(header).getText();
	}

}
