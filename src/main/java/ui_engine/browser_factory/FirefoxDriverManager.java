package ui_engine.browser_factory;

import config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;

public class FirefoxDriverManager extends DriverManager {

    private static GeckoDriverService firefoxService;
    ;

    public static final ThreadLocal<WebDriver> driver;

    static {

        driver = new ThreadLocal<WebDriver>() {
            @Override
            protected FirefoxDriver initialValue() {

                if (firefoxService == null) {
                    try {
                        firefoxService = new GeckoDriverService.Builder()
                                .usingDriverExecutable(new File("src/test/resources/chromedriver"))
                                .usingAnyFreePort()
                                .build();
                        firefoxService.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("test-type");
                options.addArguments("window-size=1920,1080");
                options.addArguments("--disable-gpu");
                options.setHeadless(Configuration.isHeadless);
                FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxService, options);
                drivers.add(firefoxDriver);
                return firefoxDriver;
            }
        };
    }
    @Override
    public ThreadLocal<WebDriver> createDriver() {
        return driver;
    }
}
