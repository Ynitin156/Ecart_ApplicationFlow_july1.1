package Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

public class WaitsUtils 
{

	WebDriver driver;
	WebDriverWait wait;

	public WaitsUtils(WebDriver driver) 
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	public WebElement waitforVisibility(By locator)
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement waitforClickable(By Locator)
	{
		return wait.until(ExpectedConditions.elementToBeClickable(Locator));
	}
	
	public boolean waitForInvisibility(By locator)
	{
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
	
}
