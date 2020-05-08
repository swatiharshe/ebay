package com.ebay.pages.home;

import io.appium.java_client.android.AndroidDriver;

import org.apache.log4j.Logger;

import com.util.ScreenshotUtils;
import com.util.SelectorProp;
import com.util.WebDriverUtils;


/**
 * This class helps to navigate from searching the product till the selection
 * @author Swati
 *
 */

public class HomePage {

	private static Logger logger = Logger.getLogger(HomePage.class);
	
	private static AndroidDriver driver;
	
	public HomePage() throws Exception {
		driver = WebDriverUtils.intializeDriver();
	}
	
	/**
	 * This method search the desired product e.g. 'sugar 2kg pantry offer'
	 * @throws Exception
	 */
	public void enterSearch() throws Exception {
		logger.info("Entered to Home page");
		ScreenshotUtils.captureScreen("Home Screen");
		driver.findElementByXPath(SelectorProp.getSelector("Home_Search_button")).click();
		driver.findElementByXPath(SelectorProp.getSelector("Home_Search_button")).sendKeys("sugar 2kg pantry offer");
		Thread.sleep(10000);		
	}
	
	
	/**
	 * This method choose the suggested option and select the first product.
	 * @throws Exception
	 */
	public void selectProduct() throws Exception {
		logger.info("Select product from suggested list");
		driver.findElementByXPath(SelectorProp.getSelector("select_suggested_option")).click();
		Thread.sleep(10000);
		driver.findElementByXPath(SelectorProp.getSelector("select_item_from_list")).click();
		Thread.sleep(10000);
		ScreenshotUtils.captureScreen("Product Screen");		
	}
}
