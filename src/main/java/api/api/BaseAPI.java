package api.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static configuration.Endpoints.BASE_URI;
import static io.restassured.RestAssured.given;


public class BaseAPI {
    public static Response postReq(Object body, String endpoint) {
        return given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint);
    }

    public static Response deleteReq(String endpoint, String token) {
        return given()
                .auth().oauth2(token)
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .when()
                .delete(endpoint);
    }
}
