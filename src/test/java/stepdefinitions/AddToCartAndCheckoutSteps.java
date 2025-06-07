package stepdefinitions;

import org.junit.Assert;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.CompletePage;
import Pages.OverviewPage;
import Pages.ProductsPage;
import Utils.ExtentReportManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartAndCheckoutSteps {

	ProductsPage productsPage = new ProductsPage();
	CartPage cartPage = new CartPage();
	CheckoutPage checkoutPage = new CheckoutPage();
	OverviewPage overviewPage = new OverviewPage();
	CompletePage completePage = new CompletePage();

	@When("the user adds two products to the cart")
	public void user_adds_products() {
		ExtentReportManager.logInfo("Adding two products to cart");
		productsPage.addProductByIndex(0);
		productsPage.addProductByIndex(1);
		productsPage.goToCart();
	}

	@When("the user proceeds to the checkout page")
	public void user_proceeds_to_checkout() {
		ExtentReportManager.logInfo("User moves to checkout page");
		cartPage.clickCheckout();
	}

	@When("the user fills in checkout information with {string}, {string}, and {string}")
	public void user_fills_checkout_info(String firstName, String lastName, String zip) {
		checkoutPage.fillCheckoutInformation(firstName, lastName, zip);
		checkoutPage.continueCheckout();
	}

	@When("the user confirms the checkout")
	public void user_confirms_checkout() {
		overviewPage.finishCheckout();
	}

	@Then("the user should see the {string} page")
	public void user_should_see_complete_page(String expectedHeader) {
		String actualHeader = completePage.getHeaderText();
		Assert.assertEquals(expectedHeader, actualHeader);
	}

}
