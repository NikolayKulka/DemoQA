package ui_engine.utils;


import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {

    public static String scrPath;

    @Attachment(value = "{1}", type = "image/png")
    public static byte[] allureScreenshot(WebDriver driver, String scrName)
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }

    public static void captureScreenshot(WebDriver driver, String scrName)
    {
        try
        {
            TakesScreenshot ts = (TakesScreenshot)driver;
            File file = ts.getScreenshotAs(OutputType.FILE);
            scrPath = "./target/screenshots/" + scrName + ".png";
            FileUtils.copyFile(file, new File(scrPath));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
