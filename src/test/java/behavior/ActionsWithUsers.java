package behavior;

import core.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alex Astakhov on 16.10.2016.
 */
public class ActionsWithUsers extends BrowserFactory{

    String matchesUrl = "https://kismia.com/matches";
    String blockedUsersPage = "https://kismia.com/profile/delete";
    String selectedUsersPage = "https://kismia.com/profile/selected";


    @Test
    public void login(){
        driver.get("https://kismia.com");
        MainPage mainPage = new MainPage();
        mainPage.login(Constants.EMAIL, Constants.PASSWORD);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/u"));
    }

    @Test(dependsOnMethods = {"login"})
    public void blockUser() throws InterruptedException {
        driver.get(matchesUrl);
        MatchesPage matchesPage = new MatchesPage();
        String blockedUserId = matchesPage.blockFirstUser();
        Thread.sleep(2000);
        driver.get(blockedUsersPage);
        BlockedUsersPage blocked = new BlockedUsersPage();
        String unlockedUserLink = blocked.unlockFirstUser();
        System.out.println("Blocked user ID: " + blockedUserId);
        System.out.println("Unlocked user link: " + unlockedUserLink);
        Assert.assertTrue(unlockedUserLink.contains(blockedUserId));
    }

    @Test(dependsOnMethods = {"login"})
    public void addUserToSelected() throws InterruptedException {
        driver.get(matchesUrl);
        MatchesPage matchesPage = new MatchesPage();
        String selectedUserId = matchesPage.selectFirstUser();
        Thread.sleep(2000);
        driver.get(selectedUsersPage);
        SelectedUsersPage selected = new SelectedUsersPage();
        String deletedUserLink = selected.deleteFirstUser();
        System.out.println("Selected user ID: " + selectedUserId);
        System.out.println("Deleted user link: " + deletedUserLink);
        Assert.assertTrue(deletedUserLink.contains(selectedUserId));
    }
}
