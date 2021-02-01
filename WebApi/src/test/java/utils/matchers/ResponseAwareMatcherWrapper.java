package utils.matchers;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.hamcrest.Matcher;

import java.util.Objects;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResponseAwareMatcherWrapper<T> implements ResponseAwareMatcher<Response>
{
    private final String bodyPath;
    private final BiFunction<Response, T, Matcher<?>> bifunc;

    public ResponseAwareMatcherWrapper(String bodyPath, BiFunction<Response, T, Matcher<?>> biFunc)
    {
        Objects.requireNonNull(bodyPath);
        Objects.requireNonNull(biFunc);
        this.bodyPath = bodyPath;
        this.bifunc = biFunc;
    }

    @Override
    public Matcher<?> matcher(Response response)
    {
        T bodyVal = response.jsonPath().get(bodyPath);
        return bifunc.apply(response, bodyVal);
    }

    public void matches(Response response)
    {
        assertTrue(matcher(response).matches(response));
    }
}
