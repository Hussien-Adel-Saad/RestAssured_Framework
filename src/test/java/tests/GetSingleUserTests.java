package tests;

import io.restassured.response.Response;
import models.responses.GetSingleUserResponse;
import org.testng.annotations.Test;
import utils.RequestSpecificationBuilder;

import static utils.APIAssertionsHandler.*;
import static utils.APIAssertionsHandler.assertResponseTimeUnder;

public class GetSingleUserTests extends BaseTests{
    //    @Test(priority = 2)
//    public void testGetSingleUser() {
//        Response response = RequestSpecificationBuilder.getDefaultRequestSpec()
//                .pathParam("id", createdUserId)
//                .when()
//                .get("/users/{id}");
//
//        ResponseValidator.validateStatusCode(response, 200);
//
//
//        GetSingleUserResponse getSingleUserResponse = response.as(GetSingleUserResponse.class);
//        assertEquals(getSingleUserResponse.getData().getId(), createdUserId);
//        assertEquals(getSingleUserResponse.getData().getFirst_name(), "Hussien");
//    }

    @Test(priority = 1)
    public void testGetSingleUser() {
        Response response = RequestSpecificationBuilder.getDefaultRequestSpec()
                .pathParam("id", 2)
                .when()
                .get("/users/{id}");


        GetSingleUserResponse getSingleUserResponse = response.as(GetSingleUserResponse.class);

        assertStatusCode(response, 200);
        assertResponseTimeUnder(response, 2000);
        assertResponseFieldEquals("id",getSingleUserResponse.getData().getId(), "2");
        assertResponseFieldEquals("email",getSingleUserResponse.getData().getEmail(), "janet.weaver@reqres.in");
        assertResponseFieldEquals("first_name",getSingleUserResponse.getData().getFirst_name(), "Janet");
        assertResponseFieldEquals("last_name",getSingleUserResponse.getData().getLast_name(), "Weaver");
        assertResponseFieldEquals("avatar",getSingleUserResponse.getData().getAvatar(), "https://reqres.in/img/faces/2-image.jpg");
        assertResponseFieldEquals("url",getSingleUserResponse.getSupport().getUrl(), "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral");
        assertResponseFieldEquals("text",getSingleUserResponse.getSupport().getText(), "Tired of writing endless social media content? Let Content Caddy generate it for you.");

    }

    @Test
    public void testGetUserWithInvalidUserId() {
        Response response = RequestSpecificationBuilder.getDefaultRequestSpec()
                .pathParam("id", 9999)
                .when()
                .get("/users/{id}");

        assertStatusCode(response, 404);
        assertResponseTimeUnder(response, 2000);

    }
}
