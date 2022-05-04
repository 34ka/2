package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${device}.properties"})
public interface DataConfig extends Config {

    @Key("deviceName")
    @DefaultValue("Pixel_4_API_30")
    String deviceName();

    @Key("platformVersion")
    @DefaultValue("11.0")
    String platformVersion();

    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("app")
    String app();

    @Key("url")
    String url();
}
