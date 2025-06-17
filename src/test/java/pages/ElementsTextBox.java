package pages;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ElementsTextBox extends Base{
	
	static ElementsTextBox etb = new ElementsTextBox();
   
    public static void main(String[] args) {
    	System.out.println("Test1"); 
    	String path = "//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div";
    	etb.clickIcon(path);
    	etb.canClickTextBox();
	}

    public void canClickTextBox() {
    	System.out.println("Test initiated");
    	String path = "//*[@id=\"item-0\"]";
    	etb.testIconIsClickable(path);;
    }

}
