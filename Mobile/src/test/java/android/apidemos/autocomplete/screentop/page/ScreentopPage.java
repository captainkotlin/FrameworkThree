package android.apidemos.autocomplete.screentop.page;

import android.apidemos.page.ApiDemosPage;
import io.appium.java_client.AppiumDriver;

public class ScreentopPage extends ApiDemosPage<ScreentopPage>
{
    public ScreentopPage(AppiumDriver<?> driver)
    {
        super(driver);
    }

    @Override
    public ScreentopPage startActivity()
    {
        return startActivity(".view.AutoComplete1");
    }

    public ScreentopPage fillCountryField(String str)
    {
        var countryField = driver.findElementById("io.appium.android.apis:id/edit");
        countryField.click();
        countryField.sendKeys(str);
        return asTypedPage();
    }
}
