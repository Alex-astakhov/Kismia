package footer;

import core.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.FooterBlock;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alex Astakhov on 11.10.2016.
 */
public class LanguageChanges extends BrowserFactory{


    String englishReg = "Registration".toUpperCase();
    String russianReg = "Регистрация".toUpperCase();
    String portugalReg = "Registo".toUpperCase();
    String spanishReg = "Inscripción".toUpperCase();
    String franchReg = "Inscription".toUpperCase();


    @BeforeClass
    public void landing(){
        driver.get("https://kismia.com");
    }

    @Test
    public void verifyEnglish(){
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.setEnglish();
        System.out.println(footerBlock.getRegLinkText());
        Assert.assertTrue(footerBlock.getRegLinkText().contains(englishReg));
    }

    @Test
    public void verifyRussian(){
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.setRussian();
        System.out.println(footerBlock.getRegLinkText());
        Assert.assertTrue(footerBlock.getRegLinkText().contains(russianReg));
    }

    @Test
    public void verifyPortugal(){
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.setPortuges();
        System.out.println(footerBlock.getRegLinkText());
        Assert.assertTrue(footerBlock.getRegLinkText().contains(portugalReg));
    }

    @Test
    public void verifySpanish(){
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.setSpanish();
        System.out.println(footerBlock.getRegLinkText());
        Assert.assertTrue(footerBlock.getRegLinkText().contains(spanishReg));
    }

    @Test
    public void verifyFranch(){
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.setFranch();
        System.out.println(footerBlock.getRegLinkText());
        Assert.assertTrue(footerBlock.getRegLinkText().contains(franchReg));
    }

}
