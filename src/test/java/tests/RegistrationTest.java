package tests;

import api.requests.AuthReq;
import api.requests.CreateUserReq;
import api.responses.CreateUserResponse;
import api.responses.LoginResponse;
import configuration.Generators;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import utils.BaseTest;

import static api.BaseAPI.postReq;
import static api.CreateUserAPI.*;
import static org.junit.Assert.assertEquals;


public class RegistrationTest extends BaseTest {
    Generators userDataGenerator = new Generators();
    CreateUserReq createUser = userDataGenerator.createUser();

    @Test
    @DisplayName("Тест успешной регистрации пользователя")
    @Description("")
    public void userRegistrationTest(){
        /* mainPage.clickLoginButton();
        loginPage.forwardToRegistrationPage();
        regPage.setUserDataOnPage(
                createUser.getEmail(),
                createUser.getPassword(),
                createUser.getName()
                );

        regPage.pressRegistrationButton();
        //Зайти в аккаунт и сверить
        loginPage.setUserAuthData(createUser.getEmail(), createUser.getPassword());
        loginPage.pressEnterButton();

        header.pressPCButton(); */

//        System.out.println(accountProfilePage.getUserEmail());
//        assertEquals(accountProfilePage.getUserEmail(), createUser.getEmail());
//        assertEquals(accountProfilePage.getUserName(), createUser.getEmail());


        Response crtusr = createUserAPI(createUser);
        System.out.println("CREATE_USER:");
        crtusr.prettyPrint();

        AuthReq authReq = new AuthReq(createUser.getEmail(), createUser.getPassword());


        Response response = loginUserAPI(authReq);
        System.out.println("LOGIN_USER:");
        response.prettyPrint();


        String token = response.as(CreateUserResponse.class).getAccessToken().substring(7);
        System.out.println("TOKEN: " + token);
//         deleteUserAPI(token);
    }
}
