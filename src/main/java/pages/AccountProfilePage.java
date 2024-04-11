package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class AccountProfilePage extends BasePage {
    public AccountProfilePage(WebDriver driver) {
        super(driver);
    }

    private final By exitButton = By.xpath(mainXPath + "//li[3]/button");
    private final String exitButtonText = "Выход";

    private final By emailOnUserPage = By.xpath("*//li[1]//input[@value]");
    private final By nameOnUserPage = By.xpath("*//li[2]/div/div/input[@value]");

    public void clickExitButton() {
    	driver.findElement(exitButton).click();
    }

    public String getUserEmail(){
        return driver.findElement(emailOnUserPage).getText();
    }

    public String getUserName(){
        return driver.findElement(nameOnUserPage).getText();
    }
}
