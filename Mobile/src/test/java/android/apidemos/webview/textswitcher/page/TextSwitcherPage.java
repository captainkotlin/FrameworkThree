package android.apidemos.webview.textswitcher.page;

import android.apidemos.page.ViewsPage;
import io.appium.java_client.AppiumDriver;

public class TextSwitcherPage extends ViewsPage<TextSwitcherPage>
{
    public TextSwitcherPage(AppiumDriver<?> driver)
    {
        super(driver);
    }

    @Override
    public TextSwitcherPage startActivity()
    {
        return startActivity(".view.TextSwitcher1");
    }

    public void clickNextButton()
    {
        driver.findElementByAccessibilityId("Next").click();
    }

    public Integer getCounterValue()
    {
        var counterStr = driver.findElementByXPath("//android.widget.TextView[@text!='Views/TextSwitcher']").getText();
        return Integer.valueOf(counterStr);
    }
}
