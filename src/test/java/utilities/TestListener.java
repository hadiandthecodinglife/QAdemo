package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.Base;
import tests.BaseTest;

import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {
	
	 ExtentSparkReporter htmlReporter;
	 ExtentReports extent;
	 ExtentTest test;
	 
	 @Override
	 public void onStart(ITestContext context) {
		 htmlReporter = new ExtentSparkReporter("ExtentReport.html");
		 extent = new ExtentReports();
	 	 extent.attachReporter(htmlReporter);
	 }
	 
	 @Override
	 public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getName());
		 System.out.println("*********Test started: " + result.getName());
	 }
	 
	 @Override
	 public void onTestSuccess(ITestResult result) {
		 test.pass("Test Passed: " + result.getName());
	 }
	 
	 @Override
	 public void onTestFailure(ITestResult result) {
	     Object testInstance = result.getInstance();
	     //WebDriver driver = new ChromeDriver();
	     WebDriver driver = ((BaseTest) testInstance).getDriver();

	     String screenshotPath = TakeScreenshot.captureScreenshot(driver, result.getName());
	     test.fail("Test Failed: " + result.getName())
	         .addScreenCaptureFromPath(screenshotPath);
	 }
	 
	 @Override
	 public void onTestSkipped(ITestResult result) {
		 test.skip("Test Skipped: " + result.getName());
	 }
	 
	 @Override
	 public void onFinish(ITestContext context) {
		 extent.flush();
	 }
}
	

