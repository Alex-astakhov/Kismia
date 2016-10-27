package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Astakhov on 10.10.2016.
 */
public class MainPage {
    private WebDriver driver;

    private By emailField = By.id("user-email");
    private By passwordField = By.id("user-password");
    private By enterButton = By.cssSelector("#sign-in-form .submit");

    private By registrationButton = By.id("form-registration");
    private By iAmBoy = By.xpath(".//*[@for='iam-boy']");
    private By userRegName = By.id("user-reg-myname");
    private By submitFirst = By.cssSelector("#block-first .submit");
    private By submitLast = By.cssSelector("#block-last .submit");

    private By emailRegField = By.id("user-reg-myemail");
    private By passRegField = By.id("user-reg-mypass");

    private By noPasswordError = By.xpath(".//*[@id='block-last']//*[@class='error-msg no-password']");
    private By incorrectEmailError = By.xpath(".//*[@id='block-last']//*[@class='error-msg incorrect-email']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }


    public void pressIamBoy(){
        driver.findElement(iAmBoy).click();
    }

    public void typeUserRegName(String name){
        driver.findElement(userRegName).clear();
        driver.findElement(userRegName).sendKeys(name);
    }

    public void typeRegEmail(String email){
        driver.findElement(emailRegField).clear();
        driver.findElement(emailRegField).sendKeys(email);
    }

    public void pressSubmitFirst(){
        driver.findElement(submitFirst).click();
    }

    public void pressSubmitLast(){
        driver.findElement(submitLast).click();
    }

    public void waitForEmailErrorDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(incorrectEmailError), ExpectedConditions.visibilityOfElementLocated(noPasswordError)));
    }

    public void waitForEmailErrorHid(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOfElementLocated(incorrectEmailError), ExpectedConditions.invisibilityOfElementLocated(noPasswordError)));
    }

    public void registrationFirstStep(String name) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(registrationButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(iAmBoy));
        pressIamBoy();
        typeUserRegName(name);
        pressSubmitFirst();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(emailRegField));
    }

    public boolean incorrectEmailDisplayed(){
        return driver.findElement(incorrectEmailError).isDisplayed();
    }

    public boolean noPasswordDisplayed(){
        return driver.findElement(noPasswordError).isDisplayed();
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
