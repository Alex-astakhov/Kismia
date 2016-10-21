package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alex Astakhov on 13.10.2016.
 */
public class ProfileSettingsPage {
    private WebDriver driver;

    private By name = By.id("settingsName");
    private By birthDate = By.id("settingsBDate");
    private By password = By.id("settingsPassword");
    private By password2 = By.id("settingsPassword2");
    private By gender = By.id("settingsGender");
    private By searchGender = By.id("ettingsSearchGender");
    private By ageFrom = By.id("settingsSearchAgeFrom");
    private By ageTo = By.id("settingsSearchAgeTo");
    private By phone = By.id("change-phone");
    private By saveButton = By.xpath(".//*[@class='btn btn_medium']");
    private By city = By.cssSelector(".city");
    private By changCityButton = By.xpath(".//*[@class='btn btn_medium change_city']");

    private By newGiftNotif = By.id("notification_27");
    private By youLikedNotif = By.id("notification_22");
    private By newMatchesNotif = By.id("notification_24");
    private By newMessagesNotif = By.id("notification_19");
    private By premiumPurchaseNotif = By.id("notification_31");
    private By newAppropriateNotif = By.id("notification_20");
    private By newVisitorsNotif = By.id("notification_21");
    private By saveNotifButton = By.xpath(".//button[@type='submit']");

    public ProfileSettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name){
        driver.findElement(this.name).clear();
        driver.findElement(this.name).sendKeys(name);
        driver.findElement(saveButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("?"));
    }

    public String getName(){
        return driver.findElement(name).getAttribute("value");
    }

    public void setBirthDate(String date){
        driver.findElement(birthDate).clear();
        driver.findElement(birthDate).sendKeys(date);
        driver.findElement(saveButton).click();
    }

    public String getBirthDate(){
        return driver.findElement(birthDate).getAttribute("value");
    }

    public void setPassword(String pass){
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
        driver.findElement(password2).clear();
        driver.findElement(password2).sendKeys(pass);
        driver.findElement(saveButton).click();
    }

    public void setWomanGender(){
        Select select = new Select(driver.findElement(gender));
        select.selectByValue("f");
        driver.findElement(saveButton).click();
    }

    public void setManGender(){
        Select select = new Select(driver.findElement(gender));
        select.selectByValue("m");
        driver.findElement(saveButton).click();
    }

    public String getGender(){
        Select select = new Select(driver.findElement(gender));
        return select.getFirstSelectedOption().getAttribute("value");
    }

    public void setWomanSearchGender(){
        Select select = new Select(driver.findElement(searchGender));
        select.selectByValue("f");
        driver.findElement(saveButton).click();
    }

    public void setManSearchGender(){
        Select select = new Select(driver.findElement(searchGender));
        select.selectByValue("m");
        driver.findElement(saveButton).click();
    }

    public String getSearchGender(){
        Select select = new Select(driver.findElement(searchGender));
        return select.getFirstSelectedOption().getAttribute("value");
    }

    public void setAgeFrom(String age){
        Select select = new Select(driver.findElement(ageFrom));
        select.selectByVisibleText(age);
        driver.findElement(saveButton).click();
    }

    public String getAgeFrom(){
        Select select = new Select(driver.findElement(ageFrom));
        return select.getFirstSelectedOption().getText();
    }

    public void setAgeTo(String age){
        Select select = new Select(driver.findElement(ageTo));
        select.selectByVisibleText(age);
        driver.findElement(saveButton).click();
    }

    public String getAgeTo(){
        Select select = new Select(driver.findElement(ageTo));
        return select.getFirstSelectedOption().getText();
    }

    public void setNewGiftNotif(){
        driver.findElement(newGiftNotif).click();
        driver.findElement(saveNotifButton).click();
    }

    public boolean newGiftIsChecked(){
        return driver.findElement(newGiftNotif).isSelected();
    }

    public void setYouLikedNotif(){
        driver.findElement(youLikedNotif).click();
        driver.findElement(saveNotifButton).click();
    }

    public boolean youLikedChecked(){
        return driver.findElement(youLikedNotif).isSelected();
    }

    public void setNewMatchesNotif(){
        driver.findElement(newMatchesNotif).click();
        driver.findElement(saveNotifButton).click();
    }

    public boolean newMatchesChecked(){
        return driver.findElement(newMatchesNotif).isSelected();
    }

    public void setNewMessagesNotif(){
        driver.findElement(newMessagesNotif).click();
        driver.findElement(saveNotifButton).click();
    }

    public boolean newMessagesChecked(){
        return driver.findElement(newMessagesNotif).isSelected();
    }

    public void setPremiumPurchaseNotif(){
        driver.findElement(premiumPurchaseNotif).click();
        driver.findElement(saveNotifButton).click();
    }

    public boolean premiumPurchaseChecked(){
        return driver.findElement(premiumPurchaseNotif).isSelected();
    }

    public void setNewAppropriateNotif(){
        driver.findElement(newAppropriateNotif).click();
        driver.findElement(saveNotifButton).click();
    }

    public boolean newAppropriateChecked(){
        return driver.findElement(newAppropriateNotif).isSelected();
    }

    public void setNewVisitorsNotif(){
        driver.findElement(newVisitorsNotif).click();
        driver.findElement(saveNotifButton).click();
    }

    public boolean newVisitorsChecked(){
        return driver.findElement(newVisitorsNotif).isSelected();
    }
}
