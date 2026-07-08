package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports 
{
	ExtentReports extent;
    ExtentSparkReporter spark;
	
    public String reportPath;
    
	public Reports()
	{
		    extent = new ExtentReports();
		    String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

		    spark = new ExtentSparkReporter("Reports/Report_" + timeStamp + ".html");
            extent.attachReporter(spark);
            
            
            extent.setSystemInfo("Tester", "Nitin Yadav");
            extent.setSystemInfo("Browser", "Chrome,Firefox and Edge");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("E-Commerce Test Execution Report");
	}
	
	public ExtentReports getReport()
    {
		extent = new ExtentReports();

	    String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

	    reportPath = "Reports/Report_" + timeStamp + ".html";

	    spark = new ExtentSparkReporter(reportPath);

	    extent.attachReporter(spark);

	    return extent;
    }
	
	public String getReportPath()
	{
	    return reportPath;
	}
}
