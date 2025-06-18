package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ElementsTextBoxPage;


public class ElementsTextBoxPageTest {

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
    	
    	logger.info("Starting test: testFillTextBoxForm");

        textBoxPage.clickTextBox();
        logger.info("Clicked on the Text Box section.");

        textBoxPage.inputForm(fullName, validEmail, currentAddress, permanentAddress);
        logger.info("Form input entered: {}, {}, {}, {}", fullName, validEmail, currentAddress, permanentAddress);

        textBoxPage.clickSubmit();
        logger.info("Form submitted");
        
        String detailsSubmitted = textBoxPage.getSubmittedDetails();
        
        Assert.assertTrue(detailsSubmitted.contains("Name:" + fullName));
        Assert.assertTrue(detailsSubmitted.contains("Email:" + validEmail));
        Assert.assertTrue(detailsSubmitted.contains("Current Address :" + currentAddress));
        Assert.assertTrue(detailsSubmitted.contains("Permananet Address :" + permanentAddress));
       
        logger.info("Form field assertions passed.");  
    }
    
    @Test
    public void canNotSubmitWithInvalidEmail() {
    	
    	logger.info("Starting test: testFillTextBoxForm");

        textBoxPage.clickTextBox();
        logger.info("Clicked on the Text Box section.");

        textBoxPage.inputForm(fullName, invalidEmail, currentAddress, permanentAddress);
        logger.debug("Form input entered: {}, {}, {}, {}", fullName, invalidEmail, currentAddress, permanentAddress);

        textBoxPage.clickSubmit();
        logger.info("Form submitted");
        
        String detailsSubmitted = textBoxPage.getSubmittedDetails();
        logger.debug("Submission box details: " + detailsSubmitted);
        
        Assert.assertTrue(detailsSubmitted.isEmpty());
        logger.info("Form field assertions passed.");  
    }
    
    
    
    
    @AfterMethod
    public void tearDown() {
        if (textBoxPage.driver != null) {
        	logger.info("Closing the browser and quitting WebDriver.");
            textBoxPage.driver.quit();
        }
    }
}
