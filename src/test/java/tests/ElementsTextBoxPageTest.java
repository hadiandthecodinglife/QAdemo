package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ElementsTextBoxPage;


public class ElementsTextBoxPageTest extends BaseTest{

    private ElementsTextBoxPage textBoxPage;
    
    private String fullName = "Hadi Baloch";
    private String validEmail = "hadi@example.com";
    private String invalidEmail = "invalid email";
    private String currentAddress = "22 London Road";
    private String permanentAddress = "1 Guildford Road";

    private static final Logger logger = LogManager.getLogger(ElementsTextBoxPageTest.class);
    
    @BeforeMethod
    public void setUp() {
    	textBoxPage = new ElementsTextBoxPage();
    }

   @Test
    public void canSubmitWithValidDetails() {
   		test = extent.createTest("Testing the Text Box page with Valid details");

    	test.info("Starting test: submit with valid details");

        textBoxPage.clickTextBox();
        test.info("Opened on the Text Box section.");

        textBoxPage.inputForm(fullName, validEmail, currentAddress, permanentAddress);
        test.info("Form input entered:\n name: " + fullName + "\nemail: " + validEmail + "\nca: " + currentAddress + "\npa: " + permanentAddress);
        
        textBoxPage.clickSubmit();
        test.pass("Form submitted");
        
        String detailsSubmitted = textBoxPage.getSubmittedDetails();
        
        Assert.assertTrue(detailsSubmitted.contains("Name:" + fullName));
        test.pass("Correct name submitted");
        
        Assert.assertTrue(detailsSubmitted.contains("Email:" + validEmail));
        test.pass("Correct email submitted");
        
        Assert.assertTrue(detailsSubmitted.contains("Current Address :" + currentAddress));
        test.pass("Correct current address submitted");
        
        Assert.assertTrue(detailsSubmitted.contains("Permananet Address :" + permanentAddress));
        test.pass("Correct permanent address submitted");
        test.pass("Test passed successfully");
    }
    
    @Test
    public void canNotSubmitWithInvalidEmail() {
    	test = extent.createTest("Testing the Text Box page with an invalid email");
    	
    	logger.info("Starting test: testFillTextBoxForm");
    	test.info("Starting test: submit with invalid email");
    	
        textBoxPage.clickTextBox();
        test.info("Opened on the Text Box section.");

        textBoxPage.inputForm(fullName, invalidEmail, currentAddress, permanentAddress);
        test.info("Form input entered:\n name: " + fullName + "\nemail: " + invalidEmail + "\nca: " + currentAddress + "\npa: " + permanentAddress);
        
        textBoxPage.clickSubmit();
        test.info("Submission attemot made with an invalid email");
        
        String detailsSubmitted = textBoxPage.getSubmittedDetails();
        
        Assert.assertTrue(detailsSubmitted.isEmpty());
        test.pass("Test Passed, Submission not possible with an invalid email");
    }
    
    @AfterMethod
    public void tearDown() {
        if (textBoxPage.driver != null) {
        	logger.info("Closing the browser and quitting WebDriver.");
            textBoxPage.driver.quit();
        }
    }
}
