package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AbstractPage<T extends AbstractPage<T>>
{
    protected AppiumDriver<?> driver;

    public AbstractPage(AppiumDriver<?> driver)
    {
        this.driver = driver;
    }

    public T asTypedPage()
    {
        return (T) this;
    }

    public AndroidDriver<?> androidDriver()
    {
        return (AndroidDriver<?>) driver;
    }
}
