package ui_engine.browser_factory;

public class DriverManagerFactory {

    public static DriverManager getManager(BrowserType type) {

        DriverManager driverManager;

        switch (type){
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            case IE:
                driverManager = new IEDriverManager();
                break;
            case REMOTE_CHROME:
                driverManager = new RemoteChromeManager();
                break;
            case CHROME:
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }

    public static BrowserType returnBrowserType(String browser)
    {
        browser = browser.toUpperCase();

        switch (browser){

            case "EDGE":
                return BrowserType.EDGE;
            case "IE":
                return BrowserType.IE;
            case "FIREFOX":
                return BrowserType.FIREFOX;
            case "REMOTE_CHROME":
                return BrowserType.REMOTE_CHROME;
            case "CHROME":
            default:
                return BrowserType.CHROME;
        }
    }
}
