package core;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alex Astakhov on 31.10.2016.
 */
public class MethodsFactory {
    public static WebDriver driver;

    public static StringBuilder cutStringBuilder(StringBuilder source, String begin, String end){
        int beginIndex = source.indexOf(begin) + begin.length();
        source = new StringBuilder(source.substring(beginIndex));
        int endIndex = source.indexOf(end);
        return new StringBuilder(source.substring(0, endIndex));
    }

    public static StringBuilder cutStringBuilder(StringBuilder source, String begin){
        int beginIndex = source.indexOf(begin) + begin.length();
        return new StringBuilder(source.substring(beginIndex));
    }

    protected void waitForElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] pngAttachment(){
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            return Files.readAllBytes(Paths.get(scrFile.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public String getCurrentdateAndTimeString(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void waitForElementEmountIncrease(By by, int emountBefore){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, emountBefore));
    }
}
