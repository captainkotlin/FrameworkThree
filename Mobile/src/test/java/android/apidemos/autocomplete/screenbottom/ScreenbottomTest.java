package android.apidemos.autocomplete.screenbottom;

import android.apidemos.AbstractApiDemosTest;
import android.apidemos.autocomplete.screenbottom.page.ScreenbottomPage;
import org.junit.jupiter.api.Test;

public class ScreenbottomTest extends AbstractApiDemosTest<ScreenbottomPage>
{
    @Test
    public void screenbottomTest()
    {
        page.startActivity()
                .fillEditField("fr")
                .pressSearchOnKeyboard();
    }

    @Override
    public Class<ScreenbottomPage> getPageClass()
    {
        return ScreenbottomPage.class;
    }
}
