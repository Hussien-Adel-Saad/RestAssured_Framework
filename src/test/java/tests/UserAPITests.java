package tests;

import io.restassured.response.Response;
import models.requests.CreateUserRequest;
import models.responses.GetSingleUserResponse;
import models.responses.UpdateUserResponse;
import models.responses.CreateUserResponse;
import org.testng.annotations.Test;
import utils.*;
import static utils.APIAssertionsHandler.*;


public class UserAPITests extends BaseTests {

    private String createdUserId;


    @Test(priority = 1)
    public void testCreateUser() {
        CreateUserRequest user = new CreateUserRequest("Hussien Adel", "Test Engineer");

        Response response = RequestSpecificationBuilder.getDefaultRequestSpec()
                .body(user)
                .when()
                .post("/users");

        CreateUserResponse createdUserResponse = response.as(CreateUserResponse.class);
        createdUserId = createdUserResponse.getId();

        //verify create user response
        assertResponseFieldNotNull("id", createdUserId);
        assertResponseFieldEquals("name",createdUserResponse.getName(), "Hussien Adel");
        assertResponseFieldEquals("job",createdUserResponse.getJob(), "Test Engineer");
        assertResponseFieldNotNull("createdAt", createdUserResponse.getCreatedAt());
    }

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

    @Test(priority = 2)
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


    @Test(priority = 3, dependsOnMethods = "testCreateUser")
    public void testUpdateUser() {
        CreateUserRequest updatedUser = new CreateUserRequest("Hussien Updated", "Senior Test Engineer");

        Response response = RequestSpecificationBuilder.getDefaultRequestSpec()
                .pathParam("id", createdUserId)
                .body(updatedUser)
                .when()
                .put("/users/{id}");

        UpdateUserResponse updatedUserResponse = response.as(UpdateUserResponse.class);

        assertResponseFieldEquals("name",updatedUserResponse.getName(), "Hussien Updated");
        assertResponseFieldEquals("job",updatedUserResponse.getJob(), "Senior Test Engineer");
        assertResponseFieldNotNull("updatedAt",updatedUserResponse.getUpdatedAt());
    }

}