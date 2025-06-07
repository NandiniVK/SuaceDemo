package stepdefinitions;

import org.junit.Assert;

import Pages.LoginPage;
import Utils.BaseTest;
import Utils.Config;
import Utils.ExtentReportManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	LoginPage loginPage;

	@Given("The user is on the SauceDemo login page")
	public void the_user_is_on_the_saucedemo_login_page() {
		BaseTest.getDriver().get(Config.get("url"));
		ExtentReportManager.logInfo("Navigated to SauceDemo login page");
	}
	
	@When("The user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) {
		loginPage = new LoginPage();
		loginPage.login(username, password);
        ExtentReportManager.logInfo("Attempted login with username: " + username + " and password: "+password);
    }
	
	@Then("{string}")
	public void validate_expected_result(String expected) {
		if(expected.equalsIgnoreCase("The user should be redirected to the inventory page")) {
			Assert.assertTrue("User was not redirected to inventory page", loginPage.isOnInventory());
	        ExtentReportManager.logPass("Login successful. User is on inventory page.");
		}
		
		else if (expected.equalsIgnoreCase("Error message should be displayed")) {
			Assert.assertTrue("User was able to log in using invalid credentials", loginPage.isErrorMessageDisplayed());
			ExtentReportManager.logPass("Login was unsuccessful. User is still in the login page.");
		}
		
		else {
			Assert.fail("Invalid step definition");
			ExtentReportManager.logFail("Invalid step definition");
		}
	}
	
	@When("The user logs in with empty credentials")
	public void the_user_logs_in_with_empty_credentials() {
        loginPage = new LoginPage();
		loginPage.clickLogin();
		ExtentReportManager.logInfo("Attempted login with empty username and password");
	}
	
	@Then("The error message {string} should be displayed")
	public void the_error_message_should_be_displayed(String error) {
		Assert.assertEquals("Error message was not displayed", error, loginPage.getErrorMessage());
		ExtentReportManager.logPass("Error message was displayed");
	}
	
	
}
