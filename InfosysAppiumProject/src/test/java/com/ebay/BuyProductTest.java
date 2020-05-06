package com.ebay;
//import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.Assert;

import com.ebapy.pages.login.LoginProcess;
import com.ebapy.pages.login.WelcomePage;
import com.ebay.pages.home.AddToCart;
import com.ebay.pages.home.HomePage;
import com.ebay.pages.home.SelectedProduct;
import com.util.poi.ExcelUtils;


public class BuyProductTest {
	
	@BeforeClass
	public static void beforeClass() throws IOException {
		LoginProcess.login();
		WelcomePage.getScreenshot("login");
	}

	@Test
	public void test() {
		try{
		HomePage.enterSearch();
		HomePage.selectProduct();
		SelectedProduct.choosedProduct();
		AddToCart.addToCart();
		Assert.assertEquals(ExcelUtils.getProductDetails(1, 0), ExcelUtils.getProductDetails(2, 0));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
