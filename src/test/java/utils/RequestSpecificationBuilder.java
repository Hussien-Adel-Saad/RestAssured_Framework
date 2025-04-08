package utils;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class RequestSpecificationBuilder {
    public static RequestSpecification getDefaultRequestSpec() {
        return given()
                .contentType("application/json")
                .accept("application/json");
    }
}