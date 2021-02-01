package android.apidemos.page;

import io.appium.java_client.AppiumDriver;

public class ViewsPage<T extends ViewsPage<T>> extends ApiDemosPage<T>
{
    private static final String TEXT_SWITCHER = "TextSwitcher";

    public ViewsPage(AppiumDriver<?> driver)
    {
        super(driver);
    }

    @Override
    public T startActivity()
    {
        return startActivity("ApiDemos");
    }

    public T proceedToTextSwitcherPane()
    {
        return proceedToPane(TEXT_SWITCHER);
    }

    private T openPane(String paneName)
    {
        scrollIntoView(paneName).click();
        return asTypedPage();
    }

    private T proceedToPane(String paneName)
    {
        openViewsPane();
        return openPane(paneName);
    }

}
