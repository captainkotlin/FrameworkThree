package android.apidemos.autocomplete.scroll;

import android.apidemos.AbstractApiDemosTest;
import android.apidemos.autocomplete.scroll.page.ScrollPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.Constants;

public class ScrollTest extends AbstractApiDemosTest<ScrollPage>
{
    @Test
    @Tag(Constants.DEBUG)
    public void scrollTest()
    {
        page.startActivity()
                .scroll();
    }

    @Override
    public Class<ScrollPage> getPageClass()
    {
        return ScrollPage.class;
    }
}
