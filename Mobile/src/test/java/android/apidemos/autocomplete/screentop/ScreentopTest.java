package android.apidemos.autocomplete.screentop;

import android.apidemos.AbstractApiDemosTest;
import android.apidemos.autocomplete.screentop.page.ScreentopPage;
import org.junit.jupiter.api.Test;

public class ScreentopTest extends AbstractApiDemosTest<ScreentopPage>
{
    @Test
    public void test()
    {
        page.startActivity().fillCountryField("fr");
    }

    @Override
    public Class<ScreentopPage> getPageClass()
    {
        return ScreentopPage.class;
    }
}
