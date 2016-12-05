package registration;

import core.BrowserFactory;
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
public class EmailRegField extends BrowserFactory {

    final String URL = "https://kismia.com/";


    @Test
    public void startRegistration() throws InterruptedException {
        MainPage mainPage = new MainPage();
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
        MainPage mainPage = new MainPage();
        mainPage.typeRegEmail(email);
        mainPage.pressSubmitLast();
        Thread.sleep(1500);
        Assert.assertEquals(incorrect, mainPage.incorrectEmailDisplayed());
    }

}
