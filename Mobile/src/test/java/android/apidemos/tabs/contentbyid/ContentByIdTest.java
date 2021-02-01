package android.apidemos.tabs.contentbyid;

import android.apidemos.AbstractApiDemosTest;
import android.apidemos.tabs.contentbyid.page.ContentByIdPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContentByIdTest extends AbstractApiDemosTest<ContentByIdPage>
{
    @Test
    public void contentByIdText()
    {
        page.startActivity();
        assertEquals(new Color(16, 16, 135, 0), page.getTab1Color());
    }

    @Override
    public Class<ContentByIdPage> getPageClass()
    {
        return ContentByIdPage.class;
    }
}
