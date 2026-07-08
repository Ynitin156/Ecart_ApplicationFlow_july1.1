package Base_login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utils.ConfigReader;


public class Base 
{
	public static WebDriver driver;

    public static Logger log = LogManager.getLogger(Base.class);

    ConfigReader cfg = new ConfigReader();

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser)
    {
        if(browser.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
            log.info("Chrome Browser Launched");
        }
        else if(browser.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
            log.info("Edge Browser Launched");
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
            log.info("Firefox Browser Launched");
            
        }
        else
        {
            throw new RuntimeException("Invalid Browser : " + browser);
        }

        driver.get(cfg.geturl());
        log.info("Application URL Opened");

        driver.manage().window().maximize();
        driver.navigate().refresh();
        log.info("Page Refreshed");
    }

    @AfterMethod
    public void teardown()
    {
        if(driver != null)
        {
            log.info("Browser Closed");
            driver.close();
        }
    }
}
