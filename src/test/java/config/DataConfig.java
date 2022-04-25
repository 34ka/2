package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:data.properties"})
public interface DataConfig extends Config {

    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("app")
    String app();

    @Key("url")
    String url();
}
