package ui;

import api_engine.EndPoints;
import api_engine.model.responses.Book;
import api_engine.model.responses.BooksResponse;
import config.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui_engine.page_objects.pages.BooksPage;

import java.util.List;
import java.util.stream.Collectors;

@Epic("Regression Tests")
@Feature("Books list")
public class BookTest extends BaseTest {

    static String URL;

    @BeforeClass
    public void openApp() {
        URL = Configuration.url;

        goToUrl(URL);
    }

    @Test(testName = "Check books list", description = "Compare books list from UI and API")
    @Story("Books list")
    public void checkBooksList() {

        BooksPage booksPage = new BooksPage(webDriver);
        List<String> booksTitlesUI = booksPage.getUIbooksTitles();

        Response books = EndPoints.getBooks();
        Assert.assertEquals(books.statusCode(), 200);
        BooksResponse booksResponse = books.getBody().as(BooksResponse.class);
        List<Book> booksTitlesApi = booksResponse.books.stream().filter(jsonValue -> !jsonValue.title.isEmpty())
                .collect(Collectors.toList());

        for (int i = 0; i < booksTitlesUI.size(); i++) {
            System.out.println("UI book title: " + (i + 1) + " " + booksTitlesUI.get(i) + " - " + "API book title: " + (i + 1) + " " + booksTitlesApi.get(i).title);
            Assert.assertEquals(booksTitlesUI.get(i), booksTitlesApi.get(i).title, "Verify Book Title " + (i + 1) + "in UI equals to Book Title in API");
        }
    }
}

