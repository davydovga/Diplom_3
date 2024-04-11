package tests;

import api.requests.CreateUserReq;
import configuration.Generators;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.BaseTest;

public class AuthorizationTest extends BaseTest {
	Generators userDataGenerator = new Generators();
	CreateUserReq createUser = userDataGenerator.createUser();

	@Test
	@DisplayName("Тест авторизации с главной страницы через кнопку 'Войти в аккаунт'")
	@Description("Тест переходит на главную страницу сайта, нажимает кнопку 'Войти в аккаунт' затем на кнопку 'Зарегестрироваться'")
	public void authFromMainPage() {
		mainPage.clickLoginButton();
		//методы авторизации
	}
}
