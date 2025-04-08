package tests;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;
import utils.ConfigLoader;

public class BaseTests {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigLoader.getBaseUrl();
        RestAssured.config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", ConfigLoader.getDefaultTimeout()));
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

    }
}