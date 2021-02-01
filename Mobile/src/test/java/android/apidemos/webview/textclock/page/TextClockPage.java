package android.apidemos.webview.textclock.page;

import android.apidemos.page.ApiDemosPage;
import io.appium.java_client.AppiumDriver;

public class TextClockPage extends ApiDemosPage<TextClockPage>
{
    public TextClockPage(AppiumDriver<?> driver)
    {
        super(driver);
    }

    @Override
    public TextClockPage startActivity()
    {
        return startActivity(".view.TextClockDemo");
    }

    public String getTimeStr()
    {
        return driver.findElementByXPath("//android.widget.TextView[@index=3]").getText();
    }
}
