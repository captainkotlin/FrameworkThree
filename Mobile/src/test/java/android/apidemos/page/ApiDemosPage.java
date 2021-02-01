package android.apidemos.page;

import android.page.AbstractAndroidPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import lombok.SneakyThrows;

public abstract class ApiDemosPage<T extends ApiDemosPage<T>> extends AbstractAndroidPage<T>
{
    public ApiDemosPage(AppiumDriver<?> driver)
    {
        super(driver);
    }

    public abstract T startActivity();

    protected T startActivity(String activityName)
    {
        var activity = new Activity("io.appium.android.apis", activityName);
        androidDriver().startActivity(activity);
        return asTypedPage();
    }

    @SneakyThrows
    public T openViewsPane()
    {
        driver.findElementByAccessibilityId("Views").click();
        return asTypedPage();
    }
}
