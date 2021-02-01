package localhost;

import io.restassured.builder.RequestSpecBuilder;
import org.junit.jupiter.api.BeforeAll;
import utils.AbstractWebApiTest;

public class AbstractLocalhostTest extends AbstractWebApiTest
{
    @BeforeAll
    public static void beforeAll()
    {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:8000/")
                .build();
    }
}
