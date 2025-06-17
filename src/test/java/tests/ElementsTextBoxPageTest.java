package tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ElementsTextBoxPage;


public class ElementsTextBoxPageTest {

    private ElementsTextBoxPage textBoxPage;
    private String fullName = "Hadi Baloch";
    private String email = "hadi@example.com";
    private String currentAddress = "22 London Road";
    private String permanentAddress = "1 Guildford Road";

    @BeforeMethod
    public void setUp() {
        textBoxPage = new ElementsTextBoxPage();
    }

    @Test
    public void testFillTextBoxForm() {
    	
        textBoxPage.clickTextBox();
        textBoxPage.inputForm(fullName, email, currentAddress, permanentAddress);
      
        String actualName = textBoxPage.driver.findElement(By.cssSelector("#userName")).getAttribute("value");
        Assert.assertEquals(actualName, fullName);
        
        String actualEmail = textBoxPage.driver.findElement(By.cssSelector("#userEmail")).getAttribute("value");
        Assert.assertEquals(actualEmail, email);
        
        String actualCurrentAddress = textBoxPage.driver.findElement(By.cssSelector("#currentAddress")).getAttribute("value");
        Assert.assertEquals(actualCurrentAddress, currentAddress);
        
        String actualPermanentAddress = textBoxPage.driver.findElement(By.cssSelector("#permanentAddress")).getAttribute("value");
        Assert.assertEquals(actualPermanentAddress, permanentAddress);  
    }

    @AfterMethod
    public void tearDown() {
        if (textBoxPage.driver != null) {
            textBoxPage.driver.quit();
        }
    }
}
