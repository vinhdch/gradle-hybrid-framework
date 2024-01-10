package pageObjects.swagLabs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;

public class ProductPO extends BasePage {

	WebDriver driver;

	public ProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemOnSortDropdown(String item) {
		waitForElementVisible(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, item);

	}

	public boolean isNameSortAscending() {
		// declare a product name list
		ArrayList<String> productUIList = new ArrayList<String>();

		// get all text on product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);

		// dung vong lap de get text va add vao ArrayList
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
			// show list product name
			System.out.println(productName.getText());
		}

		// tao ra 1 array list moi de sort data trong array list cu
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		// sort product sort list (ascending)
		Collections.sort(productSortList);

		// show list product after sort ascending
		for (String productName : productSortList) {
			System.out.println("product name after sort " + productName);

		}

		return productSortList.equals(productUIList);
	}

	public boolean isNameSortDescending() {
		// declare a product name list
		ArrayList<String> productUIList = new ArrayList<String>();

		// get all text on product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);

		// dung vong lap de get text va add vao ArrayList
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
			// show list product name
			System.out.println(productName.getText());
		}

		// tao ra 1 array list moi de sort data trong array list cu
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);

		}

		// sort product sort list (ascending)
		Collections.sort(productSortList);

		// revert sorting (descending)
		Collections.reverse(productSortList);

		// show list product after sort descending
		for (String productName : productSortList) {
			System.out.println("product name after sort " + productName);

		}

		return productSortList.equals(productUIList);

	}

	public boolean isPriceSortDescending() {
		// declare a product name list
		ArrayList<Float> productUIList = new ArrayList<Float>();

		// get all text on product name
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);

		// dung vong lap de get text va add vao ArrayList
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		// tao ra 1 array list moi de sort data trong array list cu
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);

		}

		// sort product sort list (ascending)
		Collections.sort(productSortList);

		// revert sorting (descending)
		Collections.reverse(productSortList);

		return productSortList.equals(productUIList);
	}

	public boolean isPriceSortAscending() {
		// declare a product name list
		ArrayList<Float> productUIList = new ArrayList<Float>();

		// get all text on product name
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);

		// dung vong lap de get text va add vao ArrayList
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		// tao ra 1 array list moi de sort data trong array list cu
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);

		}

		// sort product sort list (ascending)
		Collections.sort(productSortList);

		return productSortList.equals(productUIList);
	}
}
