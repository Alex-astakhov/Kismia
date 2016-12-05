package profile;

import core.BrowserFactory;
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
public class ProfileSettingsNotifications extends BrowserFactory {

    String notifUrl = Constants.NOTIFICATIONS_SETTINGS_URL;


    @Test
    public void login(){
        driver.get("https://kismia.com");
        MainPage mainPage = new MainPage();
        mainPage.login(Constants.EMAIL, Constants.PASSWORD);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/u"));
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyNewGiftNotif() {
        driver.get(notifUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage();
        profileSet.setNewGiftNotif();
        Assert.assertFalse(profileSet.newGiftIsChecked());
        profileSet.setNewGiftNotif();
        Assert.assertTrue(profileSet.newGiftIsChecked());
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyYouLikedNotif() {
        driver.get(notifUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage();
        profileSet.setYouLikedNotif();
        Assert.assertFalse(profileSet.youLikedChecked());
        profileSet.setYouLikedNotif();
        Assert.assertTrue(profileSet.youLikedChecked());
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyNewMatchesNotif() {
        driver.get(notifUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage();
        profileSet.setNewMatchesNotif();
        Assert.assertFalse(profileSet.newMatchesChecked());
        profileSet.setNewMatchesNotif();
        Assert.assertTrue(profileSet.newMatchesChecked());
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyNewMessagesNotif() {
        driver.get(notifUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage();
        profileSet.setNewMessagesNotif();
        Assert.assertFalse(profileSet.newMessagesChecked());
        profileSet.setNewMessagesNotif();
        Assert.assertTrue(profileSet.newMessagesChecked());
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyPremiumPurchaseNotif() {
        driver.get(notifUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage();
        profileSet.setPremiumPurchaseNotif();
        Assert.assertFalse(profileSet.premiumPurchaseChecked());
        profileSet.setPremiumPurchaseNotif();
        Assert.assertTrue(profileSet.premiumPurchaseChecked());
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyNewAppropriateNotif() {
        driver.get(notifUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage();
        profileSet.setNewAppropriateNotif();
        Assert.assertFalse(profileSet.newAppropriateChecked());
        profileSet.setNewAppropriateNotif();
        Assert.assertTrue(profileSet.newAppropriateChecked());
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyNewVisitorsNotif() {
        driver.get(notifUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage();
        profileSet.setNewVisitorsNotif();
        Assert.assertFalse(profileSet.newVisitorsChecked());
        profileSet.setNewVisitorsNotif();
        Assert.assertTrue(profileSet.newVisitorsChecked());
    }
}
