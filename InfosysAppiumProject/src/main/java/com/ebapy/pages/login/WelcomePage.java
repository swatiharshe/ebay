package com.ebapy.pages.login;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.util.SelectorProp;
import com.util.WebDriverUtils;
import com.util.poi.ExcelUtils;

public class WelcomePage {
	
	public static void enterUserId() throws Exception{
		WebDriverUtils.intializeDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		WebDriverUtils.intializeDriver().findElementByXPath(SelectorProp.getSelector("login_mobile_no")).sendKeys(ExcelUtils.getCredintials().get(0));
		WebDriverUtils.intializeDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		TouchAction action = new TouchAction(WebDriverUtils.intializeDriver());
	    action.press(0, 300).waitAction().moveTo(0, 200).release().perform();
		//WebDriverUtils.intializeDriver().pressKeyCode(AndroidKeyCode.BACK);
	    
	    WelcomePage.getScreenshot("Welcome Screen");
		
		WebDriverUtils.intializeDriver().findElementByXPath(SelectorProp.getSelector("login_continue")).click();
		
		WebDriverUtils.intializeDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}
	
	public static void enterPassword() throws Exception {
		WebDriverUtils.intializeDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		WebDriverUtils.intializeDriver().findElementByXPath(SelectorProp.getSelector("login_password")).click();
		WebDriverUtils.intializeDriver().findElementByXPath(SelectorProp.getSelector("login_password")).sendKeys(ExcelUtils.getCredintials().get(1));
		
		WebDriverUtils.intializeDriver().findElementByXPath(SelectorProp.getSelector("login_login_button")).click();
		
		Thread.sleep(30000);
		WebDriverUtils.intializeDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		WebDriverUtils.intializeDriver().findElementByXPath("//android.widget.Button[contains(@content-desc,'Send OTP' Or @content-desc, 'Continue')]").click();
		WebDriverUtils.intializeDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		WebDriverUtils.intializeDriver().findElementByXPath("//android.widget.Button[contains(@content-desc,'Continue')]").click();
	}
	
public static void getScreenshot(String filename) throws IOException
	
	{
		File scrfile = ((TakesScreenshot)WebDriverUtils.intializeDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File("D:/InfosysAppiumProject/Screenshot/"+filename+".png"));
		
	}
}
