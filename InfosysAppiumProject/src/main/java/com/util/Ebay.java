package com.util;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ebapy.pages.login.LoginProcess;
import com.ebay.pages.home.HomePage;

public class Ebay {
	
	private static AndroidDriver driver;
	
	private static Logger logger = Logger.getLogger(Ebay.class);
	
public static void initializeDriver() throws MalformedURLException {
	DesiredCapabilities cap = new DesiredCapabilities();
	
	logger.info("Intialize the driver");
	cap.setCapability(ConfigConstants.PLATFORM_VERSION, ConfigProp.getProperty(ConfigConstants.PLATFORM_VERSION));
	
	cap.setCapability(ConfigConstants.DEVICE_NAME, ConfigProp.getProperty(ConfigConstants.DEVICE_NAME));
	
	cap.setCapability(ConfigConstants.PLATFORM_NAME, ConfigProp.getProperty(ConfigConstants.PLATFORM_NAME));
	cap.setCapability(ConfigConstants.RESET_KEYBOARD, ConfigProp.getProperty(ConfigConstants.RESET_KEYBOARD));
	cap.setCapability(ConfigConstants.APP_PACKAGE, ConfigProp.getProperty(ConfigConstants.APP_PACKAGE));
	cap.setCapability(ConfigConstants.APP_ACTIVITY, ConfigProp.getProperty(ConfigConstants.APP_ACTIVITY));
	
	//ExcelUtils.getCredintials();
	
	/*cap.setCapability("appPackage", "com.ebay.mobile");
	cap.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");*/
	driver = new AndroidDriver(new URL(ConfigProp.getProperty(ConfigConstants.URL)), cap);
}
	
	public static void main(String args[]) throws Exception
	{
		
		LoginProcess.login();		
		System.out.println("accepting");
		HomePage.enterSearch();

		
	}
	
	
	private static void loginProces() throws InterruptedException {
		System.out.println("Started Appium Session");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		System.out.println("Page Loaded");
		//WebElement ele=driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'sign_in_button')]");
		WebElement ele=driver.findElementByXPath(SelectorProp.getSelector("login_sign_in"));
		//WebElement ele=driver.findElementByXPath("//android.widget.Button[@index='5']");
		//WebElement ele=driver.findElementByXPath("//android.widget.Button[@text='Skip sign in']");
		System.out.println(ele.isDisplayed());
		ele.click();
		
		Thread.sleep(10000);
		//driver.findElementByXPath("//android.widget.ImageButton[contains(@content-desc, 'Login')]").click();
		
		
		
		driver.findElementByXPath(SelectorProp.getSelector("login_mobile_no")).sendKeys("9373313662");
		
	//
		driver.pressKeyCode(AndroidKeyCode.BACK);
		
		driver.findElementByXPath(SelectorProp.getSelector("login_continue")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.findElementByXPath(SelectorProp.getSelector("login_password")).click();
		driver.findElementByXPath(SelectorProp.getSelector("login_password")).sendKeys("Sinfra@10");
		
		driver.findElementByXPath(SelectorProp.getSelector("login_login_button")).click();
		
		Thread.sleep(30000);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		
		//Search Product
		
		driver.findElementByXPath("//android.widget.EditText[@text='Search']").click();
		driver.findElementByXPath("//android.widget.EditText[@text='Search']").sendKeys("sugar 2kg pantry offer");
		Thread.sleep(10000);
		driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id, 'iss_search_dropdown_item_suggestions')and @index='0']").click();
		Thread.sleep(10000);
		driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id, 'list_product_linear_layout')and @index='1']").click();
		Thread.sleep(10000);
		
		//get product description, price and name
		
		String productName = driver.findElementByXPath("//android.view.View[contains(@content-desc,'Dhampure White Crystal Sugar']").getText();
		System.out.println("productName");
		
		String Price = driver.findElementByXPath("//android.view.View[contains(@content-desc,'Price:']").getText();
		System.out.println("Price");
		
		TouchAction action = new TouchAction(driver);
	    action.press(0, 500).waitAction().moveTo(200, 500).release().perform();
	    
	    driver.findElementByXPath("//android.widget.Button[contains(@content-desc,'Add to Cart']").click();
		
		
		
		
	}

}
