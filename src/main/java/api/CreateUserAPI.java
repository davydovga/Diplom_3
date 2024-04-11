package api;

import api.requests.AuthReq;
import api.requests.CreateUserReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static api.BaseAPI.*;
import static configuration.Endpoints.*;

public class CreateUserAPI {


    @Step("Вызов API регистрации пользователя")
    public static Response createUserAPI(CreateUserReq body){
        return postReq(body, CREATE_USER_ENDPOINT);
    }

    @Step("Вызов API авторизации пользователя")
    public static Response loginUserAPI(AuthReq body){
        return postReq(body, USER_LOGIN_ENDPOINT);
    }

    @Step("Вызов API получение информации о пользователе")
    public static Response getUserInfoAPI(String token){
        return getReq(USER_ENDPOINT, token);
    }

    @Step("Вызов API удаления тестового пользователя")
    public static Response deleteUserAPI(String token){
        return deleteReq(USER_ENDPOINT, token);
    }
}
