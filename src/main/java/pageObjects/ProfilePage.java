package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

/**
 * Created by Alex Astakhov on 11.10.2016.
 */
public class ProfilePage {
    private WebDriver driver;

    private By userName = By.cssSelector(".inform-col strong");
    private By status = By.xpath(".//*[contains(@class, 'status-box show')]//span");
    private By statusFieldActive = By.cssSelector("textarea");
    private By statusEdit = By.id("editStatus");
    private By statusSave = By.id("saveStatus");
    private By editLink = By.id("user_info_edit");
    private By saveLink = By.id("user_info_save");
    private By education = By.cssSelector("[name=education]");
    private By educationSelected = By.xpath(".//*[@name='education']/*[@selected]");
    private By position = By.cssSelector("[name=position]");
    private By positionSelected = By.xpath(".//*[@name='position']/*[@selected]");
    private By fieldOfActivity = By.cssSelector("[name=field_of_activity]");
    private By fieldOfActivitySelected = By.xpath(".//*[@name='field_of_activity']/*[@selected]");
    private By maritalStatus = By.cssSelector("[name=marital_status]");
    private By maritalStatuSelected = By.xpath(".//*[@name='marital_status']/*[@selected]");
    private By children = By.cssSelector("[name=children]");
    private By childrenSelected = By.xpath(".//*[@name='children']/*[@selected]");
    private By religion = By.cssSelector("[name=religion]");
    private By religionSelected = By.xpath(".//*[@name='religion']/*[@selected]");
    private By height = By.cssSelector("[name=height]");
    private By weight = By.cssSelector("[name=weight]");
    private By bodytype = By.cssSelector("[name=bodytype]");
    private By bodytypeSelected = By.xpath(".//*[@name='bodytype']/*[@selected]");
    private By health = By.cssSelector("[name=health]");
    private By healthSelected = By.xpath(".//*[@name='health']/*[@selected]");
    private By look = By.cssSelector("[name=look]");
    private By lookSelected = By.xpath(".//*[@name='look']/*[@selected]");
    private By smoking = By.cssSelector("[name=smoking]");
    private By smokingSelected = By.xpath(".//*[@name='smoking']/*[@selected]");
    private By drugs = By.cssSelector("[name=drugs]");
    private By drugsSelected = By.xpath(".//*[@name='drugs']/*[@selected]");
    private By alcohol = By.cssSelector("[name=alcohol]");
    private By alcoholSelected = By.xpath(".//*[@name='alcohol']/*[@selected]");
    private String languageId = "#foreign_languages_";
    private By infoPanel = By.cssSelector(".striped");



    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    public String varGenerator(int count){
        Random random = new Random();
        int variant = random.nextInt(count - 1) - 1;
        if (variant == -1)
            return "";
        else
            return String.valueOf(variant);

    }

    public String getUserName(){
        return driver.findElement(userName).getText();
    }

    public void clickEdit(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.findElement(editLink).click();
        wait.until(ExpectedConditions.elementToBeClickable(saveLink));
    }

    public void clickSave(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.findElement(saveLink).click();
        wait.until(ExpectedConditions.elementToBeClickable(editLink));
    }

    private void chooseFromDropList(By list, String value) {
        Select select = new Select(driver.findElement(list));
        select.selectByValue(value);
    }

    public void setStatus(String text){
        driver.findElement(statusEdit).click();
        driver.findElement(statusFieldActive).clear();
        driver.findElement(statusFieldActive).sendKeys(text);
        driver.findElement(statusSave).click();
    }

    public String getStatus(){
        return driver.findElement(status).getText();
    }

    public void setEducation(String var){
        chooseFromDropList(education, var);
    }

    public String getEducation(){
        return driver.findElement(educationSelected).getAttribute("value");
    }

    public void setPosition(String var){
        chooseFromDropList(position, var);
    }

    public String getPosition(){
        return driver.findElement(positionSelected).getAttribute("value");
    }

    public void setFieldOfActivity(String var){
        chooseFromDropList(fieldOfActivity, var);
    }

    public String getFieldOfActivity(){
        return driver.findElement(fieldOfActivitySelected).getAttribute("value");
    }

    public void setMaritalStatus(String var){
        chooseFromDropList(maritalStatus, var);
    }

    public String getMaritalStatus(){
        return driver.findElement(maritalStatuSelected).getAttribute("value");
    }

    public void setChildren(String var){
        chooseFromDropList(children, var);
    }

    public String getChildren(){
        return driver.findElement(childrenSelected).getAttribute("value");
    }

    public void setReligion(String var){
        chooseFromDropList(religion, var);
    }

    public String getReligion(){
        return driver.findElement(religionSelected).getAttribute("value");
    }

    public void setHeight(int height){
        driver.findElement(this.height).clear();
        driver.findElement(this.height).sendKeys(String.valueOf(height));
    }

    public int getHeight(){
        String val = driver.findElement(this.height).getAttribute("value");
        return Integer.parseInt(val);
    }

    public void setWeight(int weight){
        driver.findElement(this.weight).clear();
        driver.findElement(this.weight).sendKeys(String.valueOf(weight));
    }

    public int getWeight(){
        String val = driver.findElement(this.weight).getAttribute("value");
        return Integer.parseInt(val);
    }

    public void setBodytype(String var){
        chooseFromDropList(bodytype, var);
    }

    public String getBodytype(){
        return driver.findElement(bodytypeSelected).getAttribute("value");
    }

    public void setHealth(String var){
        chooseFromDropList(health, var);
    }

    public String getHealth(){
        return driver.findElement(healthSelected).getAttribute("value");
    }

    public void setLook(String var){
        chooseFromDropList(look, var);
    }

    public String getLook(){
        return driver.findElement(lookSelected).getAttribute("value");
    }

    public void setSmoking(String var){
        chooseFromDropList(smoking, var);
    }

    public String getSmoking(){
        return driver.findElement(smokingSelected).getAttribute("value");
    }

    public void setDrugs(String var){
        chooseFromDropList(drugs, var);
    }

    public String getDrugs(){
        return driver.findElement(drugsSelected).getAttribute("value");
    }

    public void setAlcohol(String var){
        chooseFromDropList(alcohol, var);
    }

    public String getAlcohol(){
        return driver.findElement(alcoholSelected).getAttribute("value");
    }

    public String setLanguage(String id){
        driver.findElement(By.cssSelector(languageId + id)).click();
        return driver.findElement(By.cssSelector(languageId + id + "+label")).getText();
    }

    public String getInfoPanelText(){
        return driver.findElement(infoPanel).getText();
    }

    public String stringGenerator(int count){
        Random random = new Random();
        char[] array = new char[count];
        for (int i = 0; i < count; i++) {
            array[i] = (char) (random.nextInt(1038) + 65);
        }
        return String.valueOf(array);
    }

}
