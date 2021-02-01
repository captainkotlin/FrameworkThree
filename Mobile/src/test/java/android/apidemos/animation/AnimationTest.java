package android.apidemos.animation;

import android.apidemos.AbstractApiDemosTest;
import android.apidemos.animation.page.AnimationPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AnimationTest extends AbstractApiDemosTest<AnimationPage>
{
    @Test
    public void animationTest()
    {
        page.startActivity();
        var locationA = page.getInterpolatorsSubscriptionLocation();
        page.sleep(2);
        var locationB = page.getInterpolatorsSubscriptionLocation();
        assertNotEquals(locationA, locationB);
    }

    @Override
    public Class<AnimationPage> getPageClass()
    {
        return AnimationPage.class;
    }
}
