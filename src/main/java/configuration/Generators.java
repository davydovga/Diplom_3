package configuration;

import api.requests.CreateUserReq;
import api.responses.CreateUserResponse;
import com.github.javafaker.Faker;
import io.restassured.response.Response;


public class Generators {
    Faker faker = new Faker();

    public CreateUserReq createUser(){
        return new CreateUserReq(
                faker.internet().emailAddress(),
                faker.internet().password(6,12),
                faker.name().username());
    }

    public CreateUserReq createBadPasswordUser(){
        return new CreateUserReq(
                faker.internet().emailAddress(),
                faker.internet().password(1,5),
                faker.name().username());
    }

    public String parseToken(Response token){
        return token.as(CreateUserResponse.class).getAccessToken().substring(7);
    }
}
