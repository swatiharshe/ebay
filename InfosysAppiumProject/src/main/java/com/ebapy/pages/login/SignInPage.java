package com.ebapy.pages.login;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.util.SelectorProp;
import com.util.WebDriverUtils;

public class SignInPage {

	private static Logger logger = Logger.getLogger(SignInPage.class);

	public static void signInCustomer() throws Exception {
		//Thread.sleep(5000);
		logger.info("Entered to login page");
		WebDriverUtils.intializeDriver().manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		WelcomePage.getScreenshot("Splash Screen");

		WebDriverUtils.intializeDriver().findElementByXPath(SelectorProp.getSelector("login_sign_in")).click();	
	}

	public void newCustomer() {

	}

	public void skipSignIn() {

	}

}
