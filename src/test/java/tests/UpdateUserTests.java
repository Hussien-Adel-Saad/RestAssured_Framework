package tests;

import io.restassured.response.Response;
import models.requests.CreateUserRequest;
import models.responses.UpdateUserResponse;
import org.testng.annotations.Test;
import utils.RequestSpecificationBuilder;

import static utils.APIAssertionsHandler.*;

public class UpdateUserTests extends BaseTests{
    @Test(priority = 1, dependsOnMethods = "testCreateUser")
    public void testUpdateUser() {
        CreateUserRequest updatedUser = new CreateUserRequest("Hussien Updated", "Senior Test Engineer");

        Response response = RequestSpecificationBuilder.getDefaultRequestSpec()
                .pathParam("id", CreateUserTests.createdUserId)
                .body(updatedUser)
                .when()
                .put("/users/{id}");

        UpdateUserResponse updatedUserResponse = response.as(UpdateUserResponse.class);

        assertResponseFieldEquals("name",updatedUserResponse.getName(), "Hussien Updated");
        assertResponseFieldEquals("job",updatedUserResponse.getJob(), "Senior Test Engineer");
        assertResponseFieldNotNull("updatedAt",updatedUserResponse.getUpdatedAt());
    }
}
