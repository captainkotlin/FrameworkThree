package heroku.fileupload;

import heroku.AbstractHerokuTest;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class FileUploadTest extends AbstractHerokuTest
{
    @Test
    @SneakyThrows
    public void fileUploadTest()
    {
        var fileName = "netstat.log";
        var bytes = IOUtils.toByteArray(getClass().getResourceAsStream(fileName));
        given(requestSpec)
                .multiPart("filename", fileName, bytes)
                .expect()
                .statusCode(SC_OK)
                .when()
                .post("/uploads/fileprocessor");
    }
}
