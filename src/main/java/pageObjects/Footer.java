package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Alex Astakhov on 12.10.2016.
 */
public class Footer {
    private WebDriver driver;
    private By russian = By.xpath(".//a[contains(text(),'Русский')]");
    private By english = By.xpath(".//a[contains(text(),'English')]");
    private By portuges = By.xpath(".//a[contains(text(),'Português')]");
    private By spanish = By.xpath(".//a[contains(text(),'Español')]");
    private By franch = By.xpath(".//a[contains(text(),'Français')]");
    private By checkHeader = By.cssSelector(".head-info h1");
    private By checkRegLink = By.id("form-registration");

    public Footer(WebDriver driver){
        this.driver = driver;
    }

    public void setEnglish(){
        driver.findElement(english).click();
    }

    public void setRussian(){
        driver.findElement(russian).click();
    }

    public void setPortuges(){
        driver.findElement(portuges).click();
    }

    public void setSpanish(){
        driver.findElement(spanish).click();
    }

    public void setFranch(){
        driver.findElement(franch).click();
    }

    public String getHeaderText(){
        return driver.findElement(checkHeader).getText();
    }

    public String getRegLinkText(){
        return driver.findElement(checkRegLink).getText();
    }
}
