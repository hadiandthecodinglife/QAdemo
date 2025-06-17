package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ElementsTextBoxPage extends Base{
	
	
	@FindBy(xpath = "//*[@id=\\\"app\\\"]/div/div/div/div[1]/div/div/div[1]/span/div")
	WebElement element;
	
	@FindBy(css = "//*[@id=\"item-0\"]")
	WebElement textBox;
	
	@FindBy(css = "#userName")
	WebElement fullName;
	
	@FindBy(css = "#userEmail")
	WebElement email; 
	
	@FindBy(css = "#currentAddress")
	WebElement currentAddress;
	
	@FindBy(css = "#permanentAddress")
	WebElement permenantAddress;
	
	@FindBy(css = "#submit")
	WebElement submit;
   
    
	
	public ElementsTextBoxPage(){
    	super();
    	PageFactory.initElements(driver, this);
	}

}
