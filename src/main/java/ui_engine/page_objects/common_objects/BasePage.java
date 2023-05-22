package ui_engine.page_objects.common_objects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import ui_engine.utils.SimpleAPI;
public class BasePage extends SimpleAPI {

    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }
}
