package ui;

import config.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui_engine.page_objects.pages.LoginPage;

@Epic("Regression Tests")
@Feature("Login")
public class LoginTest extends BaseTest {

    static String URL;

    @BeforeClass
    public void openApp() {
        URL = Configuration.url;

        goToUrl(URL);
    }

    @Test(testName = "Login test positive", description = "User can login")
    @Story("Login")
    public void loginTestPositive() {

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickLogin();
        loginPage.setUserName(Configuration.userName);
        loginPage.setPassword(Configuration.password);
        loginPage.clickLogin();

        Assert.assertEquals(loginPage.logoutButtonIsDisplayed(), true, "Verify user is logged in");
        Assert.assertEquals(loginPage.getUserName(), Configuration.userName, "Verify user name is correct");
    }

    @Test(testName = "Login test negative", description = "User unable to login with wrong credentials")
    @Story("Login")
    public void loginTestNegative() {

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickLogin();
        loginPage.setUserName(RandomStringUtils.randomAlphabetic(5));
        loginPage.setPassword(RandomStringUtils.randomAlphabetic(5));
        loginPage.clickLogin();

        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid username or password!", "User is logged in or error message is absent/wrong");
    }
}

