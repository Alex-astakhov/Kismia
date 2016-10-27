package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.MainPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alex Astakhov on 26.10.2016.
 */
public class EmailRegField {
    WebDriver driver;
    final String URL = "https://kismia.com/";

    @BeforeTest
    public void setUpBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void startRegistration() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        driver.get(URL);
        mainPage.registrationFirstStep("Sasha");
    }

    @DataProvider
    public Object[][] incorrectEmails(){
        return new Object[][]{
                {"qwerty", true},
                {"qwerty@", true},
                {"qwerty@test", true},
                {"qwerty@test.", true},
                {"qwerty@test.com", false},
                {"qwerty@.com", true},
                {"@test.com", true},
                {"@.com", true},
                {"@.", true},
                {"q@w.e", true},
                {"kismiaTestEmail@gmail.com", false},
                {"kismiaTestEmail@ukr.net", false},
                {"kismiaTestEmail@yahoo.com", false},
                {"kismiaTestEmail@rambler.ru", false},
                {"kismiaTestEmail@yandex.ru", false},
                {"kismiaTestEmail@mail.ru", false},
                {"kismiaTestEmail@bigmir.net", false}
        };
    }

    @Test(dataProvider = "incorrectEmails", dependsOnMethods = "startRegistration")
    public void enterEmails(String email, boolean incorrect) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.typeRegEmail(email);
        mainPage.pressSubmitLast();
        Thread.sleep(1500);
        Assert.assertEquals(incorrect, mainPage.incorrectEmailDisplayed());
    }

}
