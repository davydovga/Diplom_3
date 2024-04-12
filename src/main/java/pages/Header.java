package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
    }

    private final String lkButtonText = "Личный Кабинет";
    private final By headerPCButton = By.xpath("//a/p[text()='"+lkButtonText+"']");

    private final By burgerButton = By.xpath(".//nav/div/a");
    private final By constructorButton = By.xpath(".//ul/li[1]/a");

    @Step("Нажатие на кнопку 'Личный кабинет' в хедере страницы")
    public void pressPCButton(){
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
