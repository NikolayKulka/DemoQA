package ui_engine.page_objects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui_engine.page_objects.common_objects.BasePage;

import java.util.ArrayList;
import java.util.List;

public class BooksPage extends BasePage {

    private final String bookTitle = "//div[@class='rt-table']//a[@href]";


    public BooksPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getUIbooksTitles() {

        List<WebElement> bookTitlesElements = webDriver.findElements(By.xpath(bookTitle));
        List<String> bookTitles = new ArrayList<>();


        for (int i = 0; i < bookTitlesElements.size(); i++) {
            bookTitles.add(i, bookTitlesElements.get(i).getText());
        }

        return bookTitles;
    }

}