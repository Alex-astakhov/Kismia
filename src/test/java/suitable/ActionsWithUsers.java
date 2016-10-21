package suitable;

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
public class ActionsWithUsers {
    WebDriver driver;
    String matchesUrl = "https://kismia.com/matches";
    String blockedUsersPage = "https://kismia.com/profile/delete";
    String selectedUsersPage = "https://kismia.com/profile/selected";


    @BeforeTest
    public void setUpBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }


    @Test
    public void login(){
        driver.get("https://kismia.com");
        MainPage mainPage = new MainPage(driver);
        mainPage.login(Constants.EMAIL, Constants.PASSWORD);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/u"));
    }

    @Test(dependsOnMethods = {"login"})
    public void blockUser() throws InterruptedException {
        driver.get(matchesUrl);
        MatchesPage matchesPage = new MatchesPage(driver);
        String blockedUserId = matchesPage.blockFirstUser();
        Thread.sleep(2000);
        driver.get(blockedUsersPage);
        BlockedUsersPage blocked = new BlockedUsersPage(driver);
        String unlockedUserLink = blocked.unlockFirstUser();
        System.out.println("Blocked user ID: " + blockedUserId);
        System.out.println("Unlocked user link: " + unlockedUserLink);
        Assert.assertTrue(unlockedUserLink.contains(blockedUserId));
    }

    @Test(dependsOnMethods = {"login"})
    public void addUserToSelected() throws InterruptedException {
        driver.get(matchesUrl);
        MatchesPage matchesPage = new MatchesPage(driver);
        String selectedUserId = matchesPage.selectFirstUser();
        Thread.sleep(2000);
        driver.get(selectedUsersPage);
        SelectedUsersPage selected = new SelectedUsersPage(driver);
        String deletedUserLink = selected.deleteFirstUser();
        System.out.println("Selected user ID: " + selectedUserId);
        System.out.println("Deleted user link: " + deletedUserLink);
        Assert.assertTrue(deletedUserLink.contains(selectedUserId));
    }
}
