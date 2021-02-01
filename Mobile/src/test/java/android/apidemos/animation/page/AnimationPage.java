package android.apidemos.animation.page;

import android.apidemos.page.ApiDemosPage;
import io.appium.java_client.AppiumDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class AnimationPage extends ApiDemosPage<AnimationPage>
{
    public AnimationPage(AppiumDriver<?> driver)
    {
        super(driver);
    }

    @Override
    public AnimationPage startActivity()
    {
        return startActivity(".view.Animation3");
    }

    @SneakyThrows
    public BufferedImage getInterpolatorsSubscriptionLocation()
    {
        return ImageIO.read(driver.findElementByAccessibilityId("Interpolators")
                .getScreenshotAs(OutputType.FILE));

    }
}
