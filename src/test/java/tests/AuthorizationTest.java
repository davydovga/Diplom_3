package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.BaseTest;

import static configuration.URL.*;


public class AuthorizationTest extends BaseTest {
	@Test
	@DisplayName("Тест авторизации с главной страницы через кнопку 'Войти в аккаунт'")
	@Description("Тест переходит на главную страницу сайта, нажимает кнопку 'Войти в аккаунт' и авторизируется")
	public void authFromMainPageTest() {
		driver.get(MAIN_PAGE);

		mainPage.clickLoginButton();
		loginPage.setUserAuthData(createUser.getEmail(), createUser.getPassword());

		header.pressPCButton();
		assertCurrentPageIs(PROFILE_PAGE);
	}

	@Test
	@DisplayName("Тест авторизации с главной страницы через кнопку 'Личный кабинет' в хедере страницы")
	@Description("Тест переходит на главную страницу сайта, нажимает кнопку 'Личный кабинет' и авторизируется ")
	public void authFromHeaderButtonTest(){
		driver.get(MAIN_PAGE);
		header.pressPCButton();
		loginPage.setUserAuthData(createUser.getEmail(), createUser.getPassword());

		header.pressPCButton();
		assertCurrentPageIs(PROFILE_PAGE);
	}

	@Test
	@DisplayName("Тест авторизации со страницы 'Забыли пароль?'")
	@Description("Тест переходит на страницу 'Забыли пароль?', после чего возвращается на страницу авторизации по кнопке 'Войти' и авторизируется ")
	public void authFromForgotPasswordFormTest(){
		driver.get(FORGOT_PASSWORD_PAGE);
		forgotPasswordPage.clickEnterLink();
		loginPage.setUserAuthData(createUser.getEmail(), createUser.getPassword());

		header.pressPCButton();
		assertCurrentPageIs(PROFILE_PAGE);
	}
}
