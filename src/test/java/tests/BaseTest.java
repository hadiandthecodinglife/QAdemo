package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {
	
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
	 
	@AfterSuite
	public void tearDownExtent() {
		System.out.println("\n \n THE END \n \n");
		extent.flush();
	 }
}
