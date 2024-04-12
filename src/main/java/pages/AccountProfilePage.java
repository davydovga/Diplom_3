package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class AccountProfilePage extends BasePage {
    public AccountProfilePage(WebDriver driver) {
        super(driver);
    }

    private final String exitButtonText = "Выход";
    private final By exitButton = By.xpath(mainXPath + "//li[3]/button[text()='"+ exitButtonText +"']");


    private final By emailOnUserPage = By.xpath("*//li[1]//input[@value]");
    private final By nameOnUserPage = By.xpath("*//li[2]/div/div/input[@value]");


    @Step("Нажатие на кнопку 'Выход' в личном кабинете")
    public void clickExitButton() {
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(exitButton));
    	driver.findElement(exitButton).click();
    }

    public String getUserEmail(){
        return driver.findElement(emailOnUserPage).getText();
    }

    public String getUserName(){
        return driver.findElement(nameOnUserPage).getText();
    }
}
