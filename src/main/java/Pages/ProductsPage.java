package Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Utils.BaseTest;
import Utils.WaitUtils;

public class ProductsPage extends BaseTest {

	@FindBy(xpath = "//div[@class='inventory_item_description']")
	List<WebElement> products;
	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement sort;
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	List<WebElement> itemPrices;

	public boolean isProductsListed() {
		boolean isListed = false;
		if (products.size() > 0 && isNavigatedToProductPage()) {
			isListed = true;
		}
		return isListed;

	}

	public boolean isNavigatedToProductPage() {
		boolean isNavigated = getDriver().getCurrentUrl().contains("inventory") ? true : false;
		return isNavigated;

	}

	public void sortProduct(String condition) {
		Select sortSelect = new Select(sort);
		sortSelect.selectByVisibleText(condition);
	}

	public List<Double> getPricesBeforeSort() {
		List<Double> pricesBeforeSort = new ArrayList<Double>();
		for (WebElement element : itemPrices) {
			String text = element.getText().replace("$", "").trim();
			pricesBeforeSort.add(Double.parseDouble(text));
		}
		return getPricesBeforeSort();

	}

	public boolean isProductsAreSortedByPrice() {
		List<WebElement> pricesAfterSort = getDriver().findElements(By.xpath("//div[@class='inventory_item_price']"));
		List<Double> prices = new ArrayList<Double>();
		for (WebElement element : pricesAfterSort) {
			String text = element.getText().replace("$", "").trim();
			prices.add(Double.parseDouble(text));
		}
		List<Double> sortedPrices = new ArrayList<>(prices);
		Collections.sort(sortedPrices);
		return sortedPrices.equals(prices);

	}
	
	public void addProductByIndex(int index) {
		getDriver().findElements(By.className("btn_inventory")).get(index).click();
       
    }
	
	public void goToCart() {
        getDriver().findElement(By.className("shopping_cart_link")).click();
    }

}
