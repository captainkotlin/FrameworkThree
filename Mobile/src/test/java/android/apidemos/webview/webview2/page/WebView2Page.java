package android.apidemos.webview.webview2.page;

import android.apidemos.page.ViewsPage;
import io.appium.java_client.AppiumDriver;

public class WebView2Page extends ViewsPage<WebView2Page>
{
    public WebView2Page(AppiumDriver<?> driver)
    {
        super(driver);
    }

    @Override
    public WebView2Page startActivity()
    {
        return startActivity("view.WebView2");
    }

    public WebView2Page typeIntoEditField(String str)
    {
        driver.findElementByXPath("//*[@resource-id='i_am_a_textbox']")
                .sendKeys(str);
        return asTypedPage();
    }

    public void clickIAmLink()
    {
        driver.findElementByAccessibilityId("i am a link")
                .click();
    }
}
