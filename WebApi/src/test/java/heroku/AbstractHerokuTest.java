package heroku;

import io.restassured.builder.RequestSpecBuilder;
import org.junit.jupiter.api.BeforeAll;
import utils.AbstractWebApiTest;

public class AbstractHerokuTest extends AbstractWebApiTest
{
    @BeforeAll
    public static void beforeAll()
    {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://testpages.herokuapp.com")
                .setRelaxedHTTPSValidation()
                .build();
    }
}
