package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.BaseTest;
import Utils.WaitUtils;

public class OverviewPage extends BaseTest{
	
	@FindBy(xpath = "//button[@id='finish']")
	WebElement finishBtn;
	
	WaitUtils utils = new WaitUtils(getDriver());
	
	public void finishCheckout() {
        utils.waitForVisibility(finishBtn).click();
    }

}
