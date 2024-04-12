package api.api;

import api.requests.CreateUserReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static api.api.BaseAPI.deleteReq;
import static api.api.BaseAPI.postReq;
import static configuration.Endpoints.*;

public class CreateUserAPI {


    @Step("Вызов API регистрации пользователя")
    public static Response createUserAPI(CreateUserReq body){
        return postReq(body, CREATE_USER_ENDPOINT);
    }

    @Step("Вызов API авторизации пользователя")
    public static Response loginUserAPI(CreateUserReq body){
        return postReq(body, USER_LOGIN_ENDPOINT);
    }

    @Step("Вызов API удаления тестового пользователя")
    public static void deleteUserAPI(String token){
        deleteReq(USER_ENDPOINT, token);
    }
}
