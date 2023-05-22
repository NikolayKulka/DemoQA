package ui_engine.browser_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.File;

public class IEDriverManager extends DriverManager {

    private static InternetExplorerDriverService iEService;

    public static final ThreadLocal<WebDriver> driver;

    static {

        driver = new ThreadLocal<WebDriver>() {
            @Override
            protected InternetExplorerDriver initialValue() {

                if (iEService == null) {
                    try {
                        iEService = new InternetExplorerDriverService.Builder()
                                .usingDriverExecutable(new File("src/test/resources/chromedriver.exe"))
                                .usingAnyFreePort()
                                .build();
                        iEService.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                InternetExplorerOptions options = new InternetExplorerOptions();
                InternetExplorerDriver ieDriver = new InternetExplorerDriver(iEService, options);
                drivers.add(ieDriver);
                return ieDriver;
            }
        };
    }

    @Override
    public ThreadLocal<WebDriver> createDriver() {
        return  driver;
    }
}
