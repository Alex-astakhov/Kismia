package profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Constants;
import pageObjects.MainPage;
import pageObjects.ProfileSettingsPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alex Astakhov on 15.10.2016.
 */
public class ProfileSettingsNotifications {
    WebDriver driver;
    String notifUrl = Constants.NOTIFICATIONS_SETTINGS_URL;

    @BeforeTest
    public void setUpBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
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
    public void verifyNewGiftNotif() {
        driver.get(notifUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage(driver);
        profileSet.setNewGiftNotif();
        Assert.assertFalse(profileSet.newGiftIsChecked());
        profileSet.setNewGiftNotif();
        Assert.assertTrue(profileSet.newGiftIsChecked());
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyYouLikedNotif() {
        driver.get(notifUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage(driver);
        profileSet.setYouLikedNotif();
        Assert.assertFalse(profileSet.youLikedChecked());
        profileSet.setYouLikedNotif();
        Assert.assertTrue(profileSet.youLikedChecked());
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyNewMatchesNotif() {
        driver.get(notifUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage(driver);
        profileSet.setNewMatchesNotif();
        Assert.assertFalse(profileSet.newMatchesChecked());
        profileSet.setNewMatchesNotif();
        Assert.assertTrue(profileSet.newMatchesChecked());
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyNewMessagesNotif() {
        driver.get(notifUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage(driver);
        profileSet.setNewMessagesNotif();
        Assert.assertFalse(profileSet.newMessagesChecked());
        profileSet.setNewMessagesNotif();
        Assert.assertTrue(profileSet.newMessagesChecked());
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyPremiumPurchaseNotif() {
        driver.get(notifUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage(driver);
        profileSet.setPremiumPurchaseNotif();
        Assert.assertFalse(profileSet.premiumPurchaseChecked());
        profileSet.setPremiumPurchaseNotif();
        Assert.assertTrue(profileSet.premiumPurchaseChecked());
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyNewAppropriateNotif() {
        driver.get(notifUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage(driver);
        profileSet.setNewAppropriateNotif();
        Assert.assertFalse(profileSet.newAppropriateChecked());
        profileSet.setNewAppropriateNotif();
        Assert.assertTrue(profileSet.newAppropriateChecked());
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyNewVisitorsNotif() {
        driver.get(notifUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage(driver);
        profileSet.setNewVisitorsNotif();
        Assert.assertFalse(profileSet.newVisitorsChecked());
        profileSet.setNewVisitorsNotif();
        Assert.assertTrue(profileSet.newVisitorsChecked());
    }
}
