package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;

import Utils.Screenshot;
import Utils.WaitsUtils;



public class PaymentFlow 
{

  WebDriver driver;	 
  WaitsUtils wait;
 
  
  //Logger
  private static final Logger log = LogManager.getLogger(PaymentFlow.class);
  
	
  By name_on_card = By.xpath("//*[contains(@name,'name_on_card')]");
  By card_number = By.xpath("//*[contains(@name,'card_number')]");
  By cvv = By.xpath("//*[contains(@name,'cvc')]"); 
  By month = By.xpath("//*[contains(@name,'expiry_month')]");
  By year = By.xpath("//*[contains(@name,'expiry_year')]");
  By pay_and_confirm_order = By.xpath("//*[contains(@id,'submit')]");
  By download_invoice = By.xpath("//a[text()='Download Invoice']");
  
  public PaymentFlow(WebDriver driver)
  {
	  this.driver=driver;
	  wait = new WaitsUtils(driver);
	  
  }
  
  public void credit_card_payment() throws InterruptedException
  {
	  wait.waitforVisibility(name_on_card);
	  driver.findElement(name_on_card).sendKeys("Nitin Yadav");
	  log.info("card name enter succesfully");
	  
	  wait.waitforVisibility(card_number);
	  driver.findElement(card_number).sendKeys("340256450061004");
	  log.info("card number enter succesfully");
	  
	  wait.waitforVisibility(cvv);
	  driver.findElement(cvv).sendKeys("123");
	  log.info("cvv enter");
	  
	  wait.waitforVisibility(month);
	  driver.findElement(month).sendKeys("12");
	  log.info("expiry month entered");
	  
	  wait.waitforVisibility(year);
	  driver.findElement(year).sendKeys("2029");
	  log.info("Expiry year entered");
	  
	  wait.waitforVisibility(pay_and_confirm_order);
	  
	  Screenshot sc2 = new Screenshot(driver);
	  sc2.Capturedscreenshot("confirm");
	  
	  driver.findElement(pay_and_confirm_order).click();
	  log.info("Pay and confirm order button clicked");
	  
	  log.info("wait for enter manually opt for transaction");
	  
	  wait.waitforVisibility(download_invoice);

	  log.info("Payment completed successfully");
	  
  }
  
  public void invoice_order_download()
  {
	  wait.waitforVisibility(download_invoice);
	
	  Screenshot sc1 = new Screenshot(driver);
	  sc1.Capturedscreenshot("OrderPlaced");
	  log.info("order placed succesfully");
	  
	  driver.findElement(download_invoice).click();
	  log.info("download_invoice succesfully");
  }
}
