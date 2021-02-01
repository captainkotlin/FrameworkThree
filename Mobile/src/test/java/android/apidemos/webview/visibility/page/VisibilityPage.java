package android.apidemos.webview.visibility.page;

import android.apidemos.page.ViewsPage;
import io.appium.java_client.AppiumDriver;

public class VisibilityPage extends ViewsPage<VisibilityPage>
{
    public VisibilityPage(AppiumDriver<?> driver)
    {
        super(driver);
    }

    @Override
    public VisibilityPage startActivity()
    {
        return startActivity(".view.Visibility1");
    }

    public VisibilityPage pressInvisButton()
    {
        driver.findElementByAccessibilityId("Invis").click();
        return asTypedPage();
    }

    public boolean isViewBVisible()
    {
        var viewId = "View B";
        return !driver.findElementsByAccessibilityId(viewId).isEmpty() && driver.findElementByAccessibilityId(viewId).isDisplayed();
    }
}
