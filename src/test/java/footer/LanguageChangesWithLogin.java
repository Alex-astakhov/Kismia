package footer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Footer;
import pageObjects.MainPage;
import pageObjects.ProfilePage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alex Astakhov on 11.10.2016.
 */
public class LanguageChangesWithLogin {
    WebDriver driver;
    String email = "bevov@divismail.ru";
    String password = "ahtung";
    String englishHeader = "My page";
    String russianHeader = "Моя страница";
    String portugalHeader = "Minha página";
    String spanishHeader = "Mi página";
    String franchHeader = "Mon profil";


    @BeforeTest
    public void setUpBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }


    @Test
    public void login(){
        driver.get("https://kismia.com");
        MainPage mainPage = new MainPage(driver);
        mainPage.login(email, password);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/u"));
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyEnglish(){
        Footer footer = new Footer(driver);
        footer.setEnglish();
        System.out.println(footer.getHeaderText());
        Assert.assertTrue(footer.getHeaderText().contains(englishHeader));
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyRussian(){
        Footer footer = new Footer(driver);
        footer.setRussian();
        System.out.println(footer.getHeaderText());
        Assert.assertTrue(footer.getHeaderText().contains(russianHeader));
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyPortugal(){
        Footer footer = new Footer(driver);
        footer.setPortuges();
        System.out.println(footer.getHeaderText());
        Assert.assertTrue(footer.getHeaderText().contains(portugalHeader));
    }

    @Test(dependsOnMethods = {"login"})
    public void verifySpanish(){
        Footer footer = new Footer(driver);
        footer.setSpanish();
        System.out.println(footer.getHeaderText());
        Assert.assertTrue(footer.getHeaderText().contains(spanishHeader));
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyFranch(){
        Footer footer = new Footer(driver);
        footer.setFranch();
        System.out.println(footer.getHeaderText());
        Assert.assertTrue(footer.getHeaderText().contains(franchHeader));
    }

}
