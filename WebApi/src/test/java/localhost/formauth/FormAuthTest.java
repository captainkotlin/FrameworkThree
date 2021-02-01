package localhost.formauth;

import io.restassured.authentication.FormAuthConfig;
import localhost.AbstractLocalhostTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.Constants;

import static io.restassured.RestAssured.given;

public class FormAuthTest extends AbstractLocalhostTest
{
    @Test
    @Tag(Constants.DISABLED)
    public void formAuthTest()
    {
        given()
                .auth().form("John", "Doe", new FormAuthConfig("/j_spring_security_check", "j_username", "j_password"))
                .expect()
                .when()
                .get("formauth.html");
    }
}
