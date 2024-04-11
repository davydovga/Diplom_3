package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    
    protected final String mainXPath ="*//main";
		
    protected By findButtonWith(String buttonText) {
    		return By.xpath(mainXPath + "//button[text()='" + buttonText + "']");
    }
}
