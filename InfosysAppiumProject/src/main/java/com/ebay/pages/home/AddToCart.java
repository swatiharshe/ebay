package com.ebay.pages.home;

import io.appium.java_client.TouchAction;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.util.WebDriverUtils;
import com.util.poi.ExcelUtils;

public class AddToCart {
	
	private static Logger logger = Logger.getLogger(AddToCart.class);

	
	public static void addToCart() throws MalformedURLException{
		
		logger.info("Entered to add to cart page");
		Map<String, String> productDetails = new HashMap<String, String>();
		
		WebDriverUtils.intializeDriver().findElementByXPath("//android.widget.ImageView[contains(@content-desc,'Cart')]").click();
		WebDriverUtils.intializeDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		TouchAction action = new TouchAction(WebDriverUtils.intializeDriver());
		
	    action.press(0, 500).waitAction().moveTo(0, 300).release().perform();
	    
        String productName = WebDriverUtils.intializeDriver().findElementByXPath("//android.view.View[contains(@content-desc,'Dhampure White Crystal Sugar')]").getText();
        productDetails.put("productName", productName);
        
        String price = WebDriverUtils.intializeDriver().findElementByXPath("//android.view.View[contains(@content-desc,'Price:')]").getText();
		
		productDetails.put("price", price);
        
		ExcelUtils.addProductDetails(productDetails, 2);
		
		
	}

}
