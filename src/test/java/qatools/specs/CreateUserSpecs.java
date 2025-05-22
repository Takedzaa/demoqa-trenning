package qatools.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static qatools.helpers.CustomAllureListener.withCustomTemplates;

public class CreateUserSpecs {

    public static RequestSpecification createUserSpecs = with()
            .filter(withCustomTemplates())
            .contentType("application/json")
            .header("x-api-key", "reqres-free-v1")
            .basePath("api/users");

    public static ResponseSpecification createUserResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(STATUS)
            .log(BODY)
            .build();
}
