package profile;

import core.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Constants;
import pageObjects.MainPage;
import pageObjects.ProfilePage;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alex Astakhov on 11.10.2016.
 */
public class ProfileInfoChanges extends BrowserFactory{

    String profilePageUrl = Constants.PROFILE_URL;



    @Test
    public void login(){
        driver.get("https://kismia.com");
        MainPage mainPage = new MainPage();
        mainPage.login(Constants.EMAIL, Constants.PASSWORD);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/u"));
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyStatus(){
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String text = dateFormat.format(date);
        profilePage.setStatus(text);
        Assert.assertEquals(text, profilePage.getStatus());
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyEducation(){
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEdit();
        String variant = profilePage.varGenerator(6);
        profilePage.setEducation(variant);
        profilePage.clickSave();
        Assert.assertEquals(profilePage.getEducation(), variant);
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyPosition(){
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEdit();
        String variant = profilePage.varGenerator(10);
        profilePage.setPosition(variant);
        profilePage.clickSave();
        Assert.assertEquals(profilePage.getPosition(), variant);
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyFieldOfActivity(){
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEdit();
        String variant = profilePage.varGenerator(12);
        profilePage.setFieldOfActivity(variant);
        profilePage.clickSave();
        Assert.assertEquals(profilePage.getFieldOfActivity(), variant);
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyMaritalStatus(){
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEdit();
        String variant = profilePage.varGenerator(12);
        profilePage.setMaritalStatus(variant);
        profilePage.clickSave();
        Assert.assertEquals(profilePage.getMaritalStatus(), variant);
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyChildren(){
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEdit();
        String variant = profilePage.varGenerator(5);
        profilePage.setChildren(variant);
        profilePage.clickSave();
        Assert.assertEquals(profilePage.getChildren(), variant);
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyReligion(){
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEdit();
        String variant = profilePage.varGenerator(9);
        profilePage.setReligion(variant);
        profilePage.clickSave();
        Assert.assertEquals(profilePage.getReligion(), variant);
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyHeight() throws InterruptedException {
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEdit();
        Random random = new Random();
        int variant = random.nextInt(61) + 120;
        profilePage.setHeight(variant);
        profilePage.clickSave();
        Assert.assertEquals(profilePage.getHeight(), variant);
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyWeight(){
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEdit();
        Random random = new Random();
        int variant = random.nextInt(106) + 45;
        profilePage.setWeight(variant);
        profilePage.clickSave();
        Assert.assertEquals(profilePage.getWeight(), variant);
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyBodytype(){
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEdit();
        String variant = profilePage.varGenerator(6);
        profilePage.setBodytype(variant);
        profilePage.clickSave();
        Assert.assertEquals(profilePage.getBodytype(), variant);
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyHealth(){
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEdit();
        String variant = profilePage.varGenerator(5);
        profilePage.setHealth(variant);
        profilePage.clickSave();
        Assert.assertEquals(profilePage.getHealth(), variant);
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyLook(){
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEdit();
        String variant = profilePage.varGenerator(7);
        profilePage.setLook(variant);
        profilePage.clickSave();
        Assert.assertEquals(profilePage.getLook(), variant);
    }

    @Test(dependsOnMethods = {"login"})
    public void verifySmoking(){
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEdit();
        String variant = profilePage.varGenerator(6);
        profilePage.setSmoking(variant);
        profilePage.clickSave();
        Assert.assertEquals(profilePage.getSmoking(), variant);
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyDrugs(){
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEdit();
        String variant = profilePage.varGenerator(5);
        profilePage.setDrugs(variant);
        profilePage.clickSave();
        Assert.assertEquals(profilePage.getDrugs(), variant);
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyAlcohol(){
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEdit();
        String variant = profilePage.varGenerator(10);
        profilePage.setAlcohol(variant);
        profilePage.clickSave();
        Assert.assertEquals(profilePage.getAlcohol(), variant);
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyLanguage(){
        driver.get(profilePageUrl);
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEdit();
        Random random = new Random();
        String variant = String.valueOf(random.nextInt(20) + 2);
        String lang = profilePage.setLanguage(variant);
        profilePage.clickSave();
        boolean langIsPresent = profilePage.getInfoPanelText().contains(lang);
        profilePage.clickEdit();
        profilePage.setLanguage(variant);
        profilePage.clickSave();
        Assert.assertTrue(langIsPresent);
    }

}
