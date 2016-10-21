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

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alex Astakhov on 15.10.2016.
 */
public class ProfileSettingsChange {
    WebDriver driver;
    String settingsUrl = Constants.PROFILE_SETTINGS_URL;
    Random random = new Random();
    private String[] names = {"Саша", "Александр", "Шура", "Шурик", "Санчо", "Сашко"};
    private String[] passwords = {"sashasasha", "kawakawa", "qwertyui", "iuytrewq"};


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

    private String generateDate(){
        String year = String.valueOf(random.nextInt(10) + 1985);
        String month = "0" + String.valueOf(random.nextInt(9) + 1);
        String day = String.valueOf(random.nextInt(17) + 11);
        return year + "-" + month + "-" + day;
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
    public void verifyBirthDate() {
        driver.get(settingsUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage(driver);
        String newDate = generateDate();
        profileSet.setBirthDate(newDate);
        Assert.assertEquals(profileSet.getBirthDate(), newDate);
    }

    @Test(dependsOnMethods = {"login"})
    public void verifyPassword(){
        driver.get(settingsUrl);
        ProfileSettingsPage profileSet = new ProfileSettingsPage(driver);
        String newPassword = passwords[random.nextInt(4)];
        profileSet.setPassword(newPassword);
        driver.get("https://kismia.com/sign/out");
        MainPage mainPage = new MainPage(driver);
        mainPage.login(Constants.EMAIL, newPassword);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/u"));
        driver.get(settingsUrl);
        profileSet.setPassword(Constants.PASSWORD);
    }

}
