package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Alex Astakhov on 10.10.2016.
 */
public class MainPage {
    private WebDriver driver;

    private By emailField = By.id("user-email");
    private By passwordField = By.id("user-password");
    private By enterButton = By.cssSelector("#sign-in-form .submit");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void typeEmail(String email){
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void typePasswd(String passwd){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(passwd);
    }

    public void pressEnterButton(){
        driver.findElement(enterButton).click();
    }

    public void login(String email, String pass){
        typeEmail(email);
        typePasswd(pass);
        pressEnterButton();
    }
}
