package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.BaseTest;

import static configuration.URL.LOGIN_PAGE;
import static configuration.URL.MAIN_PAGE;
import static org.junit.Assert.assertTrue;


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
    @DisplayName("Тест проверяет что при переходе на раздел 'Соусы' отображаются нужные ингридиенты")
    @Description("Тест пробегает по каждому разделу и сверяет что элеемент помечен как 'current'")
    public void visibilitySaucesOnPageTest(){
        driver.get(MAIN_PAGE);
        mainPage.clickSaucesSpan();

        assertTrue("Элемент 'Соусы' не отобразился",mainPage.isCurrentElementSauces());
    }

    @Test
    @DisplayName("Тест проверяет что при переходе на раздел 'Начинки' отображаются нужные ингридиенты")
    @Description("Тест пробегает по каждому разделу и сверяет что элеемент помечен как 'current'")
    public void visibilityFillingsOnPageTest(){
        driver.get(MAIN_PAGE);
        mainPage.clickFillingsSpan();

        assertTrue("Элемент 'Начинки' не отобразился", mainPage.isCurrentElementFillings());
    }

    @Test
    @DisplayName("Тест проверяет что при переходе на раздел 'Булки' отображаются нужные ингридиенты")
    @Description("Тест пробегает по каждому разделу и сверяет что элеемент помечен как 'current'")
    public void visibilityBunsOnPageTest(){
        driver.get(MAIN_PAGE);
        mainPage.clickBunsSpan();

        assertTrue("Элемент 'Булки' не отобразился",mainPage.isCurrentElementBuns());
    }
}
