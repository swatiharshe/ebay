package com.ebay.pages.home;

import io.appium.java_client.TouchAction;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ebapy.pages.login.SignInPage;
import com.util.WebDriverUtils;
import com.util.poi.ExcelUtils;

public class SelectedProduct {
	
	private static Logger logger = Logger.getLogger(SelectedProduct.class);

	public static void choosedProduct() throws Exception {
		
		logger.info("Entered to Select Product page");

		Map<String, String> productDetails = new HashMap<String, String>();
		WebDriverUtils.intializeDriver().findElementByXPath("//android.widget.LinearLayout[contains(@resource-id, 'list_product_linear_layout')and @index='1']").click();
		
		String productName = WebDriverUtils.intializeDriver().findElementByXPath("//android.view.View[contains(@content-desc, 'Sugarlite')and @index='0']").getText();
		
		productDetails.put("productName", productName);
		System.out.println(productName);
		
		String price = WebDriverUtils.intializeDriver().findElementByXPath("//android.view.View[contains(@content-desc,'Price:')]").getText();
		
		productDetails.put("price", price);
		System.out.println(price);
		
		ExcelUtils.addProductDetails(productDetails, 1);
		
		TouchAction action = new TouchAction(WebDriverUtils.intializeDriver());
		
	    action.press(0, 500).waitAction().moveTo(0, 600).release().perform();
	    
	    WebDriverUtils.intializeDriver().findElementByXPath("//android.widget.Button[contains(@content-desc,'Add to Cart')]").click();
	}
	
}
