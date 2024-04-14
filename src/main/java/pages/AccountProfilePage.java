package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BasePage;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class AccountProfilePage extends BasePage {
    public AccountProfilePage(WebDriver driver) {
        super(driver);
    }

    private final By exitButton = By.xpath("//button[text()='Выход']");

    @Step("Нажатие на кнопку 'Выход' в личном кабинете")
    public void clickExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOfElementLocated(exitButton));
    	driver.findElement(exitButton).click();
    }
}
