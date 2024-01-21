import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.InputStream;
import java.util.Map;

public class ApiRequest {

    private static final String BASE_URI = "https://reqres.in/api";

    public static Response sendGetRequest(String endpoint, Map<String, String> queryParams) {
        return RestAssured.given()
            .baseUri(BASE_URI)
            .queryParams(queryParams)
        .when()
            .get(endpoint)
        .then()
            .extract()
            .response();
    }

    public static Response sendPostRequest(String endpoint, String requestBodyPath) {
        InputStream inputStream = ApiRequest.class.getClassLoader().getResourceAsStream(requestBodyPath);
        String requestBody = new java.util.Scanner(inputStream).useDelimiter("\\A").next();

        return RestAssured.given()
            .baseUri(BASE_URI)
            .body(requestBody)
            .header("Content-Type", "application/json")
        .when()
            .post(endpoint)
        .then()
            .extract()
            .response();
    }
}
