package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.BaseTest;

import static configuration.URL.LOGIN_PAGE;
import static configuration.URL.PROFILE_PAGE;


public class ProfilePageTest extends BaseTest {

    @Test
    @DisplayName("Тест кнопки выйти в личном кабинете пользователя")
    @Description("Тест нажимает на кнопку 'Выйти' и проверяет что пользователь переадресован на страницу авторизации")
    public void exitButtonTest(){
        driver.get(PROFILE_PAGE);
        loginPage.setUserAuthData(createUser.getEmail(), createUser.getPassword());
        header.pressPCButton();
        accountProfilePage.clickExitButton();
        awaitOfURLChange(LOGIN_PAGE);
    }
}
