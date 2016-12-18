package ashot;

import api.models.User;
import core.BrowserFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex Astakhov on 17.12.2016.
 */
public class TryAshot extends BrowserFactory {


    @Test
    public void makeScreenshot(){
        driver.get("https://kismia.com/");
        core.TryAshot ashot = new core.TryAshot(".\\screenshots");
        Set<By> ignore = new HashSet<>();
        ashot.takeExpectedScreenshot(ignore);
    }

    @Test
    public void compareScreenshots(){
        driver.get("https://kismia.com/#registration");
        core.TryAshot ashot = new core.TryAshot(".\\screenshots");
        Set<By> ignore = new HashSet<>();
        ashot.takeActualScreenshot(ignore);
        Assert.assertEquals(ashot.findImageDifference().getDiffSize(), 0);
    }

    @Test
    public void equalstest(){
        User user1 = new User("111", "222", "333");
        User user2 = new User("111", "222", "33");
        Assert.assertEquals(user1, user2);
    }




}
