package utils.matchers;

import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matcher;

import java.util.function.BiFunction;

public class ResponseAwareMatcherBuilder<T>
{
    private String bodyPath;
    private BiFunction<Response, T, Matcher<?>> biFunc;

    public ResponseAwareMatcherBuilder()
    {
        this.bodyPath = StringUtils.EMPTY;
    }

    public ResponseAwareMatcherBuilder<T> withBodyPath(String bodyPath)
    {
        this.bodyPath = bodyPath;
        return this;
    }

    public ResponseAwareMatcherBuilder<T> withMapper(BiFunction<Response, T, Matcher<?>> biFunc)
    {
        this.biFunc = biFunc;
        return this;
    }

    public ResponseAwareMatcherWrapper<T> build()
    {
        return new ResponseAwareMatcherWrapper<>(bodyPath, biFunc);
    }
}
