package config;

import org.aeonbits.owner.ConfigFactory;

public class Data {
    public static DataConfig config = ConfigFactory.create(DataConfig.class, System.getProperties());

    public static boolean isBrowserStack() {
        return System.getProperty("device").equals("browserstack");
    }

    public static String getDeviceName() {
        return config.deviceName();
    }

    public static String getPlatformVersion() {
        return config.platformVersion();
    }

    public static String getUser() {
        return config.user();
    }

    public static String getKey() {
        return config.key();
    }

    public static String getApp() {
        return config.app();
    }

    public static String getUrl() {
        return config.url();
    }
}
