package android.apidemos.webview.webview2;

import android.apidemos.AbstractApiDemosTest;
import android.apidemos.webview.webview2.page.WebView2Page;
import org.junit.jupiter.api.Test;

public class WebView2Test extends AbstractApiDemosTest<WebView2Page>
{
    @Test
    public void webView2()
    {
        page.startActivity()
                .typeIntoEditField("Hello world")
                .clickIAmLink();
    }

    @Override
    public Class<WebView2Page> getPageClass()
    {
        return WebView2Page.class;
    }
}
