package pageObjects;

import core.MethodsFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex Astakhov on 30.11.2016.
 */
public class DialogPage extends MethodsFactory {
    private By textField = By.cssSelector("[name=message]");
    private By message = By.id(".white-row p");
    private By sendMessageButton = By.cssSelector("[type=submit]");
    private By messages = By.cssSelector("#list p");

    private void writeMessage(String text){
        driver.findElement(textField).clear();
        driver.findElement(textField).sendKeys(text);
    }

    public void sendMessage(String text){
        int messagesBefore = getMessagesEmount();
        writeMessage(text);
        driver.findElement(sendMessageButton).click();
        waitForElementEmountIncrease(messages, messagesBefore);
    }

    public String getMessage(WebElement element){
        return element.getText();
    }

    public int getMessagesEmount(){
        return driver.findElements(messages).size();
    }

    public String getLastMessageText(){
        List<WebElement> messages =  driver.findElements(this.messages);
        return messages.get(messages.size() - 1).getText();
    }

}
