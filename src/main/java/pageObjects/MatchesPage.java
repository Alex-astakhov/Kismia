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
public class MatchesPage extends MethodsFactory {


    private By actions = By.cssSelector(".actions");
    private By blockActions = By.cssSelector(".jsapp-du");
    private By addToFavoriteActions = By.cssSelector(".jsapp-s");
    private By userInfo = By.cssSelector(".msg-in-list .info h2 a");


    public String blockFirstUser(){
        String user = driver.findElement(userInfo).getAttribute("href");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(actions)).perform();
        driver.findElement(blockActions).click();
        return user.substring(user.lastIndexOf('d') + 1);
    }

    public String selectFirstUser(){
        String user = driver.findElement(userInfo).getAttribute("href");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(actions)).perform();
        driver.findElement(addToFavoriteActions).click();
        return user.substring(user.lastIndexOf('d') + 1);
    }


}
