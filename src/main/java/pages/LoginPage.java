package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;


public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private final String mainPage = "*//main";
	private final String formPage = mainPage + "//form";
	private final By inputEmail = By.xpath(formPage + "//fieldset[1]//input");
	private final By inputPassword = By.xpath(formPage + "//fieldset[2]//input");
	private final By enterButton = By.xpath(formPage + "//button");

  	public void setUserAuthData(String login,String password){
	  	driver.findElement(inputEmail).sendKeys(login);
	  	driver.findElement(inputPassword).sendKeys(password);
	  	pressEnterButton();
  	}

  	public void pressEnterButton(){
	  	driver.findElement(enterButton).click();
  	}
}
