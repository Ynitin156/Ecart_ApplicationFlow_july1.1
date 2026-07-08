package Pages;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;


import Utils.WaitsUtils;


public class Login 
{
	 WebDriver driver;
	 WaitsUtils wait;
	 
	 //Logger
	 private static final Logger log = LogManager.getLogger(Login.class);
	 
	 By username = By.xpath("//*[starts-with(@name,'email') and @data-qa='login-email']");
	 By userpass = By.xpath("//*[contains(@data-qa,'login-password')]");
	 By userloginclick = By.xpath("//*[text()='Login']");
	 
	 By logout = By.xpath("//a[text()=' Logout']");
	 
	 
	 public Login(WebDriver driver)
	 {
		 this.driver=driver;
		 this.wait = new WaitsUtils(driver);
	 }
	
	 public void login(String user,String pass)
	 {
		 wait.waitforVisibility(username);
		 driver.findElement(username).sendKeys(user);
		 log.info("username enter succesfully");
		 
		 wait.waitforVisibility(userpass);
		 driver.findElement(userpass).sendKeys(pass);
		 log.info("userpass enter succesfully");
		 
		 wait.waitforClickable(userloginclick);
		 driver.findElement(userloginclick).click();
		 log.info("User click on login button succesfully");
	 }
	 
	 public boolean isLoginSuccessful()
	 {
	     return driver.findElements(logout).size() > 0;
	 }
	 

}
