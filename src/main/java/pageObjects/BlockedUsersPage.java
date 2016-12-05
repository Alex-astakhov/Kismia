package pageObjects;

import core.MethodsFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alex Astakhov on 16.10.2016.
 */
public class BlockedUsersPage extends MethodsFactory {


    private By suitableUsersAction = By.cssSelector(".guests li ul");
    private By blockUserAction = By.cssSelector(".guests li ul .jsapp-ru");
    private By firstUserLink = By.cssSelector(".guests .user_link");
    private By blockedUsers = By.cssSelector(".guests .info");



    public String unlockFirstUser(){
        String userLink = driver.findElement(firstUserLink).getAttribute("href");
        Actions actions = new Actions(driver);
        int number = driver.findElements(blockedUsers).size();
        actions.moveToElement(driver.findElement(suitableUsersAction)).perform();
        driver.findElement(blockUserAction).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(blockedUsers, number));
        return userLink;
    }

}
