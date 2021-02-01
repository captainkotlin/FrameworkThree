package android.apidemos.webview.textclock;

import android.apidemos.AbstractApiDemosTest;
import android.apidemos.webview.textclock.page.TextClockPage;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TextClockTest extends AbstractApiDemosTest<TextClockPage>
{
    @Test
    public void textClockTest()
    {
        var timeStr = page.startActivity().getTimeStr();
        assertDoesNotThrow(() -> LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    @Override
    public Class<TextClockPage> getPageClass()
    {
        return TextClockPage.class;
    }
}
