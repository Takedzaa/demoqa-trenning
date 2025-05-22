package qatools.tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qatools.models.ResponseUserData;
import qatools.models.UserData;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static qatools.specs.CreateUserSpecs.createUserResponseSpec;
import static qatools.specs.CreateUserSpecs.createUserSpecs;

class ReqResTests {

    UserData data = new UserData();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    void postReqTest() {

        var firstName = data.getFirstName();

        ResponseUserData response = step("Create user", () ->
                given(createUserSpecs)
                        .body(data.getJsonBody())
                        .when()
                        .post()
                        .then()
                        .spec(createUserResponseSpec)
                        .extract().as(ResponseUserData.class));

        step("Check response", () -> assertEquals(firstName, response.getFirstName()));
    }

    @Test()
    void postReqRegistrationTest() {

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
    void getUserTest() {

        given()
                .header("x-api-key", "reqres-free-v1")
                .when()
                .get("api/users4")
                .then()
                .statusCode(200);
    }

    @Test
    void updateUserTest() {
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

