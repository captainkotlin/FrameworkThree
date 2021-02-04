package utils;

import com.codeborne.selenide.WebDriverRunner;
import com.saucelabs.saucerest.DataCenter;
import com.saucelabs.saucerest.SauceREST;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.openqa.selenium.remote.CapabilityType.*;

public class AbstractUiTest<Page extends AbstractPage<Page>>
{
    private static final String USERNAME = "username";
    private static final String ACCESS_KEY = "accesskey";
    protected RemoteWebDriver driver;
    private SauceREST sauceREST;
    private String sessionId;
    protected Page page;


    @BeforeEach
    @SneakyThrows
    public void beforeEach()
    {
        var userName = System.getProperty(USERNAME);
        var accessKey = System.getProperty(ACCESS_KEY);
        var url = new URL(String.format("https://%s:%s@ondemand.us-west-1.saucelabs.com:443/wd/hub", userName, accessKey));
        var capabilities = new DesiredCapabilities();
        capabilities.setCapability(BROWSER_NAME, System.getProperty(BROWSER_NAME));
        capabilities.setCapability(BROWSER_VERSION,System.getProperty(BROWSER_VERSION));
        capabilities.setCapability(PLATFORM_NAME, System.getProperty(PLATFORM_NAME));
        capabilities.setCapability("sauce:options", getSauceOptions(userName, accessKey));

        driver = new RemoteWebDriver(url, capabilities);
        sessionId = driver.getSessionId().toString();
        sauceREST = new SauceREST(userName, accessKey, DataCenter.US.server());
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterEach
    public void afterEach()
    {
        //((JavascriptExecutor) driver).executeScript("sauce:job-result=" + ("passed"));
        driver.quit();
    }

    public SauceREST getSauceREST()
    {
        return sauceREST;
    }

    public String getSessionId()
    {
        return sessionId;
    }

    protected String getTestName()
    {
        return this.getClass().getName();
    }

    private MutableCapabilities getSauceOptions(String username, String accessKey)
    {
        var sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability(USERNAME, username);
        sauceOptions.setCapability(ACCESS_KEY, accessKey);
        sauceOptions.setCapability("name", getTestName());
        sauceOptions.setCapability("screenResolution", "1920x1200");
        return sauceOptions;
    }
}
