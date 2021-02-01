package android.apidemos;

import android.apidemos.page.ApiDemosPage;
import android.utils.AbstractAndroidTest;
import lombok.SneakyThrows;

import java.nio.file.Paths;

public abstract class AbstractApiDemosTest<T extends ApiDemosPage<T>> extends AbstractAndroidTest<T>
{
    @Override
    @SneakyThrows
    public String getAppPath()
    {
        return Paths.get(getClass().getResource("/apps/ApiDemos-debug.apk").toURI()).toString();
    }
}
