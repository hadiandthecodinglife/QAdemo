package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementsTextBoxPage{
	
	private WebDriverWait wait;
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div")
	private WebElement element;
	
	@FindBy(xpath = "//*[@id=\"item-0\"]")
	private WebElement textBox;
	
	@FindBy(css = "#userName")
	private WebElement nameBox;
	
	@FindBy(css = "#userEmail")
	private WebElement emailBox; 
	
	@FindBy(css = "#currentAddress")
	private WebElement currentAddressBox;
	
	@FindBy(css = "#permanentAddress")
	private WebElement permenantAddressBox;
	
	@FindBy(xpath = "//*[@id=\"submit\"]")
	private WebElement submitButton;
	
	@FindBy(xpath = "//*[@id=\"output\"]/div")
	private WebElement detailsSubmitted;
	
	public ElementsTextBoxPage(WebDriver driver, WebDriverWait wait){
    	this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	public void clickTextBox() {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(textBox));
		textBox.click();
	}
	
	public void inputForm(String fullName, String email, String ca, String pa) {
		wait.until(ExpectedConditions.visibilityOf(nameBox));
	    nameBox.sendKeys(fullName);

	    wait.until(ExpectedConditions.visibilityOf(emailBox));
	    emailBox.sendKeys(email);

	    wait.until(ExpectedConditions.visibilityOf(currentAddressBox));
	    currentAddressBox.sendKeys(ca);

	    wait.until(ExpectedConditions.visibilityOf(permenantAddressBox));
	    permenantAddressBox.sendKeys(pa);
	}
	
	public void clickSubmit() {
		wait.until(ExpectedConditions.visibilityOf(submitButton));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
		
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		submitButton.click();
	}
	
	public String getSubmittedDetails() {
		return detailsSubmitted.getText();
	}
}
