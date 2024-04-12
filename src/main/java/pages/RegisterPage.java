package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

		private final String loginLink = pageMain + "//p/a";
		private final String loginLinkText = "Войти";

		@Step("Заполнение данных пользователя на странице регистрации")
		public void setUserDataOnPage(String email, String password, String name) {
			driver.findElement(inputEmail).sendKeys(email);
			driver.findElement(inputPassword).sendKeys(password);
			driver.findElement(inputName).sendKeys(name);
		}

		@Step("Нажатие кнопки ррегистрация")
		public void pressRegistrationButton() {
            String registrationText = "Зарегистрироваться";
            driver.findElement(findButtonWith(registrationText)).click();
		}

		@Step("Проверка наличия ошибки при вводе некорректного пароля")
		public void checkPasswordError(){
			String passwordErrorTest = "Некорректный пароль";
			try {
				driver.findElement(By.xpath(".//fieldset[3]/div/p[text()='" + passwordErrorTest + "']"));
			} catch (NoSuchElementException elementException) {
				System.out.println("Не найден элемент ошибки метода checkPasswordError: '" + passwordErrorTest +"'.");
			}
		}

}
