package ios.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSOptions;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import utils.AbstractMobileTest;
import utils.AbstractPage;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractIosTest<T extends AbstractPage<T>> extends AbstractMobileTest<IOSDriver<?>>
{
    protected T page;

    public abstract Class<T> getPageClass();

    @Override
    public IOSDriver<WebElement> getWebDriver()
    {
//        var appPath = Paths.get("./apps/ApiDemos-debug.apk").toAbsolutePath().toString();
        var capability = new IOSOptions();
//        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
//        capability.setCapability(MobileCapabilityType.DEVICE_NAME, "uoono7ovnf9ljnae");
//        capability.setCapability(MobileCapabilityType.APP, appPath);
//        capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        return new IOSDriver<>(appiumServerUrl, capability);
    }

    @BeforeEach
    public void initDriver()
    {
        var appPath = getAppPath();
        var capability = new IOSOptions();
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS.getPartOfOsName()[0]);
        capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capability.setCapability(MobileCapabilityType.DEVICE_NAME, "uoono7ovnf9ljnae");
        capability.setCapability(MobileCapabilityType.APP, appPath);
        capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        driver = new IOSDriver<>(appiumServerUrl, capability);
        try
        {
            page = getPageClass().getConstructor(AppiumDriver.class).newInstance(driver);
        }
        catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }
}
