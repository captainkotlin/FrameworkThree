package localhost.xmlnamespaces;

import io.restassured.config.XmlConfig;
import localhost.AbstractLocalhostTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utils.RestAssuredCfg.restAssuredCfg;

public class XmlNamespacesTest extends AbstractLocalhostTest
{
    @Test
    public void xmlNamespacesTest()
    {
        var xmlConfig = XmlConfig.xmlConfig().declareNamespace("test", "http://localhost/");
        given(requestSpec).config(restAssuredCfg(xmlConfig))
                .expect()
                .body("foo.bar.text()", equalTo("sudo make me a sandwich!"))
                .body(":foo.:bar.text()", equalTo("sudo "))
                .body("foo.test:bar.text()", equalTo("make me a sandwich!"))
                .when()
                .get("/xmlnamespaces.xml");

    }
}
