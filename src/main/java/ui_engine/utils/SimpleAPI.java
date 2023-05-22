package ui_engine.utils;

import com.google.common.base.Function;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public abstract class SimpleAPI {

    public abstract WebDriver getWebDriver();

    protected WebElement $(By locator)
    {
        return assertThat(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement $(String css)
    {
        return assertThat(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
    }
    protected WebElement $(String css, int seconds)
    {
        return assertThat(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)), seconds);
    }

    protected WebElement $(WebElement coreElement, String css)
    {
        return assertThat(ExpectedConditions.presenceOfNestedElementLocatedBy(coreElement, By.cssSelector(css)));
    }
    protected WebElement $(WebElement coreElement, String css, int seconds)
    {
        return assertThat(ExpectedConditions.presenceOfNestedElementLocatedBy(coreElement, By.cssSelector(css)), seconds);
    }

    protected WebElement $r(WebElement coreElement, String css)
    {
        try
        {
            return assertThat(ExpectedConditions.presenceOfNestedElementLocatedBy(coreElement, By.cssSelector(css)), 2);
        }
        catch (StaleElementReferenceException e)
        {
            return assertThat(ExpectedConditions.presenceOfNestedElementLocatedBy(coreElement, By.cssSelector(css)));
        }
    }

    protected WebElement $x(String xpath)
    {
        return assertThat(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    protected List<WebElement> $$(By locator)
    {
        return assertThat(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected List<WebElement> $$(String css)
    {
        return assertThat(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(css)));
    }

    protected List<WebElement> $$(String css, int seconds)
    {
        return assertThat(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(css)), seconds);
    }

    protected <V> V assertThat(Function<? super WebDriver, V> condition)
    {
        return (new WebDriverWait(getWebDriver(), 5)).until(condition);
    }

    protected <V> V assertThat(Function<? super WebDriver, V> condition, int seconds)
    {
        return (new WebDriverWait(getWebDriver(), seconds)).until(condition);
    }

    @Step("Navigate to URL: {0}")
    public void goToUrl(String url)
    {
        getWebDriver().get(url);
    }

}
