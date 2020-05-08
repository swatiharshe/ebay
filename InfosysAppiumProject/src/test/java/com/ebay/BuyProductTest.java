package com.ebay;
//import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.Assert;

import com.ebay.pages.home.AddToCart;
import com.ebay.pages.home.HomePage;
import com.ebay.pages.home.SelectedProduct;
import com.ebay.pages.login.SignInPage;
import com.util.ScreenshotUtils;
import com.util.poi.ExcelUtils;


public class BuyProductTest {
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		SignInPage sip = new SignInPage();
		sip.signInCustomer();
		sip.enterUserId();
		sip.enterPassword();
		ScreenshotUtils.captureScreen("login");
	}

@Test
	public void test() {
		try{
			HomePage hp = new HomePage();
		hp.enterSearch();
		hp.selectProduct();
		SelectedProduct sp = new SelectedProduct();
		sp.choosedProduct();
		AddToCart atc = new AddToCart();
		atc.pushToCart();
		Assert.assertEquals(ExcelUtils.getProductDetails(1, 0), ExcelUtils.getProductDetails(2, 0));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
