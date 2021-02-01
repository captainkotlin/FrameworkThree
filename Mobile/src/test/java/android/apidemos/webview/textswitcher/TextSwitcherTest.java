package android.apidemos.webview.textswitcher;

import android.apidemos.AbstractApiDemosTest;
import android.apidemos.webview.textswitcher.page.TextSwitcherPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextSwitcherTest extends AbstractApiDemosTest<TextSwitcherPage>
{
    @Test
    public void textSwitcherTest()
    {
        page.startActivity();

        startRecording();
        var initialCounterValue = 0;
        assertEquals(initialCounterValue, page.getCounterValue());
        page.clickNextButton();
        assertEquals(initialCounterValue + 1, page.getCounterValue());
        stopRecording("C://temp/file.mp4", (e) -> {});
    }

    @Override
    public Class<TextSwitcherPage> getPageClass()
    {
        return TextSwitcherPage.class;
    }
}
