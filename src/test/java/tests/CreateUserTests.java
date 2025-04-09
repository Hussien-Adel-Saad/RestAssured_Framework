package tests;

import io.restassured.response.Response;
import models.requests.CreateUserRequest;
import models.responses.CreateUserResponse;
import org.testng.annotations.Test;
import utils.*;
import static utils.APIAssertionsHandler.*;


public class CreateUserTests extends BaseTests {

    public static String createdUserId;


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






}