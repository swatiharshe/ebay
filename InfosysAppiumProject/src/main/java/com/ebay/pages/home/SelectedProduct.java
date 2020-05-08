package com.ebay.pages.home;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ebay.pages.login.SignInPage;
import com.util.SelectorProp;
import com.util.WebDriverUtils;
import com.util.poi.ExcelUtils;

/**
 * This class navigate with in cart and the selected item
 * @author Admin
 *
 */
public class SelectedProduct {
	
	private static Logger logger = Logger.getLogger(SelectedProduct.class);
	
	private static AndroidDriver driver;
	
	public SelectedProduct() throws Exception {
		driver = WebDriverUtils.intializeDriver();
	}

	/**
	 * This method choose the item and put it in to cart.
	 * @throws Exception
	 */
	public void choosedProduct() throws Exception {
		
		logger.info("Entered to Select Product page");

		Map<String, String> productDetails = new HashMap<String, String>();
		driver.findElementByXPath(SelectorProp.getSelector("select_item_from_list")).click();
		
		String productName = driver.findElementByXPath(SelectorProp.getSelector("select_item_get_name")).getText();
		
		productDetails.put("productName", productName);
		System.out.println(productName);
		
		String price = driver.findElementByXPath(SelectorProp.getSelector("select_item_get_price")).getText();
		
		productDetails.put("price", price);
		System.out.println(price);
		
		ExcelUtils.addProductDetails(productDetails, 1);
		
		TouchAction action = new TouchAction(driver);
		
	    action.press(0, 500).waitAction().moveTo(0, 600).release().perform();
	    
	    driver.findElementByXPath(SelectorProp.getSelector("add_to_cart")).click();
	}
	
}
