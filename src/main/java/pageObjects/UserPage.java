package pageObjects;

import core.MethodsFactory;
import org.openqa.selenium.By;

/**
 * Created by Alex Astakhov on 30.11.2016.
 */
public class UserPage extends MethodsFactory{
    private By sendMessageLink = By.cssSelector("[class='item message'] a");
    private By loogoutLink = By.cssSelector("[href*=sign]");

    public void clickSendMessage(){
        driver.findElement(sendMessageLink).click();
    }

    public void logout(){
        driver.findElement(loogoutLink).click();
    }
}
