package config;

import ui_engine.browser_factory.BrowserType;
import ui_engine.browser_factory.DriverManagerFactory;

public class Configuration {

    public static void setBrowser(String browser) {
        Configuration.browser = DriverManagerFactory.returnBrowserType(browser);
    }

    public static void setIsHeadless(boolean isHeadless) {
        Configuration.isHeadless = isHeadless;
    }

    public static BrowserType browser;
    public static boolean isHeadless;
    public static String url;
    public static String userName;
    public static String password;
    public static String env;

}
