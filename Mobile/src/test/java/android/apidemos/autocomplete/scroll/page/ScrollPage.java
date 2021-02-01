package android.apidemos.autocomplete.scroll.page;

import android.apidemos.page.ApiDemosPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class ScrollPage extends ApiDemosPage<ScrollPage>
{
    public ScrollPage(AppiumDriver<?> driver)
    {
        super(driver);
    }

    @Override
    public ScrollPage startActivity()
    {
        return startActivity(".view.AutoComplete3");
    }

    public void scroll()
    {
        var command = String.format("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"%s\").instance(%d))", "BUTTON", 4);
        var el = driver.findElement(MobileBy.AndroidUIAutomator(command));

    }
}
