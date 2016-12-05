package pageObjects;

import core.MethodsFactory;
import org.openqa.selenium.By;

/**
 * Created by Alex Astakhov on 04.12.2016.
 */
public class MessagesPage extends MethodsFactory{
    private String dialogXpathBegin = ".//*[@class='msg']//a[contains(@href,'";
    private String dialogXpathEnd = "')]";

    public void getDialogWithUserId(String userId){
        driver.findElement(By.xpath(dialogXpathBegin + userId + dialogXpathEnd)).click();
    }

}
