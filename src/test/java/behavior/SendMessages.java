package behavior;

import api.models.User;
import core.BrowserFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alex Astakhov on 30.11.2016.
 */
public class SendMessages extends BrowserFactory {
    //siribogoz@rootfest.net qwerty1234
    User sender = new User("siribogoz@rootfest.net", "qwerty1234", "22675765");
    User reciever = new User("bevov@divismail.ru", "ahtung", "18330465");
    String messageText = "Test " + getCurrentdateAndTimeString();


    @Step
    public String login(User user){
        driver.get("https://kismia.com");
        MainPage mainPage = new MainPage();
        mainPage.login(user.getEmail(), user.getPassword());
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/u"));
        return driver.getCurrentUrl();
    }

    @Test
    public void sendMessage() throws InterruptedException {
        login(sender);
        driver.navigate().refresh();
        driver.get("https://kismia.com/u" + reciever.getUserId());
        driver.navigate().refresh();
        UserPage userPage = new UserPage();
        userPage.clickSendMessage();
        DialogPage dialogPage = new DialogPage();
        dialogPage.sendMessage(messageText);
        userPage.logout();
        login(reciever);
        driver.get("https://kismia.com/messages");
        MessagesPage messagesPage = new MessagesPage();
        messagesPage.getDialogWithUserId(sender.getUserId());
        Assert.assertEquals(dialogPage.getLastMessageText(), messageText);
    }


}
