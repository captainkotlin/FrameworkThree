package android.apidemos.tabs.contentbyid.page;

import android.apidemos.page.ApiDemosPage;
import io.appium.java_client.AppiumDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.Color;

import javax.imageio.ImageIO;

public class ContentByIdPage extends ApiDemosPage<ContentByIdPage>
{
    public ContentByIdPage(AppiumDriver<?> driver)
    {
        super(driver);
    }

    @Override
    public ContentByIdPage startActivity()
    {
        return startActivity(".view.Tabs1");
    }

    @SneakyThrows
    public Color getTab1Color()
    {
        driver.findElementByXPath("//android.widget.LinearLayout/android.widget.TextView").click();
        var file = driver.getScreenshotAs(OutputType.FILE);
        var bufferedImage = ImageIO.read(file);
        int rgb = bufferedImage.getRGB(50, 400);
        int red   = (rgb & 0x00ff0000) >> 16;
        int green = (rgb & 0x0000ff00) >> 8;
        int blue  =  rgb & 0x000000ff;
        return new Color(red, green, blue, 0);
    }

}
