package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class AbstractMobileTest<TDriver extends AppiumDriver<?>>
{
    protected static AppiumDriverLocalService service;
    protected static final int appiumPort = 4824;
    protected static URL appiumServerUrl = null;
    protected TDriver driver;

    static
    {
        try
        {
            appiumServerUrl = new URL(String.format("http://localhost:%d/wd/hub", appiumPort));
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }

    public abstract AppiumDriver<WebElement> getWebDriver();

    public abstract String getAppPath();

    @BeforeAll
    public static void beforeAll()
    {
        var libPath = "C:\\Users\\alexander\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
        var serviceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File(libPath))
                .usingPort(appiumPort);
        service = AppiumDriverLocalService.buildService(serviceBuilder);
        service.start();
    }

    @AfterAll
    public static void afterAll()
    {
        service.stop();
    }
}
