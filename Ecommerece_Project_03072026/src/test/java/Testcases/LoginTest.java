package Testcases;


import org.testng.annotations.Test;


import Base_login.Base;
import DataProviders.dataprovider;
import Pages.Login;
import Pages.PaymentFlow;
import Pages.ProductAddToCart;
import Utils.ConfigReader;

public class LoginTest extends Base
{
 
	@Test(dataProvider = "LoginData", dataProviderClass = dataprovider.class)
	public void verifylogin(String username, String userpass) throws InterruptedException
	{
	    System.out.println("Username = " + username);
	    System.out.println("Password = " + userpass);
	    
	    Login login = new Login(driver);
	    login.login(username, userpass);
	    
	    
	   
	   
	}
		
		
	
}
