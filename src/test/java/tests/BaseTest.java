package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pages.Base;

public class BaseTest extends Base{
	
	protected static ExtentReports extent;
	protected static ExtentTest test;
	 
	@BeforeSuite
	public void setupExtent() {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
		
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Selenium Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	 }

	@BeforeMethod
    public void setUp() {
        initiateDriver();
        homePage();
    }
	
	public WebDriver getDriver(){
		return driver;
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
	    if (driver != null) {
	        driver.quit();
	    }
	}
	
	@AfterSuite
	public void tearDownExtent() {
		System.out.println("\n \n THE END \n \n");
		extent.flush();
	 }
}
