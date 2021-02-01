package android.apidemos.webview.textfields;

import android.apidemos.AbstractApiDemosTest;
import android.apidemos.webview.textfields.page.TextFieldPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextFieldsTest extends AbstractApiDemosTest<TextFieldPage>
{
    @Test
    public void textFieldTest()
    {
        page.startActivity();
        assertEquals("hint text", page.getHintText());
    }

    @Override
    public Class<TextFieldPage> getPageClass()
    {
        return TextFieldPage.class;
    }
}
