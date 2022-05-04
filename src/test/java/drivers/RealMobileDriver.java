package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Data;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class RealMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("Android");
        //options.setDeviceName("SS2LHMH892705942"); //real device
        //options.setDeviceName("Pixel_4_API_30");
        options.setDeviceName(Data.getDeviceName());
        //options.setPlatformVersion("11.0");
        //options.setPlatformVersion("8.0"); //real device
        options.setPlatformVersion(Data.getPlatformVersion());
        options.setApp(app.getAbsolutePath());
        options.setLocale("en");
        options.setLanguage("en");
        options.setAppPackage("org.wikipedia.alpha");
        options.setAppActivity("org.wikipedia.main.MainActivity");

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(Data.getUrl());
            //"http://localhost:4723/wd/hub"
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private File getApp() {
        String appPath = "src/test/resources/apk/app-alpha-universal-release.apk";
        String appUrl = Data.getApp();
                //"https://github.com/wikimedia/apps-android-wikipedia/" +
                //"releases/download/latest/app-alpha-universal-release.apk?raw=true";

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            }
            catch (IOException e) {
                throw new AssertionError("Failed to download apk", e);
            }
        }
        return app;
    }

}