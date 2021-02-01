package android.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import utils.AbstractPage;

public class AbstractAndroidPage<T extends AbstractAndroidPage<T>> extends AbstractPage<T>
{
    public AbstractAndroidPage(AppiumDriver<?> driver)
    {
        super(driver);
    }

    public WebElement scrollIntoView(String viewName)
    {
        var command = String.format("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"%s\"))", viewName);
        return driver.findElement(MobileBy.AndroidUIAutomator(command));
    }

    public void sleep(int seconds)
    {
        sleepMilliseconds(seconds * 1000);
    }

    @SneakyThrows
    public void sleepMilliseconds(int milliseconds)
    {
        Thread.sleep(milliseconds);
    }

    public T pressSearchOnKeyboard()
    {
        sleepMilliseconds(200);
        new TouchAction<>(driver)
                .tap(PointOption.point(1014, 1523))
                .perform();
        return asTypedPage();
    }
}
