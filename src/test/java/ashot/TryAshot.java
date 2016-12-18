package ashot;

import api.models.User;
import core.BrowserFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex Astakhov on 17.12.2016.
 */
@Listeners()
public class TryAshot extends BrowserFactory {

    By email = By.id("user-email");
    By pass = By.id("user-password");
    By formInput = By.cssSelector("form-input");



    @Test
    public void compareScreenshots(){
        driver.get("https://kismia.com/");
        driver.findElement(email).sendKeys("XXXXXXXXXXXXXXXXXX");
        driver.findElement(pass).sendKeys("XXXXXXXXXXXXXXXXXX");
        core.TryAshot ashot = new core.TryAshot(".\\screenshots");
        Set<By> ignore = new HashSet<>();
        ignore.add(email);
        ignore.add(pass);
        //ignore.add(formInput);
        int difference = ashot.findImageDifference(ignore).getDiffSize();
        Assert.assertTrue( difference <= 500, "Difference is more then 500 - (" + difference + ")");
    }

    @Test
    public void equalstest(){
        User user1 = new User("111", "222", "333");
        User user2 = new User("111", "222", "33");
        Assert.assertEquals(user1, user2);
    }




}
