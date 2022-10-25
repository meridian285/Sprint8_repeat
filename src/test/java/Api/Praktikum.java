package Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Praktikum {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test
    public void registrationAndAuth() {
        // Составили email
        Random random = new Random();
        String email = "something" + random.nextInt(10000000) + "@yandex.ru";
        // составь json, используя переменную email. Не забудь про экранизацию кавычек с помощью '/'
        String json = "{\"email\": \"" + email + "\", \"password\": \"aaa\" }";

// POST запрос на регистрацию signup
        given()
                .when()
                .body(json)
                .and()
                .post("/api/signup")
                .then().statusCode(201);
        // проверь статус ответа
        given()
                .when()
                .body(json)
                .and()
                .post("/api/signin")
                .then().statusCode(200)
                .and()
                .assertThat().body("token", notNullValue());
    }
}