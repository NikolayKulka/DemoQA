package ui_engine.browser_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class RemoteChromeManager extends DriverManager {

    public static final ThreadLocal<WebDriver> driver;

    static {

        driver = ThreadLocal.withInitial(() -> {

            ChromeOptions options = new ChromeOptions();
            options.setCapability("browserName", "chrome");
            options.setCapability("version", "95");
            options.setCapability("platform", "Any");
            options.setCapability("enableVNC", true);
            options.setCapability("enableVideo", true);

            RemoteWebDriver remoteDriver = null;
            try {
                remoteDriver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), options);
                remoteDriver.setFileDetector(new LocalFileDetector());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            drivers.add(remoteDriver);
            return remoteDriver;
        });
    }

    @Override
    public ThreadLocal<WebDriver> createDriver() {
        return  driver;
    }
}
