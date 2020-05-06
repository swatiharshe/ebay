package com.ebay.pages.home;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;

import io.appium.java_client.TouchAction;

import com.ebapy.pages.login.SignInPage;
import com.ebapy.pages.login.WelcomePage;
import com.util.WebDriverUtils;

public class HomePage {

	private static Logger logger = Logger.getLogger(HomePage.class);
	
	public static void enterSearch() throws Exception {
		logger.info("Entered to Home page");
		WelcomePage.getScreenshot("Home Screen");
		WebDriverUtils.intializeDriver().findElementByXPath("//android.widget.EditText[@text='Search']").click();
		WebDriverUtils.intializeDriver().findElementByXPath("//android.widget.EditText[@text='Search']").sendKeys("sugar 2kg pantry offer");
		Thread.sleep(10000);
		
		
		
		
	}
	
	public static void selectProduct() throws Exception {
		
		WebDriverUtils.intializeDriver().findElementByXPath("//android.widget.LinearLayout[contains(@resource-id, 'iss_search_dropdown_item_suggestions')and @index='0']").click();
		Thread.sleep(10000);
		WebDriverUtils.intializeDriver().findElementByXPath("//android.widget.LinearLayout[contains(@resource-id, 'list_product_linear_layout')and @index='1']").click();
		Thread.sleep(10000);
		WelcomePage.getScreenshot("Product Screen");
		
		
		
	}
}
