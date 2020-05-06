package com.util;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverUtils {

	private static AndroidDriver driver;

	private static Logger logger = Logger.getLogger(WebDriverUtils.class);

	public static AndroidDriver intializeDriver() throws MalformedURLException {		
		if(driver==null){
					
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(ConfigConstants.PLATFORM_VERSION,
				ConfigProp.getProperty(ConfigConstants.PLATFORM_VERSION));

		cap.setCapability(ConfigConstants.DEVICE_NAME,
				ConfigProp.getProperty(ConfigConstants.DEVICE_NAME));

		cap.setCapability(ConfigConstants.PLATFORM_NAME,
				ConfigProp.getProperty(ConfigConstants.PLATFORM_NAME));
		cap.setCapability(ConfigConstants.RESET_KEYBOARD,
				ConfigProp.getProperty(ConfigConstants.RESET_KEYBOARD));
		cap.setCapability(ConfigConstants.APP_PACKAGE,
				ConfigProp.getProperty(ConfigConstants.APP_PACKAGE));
		cap.setCapability(ConfigConstants.APP_ACTIVITY,
				ConfigProp.getProperty(ConfigConstants.APP_ACTIVITY));

		
		 
		driver = new AndroidDriver(new URL(
				ConfigProp.getProperty(ConfigConstants.URL)), cap);
		}
		
		return driver;
	}

}
