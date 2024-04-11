package configuration;

import api.requests.CreateUserReq;
import com.github.javafaker.Faker;

public class Generators {

    Faker faker = new Faker();
    
    //Геренатор пользователя
    public CreateUserReq createUser(){
        return new CreateUserReq(
                faker.internet().emailAddress(),
                faker.internet().password(6,12),
                faker.name().username());
    }

    public CreateUserReq createBadPasswordUser(){
        return new CreateUserReq(
                faker.internet().emailAddress(),
                faker.internet().password(0,5),
                faker.name().username());
    }
}
