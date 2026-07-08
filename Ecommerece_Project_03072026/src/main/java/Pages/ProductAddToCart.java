package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import Utils.WaitsUtils;

import Utils.WaitsUtils;
import Utils.Screenshot;

public class ProductAddToCart 
{
 
	WebDriver driver;
	WaitsUtils wait;
	
	// Logger
    private static final Logger log = LogManager.getLogger(ProductAddToCart.class);
	
   By product_search_button = By.xpath("//a[@href='/products']");
   By product = By.xpath("//input[@id='search_product']");
   By product_search = By.xpath("//button[@id='submit_search']");
   By add_to_cart  = By.xpath("(//a[contains(@class,'btn btn-default add-to-cart') and @data-product-id='7'])[1]");
   By continue_shopping = By.xpath("//button[text()='Continue Shopping']");
   By check_cart = By.xpath("//a[text()=' Cart']");
   By checkout = By.xpath("//a[text()='Proceed To Checkout']");
   By order_placed = By.xpath("//a[text()='Place Order']");
   
   public ProductAddToCart(WebDriver driver)
   {
	   this.driver=driver;
	   this.wait= new WaitsUtils(driver);
   }
   
   public void product()
   {
	   wait.waitforVisibility(product_search_button);
	   driver.findElement(product_search_button).click();
	   log.info("Navigate to Product Page");
	   
	   wait.waitforVisibility(product);
	   driver.findElement(product).sendKeys("women");
	   log.info("Product name entered: women");
	   
	   wait.waitforVisibility(product_search);
	   driver.findElement(product_search).click();
	   log.info("Product search button clicked");
   }
   
   public void cart()
   {
	   wait.waitforVisibility(add_to_cart);
	   driver.findElement(add_to_cart).click();
	   log.info("Product add to cart");
	   
	   wait.waitforVisibility(continue_shopping);
	   driver.findElement(continue_shopping).click();
	   log.info("Continue Shopping button clicked");
   }
   
   public void order()
   {
	   wait.waitforVisibility(check_cart);
	   driver.findElement(check_cart).click();
	   log.info("Cart page opened");
	   
	   wait.waitforVisibility(checkout);
	   driver.findElement(checkout).click();
	   log.info("Proceed To Checkout button clicked");
	   
	   wait.waitforVisibility(order_placed);
	   driver.findElement(order_placed).click();
	   log.info("Place Order button clicked");
	   
   }
   
}
