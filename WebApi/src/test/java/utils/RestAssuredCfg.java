package utils;

import io.restassured.config.RestAssuredConfig;
import io.restassured.config.XmlConfig;

public class RestAssuredCfg
{
    public static RestAssuredConfig restAssuredCfg()
    {
        return RestAssuredConfig.newConfig();
    }

    public static RestAssuredConfig restAssuredCfg(XmlConfig xmlConfig)
    {
        return restAssuredCfg().xmlConfig(xmlConfig);
    }
}
