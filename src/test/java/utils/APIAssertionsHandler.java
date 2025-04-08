package utils;

import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;

public class APIAssertionsHandler {

    private static final List<Integer> RETRIABLE_STATUS_CODES = List.of(500, 502, 503, 504);

    public static void assertStatusCode(Response response, int expectedStatusCode) {
        int actual = response.getStatusCode();
        String body = response.getBody().asPrettyString();

        if (actual != expectedStatusCode) {
            if (RETRIABLE_STATUS_CODES.contains(actual)) {
                Assert.fail(String.format(
                        "Server error %d. Consider retrying. Response:\n%s", actual, body));
            } else if (actual >= 400 && actual < 500) {
                Assert.fail(String.format(
                        "Client error %d. Check your request! Response:\n%s", actual, body));
            } else {
                Assert.fail(String.format(
                        "Unexpected status code %d (Expected: %d). Response:\n%s",
                        actual, expectedStatusCode, body));
            }
        }
    }

    public static void assertPOJONotNull(Object pojo) {
        Assert.assertNotNull(pojo, "Response deserialized object is null.");
    }

    public static void assertResponseFieldEquals(String fieldName, Object actualValue, Object expectedValue) {
        Assert.assertEquals(actualValue, expectedValue,
                String.format("Field '%s' mismatch. Expected: '%s', but got: '%s'",
                        fieldName, expectedValue, actualValue));
    }

    public static void assertResponseFieldNotNull(String fieldName, Object value) {
        Assert.assertNotNull(value, "Field '" + fieldName + "' should not be null.");
    }

    public static void assertResponseTimeUnder(Response response, long maxMs) {
        long time = response.getTime();
        Assert.assertTrue(time <= maxMs,
                String.format("Response time too high: %d ms (max allowed: %d ms)", time, maxMs));
    }
}
