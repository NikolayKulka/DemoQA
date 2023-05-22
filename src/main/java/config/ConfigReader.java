package config;

import ui_engine.browser_factory.DriverManagerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties prop = new Properties();

    public static String getProperty(String name)
    {
        try(InputStream input = new FileInputStream("src/main/resources/config.properties"))
        {
            prop.load(input);
            return prop.getProperty(name);
        } catch (IOException e) {
            return null;
        }
    }

    public static void readConfiguration()
    {
        Configuration.browser = DriverManagerFactory.returnBrowserType(System.getProperty("browser")==null ? getProperty("browser") : System.getProperty("browser"));
        Configuration.userName = getProperty("username");
        Configuration.url = getProperty("url");
        Configuration.password = getProperty("password");
        Configuration.env = System.getProperty("env");

        assert Configuration.env != null;

        Configuration.isHeadless = Boolean.parseBoolean(System.getProperty("isHeadless"));
    }
}
