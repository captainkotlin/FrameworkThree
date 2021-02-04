package utils;

import com.saucelabs.saucerest.SauceREST;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;
import java.util.function.BiConsumer;

public class UiTestWatcher implements TestWatcher
{
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason)
    {

    }

    @Override
    public void testSuccessful(ExtensionContext context)
    {
        withTestInstance(context, (instance, sauceREST) -> {
            sauceREST.jobPassed(instance.getSessionId());
        });
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause)
    {

    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause)
    {
        withTestInstance(context, (instance, sauceREST) -> {
            sauceREST.jobFailed(instance.getSessionId());
        });
    }

    private <T> void withTestInstance(ExtensionContext context, BiConsumer<AbstractUiTest<?>, SauceREST> consumer)
    {
        context.getTestInstance()
                .map(instance -> (AbstractUiTest<?>) instance)
                .ifPresent(instance -> consumer.accept(instance, instance.getSauceREST()));
    }
}
