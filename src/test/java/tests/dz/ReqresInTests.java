package tests.dz;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.*;
import static org.hamcrest.Matchers.*;

public class ReqresInTests {

    String authorizedData = "{\"email\": \"eve.holt@reqres.in\", " +
            "\"password\": \"cityslicka\"}";

    @Test
    public void successfulLogin() {
    given()
            .body(authorizedData)
            .contentType(JSON)
            .when()
            .post("https://reqres.in/api/login")
            .then()
            .statusCode(200)
            .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void getListTotalUsers() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("total", is(12));
    }

    @Test
    public void getDataUser() {
        given()
                .when()
                .get("https://reqres.in/api/users/12")
                .then()
                .statusCode(200)
                .body("data.id", is(12))
                .body("data.first_name", is("Rachel"))
                .body("data.last_name", is("Howell"));
    }

    String createNewUserData = "{ \"name\": \"Vinni\", \"job\": \"taster\" }";

    @Test
    public void createNewUser() {
        given()
                .body(createNewUserData)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name", is("Vinni"))
                .body("job", is("taster"));
    }

    String registerData = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"taster\"}";

    @Test
    public void successfulRegister() {
        given()
                .body(registerData)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(200)
                .body("id", not(empty()))
                .body("token", not(empty()));
    }

    String withoutPasswordData = "{\"email\": \"rgwetherth@reqres.in\"}";

    @Test
    public void unsuccessfulRegister() {
        given()
                .body(withoutPasswordData)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(400)
                .body("error", is("Missing password"));
    }
}
