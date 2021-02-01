package jerseydemos.form;

import jerseydemos.AbstractJerseyDemosTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class FormAuthTest extends AbstractJerseyDemosTest
{
    @Test
    public void formAuthTest()
    {
        given(requestSpec)
                .log().all()
                .auth().preemptive()
                .basic("howtodoinjava", "password")
                .expect()
                .log().all()
                .when()
                .get("/JerseyDemos/rest/employees");
    }
}
