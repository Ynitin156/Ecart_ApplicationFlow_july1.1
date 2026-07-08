package Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.opentelemetry.api.internal.Utils;

public class Screenshot 
{
	WebDriver driver;
	
	public Screenshot(WebDriver driver)
    {
        this.driver = driver;
    }

	
	public String Capturedscreenshot(String filename) 
	{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

	    File destination = new File("./Screenshot_captured/" + filename + "_" + timeStamp + ".png");
		try 
		{
			FileUtils.copyFile(source, destination);
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		System.out.println("Screenshot captured successfully");
		
		return destination.getAbsolutePath();
	}
}  
