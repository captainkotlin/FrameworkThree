package android.apidemos.webview.textfields.page;

import android.apidemos.page.ApiDemosPage;
import io.appium.java_client.AppiumDriver;

public class TextFieldPage extends ApiDemosPage<TextFieldPage>
{
    public TextFieldPage(AppiumDriver<?> driver)
    {
        super(driver);
    }

    @Override
    public TextFieldPage startActivity()
    {
        return startActivity(".view.TextFields");
    }

    public String getHintText()
    {
        return driver.findElementById("io.appium.android.apis:id/edit").getText();
    }
}
