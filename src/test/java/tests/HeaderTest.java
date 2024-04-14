package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;

import static configuration.URL.*;


public class HeaderTest extends BaseTest {
    @Test
    @DisplayName("Тест перехода в личный кабинет с авторизацией")
    @Description("Тест проверяет, что авторизированный пользователь, при нажатии на кнопку 'Личный Кабиент', попадает в свой ЛК")
    public void checkHeaderButtonWithAuthTest(){
        driver.get(LOGIN_PAGE);
        loginPage.setUserAuthData(createUser.getEmail(), createUser.getPassword());
        header.pressPCButton();

        assertCurrentPageIs(PROFILE_PAGE);
    }

    @Test
    @DisplayName("Тест перехода в личный кабинет без авторизации")
    @Description("Тест проверяет, что не авторизированный пользователь, при нажатии на кнопку 'Личный Кабиент', попадает на странцу авторизации")
    public void checkHeaderButtonWithoutAuthTest(){
        driver.get(MAIN_PAGE);
        header.pressPCButton();

        assertCurrentPageIs(LOGIN_PAGE);
    }
}
