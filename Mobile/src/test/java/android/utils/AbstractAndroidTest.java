package android.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidOptions;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.ScreenRecordingUploadOptions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import utils.AbstractMobileTest;
import utils.AbstractPage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.function.Consumer;

public abstract class AbstractAndroidTest<T extends AbstractPage<T>> extends AbstractMobileTest<AndroidDriver<?>>
{
    protected T page;

    public abstract Class<T> getPageClass();

    @Override
    public AndroidDriver<WebElement> getWebDriver()
    {
        var appPath = getAppPath();
        var capability = new AndroidOptions();
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID.getPartOfOsName()[0]);
        capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capability.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Pixel 4 API 29
        //capability.setCapability(MobileCapabilityType.DEVICE_NAME, "uoono7ovnf9ljnae");
        capability.setCapability(MobileCapabilityType.APP, appPath);
        capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capability.setCapability("unicodeKeyboard", false);
        capability.setCapability("resetKeyboard", true);
        return new AndroidDriver<>(appiumServerUrl, capability);
    }

    @BeforeEach
    public void initDriver()
    {
        driver = getWebDriver();
        try
        {
            page = getPageClass().getConstructor(AppiumDriver.class).newInstance(driver);
        }
        catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }

    public void startRecording()
    {
        var startScreenRecordingOptions = new AndroidStartScreenRecordingOptions();
        var screenRecordingOptions = new ScreenRecordingUploadOptions();
        startScreenRecordingOptions.withUploadOptions(screenRecordingOptions).withVideoSize("1900x1200");
        driver.startRecordingScreen(startScreenRecordingOptions);
    }

    public void stopRecording(String filePath, Consumer<IOException> exceptionHandler)
    {
        var dataStr = driver.stopRecordingScreen();
        var data = Base64.getDecoder().decode(dataStr);
        try
        {
            Files.write(Paths.get(filePath), data);
        }
        catch (IOException e)
        {
            exceptionHandler.accept(e);
        }
    }
}
