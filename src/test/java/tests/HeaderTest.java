package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.BaseTest;

import static configuration.URL.*;
import static org.junit.Assert.assertEquals;

public class HeaderTest extends BaseTest {


    @Test
    @DisplayName("Тест перехода в личный кабинет с авторизацией")
    @Description("Тест проверяет, что авторизированный пользователь, при нажатии на кнопку 'Личный Кабиент', попадает в свой ЛК")
    public void checkHeaderButtonWithAuthTest(){
        driver.get(LOGIN_PAGE);

        loginPage.setUserAuthData(
                createUser.getEmail(),
                createUser.getPassword());
        header.pressPCButton();
        awaitOfURLChange(PROFILE_PAGE);
        assertEquals("Страница не совпадает с ожидаемой. Ожидаемая страница: " + PROFILE_PAGE,
                PROFILE_PAGE, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Тест перехода в личный кабинет с без авторизации")
    @Description("Тест проверяет, что не авторизированный пользователь, при нажатии на кнопку 'Личный Кабиент', попадает на странцу авторизации")
    public void checkHeaderButtonWithoutAuthTest(){
        driver.get(MAIN_PAGE);
        header.pressPCButton();
        awaitOfURLChange(LOGIN_PAGE);
        assertEquals("Страница не совпадает с ожидаемой. Ожидаемая страница: " + LOGIN_PAGE,
                LOGIN_PAGE, driver.getCurrentUrl());
    }
}
