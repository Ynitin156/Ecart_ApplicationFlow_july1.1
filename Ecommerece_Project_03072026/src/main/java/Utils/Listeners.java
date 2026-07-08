package Utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Base_login.Base;

public class Listeners implements ITestListener
{
	Reports reports = new Reports();

    ExtentReports extent = reports.getReport();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result)
    {
    	String browser = result.getTestContext()
                .getCurrentXmlTest()
                .getParameter("browser");

        test = extent.createTest(result.getName());

        test.info("Browser : " + browser);

        test.assignCategory(browser);
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        test.pass("Test Passed");
        
        Screenshot sc = new Screenshot(Base.driver);

        String path = sc.Capturedscreenshot(result.getName());

        test.pass(result.getThrowable());

        test.addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        Screenshot sc = new Screenshot(Base.driver);

        String path = sc.Capturedscreenshot(result.getName());

        test.fail(result.getThrowable());

        test.addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context)
    {
        extent.flush();
        EmailUtils.sendEmail(reports.getReportPath());
    }
}