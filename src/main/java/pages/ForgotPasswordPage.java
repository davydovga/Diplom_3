package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    private final String enterText = "Войти";
    private final By enterLink = By.xpath(".//a[text()='"+ enterText +"']");


    @Step("Переход по ссылке ведущей на страницу авторизации")
    public void clickEnterLink(){
        driver.findElement(enterLink).click();
    }


}
