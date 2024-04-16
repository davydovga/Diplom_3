package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    protected void hideElementForFirefox(){
        String browser = System.getenv("BROWSER");
        if(browser != null && browser.equals("mozilla")){
            ((JavascriptExecutor)driver).executeScript("document.querySelector('div.Modal_modal__P3_V5').style.display = 'none';");
        }
    }
}
