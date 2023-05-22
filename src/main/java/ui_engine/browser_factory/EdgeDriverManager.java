package ui_engine.browser_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;

public class EdgeDriverManager extends DriverManager {

    private static EdgeDriverService edgeService;

    public static final ThreadLocal<WebDriver> driver;

    static {

        driver = new ThreadLocal<WebDriver>() {
            @Override
            protected EdgeDriver initialValue() {

                if (edgeService == null) {
                    try {
                        edgeService = new EdgeDriverService.Builder()
                                .usingDriverExecutable(new File("src/test/resources/edgedriver"))
                                .usingAnyFreePort()
                                .build();
                        edgeService.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                EdgeOptions options = new EdgeOptions();
                EdgeDriver edgeDriver = new EdgeDriver(edgeService, options);
                drivers.add(edgeDriver);
                return edgeDriver;
            }
        };
    }
    @Override
    public ThreadLocal<WebDriver> createDriver() {
        return driver;
    }
}
