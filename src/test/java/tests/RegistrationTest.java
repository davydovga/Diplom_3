package tests;

import api.requests.CreateUserReq;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import utils.BaseTest;

import static api.api.CreateUserAPI.deleteUserAPI;
import static api.api.CreateUserAPI.loginUserAPI;
import static configuration.URL.PROFILE_PAGE;
import static configuration.URL.REGISTER_PAGE;
import static org.junit.Assert.assertEquals;


public class RegistrationTest extends BaseTest {



    @Test
    @DisplayName("Тест успешной регистрации пользователя")
    @Description("Тест запольняет форму регистрации и заходит в ЛК под созданным пользователем")
    public void userRegistrationTest(){
        CreateUserReq createUser = userDataGenerator.createUser();

        //Открытие страницы регистрации
        driver.get(REGISTER_PAGE);

        //Заполнение формы регистрации
        regPage.setUserDataOnPage(
                createUser.getEmail(),
                createUser.getPassword(),
                createUser.getName()
                );

        //Нажатие кнопки "Зарегистрироваться" на странице регистрации
        regPage.pressRegistrationButton();
        //Нажатие кнопки "Личный кабинет" в хедере на странице регистрации
        header.pressPCButton();
        //Заполнение данных для входа
        loginPage.setUserAuthData(createUser.getEmail(),createUser.getPassword());
        //Нажатие кнопки "Личный кабинет" в хедере на странице регистрации
        header.pressPCButton();
        awaitOfURLChange(PROFILE_PAGE);
        //Проверка открытия страницы профиля
        assertEquals("Не удалось попасть в профиль пользователя после регистраци",
                PROFILE_PAGE, driver.getCurrentUrl());
        //Получение токена и удаление пользователя
        Response response = loginUserAPI(createUser);
        deleteUserAPI(userDataGenerator.parseToken(response));
    }

    @Test
    @DisplayName("Тест допустимой длины пароля при регистрации")
    @Description("Тест проверяет что ")
    public void userBadPasswordRegistrationTest(){
        CreateUserReq createUserBadPassword = userDataGenerator.createBadPasswordUser();

        //Открытие страницы регистрации
        driver.get(REGISTER_PAGE);
        //Заполнение формы регистрации
        regPage.setUserDataOnPage(
                createUserBadPassword.getEmail(),
                createUserBadPassword.getPassword(),
                createUserBadPassword.getName());

        //Нажатие кнопки "Зарегистрироваться" на странице регистрации
        regPage.pressRegistrationButton();
        //Проверка отображения ошибки
        regPage.checkPasswordError();
    }

}
