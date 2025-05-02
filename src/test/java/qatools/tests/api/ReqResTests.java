package qatools.tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import qatools.models.UserData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqResTests {

    UserData data = new UserData();

    @Test
    public void postReqTest() {

        RestAssured.baseURI = "https://reqres.in/";
        String jsonBody = String.format("{\n" +
                "    \"name\": \"%s\",\n" +
                "    \"job\": \"leader\"\n" +
                "}", data.getFirstName());

        given()
                .contentType("application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(jsonBody)
                .when()
                .post("api/users")
                .then()
                .statusCode(201)
                .body("name", equalTo(data.getFirstName()));
    }

    @Test()
    public void postReqRegistrationTest() {

        RestAssured.baseURI = "https://reqres.in/";
        String uriPath = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

        given()
                .contentType("application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(uriPath)
                .when()
                .post("api/register")
                .then()
                .statusCode(200)
                .body("id", equalTo(4));
    }

    @Test
    public void getUserTest() {
        RestAssured.baseURI = "https://reqres.in/";

        given()
                .header("x-api-key", "reqres-free-v1")
                .when()
                .get("api/users4")
                .then()
                .statusCode(200);
    }

    @Test
    public void updateUserTest() {
        RestAssured.baseURI = "https://reqres.in/";
        String jsonBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader2\"\n" +
                "}";

        given()
                .contentType("application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(jsonBody)
                .when()
                .put("api/users/")
                .then()
                .statusCode(200)
                .body("name", equalTo("morpheus"));
    }
}

