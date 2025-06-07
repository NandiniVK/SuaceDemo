package stepdefinitions;

import org.junit.Assert;

import Pages.LoginPage;
import Pages.ProductsPage;
import Utils.ExtentReportManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class productsSteps {
	
	ProductsPage productsPage = new ProductsPage();
	
	@Then("User lands on the product listing page")
	public void user_lands_on_the_product_listing_page() {
	    ExtentReportManager.logInfo("Checking whether the user is landed on the product listing page");
	    Assert.assertTrue("User is not landed on the product listing page", productsPage.isNavigatedToProductPage());
	    ExtentReportManager.logPass("user is landed on the product listing page");
	    
	}
	
	@Then("list of products is visible")
	public void list_of_products_is_visible() {
		ExtentReportManager.logInfo("Checking whether the list of product is visible");
		Assert.assertTrue("Product list is not visible", productsPage.isProductsListed());
		ExtentReportManager.logPass("Product list is visible");
	}
	
	@When("user check that sorting by Price \\(low to high)")
	public void user_check_that_sorting_by_price_low_to_high() {
	    productsPage.sortProduct("Price (low to high)");
	    ExtentReportManager.logInfo("Sorted by 'Price low to high'");
	}
	
	@Then("sorts the items correctly")
	public void sorts_the_items_correctly() {
		ExtentReportManager.logInfo("Checking whether the products are sorted by 'Price low to high'");
	    Assert.assertTrue("Products are not sorted by 'Price low to high'",productsPage.isProductsAreSortedByPrice());
	    ExtentReportManager.logPass("products are sorted by 'Price low to high'");
	}

}
