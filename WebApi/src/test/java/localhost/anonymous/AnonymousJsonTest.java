package localhost.anonymous;

import localhost.AbstractLocalhostTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.Constants;

import static io.restassured.RestAssured.given;
import static io.restassured.parsing.Parser.JSON;
import static org.hamcrest.Matchers.contains;

public class AnonymousJsonTest extends AbstractLocalhostTest
{
    @Test
    @Tag(Constants.DEBUG)
    public void anonymousJsonTest()
    {
        given(requestSpec)
                .when()
                .get("/anonymousjson.txt")
                .then()
                .using()
                .parser("text/plain", JSON)
                .body("", contains(1,2,3));
    }
}
