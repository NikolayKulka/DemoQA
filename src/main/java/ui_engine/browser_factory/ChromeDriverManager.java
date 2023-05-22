package ui_engine.browser_factory;

import config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeDriverManager extends DriverManager {

    private static ChromeDriverService chromeService;

    public static final ThreadLocal<WebDriver> driver;

    static {

        driver = new ThreadLocal<WebDriver>() {
            @Override
            protected ChromeDriver initialValue() {

                if (chromeService == null) {
                    try {
                        chromeService = new ChromeDriverService.Builder()
                                .usingDriverExecutable(new File("src/test/resources/chromedriver"))
                                .usingAnyFreePort()
                                .build();
                        chromeService.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");
                options.addArguments("window-size=1920,1080");
                options.addArguments("--disable-gpu");
                options.setHeadless(Configuration.isHeadless);
                ChromeDriver chromeDriver = new ChromeDriver(chromeService, options);
                drivers.add(chromeDriver);
                return chromeDriver;
            }
        };
    }
    @Override
    public ThreadLocal<WebDriver> createDriver() {
        return driver;
    }

}
