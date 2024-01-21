import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class UserAPITests {

    @Test
    public void testGetUsersEndpoint() {
    	Map<String, String> queryParams = new HashMap<>();
        queryParams.put("page", "2");
        Response response = ApiRequest.sendGetRequest("/users", queryParams);

        System.out.println("Response : " + response.asPrettyString());
        // Assertions using utility methods
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertJsonIntValueEquals(response.jsonPath().getInt("page"), 2, "Incorrect page value");
        Assert.assertEquals(response.jsonPath().getList("data").size(), 6, "Incorrect data size");
        // Add other assertions as needed
    }

    @Test
    public void testPostUserEndpoint() {
        String requestBodyPath = "postRequestBody.json";
        Response response = ApiRequest.sendPostRequest("/users", requestBodyPath);

        System.out.println("Response : " + response.asPrettyString());

        // Assertions using utility methods
        ApiAssertions.assertStatusCode(response, 201);
        ApiAssertions.assertJsonValueEquals(response.jsonPath().getString("name"), "Duleeka", "Incorrect name");
        ApiAssertions.assertJsonValueEquals(response.jsonPath().getString("job"), "Test Engineer", "Incorrect Job");
        Assert.assertNotNull(response.jsonPath().getString("id"), "Incorrect Job");
    }
}
