package Testcases;
import org.testng.annotations.Test;

import Base_login.Base;
import DataProviders.dataprovider;
import Pages.Login;
import Utils.ConfigReader;
import Pages.ProductAddToCart;
import Pages.PaymentFlow;

public class paymentcheck extends Base
{
	@Test(dataProvider = "LoginData", dataProviderClass = dataprovider.class)
	public void verifylogin(String username, String userpass) throws InterruptedException
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
		
		PaymentFlow pf = new PaymentFlow(driver);
		pf.credit_card_payment();
		pf.invoice_order_download();
	    }
	    
	    else
	    {
	    	System.out.println("Login falied");
	    }
	   
	}
   
   
}
