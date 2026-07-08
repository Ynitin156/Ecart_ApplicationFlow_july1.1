package Testcases;

import org.testng.annotations.Test;

import Base_login.Base;
import DataProviders.dataprovider;
import Pages.Login;
import Pages.PaymentFlow;
import Utils.ConfigReader;
import Pages.ProductAddToCart;

public class ProductCart extends Base
{
	@Test(dataProvider = "LoginData", dataProviderClass = dataprovider.class)
	public void verifylogin(String username, String userpass)
	{
	    System.out.println("Username = " + username);
	    System.out.println("Password = " + userpass);
	    
	    Login login = new Login(driver);
	    login.login(username, userpass);
	    
	    
	    if(login.isLoginSuccessful())
	    {
	    ProductAddToCart patc = new ProductAddToCart(driver);
		patc.product();
		patc.cart();
		patc.order();
	    
	    }
	    
	    else
	    {
	    	System.out.println("Login falied");
	    }
	   
	}
}
