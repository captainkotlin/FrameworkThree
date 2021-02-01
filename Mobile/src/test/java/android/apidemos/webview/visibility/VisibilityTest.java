package android.apidemos.webview.visibility;

import android.apidemos.AbstractApiDemosTest;
import android.apidemos.webview.visibility.page.VisibilityPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VisibilityTest extends AbstractApiDemosTest<VisibilityPage>
{
    @Test
    public void visibilityTest()
    {
        page.startActivity();
        assertTrue(page.isViewBVisible());
        page.pressInvisButton();
        assertFalse(page.isViewBVisible());
    }

    @Override
    public Class<VisibilityPage> getPageClass()
    {
        return VisibilityPage.class;
    }
}
