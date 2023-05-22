package ui_engine.browser_factory;

import org.openqa.selenium.WebDriver;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class DriverManager {

    protected static final Set<WebDriver> drivers = Collections.newSetFromMap(new ConcurrentHashMap<>());
    
    public static  ThreadLocal<WebDriver> driver;    
    
    public void  quitDriver()
    {
        if (driver != null) {
            driver.get().quit();
            driver = null;
        }
    }

    public ThreadLocal<WebDriver> createDriver(){
            return driver;
    }
}
