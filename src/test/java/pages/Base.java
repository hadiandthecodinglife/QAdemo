package pages;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	
	private static final Logger logger = LogManager.getLogger(Base.class);
	
	public Base() {
		initiateDriver();
		homePage();	
	}
	
	public WebDriver initiateDriver()
    {
		try {
			String browser = ph.getproperty("browser");
			
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
			logger.info("{} driver initialized successfully.", browser);
			
		} catch (IOException e) {
			logger.error("Failed to initiate WebDriver due to IOException", e);
		}
        return driver;
    }

	public void homePage() {
		String url = null;
		try {
			url = ph.getproperty("url");
		} catch (IOException e) {
			logger.error("Failed to load URL from properties", e);
		}
		
		if (url != null) {
            driver.manage().window().maximize();
            driver.get(url);
            logger.info("Navigated to homepage: {}", url);
        } else {
            logger.warn("No URL was provided—homepage not loaded.");
        }
	}
}
