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


public class RegistrationTest extends BaseTest {
    private final CreateUserReq createUserBadPassword = userDataGenerator.createBadPasswordUser(); //Создание пользователя с некорректным паролем

    @Test
    @DisplayName("Тест успешной регистрации пользователя")
    @Description("Тест запольняет форму регистрации и заходит в ЛК под созданным пользователем")
    public void userRegistrationTest(){
        driver.get(REGISTER_PAGE); //Открытие страницы регистрации
        regPage.setUserDataOnPage(createUser.getEmail(), createUser.getPassword(), createUser.getName()); //Заполнение формы регистрации
        regPage.pressRegistrationButton(); //Нажатие кнопки "Зарегистрироваться" на странице регистрации
        header.pressPCButton(); //Нажатие кнопки "Личный кабинет" в хедере на странице регистрации
        loginPage.setUserAuthData(createUser.getEmail(),createUser.getPassword()); //Заполнение данных для входа

        //Логика проврки авторизации
        header.pressPCButton(); //Нажатие кнопки "Личный кабинет" в хедере на странице регистрации
        assertCurrentPageIs(PROFILE_PAGE); //Проверка открытия страницы профиля

        //Логика удаления тестовых данных
        Response response = loginUserAPI(createUser); //Получение токена и удаление пользователя
        deleteUserAPI(userDataGenerator.parseToken(response));
    }

    @Test
    @DisplayName("Тест допустимой длины пароля при регистрации")
    @Description("Тест проверяет что ")
    public void userBadPasswordRegistrationTest(){
        driver.get(REGISTER_PAGE);//Открытие страницы регистрации
        regPage.setUserDataOnPage(createUserBadPassword.getEmail(), createUserBadPassword.getPassword(), createUserBadPassword.getName()); //Заполнение формы регистрации
        regPage.pressRegistrationButton(); //Нажатие кнопки "Зарегистрироваться" на странице регистрации

        regPage.checkPasswordError();//Проверка отображения ошибки
    }
}
