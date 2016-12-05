package footer;

import core.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.FooterBlock;
import pageObjects.MainPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alex Astakhov on 11.10.2016.
 */
public class LanguageChangesWithLogin extends BrowserFactory{

    String email = "bevov@divismail.ru";
    String password = "ahtung";
    String englishHeader = "My page";
    String russianHeader = "Моя страница";
    String portugalHeader = "Minha página";
    String spanishHeader = "Mi página";
    String franchHeader = "Mon profil";



    @Test
    public void login(){
        driver.get("https://kismia.com");
        MainPage mainPage = new MainPage();
        mainPage.login(email, password);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/u"));
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyEnglish(){
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.setEnglish();
        System.out.println(footerBlock.getHeaderText());
        Assert.assertTrue(footerBlock.getHeaderText().contains(englishHeader));
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyRussian(){
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.setRussian();
        System.out.println(footerBlock.getHeaderText());
        Assert.assertTrue(footerBlock.getHeaderText().contains(russianHeader));
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyPortugal(){
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.setPortuges();
        System.out.println(footerBlock.getHeaderText());
        Assert.assertTrue(footerBlock.getHeaderText().contains(portugalHeader));
    }

    @Test(dependsOnMethods = {"login"})
    public void verifySpanish(){
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.setSpanish();
        System.out.println(footerBlock.getHeaderText());
        Assert.assertTrue(footerBlock.getHeaderText().contains(spanishHeader));
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyFranch(){
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.setFranch();
        System.out.println(footerBlock.getHeaderText());
        Assert.assertTrue(footerBlock.getHeaderText().contains(franchHeader));
    }

}
