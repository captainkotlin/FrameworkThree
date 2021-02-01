package localhost;

import org.junit.jupiter.api.Test;
import utils.matchers.ResponseAwareMatcherBuilder;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class LocalhostTest extends AbstractLocalhostTest
{
    @Test
    public void testA() throws Exception
    {
        var response = given(requestSpec)
                .when()
                .get("sample.txt");
        new ResponseAwareMatcherBuilder<ArrayList<?>>()
                .withBodyPath("store.book.@price")
                .withMapper((fullResponse, pathResponse) -> is(fullResponse))
                .build()
                .matches(response);
    }
}
