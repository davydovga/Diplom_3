package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import utils.BaseTest;

import static configuration.URL.LOGIN_PAGE;
import static configuration.URL.MAIN_PAGE;


public class MainPageTest extends BaseTest {
    @Test
    @DisplayName("Тест перехода на главную страницу по нажатию на бургер")
    @Description("Тест проверят что при нажатии на бургер пользователь перейдет на главную страницу")
    public void forwardToMainByClickBurgerTest(){
        driver.get(LOGIN_PAGE);
        header.pressBurgerButton();

        assertCurrentPageIs(MAIN_PAGE);
    }

    @Test
    @DisplayName("Тест перехода на главную страницу по нажатию на 'Конструктор'")
    @Description("Тест проверят что при нажатии на 'Конструктор' пользователь перейдет на главную страницу")
    public void forwardToMainByClickConstructorTest(){
        driver.get(LOGIN_PAGE);
        header.pressConstructorButton();

        assertCurrentPageIs(MAIN_PAGE);
    }

    @Test
    @DisplayName("Тест проверяет что при переходе на раздел отображаются нужные ингридиенты")
    @Description("Тест пробегает по каждому разделу и сверяет что элеемент помечен как 'current'")
    public void ingredientsOnPageTest(){
        driver.get(MAIN_PAGE);
        mainPage.clickSaucesSpanAndCheckSelected();
        mainPage.clickFillingsSpanAndCheckSelected();
        mainPage.clickBunsSpanAndCheckSelected();
    }
}
