package android.apidemos.autocomplete.screenbottom.page;

import android.apidemos.page.ApiDemosPage;
import io.appium.java_client.AppiumDriver;

public class ScreenbottomPage extends ApiDemosPage<ScreenbottomPage>
{
    public ScreenbottomPage(AppiumDriver<?> driver)
    {
        super(driver);
    }

    @Override
    public ScreenbottomPage startActivity()
    {
        return startActivity(".view.AutoComplete2");
    }

    public ScreenbottomPage fillEditField(String str)
    {
        var editField = driver.findElementById("io.appium.android.apis:id/edit");
        editField.sendKeys(str);
        editField.click();
        return asTypedPage();
    }
}
