package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PropertiesHandler;

public class Base 	
{
	public WebDriver driver;
	public WebDriverWait wait;
	private PropertiesHandler ph = new PropertiesHandler();
	
	public Base() {
		initiateDriver();
		homePage();	
	}
	
	public WebDriver initiateDriver()
    {
		try {
			String browser = ph.getproperty("browser");
			System.out.println("Browser of choice: " + browser);
			
			switch (browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
				
			case "firefox":
				driver = new FirefoxDriver();
				break;
				
			case "edge":
				driver = new EdgeDriver();
				break;
				
			case "":
				driver = new ChromeDriver();
				break;
			
			default:
				driver = new ChromeDriver();
				break;
			};
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("catch base");
		}
        return driver;
    }

	public void homePage() {
		String url = null;
		try {
			url = ph.getproperty("url");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.get(url);
	}
}
