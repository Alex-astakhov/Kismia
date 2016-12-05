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
public class SelectedUsersPage extends MethodsFactory {


    private By suitableUsersAction = By.cssSelector(".guests li ul");
    private By deleteUserAction = By.cssSelector(".guests li ul .jsapp-ds");
    private By firstUserLink = By.cssSelector(".guests .user_link");
    private By selectedUsers = By.cssSelector(".guests .info");


    public String deleteFirstUser(){
        String userLink = driver.findElement(firstUserLink).getAttribute("href");
        Actions actions = new Actions(driver);
        int number = driver.findElements(selectedUsers).size();
        actions.moveToElement(driver.findElement(suitableUsersAction)).perform();
        driver.findElement(deleteUserAction).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(selectedUsers, number));
        return userLink;
    }

}
