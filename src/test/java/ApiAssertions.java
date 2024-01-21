import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

public class ApiAssertions {

    public static void assertStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Incorrect status code");
    }

    public static void assertJsonValueEquals(String actualValue, String expectedValue, String errorMessage) {
        Assert.assertEquals(actualValue, expectedValue, errorMessage);
    }

    public static void assertJsonIntValueEquals(int actualValue, int expectedValue, String errorMessage) {
        Assert.assertEquals(actualValue, expectedValue, errorMessage);
    }
}
