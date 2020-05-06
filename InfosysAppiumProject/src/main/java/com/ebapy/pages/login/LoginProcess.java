package com.ebapy.pages.login;

/**
 * @author Admin
 *
 */
public class LoginProcess {

	
	
	/**
	 * This method consolidate the complete login process
	 */
	public static void login() {
		try {
			SignInPage.signInCustomer();
			WelcomePage.enterUserId();
			WelcomePage.enterPassword();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
