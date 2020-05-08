package com.ebay.pages.home;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.util.SelectorProp;
import com.util.WebDriverUtils;
import com.util.poi.ExcelUtils;

/**
 * This class handles actions over add to cart screen
 * 
 * @author Swati
 * 
 */
public class AddToCart {

	private static Logger logger = Logger.getLogger(AddToCart.class);

	private static AndroidDriver driver;

	public AddToCart() throws Exception {
		driver = WebDriverUtils.intializeDriver();
	}

	/**
	 * This method will identify the added item in the cart and fetch the name and price of the item
	 * @throws MalformedURLException
	 */
	
	public void pushToCart() throws MalformedURLException {

		logger.info("Entered to add to cart page");
		Map<String, String> productDetails = new HashMap<String, String>();

		driver.findElementByXPath(SelectorProp.getSelector("add_to_cart_click_cart"))
				.click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		TouchAction action = new TouchAction(driver);

		action.press(0, 500).waitAction().moveTo(0, 300).release().perform();

		String productName = driver
				.findElementByXPath(SelectorProp.getSelector("selected_item_get_name"))
				.getText();
		productDetails.put("productName", productName);

		String price = driver.findElementByXPath(SelectorProp.getSelector("selected_item_get_price"))
				.getText();

		productDetails.put("price", price);

		ExcelUtils.addProductDetails(productDetails, 2);

	}

}
