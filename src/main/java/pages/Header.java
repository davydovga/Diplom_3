package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
    }

    private final By headerPCButton = By.xpath("//a/p[text()='Личный Кабинет']");

    public void pressPCButton(){
        driver.findElement(headerPCButton).click();
    }
}
