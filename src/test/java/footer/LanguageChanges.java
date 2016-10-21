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

import java.util.concurrent.TimeUnit;

/**
 * Created by Alex Astakhov on 11.10.2016.
 */
public class LanguageChanges {
    WebDriver driver;

    String englishReg = "Registration".toUpperCase();
    String russianReg = "Регистрация".toUpperCase();
    String portugalReg = "Registo".toUpperCase();
    String spanishReg = "Inscripción".toUpperCase();
    String franchReg = "Inscription".toUpperCase();


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


    @BeforeClass
    public void landing(){
        driver.get("https://kismia.com");
    }

    @Test
    public void verifyEnglish(){
        Footer footer = new Footer(driver);
        footer.setEnglish();
        System.out.println(footer.getRegLinkText());
        Assert.assertTrue(footer.getRegLinkText().contains(englishReg));
    }

    @Test
    public void verifyRussian(){
        Footer footer = new Footer(driver);
        footer.setRussian();
        System.out.println(footer.getRegLinkText());
        Assert.assertTrue(footer.getRegLinkText().contains(russianReg));
    }

    @Test
    public void verifyPortugal(){
        Footer footer = new Footer(driver);
        footer.setPortuges();
        System.out.println(footer.getRegLinkText());
        Assert.assertTrue(footer.getRegLinkText().contains(portugalReg));
    }

    @Test
    public void verifySpanish(){
        Footer footer = new Footer(driver);
        footer.setSpanish();
        System.out.println(footer.getRegLinkText());
        Assert.assertTrue(footer.getRegLinkText().contains(spanishReg));
    }

    @Test
    public void verifyFranch(){
        Footer footer = new Footer(driver);
        footer.setFranch();
        System.out.println(footer.getRegLinkText());
        Assert.assertTrue(footer.getRegLinkText().contains(franchReg));
    }

}
