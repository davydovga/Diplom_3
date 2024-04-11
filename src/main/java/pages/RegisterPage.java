package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class RegisterPage extends BasePage {
		public RegisterPage(WebDriver driver) {
			super(driver);
		}

    private final String pageMain = "*//main";
		private final String pageHeader = pageMain + "//h2";
    private final String pageForm = pageMain + "//form";

		private final By inputName = By.xpath(pageForm + "//fieldset[1]//input");
		private final By inputEmail = By.xpath(pageForm + "//fieldset[2]//input");
		private final By inputPassword = By.xpath(pageForm + "//fieldset[3]//input");

		private final By buttonSubmit = By.xpath(pageForm + "//button");
		private final String registrationText = "Зарегистрироваться";

		private final String loginLink = pageMain + "//p/a";
		private final String loginLinkText = "Войти";

		public void setUserDataOnPage(String email, String password, String name) {
			driver.findElement(inputEmail).sendKeys(email);
			driver.findElement(inputPassword).sendKeys(password);
			driver.findElement(inputName).sendKeys(name);
		}

		public void pressRegistrationButton() {
			driver.findElement(findButtonWith(registrationText)).click();
		}

}
