package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BasePage;

import java.time.Duration;


public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);
    }

    private final String lkButtonText = "Личный Кабинет";
    private final By headerPCButton = By.xpath("//a/p[text()='"+lkButtonText+"']");
    private final By headerPCButton1 = By.xpath("*//*[@href='/account']");
    private final By burgerButton = By.xpath(".//nav/div/a");
    private final By constructorButton = By.xpath(".//ul/li[1]/a");

    @Step("Нажатие на кнопку 'Личный кабинет' в хедере страницы")
    public void pressPCButton(){
        new WebDriverWait(driver, Duration.ofSeconds(5));
        hideElementForFirefox();
        driver.findElement(headerPCButton).click();
    }

    @Step("Нажатие на кнопку 'Stellar Burgers' в хедере страницы")
    public void pressBurgerButton(){
        driver.findElement(burgerButton);
    }

    @Step("Нажатие на кнопку 'Конструктор' в хедере страницы")
    public void pressConstructorButton(){
        driver.findElement(constructorButton);
    }
}
